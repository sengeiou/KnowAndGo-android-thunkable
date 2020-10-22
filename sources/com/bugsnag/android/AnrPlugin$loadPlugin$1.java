package com.bugsnag.android;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39786d2 = {"<anonymous>", "", "run"}, mo39787k = 3, mo39788mv = {1, 1, 16})
/* compiled from: AnrPlugin.kt */
final class AnrPlugin$loadPlugin$1 implements Runnable {
    final /* synthetic */ Client $client;
    final /* synthetic */ AnrPlugin this$0;

    AnrPlugin$loadPlugin$1(AnrPlugin anrPlugin, Client client) {
        this.this$0 = anrPlugin;
        this.$client = client;
    }

    public final void run() {
        this.this$0.client = this.$client;
        AnrPlugin anrPlugin = this.this$0;
        Configuration configuration = this.$client.config;
        Intrinsics.checkExpressionValueIsNotNull(configuration, "client.config");
        anrPlugin.enableAnrReporting(configuration.getCallPreviousSigquitHandler());
        Logger.warn("Initialised ANR Plugin");
    }
}
