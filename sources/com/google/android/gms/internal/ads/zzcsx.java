package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcsx implements zzdti<zzcsv> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<zzbbl> zzfgh;

    private zzcsx(zzdtu<Context> zzdtu, zzdtu<zzbbl> zzdtu2) {
        this.zzeoj = zzdtu;
        this.zzfgh = zzdtu2;
    }

    public static zzcsx zzam(zzdtu<Context> zzdtu, zzdtu<zzbbl> zzdtu2) {
        return new zzcsx(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return new zzcsv(this.zzeoj.get(), this.zzfgh.get());
    }
}
