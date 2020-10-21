package com.google.android.gms.internal.ads;

final /* synthetic */ class zzcnz implements Runnable {
    private final zzcxm zzfhm;
    private final zzcxu zzfra;
    private final zzcny zzgcb;
    private final zzcjy zzgcc;

    zzcnz(zzcny zzcny, zzcxu zzcxu, zzcxm zzcxm, zzcjy zzcjy) {
        this.zzgcb = zzcny;
        this.zzfra = zzcxu;
        this.zzfhm = zzcxm;
        this.zzgcc = zzcjy;
    }

    public final void run() {
        zzcny zzcny = this.zzgcb;
        zzcnw.zzc(this.zzfra, this.zzfhm, this.zzgcc);
    }
}
