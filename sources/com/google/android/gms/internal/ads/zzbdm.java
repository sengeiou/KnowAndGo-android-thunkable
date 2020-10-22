package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import java.lang.ref.WeakReference;

final class zzbdm implements zzgq {
    private WeakReference<zzgq> zzefl;
    private final /* synthetic */ zzbdk zzefm;

    private zzbdm(zzbdk zzbdk) {
        this.zzefm = zzbdk;
        this.zzefl = new WeakReference<>((Object) null);
    }

    public final void zza(zzgq zzgq) {
        this.zzefl = new WeakReference<>(zzgq);
    }

    public final void zza(zzhu zzhu) {
        this.zzefm.zzm("AudioTrackInitializationError", zzhu.getMessage());
        zzgq zzgq = (zzgq) this.zzefl.get();
        if (zzgq != null) {
            zzgq.zza(zzhu);
        }
    }

    public final void zza(zzhv zzhv) {
        this.zzefm.zzm("AudioTrackWriteError", zzhv.getMessage());
        zzgq zzgq = (zzgq) this.zzefl.get();
        if (zzgq != null) {
            zzgq.zza(zzhv);
        }
    }

    public final void zzb(zzgv zzgv) {
        this.zzefm.zzm("DecoderInitializationError", zzgv.getMessage());
        zzgq zzgq = (zzgq) this.zzefl.get();
        if (zzgq != null) {
            zzgq.zzb(zzgv);
        }
    }

    public final void zzb(MediaCodec.CryptoException cryptoException) {
        this.zzefm.zzm("CryptoError", cryptoException.getMessage());
        zzgq zzgq = (zzgq) this.zzefl.get();
        if (zzgq != null) {
            zzgq.zzb(cryptoException);
        }
    }

    public final void zza(String str, long j, long j2) {
        zzgq zzgq = (zzgq) this.zzefl.get();
        if (zzgq != null) {
            zzgq.zza(str, j, j2);
        }
    }
}
