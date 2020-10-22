package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

final class zzbdn implements zzgh {
    private WeakReference<zzgh> zzefl;
    private final /* synthetic */ zzbdk zzefm;

    private zzbdn(zzbdk zzbdk) {
        this.zzefm = zzbdk;
        this.zzefl = new WeakReference<>((Object) null);
    }

    public final void zzb(zzgh zzgh) {
        this.zzefl = new WeakReference<>(zzgh);
    }

    public final void zza(boolean z, int i) {
        zzgh zzgh = (zzgh) this.zzefl.get();
        if (zzgh != null) {
            zzgh.zza(z, i);
        }
    }

    public final void zzdo() {
        zzgh zzgh = (zzgh) this.zzefl.get();
        if (zzgh != null) {
            zzgh.zzdo();
        }
    }

    public final void zza(zzgd zzgd) {
        this.zzefm.zzm("PlayerError", zzgd.getMessage());
        zzgh zzgh = (zzgh) this.zzefl.get();
        if (zzgh != null) {
            zzgh.zza(zzgd);
        }
    }
}
