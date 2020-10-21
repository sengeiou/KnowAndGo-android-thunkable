package com.google.android.gms.internal.ads;

final /* synthetic */ class zzcli implements zzbrw {
    private final zzbgz zzemf;

    zzcli(zzbgz zzbgz) {
        this.zzemf = zzbgz;
    }

    public final void onAdImpression() {
        zzbgz zzbgz = this.zzemf;
        if (zzbgz.zzaai() != null) {
            zzbgz.zzaai().zzabd();
        }
    }
}
