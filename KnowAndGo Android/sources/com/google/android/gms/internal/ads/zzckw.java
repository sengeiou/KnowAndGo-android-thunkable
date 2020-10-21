package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

final /* synthetic */ class zzckw implements Callable {
    private final zzcxm zzfhm;
    private final zzcxu zzfra;
    private final zzckv zzgaf;

    zzckw(zzckv zzckv, zzcxu zzcxu, zzcxm zzcxm) {
        this.zzgaf = zzckv;
        this.zzfra = zzcxu;
        this.zzfhm = zzcxm;
    }

    public final Object call() {
        return this.zzgaf.zzc(this.zzfra, this.zzfhm);
    }
}
