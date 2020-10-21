package com.bugsnag.android;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import androidx.annotation.RequiresApi;
import androidx.core.p005os.EnvironmentCompat;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RequiresApi(24)
@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001:\u0001\u0016B8\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012)\u0010\u0004\u001a%\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016R\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0000@\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00060\u0010R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, mo39786d2 = {"Lcom/bugsnag/android/ConnectivityApi24;", "Lcom/bugsnag/android/Connectivity;", "cm", "Landroid/net/ConnectivityManager;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "connected", "", "Lcom/bugsnag/android/NetworkChangeCallback;", "(Landroid/net/ConnectivityManager;Lkotlin/jvm/functions/Function1;)V", "activeNetwork", "Landroid/net/Network;", "networkCallback", "Lcom/bugsnag/android/ConnectivityApi24$ConnectivityTrackerCallback;", "hasNetworkConnection", "registerForNetworkChanges", "retrieveNetworkAccessState", "", "unregisterForNetworkChanges", "ConnectivityTrackerCallback", "bugsnag-android-core_release"}, mo39787k = 1, mo39788mv = {1, 1, 16})
/* compiled from: ConnectivityCompat.kt */
public final class ConnectivityApi24 implements Connectivity {
    @Nullable
    @JvmField
    public volatile Network activeNetwork;

    /* renamed from: cm */
    private final ConnectivityManager f59cm;
    private final ConnectivityTrackerCallback networkCallback;

    public ConnectivityApi24(@NotNull ConnectivityManager connectivityManager, @Nullable Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(connectivityManager, "cm");
        this.f59cm = connectivityManager;
        this.networkCallback = new ConnectivityTrackerCallback(function1);
    }

    public void registerForNetworkChanges() {
        this.f59cm.registerDefaultNetworkCallback(this.networkCallback);
    }

    public void unregisterForNetworkChanges() {
        this.f59cm.unregisterNetworkCallback(this.networkCallback);
    }

    public boolean hasNetworkConnection() {
        return this.activeNetwork != null;
    }

    @NotNull
    public String retrieveNetworkAccessState() {
        Network activeNetwork2 = this.f59cm.getActiveNetwork();
        NetworkCapabilities networkCapabilities = activeNetwork2 != null ? this.f59cm.getNetworkCapabilities(activeNetwork2) : null;
        if (networkCapabilities == null) {
            return ViewProps.NONE;
        }
        if (networkCapabilities.hasTransport(1)) {
            return "wifi";
        }
        if (networkCapabilities.hasTransport(3)) {
            return "ethernet";
        }
        return networkCapabilities.hasTransport(0) ? "cellular" : EnvironmentCompat.MEDIA_UNKNOWN;
    }

    @Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B0\u0012)\u0010\u0002\u001a%\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003j\u0004\u0018\u0001`\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016R1\u0010\u0002\u001a%\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003j\u0004\u0018\u0001`\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo39786d2 = {"Lcom/bugsnag/android/ConnectivityApi24$ConnectivityTrackerCallback;", "Landroid/net/ConnectivityManager$NetworkCallback;", "cb", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "connected", "", "Lcom/bugsnag/android/NetworkChangeCallback;", "(Lcom/bugsnag/android/ConnectivityApi24;Lkotlin/jvm/functions/Function1;)V", "onAvailable", "network", "Landroid/net/Network;", "onUnavailable", "bugsnag-android-core_release"}, mo39787k = 1, mo39788mv = {1, 1, 16})
    /* compiled from: ConnectivityCompat.kt */
    private final class ConnectivityTrackerCallback extends ConnectivityManager.NetworkCallback {

        /* renamed from: cb */
        private final Function1<Boolean, Unit> f60cb;

        public ConnectivityTrackerCallback(@Nullable Function1<? super Boolean, Unit> function1) {
            this.f60cb = function1;
        }

        public void onUnavailable() {
            super.onUnavailable();
            ConnectivityApi24.this.activeNetwork = null;
            Function1<Boolean, Unit> function1 = this.f60cb;
            if (function1 != null) {
                Unit invoke = function1.invoke(false);
            }
        }

        public void onAvailable(@Nullable Network network) {
            super.onAvailable(network);
            ConnectivityApi24.this.activeNetwork = network;
            Function1<Boolean, Unit> function1 = this.f60cb;
            if (function1 != null) {
                Unit invoke = function1.invoke(true);
            }
        }
    }
}
