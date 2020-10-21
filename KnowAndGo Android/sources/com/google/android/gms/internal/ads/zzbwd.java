package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbwd implements zzdti<zzbuz<zzbsr>> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<zzbai> zzfej;
    private final zzdtu<zzcxm> zzfgo;
    private final zzdtu<zzcxv> zzfhr;
    private final zzbvz zzflo;

    private zzbwd(zzbvz zzbvz, zzdtu<Context> zzdtu, zzdtu<zzbai> zzdtu2, zzdtu<zzcxm> zzdtu3, zzdtu<zzcxv> zzdtu4) {
        this.zzflo = zzbvz;
        this.zzeoj = zzdtu;
        this.zzfej = zzdtu2;
        this.zzfgo = zzdtu3;
        this.zzfhr = zzdtu4;
    }

    public static zzbwd zza(zzbvz zzbvz, zzdtu<Context> zzdtu, zzdtu<zzbai> zzdtu2, zzdtu<zzcxm> zzdtu3, zzdtu<zzcxv> zzdtu4) {
        return new zzbwd(zzbvz, zzdtu, zzdtu2, zzdtu3, zzdtu4);
    }

    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(new zzbwa(this.zzeoj.get(), this.zzfej.get(), this.zzfgo.get(), this.zzfhr.get()), zzbbm.zzeaf), "Cannot return null from a non-@Nullable @Provides method");
    }
}
