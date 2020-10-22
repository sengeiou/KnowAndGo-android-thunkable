package com.google.android.gms.internal.ads;

final /* synthetic */ class zzcvp implements Runnable {
    private final zzbbh zzdzi;
    private final zzbbr zzfvh;
    private final zzcvo zzgis;

    zzcvp(zzcvo zzcvo, zzbbh zzbbh, zzbbr zzbbr) {
        this.zzgis = zzcvo;
        this.zzdzi = zzbbh;
        this.zzfvh = zzbbr;
    }

    public final void run() {
        this.zzgis.zzb(this.zzdzi, this.zzfvh);
    }
}
