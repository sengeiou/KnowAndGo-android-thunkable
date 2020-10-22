package expo.modules.location;

import android.content.Context;
import android.location.Address;
import android.location.Location;
import android.location.LocationManager;
import android.os.BaseBundle;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import com.amplitude.api.Constants;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.gms.location.LocationRequest;
import expo.modules.location.utils.TimeoutObject;
import java.util.Map;
import org.unimodules.core.Promise;
import org.unimodules.core.errors.CodedException;
import p024io.nlopez.smartlocation.geofencing.providers.GeofencingGooglePlayServicesProvider;
import p024io.nlopez.smartlocation.location.config.LocationAccuracy;
import p024io.nlopez.smartlocation.location.config.LocationParams;

public class LocationHelpers {
    private static final String TAG = "LocationHelpers";

    private static int mapAccuracyToPriority(int i) {
        switch (i) {
            case 1:
                return 105;
            case 2:
                return 104;
            case 4:
            case 5:
            case 6:
                return 100;
            default:
                return 102;
        }
    }

    public static boolean isAnyProviderAvailable(Context context) {
        LocationManager locationManager;
        if (context == null || (locationManager = (LocationManager) context.getSystemService(GeofencingGooglePlayServicesProvider.LOCATION_EXTRA_ID)) == null) {
            return false;
        }
        if (locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled("network")) {
            return true;
        }
        return false;
    }

    public static boolean hasNetworkProviderEnabled(Context context) {
        LocationManager locationManager;
        if (context == null || (locationManager = (LocationManager) context.getSystemService(GeofencingGooglePlayServicesProvider.LOCATION_EXTRA_ID)) == null || !locationManager.isProviderEnabled("network")) {
            return false;
        }
        return true;
    }

    public static <BundleType extends BaseBundle> BundleType locationToBundle(Location location, Class<BundleType> cls) {
        try {
            BundleType bundletype = (BaseBundle) cls.newInstance();
            BaseBundle locationToCoordsBundle = locationToCoordsBundle(location, cls);
            if (locationToCoordsBundle == null) {
                return null;
            }
            if (bundletype instanceof PersistableBundle) {
                ((PersistableBundle) bundletype).putPersistableBundle("coords", (PersistableBundle) locationToCoordsBundle);
            } else if (bundletype instanceof Bundle) {
                ((Bundle) bundletype).putBundle("coords", (Bundle) locationToCoordsBundle);
                ((Bundle) bundletype).putBoolean("mocked", location.isFromMockProvider());
            }
            bundletype.putDouble("timestamp", (double) location.getTime());
            return bundletype;
        } catch (IllegalAccessException | InstantiationException e) {
            String str = TAG;
            Log.e(str, "Unexpected exception was thrown when converting location to the bundle: " + e.toString());
            return null;
        }
    }

    static <BundleType extends BaseBundle> BundleType locationToCoordsBundle(Location location, Class<BundleType> cls) {
        try {
            BundleType bundletype = (BaseBundle) cls.newInstance();
            bundletype.putDouble("latitude", location.getLatitude());
            bundletype.putDouble("longitude", location.getLongitude());
            bundletype.putDouble("altitude", location.getAltitude());
            bundletype.putDouble("accuracy", (double) location.getAccuracy());
            bundletype.putDouble("heading", (double) location.getBearing());
            bundletype.putDouble("speed", (double) location.getSpeed());
            return bundletype;
        } catch (IllegalAccessException | InstantiationException e) {
            String str = TAG;
            Log.e(str, "Unexpected exception was thrown when converting location to coords bundle: " + e.toString());
            return null;
        }
    }

    static Bundle addressToBundle(Address address) {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.AMP_TRACKING_OPTION_CITY, address.getLocality());
        bundle.putString("street", address.getThoroughfare());
        bundle.putString("region", address.getAdminArea());
        bundle.putString(Constants.AMP_TRACKING_OPTION_COUNTRY, address.getCountryName());
        bundle.putString("postalCode", address.getPostalCode());
        bundle.putString("name", address.getFeatureName());
        bundle.putString("isoCountryCode", address.getCountryCode());
        return bundle;
    }

    static Bundle headingToBundle(double d, double d2, int i) {
        Bundle bundle = new Bundle();
        bundle.putDouble("trueHeading", d);
        bundle.putDouble("magHeading", d2);
        bundle.putInt("accuracy", i);
        return bundle;
    }

    public static LocationRequest prepareLocationRequest(Map<String, Object> map) {
        LocationParams mapOptionsToLocationParams = mapOptionsToLocationParams(map);
        return new LocationRequest().setFastestInterval(mapOptionsToLocationParams.getInterval()).setInterval(mapOptionsToLocationParams.getInterval()).setMaxWaitTime(mapOptionsToLocationParams.getInterval()).setSmallestDisplacement(mapOptionsToLocationParams.getDistance()).setPriority(mapAccuracyToPriority(getAccuracyFromOptions(map)));
    }

    public static LocationParams mapOptionsToLocationParams(Map<String, Object> map) {
        LocationParams.Builder buildLocationParamsForAccuracy = buildLocationParamsForAccuracy(getAccuracyFromOptions(map));
        if (map.containsKey("timeInterval")) {
            buildLocationParamsForAccuracy.setInterval(((Number) map.get("timeInterval")).longValue());
        }
        if (map.containsKey("distanceInterval")) {
            buildLocationParamsForAccuracy.setDistance(((Number) map.get("distanceInterval")).floatValue());
        }
        return buildLocationParamsForAccuracy.build();
    }

    static void requestSingleLocation(LocationModule locationModule, LocationRequest locationRequest, final TimeoutObject timeoutObject, final Promise promise) {
        locationRequest.setNumUpdates(1);
        locationModule.requestLocationUpdates(locationRequest, (Integer) null, new LocationRequestCallbacks() {
            public void onLocationChanged(Location location) {
                if (timeoutObject.markDoneIfNotTimedOut()) {
                    promise.resolve(LocationHelpers.locationToBundle(location, Bundle.class));
                }
            }

            public void onLocationError(CodedException codedException) {
                if (timeoutObject.markDoneIfNotTimedOut()) {
                    promise.reject(codedException);
                }
            }

            public void onRequestFailed(CodedException codedException) {
                if (timeoutObject.markDoneIfNotTimedOut()) {
                    promise.reject(codedException);
                }
            }
        });
    }

    static void requestContinuousUpdates(final LocationModule locationModule, LocationRequest locationRequest, final int i, final Promise promise) {
        locationModule.requestLocationUpdates(locationRequest, Integer.valueOf(i), new LocationRequestCallbacks() {
            public void onLocationChanged(Location location) {
                Bundle bundle = new Bundle();
                bundle.putBundle(GeofencingGooglePlayServicesProvider.LOCATION_EXTRA_ID, (Bundle) LocationHelpers.locationToBundle(location, Bundle.class));
                locationModule.sendLocationResponse(i, bundle);
            }

            public void onRequestSuccess() {
                promise.resolve((Object) null);
            }

            public void onRequestFailed(CodedException codedException) {
                promise.reject(codedException);
            }
        });
    }

    private static int getAccuracyFromOptions(Map<String, Object> map) {
        boolean z = map.containsKey("enableHighAccuracy") && ((Boolean) map.get("enableHighAccuracy")).booleanValue();
        if (map.containsKey("accuracy")) {
            return ((Number) map.get("accuracy")).intValue();
        }
        return z ? 4 : 3;
    }

    private static LocationParams.Builder buildLocationParamsForAccuracy(int i) {
        switch (i) {
            case 1:
                return new LocationParams.Builder().setAccuracy(LocationAccuracy.LOWEST).setDistance(3000.0f).setInterval(10000);
            case 2:
                return new LocationParams.Builder().setAccuracy(LocationAccuracy.LOW).setDistance(1000.0f).setInterval(DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
            case 4:
                return new LocationParams.Builder().setAccuracy(LocationAccuracy.HIGH).setDistance(50.0f).setInterval(AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
            case 5:
                return new LocationParams.Builder().setAccuracy(LocationAccuracy.HIGH).setDistance(25.0f).setInterval(1000);
            case 6:
                return new LocationParams.Builder().setAccuracy(LocationAccuracy.HIGH).setDistance(0.0f).setInterval(500);
            default:
                return new LocationParams.Builder().setAccuracy(LocationAccuracy.MEDIUM).setDistance(100.0f).setInterval(3000);
        }
    }
}
