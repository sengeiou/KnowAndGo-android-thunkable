package p024io.nlopez.smartlocation.geofencing;

import android.content.Context;
import java.util.List;
import p024io.nlopez.smartlocation.OnGeofencingTransitionListener;
import p024io.nlopez.smartlocation.geofencing.model.GeofenceModel;
import p024io.nlopez.smartlocation.utils.Logger;

/* renamed from: io.nlopez.smartlocation.geofencing.GeofencingProvider */
public interface GeofencingProvider {
    void addGeofence(GeofenceModel geofenceModel);

    void addGeofences(List<GeofenceModel> list);

    void init(Context context, Logger logger);

    void removeGeofence(String str);

    void removeGeofences(List<String> list);

    void start(OnGeofencingTransitionListener onGeofencingTransitionListener);

    void stop();
}
