package com.google.android.gms.internal.ads;

final class zzcqi implements zzbsr {
    private final /* synthetic */ zzcqf zzgfi;
    private zzbsr zzgfk;

    public zzcqi(zzcqf zzcqf, zzbsr zzbsr) {
        this.zzgfi = zzcqf;
        this.zzgfk = zzbsr;
    }

    public final void onAdLoaded() {
        this.zzgfi.zzalg();
        this.zzgfk.onAdLoaded();
        this.zzgfi.zzalh();
    }
}
