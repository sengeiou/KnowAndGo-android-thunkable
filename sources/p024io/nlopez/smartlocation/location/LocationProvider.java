package p024io.nlopez.smartlocation.location;

import android.content.Context;
import android.location.Location;
import p024io.nlopez.smartlocation.OnLocationUpdatedListener;
import p024io.nlopez.smartlocation.location.config.LocationParams;
import p024io.nlopez.smartlocation.utils.Logger;

/* renamed from: io.nlopez.smartlocation.location.LocationProvider */
public interface LocationProvider {
    Location getLastLocation();

    void init(Context context, Logger logger);

    void start(OnLocationUpdatedListener onLocationUpdatedListener, LocationParams locationParams, boolean z);

    void stop();
}
