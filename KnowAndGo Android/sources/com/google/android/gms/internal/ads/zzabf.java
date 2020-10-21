package com.google.android.gms.internal.ads;

import android.content.Context;

final /* synthetic */ class zzabf implements Runnable {
    private final zzabe zzcjs;
    private final Context zzcjt;

    zzabf(zzabe zzabe, Context context) {
        this.zzcjs = zzabe;
        this.zzcjt = context;
    }

    public final void run() {
        this.zzcjs.getRewardedVideoAdInstance(this.zzcjt);
    }
}
