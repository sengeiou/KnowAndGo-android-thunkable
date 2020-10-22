package p024io.nlopez.smartlocation.geocoding;

import android.content.Context;
import android.location.Location;
import p024io.nlopez.smartlocation.OnGeocodingListener;
import p024io.nlopez.smartlocation.OnReverseGeocodingListener;
import p024io.nlopez.smartlocation.utils.Logger;

/* renamed from: io.nlopez.smartlocation.geocoding.GeocodingProvider */
public interface GeocodingProvider {
    void addLocation(Location location, int i);

    void addName(String str, int i);

    void init(Context context, Logger logger);

    void start(OnGeocodingListener onGeocodingListener, OnReverseGeocodingListener onReverseGeocodingListener);

    void stop();
}
