package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

final class zzbeg implements zzgq {
    private final /* synthetic */ zzbdq zzegb;

    zzbeg(zzbdq zzbdq) {
        this.zzegb = zzbdq;
    }

    public final void zza(String str, long j, long j2) {
    }

    public final void zza(zzhu zzhu) {
        this.zzegb.zzn("AudioTrackInitializationError", zzhu.getMessage());
    }

    public final void zza(zzhv zzhv) {
        this.zzegb.zzn("AudioTrackWriteError", zzhv.getMessage());
    }

    public final void zzb(zzgv zzgv) {
        this.zzegb.zzn("DecoderInitializationError", zzgv.getMessage());
    }

    public final void zzb(MediaCodec.CryptoException cryptoException) {
        this.zzegb.zzn("CryptoError", cryptoException.getMessage());
    }
}
