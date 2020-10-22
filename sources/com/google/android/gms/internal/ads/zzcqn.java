package com.google.android.gms.internal.ads;

final class zzcqn implements zzbsr {
    private zzbsr zzgfk;
    private final /* synthetic */ zzcqj zzgfo;

    public zzcqn(zzcqj zzcqj, zzbsr zzbsr) {
        this.zzgfo = zzcqj;
        this.zzgfk = zzbsr;
    }

    public final void onAdLoaded() {
        this.zzgfo.zzalg();
        this.zzgfk.onAdLoaded();
        this.zzgfo.zzalh();
    }
}
