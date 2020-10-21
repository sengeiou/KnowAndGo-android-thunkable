package p024io.nlopez.smartlocation;

import java.util.List;
import p024io.nlopez.smartlocation.geocoding.utils.LocationAddress;

/* renamed from: io.nlopez.smartlocation.OnGeocodingListener */
public interface OnGeocodingListener {
    void onLocationResolved(String str, List<LocationAddress> list);
}
