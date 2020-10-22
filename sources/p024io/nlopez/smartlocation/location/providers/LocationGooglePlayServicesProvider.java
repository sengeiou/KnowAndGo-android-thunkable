package p024io.nlopez.smartlocation.location.providers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.location.Location;
import android.os.Bundle;
import android.os.Looper;
import androidx.core.app.ActivityCompat;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import p024io.nlopez.smartlocation.OnLocationUpdatedListener;
import p024io.nlopez.smartlocation.location.LocationStore;
import p024io.nlopez.smartlocation.location.ServiceLocationProvider;
import p024io.nlopez.smartlocation.location.config.LocationParams;
import p024io.nlopez.smartlocation.utils.GooglePlayServicesListener;
import p024io.nlopez.smartlocation.utils.Logger;
import p024io.nlopez.smartlocation.utils.ServiceConnectionListener;

/* renamed from: io.nlopez.smartlocation.location.providers.LocationGooglePlayServicesProvider */
public class LocationGooglePlayServicesProvider implements ServiceLocationProvider, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener, ResultCallback<Status> {
    private static final String GMS_ID = "GMS";
    public static final int REQUEST_CHECK_SETTINGS = 20001;
    public static final int REQUEST_START_LOCATION_FIX = 10001;
    private boolean alwaysShow;
    private boolean checkLocationSettings;
    private GoogleApiClient client;
    /* access modifiers changed from: private */
    public Context context;
    /* access modifiers changed from: private */
    public boolean fulfilledCheckLocationSettings;
    private GooglePlayServicesListener googlePlayServicesListener;
    private OnLocationUpdatedListener listener;
    /* access modifiers changed from: private */
    public LocationRequest locationRequest;
    private LocationStore locationStore;
    /* access modifiers changed from: private */
    public Logger logger;
    private ServiceConnectionListener serviceListener;
    private ResultCallback<LocationSettingsResult> settingsResultCallback;
    private boolean shouldStart;
    private boolean stopped;

    public LocationGooglePlayServicesProvider() {
        this.shouldStart = false;
        this.stopped = false;
        this.alwaysShow = true;
        this.settingsResultCallback = new ResultCallback<LocationSettingsResult>() {
            public void onResult(LocationSettingsResult locationSettingsResult) {
                Status status = locationSettingsResult.getStatus();
                int statusCode = status.getStatusCode();
                if (statusCode == 0) {
                    LocationGooglePlayServicesProvider.this.logger.mo39738d("All location settings are satisfied.", new Object[0]);
                    boolean unused = LocationGooglePlayServicesProvider.this.fulfilledCheckLocationSettings = true;
                    LocationGooglePlayServicesProvider.this.startUpdating(LocationGooglePlayServicesProvider.this.locationRequest);
                } else if (statusCode == 6) {
                    LocationGooglePlayServicesProvider.this.logger.mo39746w("Location settings are not satisfied. Show the user a dialog toupgrade location settings. You should hook into the Activity onActivityResult and call this provider onActivityResult method for continuing this call flow. ", new Object[0]);
                    if (LocationGooglePlayServicesProvider.this.context instanceof Activity) {
                        try {
                            status.startResolutionForResult((Activity) LocationGooglePlayServicesProvider.this.context, LocationGooglePlayServicesProvider.REQUEST_CHECK_SETTINGS);
                        } catch (IntentSender.SendIntentException unused2) {
                            LocationGooglePlayServicesProvider.this.logger.mo39742i("PendingIntent unable to execute request.", new Object[0]);
                        }
                    } else {
                        LocationGooglePlayServicesProvider.this.logger.mo39746w("Provided context is not the context of an activity, therefore we cant launch the resolution activity.", new Object[0]);
                    }
                } else if (statusCode == 8502) {
                    LocationGooglePlayServicesProvider.this.logger.mo39742i("Location settings are inadequate, and cannot be fixed here. Dialog not created.", new Object[0]);
                    LocationGooglePlayServicesProvider.this.stop();
                }
            }
        };
        this.checkLocationSettings = false;
        this.fulfilledCheckLocationSettings = false;
    }

    public LocationGooglePlayServicesProvider(GooglePlayServicesListener googlePlayServicesListener2) {
        this();
        this.googlePlayServicesListener = googlePlayServicesListener2;
    }

    public LocationGooglePlayServicesProvider(ServiceConnectionListener serviceConnectionListener) {
        this();
        this.serviceListener = serviceConnectionListener;
    }

    public void init(Context context2, Logger logger2) {
        this.logger = logger2;
        this.context = context2;
        this.locationStore = new LocationStore(context2);
        if (!this.shouldStart) {
            this.client = new GoogleApiClient.Builder(context2).addApi(LocationServices.API).addConnectionCallbacks(this).addOnConnectionFailedListener(this).build();
            this.client.connect();
            return;
        }
        logger2.mo39738d("already started", new Object[0]);
    }

    private LocationRequest createRequest(LocationParams locationParams, boolean z) {
        LocationRequest smallestDisplacement = LocationRequest.create().setFastestInterval(locationParams.getInterval()).setInterval(locationParams.getInterval()).setSmallestDisplacement(locationParams.getDistance());
        switch (locationParams.getAccuracy()) {
            case HIGH:
                smallestDisplacement.setPriority(100);
                break;
            case MEDIUM:
                smallestDisplacement.setPriority(102);
                break;
            case LOW:
                smallestDisplacement.setPriority(104);
                break;
            case LOWEST:
                smallestDisplacement.setPriority(105);
                break;
        }
        if (z) {
            smallestDisplacement.setNumUpdates(1);
        }
        return smallestDisplacement;
    }

    public void start(OnLocationUpdatedListener onLocationUpdatedListener, LocationParams locationParams, boolean z) {
        this.listener = onLocationUpdatedListener;
        if (onLocationUpdatedListener == null) {
            this.logger.mo39738d("Listener is null, you sure about this?", new Object[0]);
        }
        this.locationRequest = createRequest(locationParams, z);
        if (this.client.isConnected()) {
            startUpdating(this.locationRequest);
        } else if (this.stopped) {
            this.shouldStart = true;
            this.client.connect();
            this.stopped = false;
        } else {
            this.shouldStart = true;
            this.logger.mo39738d("still not connected - scheduled start when connection is ok", new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    public void startUpdating(LocationRequest locationRequest2) {
        if (this.checkLocationSettings && !this.fulfilledCheckLocationSettings) {
            this.logger.mo39738d("startUpdating wont be executed for now, as we have to test the location settings before", new Object[0]);
            checkLocationSettings();
        } else if (!this.client.isConnected()) {
            this.logger.mo39746w("startUpdating executed without the GoogleApiClient being connected!!", new Object[0]);
        } else if (ActivityCompat.checkSelfPermission(this.context, "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(this.context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            LocationServices.FusedLocationApi.requestLocationUpdates(this.client, locationRequest2, (LocationListener) this, Looper.getMainLooper()).setResultCallback(this);
        } else {
            this.logger.mo39742i("Permission check failed. Please handle it in your app before setting up location", new Object[0]);
        }
    }

    private void checkLocationSettings() {
        LocationServices.SettingsApi.checkLocationSettings(this.client, new LocationSettingsRequest.Builder().setAlwaysShow(this.alwaysShow).addLocationRequest(this.locationRequest).build()).setResultCallback(this.settingsResultCallback);
    }

    public void stop() {
        this.logger.mo39738d("stop", new Object[0]);
        if (this.client.isConnected()) {
            LocationServices.FusedLocationApi.removeLocationUpdates(this.client, (LocationListener) this);
            this.client.disconnect();
        }
        this.fulfilledCheckLocationSettings = false;
        this.shouldStart = false;
        this.stopped = true;
    }

    public Location getLastLocation() {
        if (this.client != null && this.client.isConnected()) {
            if (ActivityCompat.checkSelfPermission(this.context, "android.permission.ACCESS_FINE_LOCATION") != 0 && ActivityCompat.checkSelfPermission(this.context, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
                return null;
            }
            Location lastLocation = LocationServices.FusedLocationApi.getLastLocation(this.client);
            if (lastLocation != null) {
                return lastLocation;
            }
        }
        if (this.locationStore != null) {
            return this.locationStore.get(GMS_ID);
        }
        return null;
    }

    public ServiceConnectionListener getServiceListener() {
        return this.serviceListener;
    }

    public void setServiceListener(ServiceConnectionListener serviceConnectionListener) {
        this.serviceListener = serviceConnectionListener;
    }

    public void onConnected(Bundle bundle) {
        this.logger.mo39738d("onConnected", new Object[0]);
        if (this.shouldStart) {
            startUpdating(this.locationRequest);
        }
        if (this.googlePlayServicesListener != null) {
            this.googlePlayServicesListener.onConnected(bundle);
        }
        if (this.serviceListener != null) {
            this.serviceListener.onConnected();
        }
    }

    public void onConnectionSuspended(int i) {
        Logger logger2 = this.logger;
        logger2.mo39738d("onConnectionSuspended " + i, new Object[0]);
        if (this.googlePlayServicesListener != null) {
            this.googlePlayServicesListener.onConnectionSuspended(i);
        }
        if (this.serviceListener != null) {
            this.serviceListener.onConnectionSuspended();
        }
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        Logger logger2 = this.logger;
        logger2.mo39738d("onConnectionFailed " + connectionResult.toString(), new Object[0]);
        if (this.googlePlayServicesListener != null) {
            this.googlePlayServicesListener.onConnectionFailed(connectionResult);
        }
        if (this.serviceListener != null) {
            this.serviceListener.onConnectionFailed();
        }
    }

    public void onLocationChanged(Location location) {
        this.logger.mo39738d("onLocationChanged", location);
        if (this.listener != null) {
            this.listener.onLocationUpdated(location);
        }
        if (this.locationStore != null) {
            this.logger.mo39738d("Stored in SharedPreferences", new Object[0]);
            this.locationStore.put(GMS_ID, location);
        }
    }

    public void onResult(Status status) {
        if (status.isSuccess()) {
            this.logger.mo39738d("Locations update request successful", new Object[0]);
        } else if (!status.hasResolution() || !(this.context instanceof Activity)) {
            Logger logger2 = this.logger;
            logger2.mo39740e("Registering failed: " + status.getStatusMessage(), new Object[0]);
        } else {
            this.logger.mo39746w("Unable to register, but we can solve this - will startActivityForResult. You should hook into the Activity onActivityResult and call this provider onActivityResult method for continuing this call flow.", new Object[0]);
            try {
                status.startResolutionForResult((Activity) this.context, REQUEST_START_LOCATION_FIX);
            } catch (IntentSender.SendIntentException e) {
                this.logger.mo39741e(e, "problem with startResolutionForResult", new Object[0]);
            }
        }
    }

    public boolean isCheckingLocationSettings() {
        return this.checkLocationSettings;
    }

    public void setCheckLocationSettings(boolean z) {
        this.checkLocationSettings = z;
    }

    public void setLocationSettingsAlwaysShow(boolean z) {
        this.alwaysShow = z;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 20001) {
            switch (i2) {
                case -1:
                    this.logger.mo39742i("User agreed to make required location settings changes.", new Object[0]);
                    this.fulfilledCheckLocationSettings = true;
                    startUpdating(this.locationRequest);
                    return;
                case 0:
                    this.logger.mo39742i("User chose not to make required location settings changes.", new Object[0]);
                    stop();
                    return;
                default:
                    return;
            }
        } else if (i == 10001) {
            switch (i2) {
                case -1:
                    this.logger.mo39742i("User fixed the problem.", new Object[0]);
                    startUpdating(this.locationRequest);
                    return;
                case 0:
                    this.logger.mo39742i("User chose not to fix the problem.", new Object[0]);
                    stop();
                    return;
                default:
                    return;
            }
        }
    }
}
