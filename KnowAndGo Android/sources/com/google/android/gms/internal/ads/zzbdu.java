package com.google.android.gms.internal.ads;

final /* synthetic */ class zzbdu implements Runnable {
    private final boolean zzecm;
    private final zzbdq zzefz;
    private final long zzega;

    zzbdu(zzbdq zzbdq, boolean z, long j) {
        this.zzefz = zzbdq;
        this.zzecm = z;
        this.zzega = j;
    }

    public final void run() {
        this.zzefz.zzb(this.zzecm, this.zzega);
    }
}
