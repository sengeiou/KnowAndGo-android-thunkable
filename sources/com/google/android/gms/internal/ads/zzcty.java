package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;

public final class zzcty implements zzdti<zzctw> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<zzbbl> zzfgh;
    private final zzdtu<Set<String>> zzggm;

    private zzcty(zzdtu<zzbbl> zzdtu, zzdtu<Context> zzdtu2, zzdtu<Set<String>> zzdtu3) {
        this.zzfgh = zzdtu;
        this.zzeoj = zzdtu2;
        this.zzggm = zzdtu3;
    }

    public static zzcty zzn(zzdtu<zzbbl> zzdtu, zzdtu<Context> zzdtu2, zzdtu<Set<String>> zzdtu3) {
        return new zzcty(zzdtu, zzdtu2, zzdtu3);
    }

    public final /* synthetic */ Object get() {
        return new zzctw(this.zzfgh.get(), this.zzeoj.get(), this.zzggm.get());
    }
}
