package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcsf implements zzdti<zzcsd> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<zzbbl> zzfgh;

    private zzcsf(zzdtu<zzbbl> zzdtu, zzdtu<Context> zzdtu2) {
        this.zzfgh = zzdtu;
        this.zzeoj = zzdtu2;
    }

    public static zzcsf zzak(zzdtu<zzbbl> zzdtu, zzdtu<Context> zzdtu2) {
        return new zzcsf(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return new zzcsd(this.zzfgh.get(), this.zzeoj.get());
    }
}
