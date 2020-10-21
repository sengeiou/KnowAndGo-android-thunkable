package com.google.android.gms.internal.ads;

public final class zzcjx {
    private zzbrt zzfij;
    private zzcxm zzflu;

    public zzcjx(zzcxm zzcxm) {
        this.zzflu = zzcxm;
    }

    public final void zzakq() {
        if (this.zzfij != null && this.zzflu.zzgkp == 2) {
            this.zzfij.onAdImpression();
        }
    }

    public final void zza(zzbrt zzbrt) {
        this.zzfij = zzbrt;
    }
}
