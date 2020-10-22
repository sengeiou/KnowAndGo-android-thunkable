package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.view.Surface;
import java.lang.ref.WeakReference;

final class zzbdp implements zzhh {
    private WeakReference<zzhh> zzefl;
    private final /* synthetic */ zzbdk zzefm;

    private zzbdp(zzbdk zzbdk) {
        this.zzefm = zzbdk;
        this.zzefl = new WeakReference<>((Object) null);
    }

    public final void zza(zzhh zzhh) {
        this.zzefl = new WeakReference<>(zzhh);
    }

    public final void zzb(int i, long j) {
        zzhh zzhh = (zzhh) this.zzefl.get();
        if (zzhh != null) {
            zzhh.zzb(i, j);
        }
    }

    public final void zza(int i, int i2, float f) {
        zzhh zzhh = (zzhh) this.zzefl.get();
        if (zzhh != null) {
            zzhh.zza(i, i2, f);
        }
    }

    public final void zza(Surface surface) {
        zzhh zzhh = (zzhh) this.zzefl.get();
        if (zzhh != null) {
            zzhh.zza(surface);
        }
    }

    public final void zzb(zzgv zzgv) {
        this.zzefm.zzm("DecoderInitializationError", zzgv.getMessage());
        zzhh zzhh = (zzhh) this.zzefl.get();
        if (zzhh != null) {
            zzhh.zzb(zzgv);
        }
    }

    public final void zzb(MediaCodec.CryptoException cryptoException) {
        this.zzefm.zzm("CryptoError", cryptoException.getMessage());
        zzhh zzhh = (zzhh) this.zzefl.get();
        if (zzhh != null) {
            zzhh.zzb(cryptoException);
        }
    }

    public final void zza(String str, long j, long j2) {
        zzhh zzhh = (zzhh) this.zzefl.get();
        if (zzhh != null) {
            zzhh.zza(str, j, j2);
        }
    }
}
