package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbqw implements zzdti<zzbam<zzcxm, zzayb>> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<zzbai> zzfej;
    private final zzdtu<zzcxv> zzfhr;

    public zzbqw(zzdtu<Context> zzdtu, zzdtu<zzbai> zzdtu2, zzdtu<zzcxv> zzdtu3) {
        this.zzeoj = zzdtu;
        this.zzfej = zzdtu2;
        this.zzfhr = zzdtu3;
    }

    public final /* synthetic */ Object get() {
        return (zzbam) zzdto.zza(new zzbqv(this.zzeoj.get(), this.zzfej.get(), this.zzfhr.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
