package com.bugsnag.android;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Handler;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo39786d2 = {"com/bugsnag/android/AnrDetailsCollector$collectAnrErrorDetails$1", "Ljava/lang/Runnable;", "run", "", "bugsnag-plugin-android-anr_release"}, mo39787k = 1, mo39788mv = {1, 1, 16})
/* compiled from: AnrDetailsCollector.kt */
public final class AnrDetailsCollector$collectAnrErrorDetails$1 implements Runnable {
    final /* synthetic */ AtomicInteger $attempts;
    final /* synthetic */ Client $client;
    final /* synthetic */ Error $error;
    final /* synthetic */ Handler $handler;
    final /* synthetic */ AnrDetailsCollector this$0;

    AnrDetailsCollector$collectAnrErrorDetails$1(AnrDetailsCollector anrDetailsCollector, Client client, AtomicInteger atomicInteger, Handler handler, Error error) {
        this.this$0 = anrDetailsCollector;
        this.$client = client;
        this.$attempts = atomicInteger;
        this.$handler = handler;
        this.$error = error;
    }

    public void run() {
        AnrDetailsCollector anrDetailsCollector = this.this$0;
        Context context = this.$client.appContext;
        Intrinsics.checkExpressionValueIsNotNull(context, "client.appContext");
        ActivityManager.ProcessErrorStateInfo collectAnrDetails$bugsnag_plugin_android_anr_release = anrDetailsCollector.collectAnrDetails$bugsnag_plugin_android_anr_release(context);
        if (collectAnrDetails$bugsnag_plugin_android_anr_release != null) {
            this.this$0.addErrorStateInfo$bugsnag_plugin_android_anr_release(this.$error, collectAnrDetails$bugsnag_plugin_android_anr_release);
            this.$client.notify(this.$error, DeliveryStyle.ASYNC_WITH_CACHE, (Callback) null);
        } else if (this.$attempts.getAndIncrement() < 300) {
            this.$handler.postDelayed(this, 100);
        }
    }
}
