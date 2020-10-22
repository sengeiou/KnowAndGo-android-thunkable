package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzchb implements zzdti<zzbbh<String>> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<zzdh> zzfwp;
    private final zzdtu<zzbbl> zzfwq;

    private zzchb(zzdtu<zzdh> zzdtu, zzdtu<Context> zzdtu2, zzdtu<zzbbl> zzdtu3) {
        this.zzfwp = zzdtu;
        this.zzeoj = zzdtu2;
        this.zzfwq = zzdtu3;
    }

    public static zzchb zzm(zzdtu<zzdh> zzdtu, zzdtu<Context> zzdtu2, zzdtu<zzbbl> zzdtu3) {
        return new zzchb(zzdtu, zzdtu2, zzdtu3);
    }

    public final /* synthetic */ Object get() {
        return (zzbbh) zzdto.zza(this.zzfwq.get().zza(new zzcgw(this.zzfwp.get(), this.zzeoj.get())), "Cannot return null from a non-@Nullable @Provides method");
    }
}
