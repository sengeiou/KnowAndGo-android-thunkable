package com.google.android.gms.internal.ads;

final /* synthetic */ class zzbec implements Runnable {
    private final int zzdwj;
    private final int zzdwk;
    private final zzbdq zzefz;

    zzbec(zzbdq zzbdq, int i, int i2) {
        this.zzefz = zzbdq;
        this.zzdwj = i;
        this.zzdwk = i2;
    }

    public final void run() {
        this.zzefz.zzn(this.zzdwj, this.zzdwk);
    }
}
