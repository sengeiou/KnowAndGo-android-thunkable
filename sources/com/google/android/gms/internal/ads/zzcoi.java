package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbsm;

public final class zzcoi<AdT, AdapterT, ListenerT extends zzbsm> implements zzdti<zzcoe<AdT, AdapterT, ListenerT>> {
    private final zzdtu<zzcjz<AdapterT, ListenerT>> zzfek;
    private final zzdtu<zzbbl> zzfhi;
    private final zzdtu<zzczt> zzfhv;
    private final zzdtu<zzcka<AdT, AdapterT, ListenerT>> zzgcl;

    private zzcoi(zzdtu<zzczt> zzdtu, zzdtu<zzbbl> zzdtu2, zzdtu<zzcjz<AdapterT, ListenerT>> zzdtu3, zzdtu<zzcka<AdT, AdapterT, ListenerT>> zzdtu4) {
        this.zzfhv = zzdtu;
        this.zzfhi = zzdtu2;
        this.zzfek = zzdtu3;
        this.zzgcl = zzdtu4;
    }

    public static <AdT, AdapterT, ListenerT extends zzbsm> zzcoi<AdT, AdapterT, ListenerT> zzf(zzdtu<zzczt> zzdtu, zzdtu<zzbbl> zzdtu2, zzdtu<zzcjz<AdapterT, ListenerT>> zzdtu3, zzdtu<zzcka<AdT, AdapterT, ListenerT>> zzdtu4) {
        return new zzcoi<>(zzdtu, zzdtu2, zzdtu3, zzdtu4);
    }

    public final /* synthetic */ Object get() {
        return new zzcoe(this.zzfhv.get(), this.zzfhi.get(), this.zzfek.get(), this.zzgcl.get());
    }
}
