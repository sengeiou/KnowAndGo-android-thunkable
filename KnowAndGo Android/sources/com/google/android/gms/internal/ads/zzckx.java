package com.google.android.gms.internal.ads;

final /* synthetic */ class zzckx implements Runnable {
    private final zzcxm zzfhm;
    private final zzcxu zzfra;
    private final zzckv zzgaf;

    zzckx(zzckv zzckv, zzcxu zzcxu, zzcxm zzcxm) {
        this.zzgaf = zzckv;
        this.zzfra = zzcxu;
        this.zzfhm = zzcxm;
    }

    public final void run() {
        this.zzgaf.zzd(this.zzfra, this.zzfhm);
    }
}
