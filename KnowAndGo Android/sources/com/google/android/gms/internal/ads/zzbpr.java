package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

public final class zzbpr {
    private final zzcxm zzffc;
    private final String zzfis;
    private final zzcxu zzfje;

    public zzbpr(zzcxu zzcxu, zzcxm zzcxm, @Nullable String str) {
        this.zzfje = zzcxu;
        this.zzffc = zzcxm;
        this.zzfis = str == null ? "com.google.ads.mediation.admob.AdMobAdapter" : str;
    }

    public final zzcxu zzaga() {
        return this.zzfje;
    }

    public final zzcxm zzagb() {
        return this.zzffc;
    }

    public final String zzagc() {
        return this.zzfis;
    }
}
