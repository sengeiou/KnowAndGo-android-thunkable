package com.google.android.gms.internal.ads;

final /* synthetic */ class zzbdt implements Runnable {
    private final int zzdwj;
    private final zzbdq zzefz;

    zzbdt(zzbdq zzbdq, int i) {
        this.zzefz = zzbdq;
        this.zzdwj = i;
    }

    public final void run() {
        this.zzefz.zzdd(this.zzdwj);
    }
}
