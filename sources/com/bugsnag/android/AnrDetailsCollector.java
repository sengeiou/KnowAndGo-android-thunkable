package com.bugsnag.android;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\u000bJ\u001f\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0001¢\u0006\u0002\b\u0011J\u0017\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0015J\u001d\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\u0019R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo39786d2 = {"Lcom/bugsnag/android/AnrDetailsCollector;", "", "()V", "handlerThread", "Landroid/os/HandlerThread;", "addErrorStateInfo", "", "error", "Lcom/bugsnag/android/Error;", "anrState", "Landroid/app/ActivityManager$ProcessErrorStateInfo;", "addErrorStateInfo$bugsnag_plugin_android_anr_release", "captureProcessErrorState", "am", "Landroid/app/ActivityManager;", "pid", "", "captureProcessErrorState$bugsnag_plugin_android_anr_release", "collectAnrDetails", "ctx", "Landroid/content/Context;", "collectAnrDetails$bugsnag_plugin_android_anr_release", "collectAnrErrorDetails", "client", "Lcom/bugsnag/android/Client;", "collectAnrErrorDetails$bugsnag_plugin_android_anr_release", "Companion", "bugsnag-plugin-android-anr_release"}, mo39787k = 1, mo39788mv = {1, 1, 16})
/* compiled from: AnrDetailsCollector.kt */
public final class AnrDetailsCollector {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long INFO_POLL_THRESHOLD_MS = 100;
    private static final int MAX_ATTEMPTS = 300;
    private final HandlerThread handlerThread = new HandlerThread("bugsnag-anr-collector");

    public AnrDetailsCollector() {
        this.handlerThread.start();
    }

    @Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo39786d2 = {"Lcom/bugsnag/android/AnrDetailsCollector$Companion;", "", "()V", "INFO_POLL_THRESHOLD_MS", "", "MAX_ATTEMPTS", "", "bugsnag-plugin-android-anr_release"}, mo39787k = 1, mo39788mv = {1, 1, 16})
    /* compiled from: AnrDetailsCollector.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Nullable
    public final ActivityManager.ProcessErrorStateInfo collectAnrDetails$bugsnag_plugin_android_anr_release(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        Object systemService = context.getSystemService("activity");
        if (systemService != null) {
            return captureProcessErrorState$bugsnag_plugin_android_anr_release((ActivityManager) systemService, Process.myPid());
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.ActivityManager");
    }

    @VisibleForTesting
    @Nullable
    public final ActivityManager.ProcessErrorStateInfo captureProcessErrorState$bugsnag_plugin_android_anr_release(@NotNull ActivityManager activityManager, int i) {
        Object obj;
        boolean z;
        Intrinsics.checkParameterIsNotNull(activityManager, "am");
        try {
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
            if (processesInErrorState == null) {
                processesInErrorState = CollectionsKt.emptyList();
            }
            Iterator it = processesInErrorState.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((ActivityManager.ProcessErrorStateInfo) obj).pid == i) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            return (ActivityManager.ProcessErrorStateInfo) obj;
        } catch (RuntimeException unused) {
            return null;
        }
    }

    public final void addErrorStateInfo$bugsnag_plugin_android_anr_release(@NotNull Error error, @NotNull ActivityManager.ProcessErrorStateInfo processErrorStateInfo) {
        Intrinsics.checkParameterIsNotNull(error, "error");
        Intrinsics.checkParameterIsNotNull(processErrorStateInfo, "anrState");
        String str = processErrorStateInfo.shortMsg;
        Intrinsics.checkExpressionValueIsNotNull(str, NotificationCompat.CATEGORY_MESSAGE);
        if (StringsKt.startsWith$default(str, "ANR", false, 2, (Object) null)) {
            str = StringsKt.replaceFirst$default(str, "ANR", "", false, 4, (Object) null);
        }
        error.setExceptionMessage(str);
    }

    public final void collectAnrErrorDetails$bugsnag_plugin_android_anr_release(@NotNull Client client, @NotNull Error error) {
        Intrinsics.checkParameterIsNotNull(client, "client");
        Intrinsics.checkParameterIsNotNull(error, "error");
        Handler handler = new Handler(this.handlerThread.getLooper());
        handler.post(new AnrDetailsCollector$collectAnrErrorDetails$1(this, client, new AtomicInteger(), handler, error));
    }
}
