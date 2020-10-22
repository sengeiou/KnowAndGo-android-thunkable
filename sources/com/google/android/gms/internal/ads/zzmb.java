package com.google.android.gms.internal.ads;

final class zzmb implements Runnable {
    private final /* synthetic */ zznc zzavj;
    private final /* synthetic */ zzma zzavk;

    zzmb(zzma zzma, zznc zznc) {
        this.zzavk = zzma;
        this.zzavj = zznc;
    }

    public final void run() {
        this.zzavk.zzavi.zza(this.zzavj);
    }
}
