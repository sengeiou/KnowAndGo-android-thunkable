package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbzg implements zzdti<zzavf> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<zzcxv> zzfhr;
    private final zzbzf zzfpe;

    private zzbzg(zzbzf zzbzf, zzdtu<Context> zzdtu, zzdtu<zzcxv> zzdtu2) {
        this.zzfpe = zzbzf;
        this.zzeoj = zzdtu;
        this.zzfhr = zzdtu2;
    }

    public static zzbzg zza(zzbzf zzbzf, zzdtu<Context> zzdtu, zzdtu<zzcxv> zzdtu2) {
        return new zzbzg(zzbzf, zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return (zzavf) zzdto.zza(new zzavf(this.zzeoj.get(), this.zzfhr.get().zzglb), "Cannot return null from a non-@Nullable @Provides method");
    }
}
