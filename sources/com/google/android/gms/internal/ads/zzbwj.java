package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbwj implements zzdti<zzavf> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<zzcxv> zzfhr;
    private final zzbvz zzflo;

    private zzbwj(zzbvz zzbvz, zzdtu<Context> zzdtu, zzdtu<zzcxv> zzdtu2) {
        this.zzflo = zzbvz;
        this.zzeoj = zzdtu;
        this.zzfhr = zzdtu2;
    }

    public static zzbwj zza(zzbvz zzbvz, zzdtu<Context> zzdtu, zzdtu<zzcxv> zzdtu2) {
        return new zzbwj(zzbvz, zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return (zzavf) zzdto.zza(new zzavf(this.zzeoj.get(), this.zzfhr.get().zzglb), "Cannot return null from a non-@Nullable @Provides method");
    }
}
