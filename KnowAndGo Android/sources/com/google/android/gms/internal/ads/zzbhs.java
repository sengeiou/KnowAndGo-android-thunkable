package com.google.android.gms.internal.ads;

final /* synthetic */ class zzbhs implements Runnable {
    private final int zzdwj;
    private final int zzdwk;
    private final boolean zzeka;
    private final boolean zzekb;
    private final zzbhq zzemc;

    zzbhs(zzbhq zzbhq, int i, int i2, boolean z, boolean z2) {
        this.zzemc = zzbhq;
        this.zzdwj = i;
        this.zzdwk = i2;
        this.zzeka = z;
        this.zzekb = z2;
    }

    public final void run() {
        this.zzemc.zzb(this.zzdwj, this.zzdwk, this.zzeka, this.zzekb);
    }
}
