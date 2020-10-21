package expo.modules.location;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.hardware.GeomagneticField;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import com.amplitude.api.DeviceInfo;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.polidea.rxandroidble.ClientComponent;
import expo.modules.location.exceptions.LocationRequestRejectedException;
import expo.modules.location.exceptions.LocationRequestTimeoutException;
import expo.modules.location.exceptions.LocationSettingsUnsatisfiedException;
import expo.modules.location.exceptions.LocationUnauthorizedException;
import expo.modules.location.exceptions.LocationUnavailableException;
import expo.modules.location.taskConsumers.GeofencingTaskConsumer;
import expo.modules.location.taskConsumers.LocationTaskConsumer;
import expo.modules.location.utils.TimeoutObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.unimodules.core.ExportedModule;
import org.unimodules.core.ModuleRegistry;
import org.unimodules.core.Promise;
import org.unimodules.core.interfaces.ActivityEventListener;
import org.unimodules.core.interfaces.ActivityProvider;
import org.unimodules.core.interfaces.ExpoMethod;
import org.unimodules.core.interfaces.LifecycleEventListener;
import org.unimodules.core.interfaces.services.EventEmitter;
import org.unimodules.core.interfaces.services.UIManager;
import org.unimodules.interfaces.permissions.Permissions;
import org.unimodules.interfaces.permissions.PermissionsResponse;
import org.unimodules.interfaces.permissions.PermissionsResponseListener;
import org.unimodules.interfaces.permissions.PermissionsStatus;
import org.unimodules.interfaces.taskManager.TaskManagerInterface;
import p024io.nlopez.smartlocation.OnGeocodingListener;
import p024io.nlopez.smartlocation.OnLocationUpdatedListener;
import p024io.nlopez.smartlocation.OnReverseGeocodingListener;
import p024io.nlopez.smartlocation.SmartLocation;
import p024io.nlopez.smartlocation.geocoding.utils.LocationAddress;
import p024io.nlopez.smartlocation.location.config.LocationParams;
import p024io.nlopez.smartlocation.location.utils.LocationState;

public class LocationModule extends ExportedModule implements LifecycleEventListener, SensorEventListener, ActivityEventListener {
    public static final int ACCURACY_BALANCED = 3;
    public static final int ACCURACY_BEST_FOR_NAVIGATION = 6;
    public static final int ACCURACY_HIGH = 4;
    public static final int ACCURACY_HIGHEST = 5;
    public static final int ACCURACY_LOW = 2;
    public static final int ACCURACY_LOWEST = 1;
    private static final int CHECK_SETTINGS_REQUEST_CODE = 42;
    private static final double DEGREE_DELTA = 0.0355d;
    public static final int GEOFENCING_EVENT_ENTER = 1;
    public static final int GEOFENCING_EVENT_EXIT = 2;
    public static final int GEOFENCING_REGION_STATE_INSIDE = 1;
    public static final int GEOFENCING_REGION_STATE_OUTSIDE = 2;
    public static final int GEOFENCING_REGION_STATE_UNKNOWN = 0;
    private static final String HEADING_EVENT_NAME = "Expo.headingChanged";
    private static final String LOCATION_EVENT_NAME = "Expo.locationChanged";
    private static final String SHOW_USER_SETTINGS_DIALOG_KEY = "mayShowUserSettingsDialog";
    private static final String TAG = "LocationModule";
    private static final float TIME_DELTA = 50.0f;
    private int mAccuracy = 0;
    private ActivityProvider mActivityProvider;
    /* access modifiers changed from: private */
    public Context mContext;
    private EventEmitter mEventEmitter;
    private boolean mGeocoderPaused = false;
    /* access modifiers changed from: private */
    public GeomagneticField mGeofield;
    private float[] mGeomagnetic;
    private float[] mGravity;
    private int mHeadingId;
    private float mLastAzimut = 0.0f;
    private long mLastUpdate = 0;
    private Map<Integer, LocationCallback> mLocationCallbacks = new HashMap();
    private Map<Integer, LocationRequest> mLocationRequests = new HashMap();
    private List<LocationActivityResultListener> mPendingLocationRequests = new ArrayList();
    private Permissions mPermissionsManager;
    private SensorManager mSensorManager;
    private TaskManagerInterface mTaskManager;
    /* access modifiers changed from: private */
    public UIManager mUIManager;

    public String getName() {
        return "ExpoLocation";
    }

    public void onNewIntent(Intent intent) {
    }

    public LocationModule(Context context) {
        super(context);
        this.mContext = context;
    }

    public void onCreate(ModuleRegistry moduleRegistry) {
        if (this.mUIManager != null) {
            this.mUIManager.unregisterLifecycleEventListener(this);
        }
        this.mEventEmitter = (EventEmitter) moduleRegistry.getModule(EventEmitter.class);
        this.mUIManager = (UIManager) moduleRegistry.getModule(UIManager.class);
        this.mPermissionsManager = (Permissions) moduleRegistry.getModule(Permissions.class);
        this.mTaskManager = (TaskManagerInterface) moduleRegistry.getModule(TaskManagerInterface.class);
        this.mActivityProvider = (ActivityProvider) moduleRegistry.getModule(ActivityProvider.class);
        if (this.mUIManager != null) {
            this.mUIManager.registerLifecycleEventListener(this);
        }
    }

    @ExpoMethod
    public void requestPermissionsAsync(Promise promise) {
        if (this.mPermissionsManager == null) {
            promise.reject("E_NO_PERMISSIONS", "Permissions module is null. Are you sure all the installed Expo modules are properly linked?");
        } else {
            this.mPermissionsManager.askForPermissions(new PermissionsResponseListener(promise) {
                private final /* synthetic */ Promise f$1;

                {
                    this.f$1 = r2;
                }

                public final void onResult(Map map) {
                    this.f$1.resolve(LocationModule.this.handleLocationPermissions(map));
                }
            }, "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION");
        }
    }

    @ExpoMethod
    public void getPermissionsAsync(Promise promise) {
        if (this.mPermissionsManager == null) {
            promise.reject("E_NO_PERMISSIONS", "Permissions module is null. Are you sure all the installed Expo modules are properly linked?");
        } else {
            this.mPermissionsManager.getPermissions(new PermissionsResponseListener(promise) {
                private final /* synthetic */ Promise f$1;

                {
                    this.f$1 = r2;
                }

                public final void onResult(Map map) {
                    this.f$1.resolve(LocationModule.this.handleLocationPermissions(map));
                }
            }, "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION");
        }
    }

    @ExpoMethod
    public void getLastKnownPositionAsync(Promise promise) {
        if (isMissingPermissions()) {
            promise.reject(new LocationUnauthorizedException());
        } else {
            getLastKnownLocation((Double) null, new OnSuccessListener() {
                public final void onSuccess(Object obj) {
                    LocationModule.lambda$getLastKnownPositionAsync$2(Promise.this, (Location) obj);
                }
            });
        }
    }

    static /* synthetic */ void lambda$getLastKnownPositionAsync$2(Promise promise, Location location) {
        if (location == null) {
            promise.reject("E_LAST_KNOWN_LOCATION_NOT_FOUND", "Last known location not found.", (Throwable) null);
        } else {
            promise.resolve(LocationHelpers.locationToBundle(location, Bundle.class));
        }
    }

    @ExpoMethod
    public void getCurrentPositionAsync(Map<String, Object> map, final Promise promise) {
        Long valueOf = map.containsKey(ClientComponent.NamedSchedulers.TIMEOUT) ? Long.valueOf(((Double) map.get(ClientComponent.NamedSchedulers.TIMEOUT)).longValue()) : null;
        final LocationRequest prepareLocationRequest = LocationHelpers.prepareLocationRequest(map);
        boolean z = !map.containsKey(SHOW_USER_SETTINGS_DIALOG_KEY) || ((Boolean) map.get(SHOW_USER_SETTINGS_DIALOG_KEY)).booleanValue();
        if (isMissingPermissions()) {
            promise.reject(new LocationUnauthorizedException());
            return;
        }
        final TimeoutObject timeoutObject = new TimeoutObject(valueOf);
        timeoutObject.onTimeout(new TimeoutObject.TimeoutListener() {
            public void onTimeout() {
                promise.reject(new LocationRequestTimeoutException());
            }
        });
        timeoutObject.start();
        if (map.containsKey("maximumAge")) {
            getLastKnownLocation((Double) map.get("maximumAge"), new OnSuccessListener<Location>() {
                public void onSuccess(Location location) {
                    if (location != null) {
                        promise.resolve(LocationHelpers.locationToBundle(location, Bundle.class));
                        timeoutObject.markDoneIfNotTimedOut();
                    }
                }
            });
        }
        if (LocationHelpers.hasNetworkProviderEnabled(this.mContext) || !z) {
            LocationHelpers.requestSingleLocation(this, prepareLocationRequest, timeoutObject, promise);
        } else {
            addPendingLocationRequest(prepareLocationRequest, new LocationActivityResultListener() {
                public void onResult(int i) {
                    if (i == -1) {
                        LocationHelpers.requestSingleLocation(LocationModule.this, prepareLocationRequest, timeoutObject, promise);
                    } else {
                        promise.reject(new LocationSettingsUnsatisfiedException());
                    }
                }
            });
        }
    }

    @ExpoMethod
    public void getProviderStatusAsync(Promise promise) {
        if (this.mContext == null) {
            promise.reject("E_CONTEXT_UNAVAILABLE", "Context is not available");
        }
        LocationState state = SmartLocation.with(this.mContext).location().state();
        Bundle bundle = new Bundle();
        bundle.putBoolean("locationServicesEnabled", state.locationServicesEnabled());
        bundle.putBoolean("gpsAvailable", state.isGpsAvailable());
        bundle.putBoolean("networkAvailable", state.isNetworkAvailable());
        bundle.putBoolean("passiveAvailable", state.isPassiveAvailable());
        bundle.putBoolean("backgroundModeEnabled", state.locationServicesEnabled());
        promise.resolve(bundle);
    }

    @ExpoMethod
    public void watchDeviceHeading(int i, Promise promise) {
        this.mSensorManager = (SensorManager) this.mContext.getSystemService("sensor");
        this.mHeadingId = i;
        startHeadingUpdate();
        promise.resolve((Object) null);
    }

    @ExpoMethod
    public void watchPositionImplAsync(final int i, Map<String, Object> map, final Promise promise) {
        if (isMissingPermissions()) {
            promise.reject(new LocationUnauthorizedException());
            return;
        }
        final LocationRequest prepareLocationRequest = LocationHelpers.prepareLocationRequest(map);
        boolean z = !map.containsKey(SHOW_USER_SETTINGS_DIALOG_KEY) || ((Boolean) map.get(SHOW_USER_SETTINGS_DIALOG_KEY)).booleanValue();
        if (LocationHelpers.hasNetworkProviderEnabled(this.mContext) || !z) {
            LocationHelpers.requestContinuousUpdates(this, prepareLocationRequest, i, promise);
        } else {
            addPendingLocationRequest(prepareLocationRequest, new LocationActivityResultListener() {
                public void onResult(int i) {
                    if (i == -1) {
                        LocationHelpers.requestContinuousUpdates(LocationModule.this, prepareLocationRequest, i, promise);
                    } else {
                        promise.reject(new LocationSettingsUnsatisfiedException());
                    }
                }
            });
        }
    }

    @ExpoMethod
    public void removeWatchAsync(int i, Promise promise) {
        if (isMissingPermissions()) {
            promise.reject(new LocationUnauthorizedException());
            return;
        }
        if (i == this.mHeadingId) {
            destroyHeadingWatch();
        } else {
            removeLocationUpdatesForRequest(Integer.valueOf(i));
        }
        promise.resolve((Object) null);
    }

    @ExpoMethod
    public void geocodeAsync(String str, final Promise promise) {
        if (this.mGeocoderPaused) {
            promise.reject("E_CANNOT_GEOCODE", "Geocoder is not running.");
        } else if (isMissingPermissions()) {
            promise.reject(new LocationUnauthorizedException());
        } else if (Geocoder.isPresent()) {
            SmartLocation.with(this.mContext).geocoding().direct(str, new OnGeocodingListener() {
                public void onLocationResolved(String str, List<LocationAddress> list) {
                    ArrayList arrayList = new ArrayList(list.size());
                    for (LocationAddress location : list) {
                        Bundle bundle = (Bundle) LocationHelpers.locationToCoordsBundle(location.getLocation(), Bundle.class);
                        if (bundle != null) {
                            arrayList.add(bundle);
                        }
                    }
                    SmartLocation.with(LocationModule.this.mContext).geocoding().stop();
                    promise.resolve(arrayList);
                }
            });
        } else {
            promise.reject("E_NO_GEOCODER", "Geocoder service is not available for this device.");
        }
    }

    @ExpoMethod
    public void reverseGeocodeAsync(Map<String, Object> map, final Promise promise) {
        if (this.mGeocoderPaused) {
            promise.reject("E_CANNOT_GEOCODE", "Geocoder is not running.");
        } else if (isMissingPermissions()) {
            promise.reject(new LocationUnauthorizedException());
        } else {
            Location location = new Location("");
            location.setLatitude(((Double) map.get("latitude")).doubleValue());
            location.setLongitude(((Double) map.get("longitude")).doubleValue());
            if (Geocoder.isPresent()) {
                SmartLocation.with(this.mContext).geocoding().reverse(location, new OnReverseGeocodingListener() {
                    public void onAddressResolved(Location location, List<Address> list) {
                        ArrayList arrayList = new ArrayList(list.size());
                        for (Address addressToBundle : list) {
                            arrayList.add(LocationHelpers.addressToBundle(addressToBundle));
                        }
                        SmartLocation.with(LocationModule.this.mContext).geocoding().stop();
                        promise.resolve(arrayList);
                    }
                });
            } else {
                promise.reject("E_NO_GEOCODER", "Geocoder service is not available for this device.");
            }
        }
    }

    @ExpoMethod
    public void enableNetworkProviderAsync(final Promise promise) {
        if (LocationHelpers.hasNetworkProviderEnabled(this.mContext)) {
            promise.resolve((Object) null);
        } else {
            addPendingLocationRequest(LocationHelpers.prepareLocationRequest(new HashMap()), new LocationActivityResultListener() {
                public void onResult(int i) {
                    if (i == -1) {
                        promise.resolve((Object) null);
                    } else {
                        promise.reject(new LocationSettingsUnsatisfiedException());
                    }
                }
            });
        }
    }

    @ExpoMethod
    public void hasServicesEnabledAsync(Promise promise) {
        promise.resolve(Boolean.valueOf(LocationHelpers.isAnyProviderAvailable(getContext())));
    }

    @ExpoMethod
    public void startLocationUpdatesAsync(String str, Map<String, Object> map, Promise promise) {
        try {
            this.mTaskManager.registerTask(str, LocationTaskConsumer.class, map);
            promise.resolve((Object) null);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ExpoMethod
    public void stopLocationUpdatesAsync(String str, Promise promise) {
        try {
            this.mTaskManager.unregisterTask(str, LocationTaskConsumer.class);
            promise.resolve((Object) null);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ExpoMethod
    public void hasStartedLocationUpdatesAsync(String str, Promise promise) {
        promise.resolve(Boolean.valueOf(this.mTaskManager.taskHasConsumerOfClass(str, LocationTaskConsumer.class)));
    }

    @ExpoMethod
    public void startGeofencingAsync(String str, Map<String, Object> map, Promise promise) {
        try {
            this.mTaskManager.registerTask(str, GeofencingTaskConsumer.class, map);
            promise.resolve((Object) null);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ExpoMethod
    public void stopGeofencingAsync(String str, Promise promise) {
        try {
            this.mTaskManager.unregisterTask(str, GeofencingTaskConsumer.class);
            promise.resolve((Object) null);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ExpoMethod
    public void hasStartedGeofencingAsync(String str, Promise promise) {
        promise.resolve(Boolean.valueOf(this.mTaskManager.taskHasConsumerOfClass(str, GeofencingTaskConsumer.class)));
    }

    /* access modifiers changed from: package-private */
    public void requestLocationUpdates(LocationRequest locationRequest, Integer num, final LocationRequestCallbacks locationRequestCallbacks) {
        FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this.mContext);
        C35028 r1 = new LocationCallback() {
            public void onLocationResult(LocationResult locationResult) {
                Location lastLocation = locationResult != null ? locationResult.getLastLocation() : null;
                if (lastLocation != null) {
                    locationRequestCallbacks.onLocationChanged(lastLocation);
                }
            }

            public void onLocationAvailability(LocationAvailability locationAvailability) {
                if (!locationAvailability.isLocationAvailable()) {
                    locationRequestCallbacks.onLocationError(new LocationUnavailableException());
                }
            }
        };
        if (num != null) {
            this.mLocationCallbacks.put(num, r1);
            this.mLocationRequests.put(num, locationRequest);
        }
        try {
            fusedLocationProviderClient.requestLocationUpdates(locationRequest, r1, Looper.myLooper());
            locationRequestCallbacks.onRequestSuccess();
        } catch (SecurityException e) {
            locationRequestCallbacks.onRequestFailed(new LocationRequestRejectedException(e));
        }
    }

    private boolean isMissingPermissions() {
        return this.mPermissionsManager == null || !this.mPermissionsManager.hasGrantedPermissions("android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION");
    }

    private void getLastKnownLocation(final Double d, final OnSuccessListener<Location> onSuccessListener) {
        try {
            LocationServices.getFusedLocationProviderClient(this.mContext).getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                public void onSuccess(Location location) {
                    if (location == null || (d != null && ((double) (System.currentTimeMillis() - location.getTime())) >= d.doubleValue())) {
                        onSuccessListener.onSuccess(null);
                    } else {
                        onSuccessListener.onSuccess(location);
                    }
                }
            });
        } catch (SecurityException unused) {
            onSuccessListener.onSuccess(null);
        }
    }

    private void addPendingLocationRequest(LocationRequest locationRequest, LocationActivityResultListener locationActivityResultListener) {
        this.mPendingLocationRequests.add(locationActivityResultListener);
        if (this.mPendingLocationRequests.size() == 1) {
            resolveUserSettingsForRequest(locationRequest);
        }
    }

    private void resolveUserSettingsForRequest(LocationRequest locationRequest) {
        final Activity currentActivity = this.mActivityProvider.getCurrentActivity();
        if (currentActivity == null) {
            executePendingRequests(0);
            return;
        }
        Task<LocationSettingsResponse> checkLocationSettings = LocationServices.getSettingsClient(this.mContext).checkLocationSettings(new LocationSettingsRequest.Builder().addLocationRequest(locationRequest).build());
        checkLocationSettings.addOnSuccessListener(new OnSuccessListener<LocationSettingsResponse>() {
            public void onSuccess(LocationSettingsResponse locationSettingsResponse) {
                LocationModule.this.executePendingRequests(-1);
            }
        });
        checkLocationSettings.addOnFailureListener(new OnFailureListener() {
            public void onFailure(@NonNull Exception exc) {
                if (((ApiException) exc).getStatusCode() != 6) {
                    LocationModule.this.executePendingRequests(0);
                    return;
                }
                try {
                    LocationModule.this.mUIManager.registerActivityEventListener(LocationModule.this);
                    ((ResolvableApiException) exc).startResolutionForResult(currentActivity, 42);
                } catch (IntentSender.SendIntentException unused) {
                    LocationModule.this.executePendingRequests(0);
                }
            }
        });
    }

    private void pauseLocationUpdatesForRequest(Integer num) {
        FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this.mContext);
        if (this.mLocationCallbacks.containsKey(num)) {
            fusedLocationProviderClient.removeLocationUpdates(this.mLocationCallbacks.get(num));
        }
    }

    private void resumeLocationUpdates() {
        FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this.mContext);
        for (Integer next : this.mLocationCallbacks.keySet()) {
            LocationCallback locationCallback = this.mLocationCallbacks.get(next);
            LocationRequest locationRequest = this.mLocationRequests.get(next);
            if (!(locationCallback == null || locationRequest == null)) {
                try {
                    fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, Looper.myLooper());
                } catch (SecurityException e) {
                    String str = TAG;
                    Log.e(str, "Error occurred while resuming location updates: " + e.toString());
                }
            }
        }
    }

    private void removeLocationUpdatesForRequest(Integer num) {
        pauseLocationUpdatesForRequest(num);
        this.mLocationCallbacks.remove(num);
        this.mLocationRequests.remove(num);
    }

    /* access modifiers changed from: package-private */
    public void sendLocationResponse(int i, Bundle bundle) {
        bundle.putInt("watchId", i);
        this.mEventEmitter.emit(LOCATION_EVENT_NAME, bundle);
    }

    /* access modifiers changed from: private */
    public void executePendingRequests(int i) {
        for (LocationActivityResultListener onResult : this.mPendingLocationRequests) {
            onResult.onResult(i);
        }
        this.mPendingLocationRequests.clear();
    }

    private void startHeadingUpdate() {
        if (this.mSensorManager != null && this.mContext != null) {
            SmartLocation.LocationControl config = SmartLocation.with(this.mContext).location().oneFix().config(LocationParams.BEST_EFFORT);
            Location lastLocation = config.getLastLocation();
            if (lastLocation != null) {
                this.mGeofield = new GeomagneticField((float) lastLocation.getLatitude(), (float) lastLocation.getLongitude(), (float) lastLocation.getAltitude(), System.currentTimeMillis());
            } else {
                config.start(new OnLocationUpdatedListener() {
                    public void onLocationUpdated(Location location) {
                        GeomagneticField unused = LocationModule.this.mGeofield = new GeomagneticField((float) location.getLatitude(), (float) location.getLongitude(), (float) location.getAltitude(), System.currentTimeMillis());
                    }
                });
            }
            this.mSensorManager.registerListener(this, this.mSensorManager.getDefaultSensor(2), 3);
            this.mSensorManager.registerListener(this, this.mSensorManager.getDefaultSensor(1), 3);
        }
    }

    private void sendUpdate() {
        float[] fArr = new float[9];
        if (SensorManager.getRotationMatrix(fArr, new float[9], this.mGravity, this.mGeomagnetic)) {
            float[] fArr2 = new float[3];
            SensorManager.getOrientation(fArr, fArr2);
            if (((double) Math.abs(fArr2[0] - this.mLastAzimut)) > DEGREE_DELTA && ((float) (System.currentTimeMillis() - this.mLastUpdate)) > TIME_DELTA) {
                this.mLastAzimut = fArr2[0];
                this.mLastUpdate = System.currentTimeMillis();
                float calcMagNorth = calcMagNorth(fArr2[0]);
                float calcTrueNorth = calcTrueNorth(calcMagNorth);
                Bundle bundle = new Bundle();
                Bundle headingToBundle = LocationHelpers.headingToBundle((double) calcTrueNorth, (double) calcMagNorth, this.mAccuracy);
                bundle.putInt("watchId", this.mHeadingId);
                bundle.putBundle("heading", headingToBundle);
                this.mEventEmitter.emit(HEADING_EVENT_NAME, bundle);
            }
        }
    }

    private float calcMagNorth(float f) {
        return (((float) Math.toDegrees((double) f)) + 360.0f) % 360.0f;
    }

    private float calcTrueNorth(float f) {
        if (isMissingPermissions() || this.mGeofield == null) {
            return -1.0f;
        }
        return f + this.mGeofield.getDeclination();
    }

    private void stopHeadingWatch() {
        if (this.mSensorManager != null) {
            this.mSensorManager.unregisterListener(this);
        }
    }

    private void destroyHeadingWatch() {
        stopHeadingWatch();
        this.mSensorManager = null;
        this.mGravity = null;
        this.mGeomagnetic = null;
        this.mGeofield = null;
        this.mHeadingId = 0;
        this.mLastAzimut = 0.0f;
        this.mAccuracy = 0;
    }

    private void startWatching() {
        if (this.mContext != null) {
            if (!isMissingPermissions()) {
                this.mGeocoderPaused = false;
            }
            resumeLocationUpdates();
        }
    }

    private void stopWatching() {
        if (this.mContext != null) {
            if (Geocoder.isPresent() && !isMissingPermissions()) {
                SmartLocation.with(this.mContext).geocoding().stop();
                this.mGeocoderPaused = true;
            }
            for (Integer pauseLocationUpdatesForRequest : this.mLocationCallbacks.keySet()) {
                pauseLocationUpdatesForRequest(pauseLocationUpdatesForRequest);
            }
        }
    }

    private Bundle handleLocationPermissions(Map<String, PermissionsResponse> map) {
        PermissionsResponse permissionsResponse = map.get("android.permission.ACCESS_FINE_LOCATION");
        PermissionsResponse permissionsResponse2 = map.get("android.permission.ACCESS_COARSE_LOCATION");
        PermissionsStatus permissionsStatus = PermissionsStatus.UNDETERMINED;
        String str = ViewProps.NONE;
        boolean z = true;
        Boolean valueOf = Boolean.valueOf(permissionsResponse2.getCanAskAgain() && permissionsResponse.getCanAskAgain());
        if (permissionsResponse.getStatus() == PermissionsStatus.GRANTED) {
            str = "fine";
            permissionsStatus = PermissionsStatus.GRANTED;
        } else if (permissionsResponse2.getStatus() == PermissionsStatus.GRANTED) {
            str = "coarse";
            permissionsStatus = PermissionsStatus.GRANTED;
        } else if (permissionsResponse.getStatus() == PermissionsStatus.DENIED && permissionsResponse2.getStatus() == PermissionsStatus.DENIED) {
            permissionsStatus = PermissionsStatus.DENIED;
        }
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle2.putString("scope", str);
        bundle.putString("status", permissionsStatus.getStatus());
        bundle.putString(PermissionsResponse.EXPIRES_KEY, "never");
        bundle.putBoolean(PermissionsResponse.CAN_ASK_AGAIN_KEY, valueOf.booleanValue());
        if (permissionsStatus != PermissionsStatus.GRANTED) {
            z = false;
        }
        bundle.putBoolean(PermissionsResponse.GRANTED_KEY, z);
        bundle.putBundle(DeviceInfo.OS_NAME, bundle2);
        return bundle;
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1) {
            this.mGravity = sensorEvent.values;
        } else if (sensorEvent.sensor.getType() == 2) {
            this.mGeomagnetic = sensorEvent.values;
        }
        if (this.mGravity != null && this.mGeomagnetic != null) {
            sendUpdate();
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
        this.mAccuracy = i;
    }

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        if (i == 42) {
            executePendingRequests(i2);
            this.mUIManager.unregisterActivityEventListener(this);
        }
    }

    public void onHostResume() {
        startWatching();
        startHeadingUpdate();
    }

    public void onHostPause() {
        stopWatching();
        stopHeadingWatch();
    }

    public void onHostDestroy() {
        stopWatching();
        stopHeadingWatch();
    }
}
