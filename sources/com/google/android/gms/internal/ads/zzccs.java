package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzu;

final /* synthetic */ class zzccs implements zzu {
    private final zzbse zzfss;

    private zzccs(zzbse zzbse) {
        this.zzfss = zzbse;
    }

    static zzu zza(zzbse zzbse) {
        return new zzccs(zzbse);
    }

    public final void zztq() {
        this.zzfss.onAdLeftApplication();
    }
}
