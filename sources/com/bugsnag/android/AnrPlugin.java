package com.bugsnag.android;

import android.os.Handler;
import android.os.Looper;
import com.bugsnag.android.Error;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\r\u001a\u00020\u000eH J\u0011\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\bH J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0002J\b\u0010\u0013\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0015"}, mo39786d2 = {"Lcom/bugsnag/android/AnrPlugin;", "Lcom/bugsnag/android/BugsnagPlugin;", "()V", "client", "Lcom/bugsnag/android/Client;", "collector", "Lcom/bugsnag/android/AnrDetailsCollector;", "loaded", "", "getLoaded", "()Z", "setLoaded", "(Z)V", "disableAnrReporting", "", "enableAnrReporting", "callPreviousSigquitHandler", "loadPlugin", "notifyAnrDetected", "unloadPlugin", "Companion", "bugsnag-plugin-android-anr_release"}, mo39787k = 1, mo39788mv = {1, 1, 16})
/* compiled from: AnrPlugin.kt */
public final class AnrPlugin implements BugsnagPlugin {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public Client client;
    private final AnrDetailsCollector collector = new AnrDetailsCollector();
    private boolean loaded;

    private final native void disableAnrReporting();

    /* access modifiers changed from: private */
    public final native void enableAnrReporting(boolean z);

    public static final /* synthetic */ Client access$getClient$p(AnrPlugin anrPlugin) {
        Client client2 = anrPlugin.client;
        if (client2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("client");
        }
        return client2;
    }

    @Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo39786d2 = {"Lcom/bugsnag/android/AnrPlugin$Companion;", "", "()V", "bugsnag-plugin-android-anr_release"}, mo39787k = 1, mo39788mv = {1, 1, 16})
    /* compiled from: AnrPlugin.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        System.loadLibrary("bugsnag-plugin-android-anr");
    }

    public boolean getLoaded() {
        return this.loaded;
    }

    public void setLoaded(boolean z) {
        this.loaded = z;
    }

    public void loadPlugin(@NotNull Client client2) {
        Intrinsics.checkParameterIsNotNull(client2, "client");
        new Handler(Looper.getMainLooper()).post(new AnrPlugin$loadPlugin$1(this, client2));
    }

    public void unloadPlugin() {
        disableAnrReporting();
    }

    private final void notifyAnrDetected() {
        Looper mainLooper = Looper.getMainLooper();
        Intrinsics.checkExpressionValueIsNotNull(mainLooper, "Looper.getMainLooper()");
        Thread thread = mainLooper.getThread();
        Intrinsics.checkExpressionValueIsNotNull(thread, "thread");
        BugsnagException bugsnagException = new BugsnagException("ANR", "Application did not respond to UI input", thread.getStackTrace());
        Client client2 = this.client;
        if (client2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("client");
        }
        Configuration configuration = client2.config;
        Throwable th = bugsnagException;
        Client client3 = this.client;
        if (client3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("client");
        }
        Error build = new Error.Builder(configuration, th, client3.sessionTracker, thread, true).severity(Severity.ERROR).severityReasonType("anrError").build();
        AnrDetailsCollector anrDetailsCollector = this.collector;
        Client client4 = this.client;
        if (client4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("client");
        }
        Intrinsics.checkExpressionValueIsNotNull(build, "error");
        anrDetailsCollector.collectAnrErrorDetails$bugsnag_plugin_android_anr_release(client4, build);
    }
}
