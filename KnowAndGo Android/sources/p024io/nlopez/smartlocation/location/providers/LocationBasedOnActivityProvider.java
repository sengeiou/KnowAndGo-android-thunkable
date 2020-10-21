package p024io.nlopez.smartlocation.location.providers;

import android.content.Context;
import android.location.Location;
import androidx.annotation.NonNull;
import com.google.android.gms.location.DetectedActivity;
import p024io.nlopez.smartlocation.OnActivityUpdatedListener;
import p024io.nlopez.smartlocation.OnLocationUpdatedListener;
import p024io.nlopez.smartlocation.activity.config.ActivityParams;
import p024io.nlopez.smartlocation.activity.providers.ActivityGooglePlayServicesProvider;
import p024io.nlopez.smartlocation.location.LocationProvider;
import p024io.nlopez.smartlocation.location.config.LocationParams;
import p024io.nlopez.smartlocation.utils.Logger;

/* renamed from: io.nlopez.smartlocation.location.providers.LocationBasedOnActivityProvider */
public class LocationBasedOnActivityProvider implements LocationProvider, OnActivityUpdatedListener {
    private final ActivityGooglePlayServicesProvider activityProvider = new ActivityGooglePlayServicesProvider();
    private final LocationBasedOnActivityListener locationBasedOnActivityListener;
    private LocationParams locationParams;
    private final LocationGooglePlayServicesProvider locationProvider = new LocationGooglePlayServicesProvider();
    private OnLocationUpdatedListener locationUpdatedListener;

    /* renamed from: io.nlopez.smartlocation.location.providers.LocationBasedOnActivityProvider$LocationBasedOnActivityListener */
    public interface LocationBasedOnActivityListener {
        LocationParams locationParamsForActivity(DetectedActivity detectedActivity);
    }

    public LocationBasedOnActivityProvider(@NonNull LocationBasedOnActivityListener locationBasedOnActivityListener2) {
        this.locationBasedOnActivityListener = locationBasedOnActivityListener2;
    }

    public void init(Context context, Logger logger) {
        this.locationProvider.init(context, logger);
        this.activityProvider.init(context, logger);
    }

    public void start(OnLocationUpdatedListener onLocationUpdatedListener, LocationParams locationParams2, boolean z) {
        if (!z) {
            this.locationProvider.start(onLocationUpdatedListener, locationParams2, false);
            this.activityProvider.start(this, ActivityParams.NORMAL);
            this.locationParams = locationParams2;
            this.locationUpdatedListener = onLocationUpdatedListener;
            return;
        }
        throw new IllegalArgumentException("singleUpdate cannot be set to true");
    }

    public void stop() {
        this.locationProvider.stop();
        this.activityProvider.stop();
    }

    public Location getLastLocation() {
        return this.locationProvider.getLastLocation();
    }

    public void onActivityUpdated(DetectedActivity detectedActivity) {
        LocationParams locationParamsForActivity = this.locationBasedOnActivityListener.locationParamsForActivity(detectedActivity);
        if (locationParamsForActivity != null && this.locationParams != null && !this.locationParams.equals(locationParamsForActivity)) {
            start(this.locationUpdatedListener, locationParamsForActivity, false);
        }
    }
}
