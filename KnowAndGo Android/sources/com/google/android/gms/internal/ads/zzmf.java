package com.google.android.gms.internal.ads;

final class zzmf implements Runnable {
    private final /* synthetic */ zzma zzavk;
    private final /* synthetic */ zznc zzavr;

    zzmf(zzma zzma, zznc zznc) {
        this.zzavk = zzma;
        this.zzavr = zznc;
    }

    public final void run() {
        this.zzavr.zzdk();
        this.zzavk.zzavi.zzb(this.zzavr);
    }
}
