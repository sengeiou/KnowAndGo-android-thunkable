package com.google.android.gms.internal.ads;

final /* synthetic */ class zzcke implements zzbrw {
    private final zzbgz zzemf;

    zzcke(zzbgz zzbgz) {
        this.zzemf = zzbgz;
    }

    public final void onAdImpression() {
        zzbgz zzbgz = this.zzemf;
        if (zzbgz.zzaai() != null) {
            zzbgz.zzaai().zzabd();
        }
    }
}
