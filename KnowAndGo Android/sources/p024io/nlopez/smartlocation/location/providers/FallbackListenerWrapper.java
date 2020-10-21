package p024io.nlopez.smartlocation.location.providers;

import androidx.annotation.NonNull;
import p024io.nlopez.smartlocation.location.LocationProvider;
import p024io.nlopez.smartlocation.location.ServiceLocationProvider;
import p024io.nlopez.smartlocation.utils.ServiceConnectionListener;

/* renamed from: io.nlopez.smartlocation.location.providers.FallbackListenerWrapper */
class FallbackListenerWrapper implements ServiceConnectionListener {
    private final ServiceLocationProvider childProvider;
    private final MultiFallbackProvider fallbackProvider;
    private final ServiceConnectionListener listener;

    public FallbackListenerWrapper(@NonNull MultiFallbackProvider multiFallbackProvider, ServiceLocationProvider serviceLocationProvider) {
        this.fallbackProvider = multiFallbackProvider;
        this.childProvider = serviceLocationProvider;
        this.listener = serviceLocationProvider.getServiceListener();
    }

    public void onConnected() {
        if (this.listener != null) {
            this.listener.onConnected();
        }
    }

    public void onConnectionSuspended() {
        if (this.listener != null) {
            this.listener.onConnectionSuspended();
        }
        runFallback();
    }

    public void onConnectionFailed() {
        if (this.listener != null) {
            this.listener.onConnectionFailed();
        }
        runFallback();
    }

    private void runFallback() {
        LocationProvider currentProvider = this.fallbackProvider.getCurrentProvider();
        if (currentProvider != null && currentProvider.equals(this.childProvider)) {
            this.fallbackProvider.fallbackProvider();
        }
    }
}
