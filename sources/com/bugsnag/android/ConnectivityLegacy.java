package com.bugsnag.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0016B@\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012)\u0010\u0006\u001a%\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007j\u0004\u0018\u0001`\r¢\u0006\u0002\u0010\u000eJ\b\u0010\u0011\u001a\u00020\bH\u0016J\b\u0010\u0012\u001a\u00020\fH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016R\u0012\u0010\u000f\u001a\u00060\u0010R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, mo39786d2 = {"Lcom/bugsnag/android/ConnectivityLegacy;", "Lcom/bugsnag/android/Connectivity;", "context", "Landroid/content/Context;", "cm", "Landroid/net/ConnectivityManager;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "connected", "", "Lcom/bugsnag/android/NetworkChangeCallback;", "(Landroid/content/Context;Landroid/net/ConnectivityManager;Lkotlin/jvm/functions/Function1;)V", "changeReceiver", "Lcom/bugsnag/android/ConnectivityLegacy$ConnectivityChangeReceiver;", "hasNetworkConnection", "registerForNetworkChanges", "retrieveNetworkAccessState", "", "unregisterForNetworkChanges", "ConnectivityChangeReceiver", "bugsnag-android-core_release"}, mo39787k = 1, mo39788mv = {1, 1, 16})
/* compiled from: ConnectivityCompat.kt */
public final class ConnectivityLegacy implements Connectivity {
    private final ConnectivityChangeReceiver changeReceiver;

    /* renamed from: cm */
    private final ConnectivityManager f62cm;
    private final Context context;

    public ConnectivityLegacy(@NotNull Context context2, @NotNull ConnectivityManager connectivityManager, @Nullable Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(connectivityManager, "cm");
        this.context = context2;
        this.f62cm = connectivityManager;
        this.changeReceiver = new ConnectivityChangeReceiver(function1);
    }

    public void registerForNetworkChanges() {
        this.context.registerReceiver(this.changeReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public void unregisterForNetworkChanges() {
        this.context.unregisterReceiver(this.changeReceiver);
    }

    public boolean hasNetworkConnection() {
        NetworkInfo activeNetworkInfo = this.f62cm.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.isConnectedOrConnecting();
        }
        return false;
    }

    @NotNull
    public String retrieveNetworkAccessState() {
        NetworkInfo activeNetworkInfo = this.f62cm.getActiveNetworkInfo();
        Integer valueOf = activeNetworkInfo != null ? Integer.valueOf(activeNetworkInfo.getType()) : null;
        if (valueOf == null) {
            return ViewProps.NONE;
        }
        if (valueOf.intValue() == 1) {
            return "wifi";
        }
        return valueOf.intValue() == 9 ? "ethernet" : "cellular";
    }

    @Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B0\u0012)\u0010\u0002\u001a%\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003j\u0004\u0018\u0001`\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R1\u0010\u0002\u001a%\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003j\u0004\u0018\u0001`\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo39786d2 = {"Lcom/bugsnag/android/ConnectivityLegacy$ConnectivityChangeReceiver;", "Landroid/content/BroadcastReceiver;", "cb", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "connected", "", "Lcom/bugsnag/android/NetworkChangeCallback;", "(Lcom/bugsnag/android/ConnectivityLegacy;Lkotlin/jvm/functions/Function1;)V", "onReceive", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "bugsnag-android-core_release"}, mo39787k = 1, mo39788mv = {1, 1, 16})
    /* compiled from: ConnectivityCompat.kt */
    private final class ConnectivityChangeReceiver extends BroadcastReceiver {

        /* renamed from: cb */
        private final Function1<Boolean, Unit> f63cb;

        public ConnectivityChangeReceiver(@Nullable Function1<? super Boolean, Unit> function1) {
            this.f63cb = function1;
        }

        public void onReceive(@NotNull Context context, @NotNull Intent intent) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(intent, "intent");
            Function1<Boolean, Unit> function1 = this.f63cb;
            if (function1 != null) {
                Unit invoke = function1.invoke(Boolean.valueOf(ConnectivityLegacy.this.hasNetworkConnection()));
            }
        }
    }
}
