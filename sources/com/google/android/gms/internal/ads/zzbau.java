package com.google.android.gms.internal.ads;

final /* synthetic */ class zzbau implements Runnable {
    private final zzbbr zzbxh;
    private final zzbbh zzdzk;
    private final zzbal zzdzl;

    zzbau(zzbbr zzbbr, zzbal zzbal, zzbbh zzbbh) {
        this.zzbxh = zzbbr;
        this.zzdzl = zzbal;
        this.zzdzk = zzbbh;
    }

    public final void run() {
        zzbar.zza(this.zzbxh, this.zzdzl, this.zzdzk);
    }
}
