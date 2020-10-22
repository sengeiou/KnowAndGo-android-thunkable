package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbns implements zzdti<zzbuz<zzbsr>> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<zzbai> zzfej;
    private final zzdtu<zzcxm> zzfgo;
    private final zzbnk zzfhp;
    private final zzdtu<zzcxv> zzfhr;

    public zzbns(zzbnk zzbnk, zzdtu<Context> zzdtu, zzdtu<zzbai> zzdtu2, zzdtu<zzcxm> zzdtu3, zzdtu<zzcxv> zzdtu4) {
        this.zzfhp = zzbnk;
        this.zzeoj = zzdtu;
        this.zzfej = zzdtu2;
        this.zzfgo = zzdtu3;
        this.zzfhr = zzdtu4;
    }

    public static zzbuz<zzbsr> zza(zzbnk zzbnk, Context context, zzbai zzbai, zzcxm zzcxm, zzcxv zzcxv) {
        return (zzbuz) zzdto.zza(new zzbuz(new zzbnl(context, zzbai, zzcxm, zzcxv), zzbbm.zzeaf), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzfhp, this.zzeoj.get(), this.zzfej.get(), this.zzfgo.get(), this.zzfhr.get());
    }
}
