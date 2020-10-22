package com.google.android.gms.internal.ads;

final /* synthetic */ class zzber implements Runnable {
    private final int zzdwj;
    private final int zzdwk;
    private final zzbek zzegk;

    zzber(zzbek zzbek, int i, int i2) {
        this.zzegk = zzbek;
        this.zzdwj = i;
        this.zzdwk = i2;
    }

    public final void run() {
        this.zzegk.zzq(this.zzdwj, this.zzdwk);
    }
}
