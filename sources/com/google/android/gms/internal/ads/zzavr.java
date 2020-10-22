package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

final /* synthetic */ class zzavr implements Callable {
    private final Context zzcjt;
    private final zzavg zzdsp;

    zzavr(zzavg zzavg, Context context) {
        this.zzdsp = zzavg;
        this.zzcjt = context;
    }

    public final Object call() {
        return this.zzdsp.zzaf(this.zzcjt);
    }
}
