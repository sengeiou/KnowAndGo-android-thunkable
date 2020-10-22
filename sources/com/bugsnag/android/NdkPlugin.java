package com.bugsnag.android;

import com.bugsnag.android.ndk.NativeBridge;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\u000b\u001a\u00020\fH J\t\u0010\r\u001a\u00020\fH J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo39786d2 = {"Lcom/bugsnag/android/NdkPlugin;", "Lcom/bugsnag/android/BugsnagPlugin;", "()V", "loaded", "", "getLoaded", "()Z", "setLoaded", "(Z)V", "nativeBridge", "Lcom/bugsnag/android/ndk/NativeBridge;", "disableCrashReporting", "", "enableCrashReporting", "loadPlugin", "client", "Lcom/bugsnag/android/Client;", "unloadPlugin", "Companion", "bugsnag-plugin-android-ndk_release"}, mo39787k = 1, mo39788mv = {1, 1, 16})
/* compiled from: NdkPlugin.kt */
public final class NdkPlugin implements BugsnagPlugin {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private boolean loaded;
    private NativeBridge nativeBridge;

    private final native void disableCrashReporting();

    private final native void enableCrashReporting();

    @Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo39786d2 = {"Lcom/bugsnag/android/NdkPlugin$Companion;", "", "()V", "bugsnag-plugin-android-ndk_release"}, mo39787k = 1, mo39788mv = {1, 1, 16})
    /* compiled from: NdkPlugin.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        System.loadLibrary("bugsnag-ndk");
    }

    public boolean getLoaded() {
        return this.loaded;
    }

    public void setLoaded(boolean z) {
        this.loaded = z;
    }

    public void loadPlugin(@NotNull Client client) {
        Intrinsics.checkParameterIsNotNull(client, "client");
        if (this.nativeBridge == null) {
            this.nativeBridge = new NativeBridge();
            client.addObserver(this.nativeBridge);
            client.sendNativeSetupNotification();
        }
        enableCrashReporting();
        Logger.info("Initialised NDK Plugin");
    }

    public void unloadPlugin() {
        disableCrashReporting();
    }
}
