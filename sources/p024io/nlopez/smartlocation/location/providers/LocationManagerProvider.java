package p024io.nlopez.smartlocation.location.providers;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import androidx.core.app.ActivityCompat;
import p024io.nlopez.smartlocation.OnLocationUpdatedListener;
import p024io.nlopez.smartlocation.geofencing.providers.GeofencingGooglePlayServicesProvider;
import p024io.nlopez.smartlocation.location.LocationProvider;
import p024io.nlopez.smartlocation.location.LocationStore;
import p024io.nlopez.smartlocation.location.config.LocationAccuracy;
import p024io.nlopez.smartlocation.location.config.LocationParams;
import p024io.nlopez.smartlocation.utils.Logger;

/* renamed from: io.nlopez.smartlocation.location.providers.LocationManagerProvider */
public class LocationManagerProvider implements LocationProvider, LocationListener {
    private static final String LOCATIONMANAGERPROVIDER_ID = "LMP";
    private OnLocationUpdatedListener listener;
    private LocationManager locationManager;
    private LocationStore locationStore;
    private Logger logger;
    private Context mContext;

    public void onProviderDisabled(String str) {
    }

    public void onProviderEnabled(String str) {
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
    }

    public void init(Context context, Logger logger2) {
        this.locationManager = (LocationManager) context.getSystemService(GeofencingGooglePlayServicesProvider.LOCATION_EXTRA_ID);
        this.logger = logger2;
        this.mContext = context;
        this.locationStore = new LocationStore(context);
    }

    public void start(OnLocationUpdatedListener onLocationUpdatedListener, LocationParams locationParams, boolean z) {
        this.listener = onLocationUpdatedListener;
        if (onLocationUpdatedListener == null) {
            this.logger.mo39738d("Listener is null, you sure about this?", new Object[0]);
        }
        Criteria provider = getProvider(locationParams);
        if (!z) {
            this.locationManager.requestLocationUpdates(locationParams.getInterval(), locationParams.getDistance(), provider, this, Looper.getMainLooper());
        } else if (ActivityCompat.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(this.mContext, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            this.locationManager.requestSingleUpdate(provider, this, Looper.getMainLooper());
        } else {
            this.logger.mo39742i("Permission check failed. Please handle it in your app before setting up location", new Object[0]);
        }
    }

    public void stop() {
        if (ActivityCompat.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(this.mContext, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            this.locationManager.removeUpdates(this);
        }
    }

    public Location getLastLocation() {
        if (this.locationManager != null) {
            if (ActivityCompat.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION") != 0 && ActivityCompat.checkSelfPermission(this.mContext, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
                return null;
            }
            Location lastKnownLocation = this.locationManager.getLastKnownLocation("gps");
            if (lastKnownLocation != null) {
                return lastKnownLocation;
            }
        }
        Location location = this.locationStore.get(LOCATIONMANAGERPROVIDER_ID);
        if (location != null) {
            return location;
        }
        return null;
    }

    private Criteria getProvider(LocationParams locationParams) {
        LocationAccuracy accuracy = locationParams.getAccuracy();
        Criteria criteria = new Criteria();
        switch (accuracy) {
            case HIGH:
                criteria.setAccuracy(1);
                criteria.setHorizontalAccuracy(3);
                criteria.setVerticalAccuracy(3);
                criteria.setBearingAccuracy(3);
                criteria.setSpeedAccuracy(3);
                criteria.setPowerRequirement(3);
                break;
            case MEDIUM:
                criteria.setAccuracy(2);
                criteria.setHorizontalAccuracy(2);
                criteria.setVerticalAccuracy(2);
                criteria.setBearingAccuracy(2);
                criteria.setSpeedAccuracy(2);
                criteria.setPowerRequirement(2);
                break;
            default:
                criteria.setAccuracy(2);
                criteria.setHorizontalAccuracy(1);
                criteria.setVerticalAccuracy(1);
                criteria.setBearingAccuracy(1);
                criteria.setSpeedAccuracy(1);
                criteria.setPowerRequirement(1);
                break;
        }
        return criteria;
    }

    public void onLocationChanged(Location location) {
        this.logger.mo39738d("onLocationChanged", location);
        if (this.listener != null) {
            this.listener.onLocationUpdated(location);
        }
        if (this.locationStore != null) {
            this.logger.mo39738d("Stored in SharedPreferences", new Object[0]);
            this.locationStore.put(LOCATIONMANAGERPROVIDER_ID, location);
        }
    }
}
