package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

final /* synthetic */ class zzavl implements Callable {
    private final zzavg zzdsp;
    private final String zzdsr;
    private final zzavv zzdss;

    zzavl(zzavg zzavg, zzavv zzavv, String str) {
        this.zzdsp = zzavg;
        this.zzdss = zzavv;
        this.zzdsr = str;
    }

    public final Object call() {
        return this.zzdsp.zza(this.zzdss, this.zzdsr);
    }
}
