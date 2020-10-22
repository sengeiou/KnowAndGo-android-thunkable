package com.google.android.gms.internal.ads;

final /* synthetic */ class zzbdv implements Runnable {
    private final boolean zzecm;
    private final zzbdq zzefz;
    private final long zzega;

    zzbdv(zzbdq zzbdq, boolean z, long j) {
        this.zzefz = zzbdq;
        this.zzecm = z;
        this.zzega = j;
    }

    public final void run() {
        this.zzefz.zzc(this.zzecm, this.zzega);
    }
}
