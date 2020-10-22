package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcuy implements zzdti<zzcuw> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<zzbai> zzfej;
    private final zzdtu<zzbbl> zzfgh;

    private zzcuy(zzdtu<zzbbl> zzdtu, zzdtu<Context> zzdtu2, zzdtu<zzbai> zzdtu3) {
        this.zzfgh = zzdtu;
        this.zzeoj = zzdtu2;
        this.zzfej = zzdtu3;
    }

    public static zzcuy zzp(zzdtu<zzbbl> zzdtu, zzdtu<Context> zzdtu2, zzdtu<zzbai> zzdtu3) {
        return new zzcuy(zzdtu, zzdtu2, zzdtu3);
    }

    public final /* synthetic */ Object get() {
        return new zzcuw(this.zzfgh.get(), this.zzeoj.get(), this.zzfej.get());
    }
}
