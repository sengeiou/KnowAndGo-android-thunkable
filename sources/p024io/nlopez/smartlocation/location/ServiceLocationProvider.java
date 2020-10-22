package p024io.nlopez.smartlocation.location;

import p024io.nlopez.smartlocation.utils.ServiceConnectionListener;

/* renamed from: io.nlopez.smartlocation.location.ServiceLocationProvider */
public interface ServiceLocationProvider extends LocationProvider {
    ServiceConnectionListener getServiceListener();

    void setServiceListener(ServiceConnectionListener serviceConnectionListener);
}
