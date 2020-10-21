package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.view.Surface;

final class zzbef implements zzhh {
    private final /* synthetic */ zzbdq zzegb;

    zzbef(zzbdq zzbdq) {
        this.zzegb = zzbdq;
    }

    public final void zza(Surface surface) {
    }

    public final void zza(String str, long j, long j2) {
    }

    public final void zzb(int i, long j) {
        StringBuilder sb = new StringBuilder(64);
        sb.append("Dropped frames. Count: ");
        sb.append(i);
        sb.append(" Elapsed: ");
        sb.append(j);
        zzawz.zzdp(sb.toString());
    }

    public final void zza(int i, int i2, float f) {
        int unused = this.zzegb.zzebc = i;
        int unused2 = this.zzegb.zzebd = i2;
        float unused3 = this.zzegb.zzaft = f;
        this.zzegb.zzb(this.zzegb.zzebc, this.zzegb.zzebd, this.zzegb.zzaft);
    }

    public final void zzb(zzgv zzgv) {
        this.zzegb.zzn("DecoderInitializationError", zzgv.getMessage());
    }

    public final void zzb(MediaCodec.CryptoException cryptoException) {
        this.zzegb.zzn("CryptoError", cryptoException.getMessage());
    }
}
