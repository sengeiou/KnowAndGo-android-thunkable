package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbmm implements zzdti<zzbml> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<zzty> zzffq;

    private zzbmm(zzdtu<Context> zzdtu, zzdtu<zzty> zzdtu2) {
        this.zzeoj = zzdtu;
        this.zzffq = zzdtu2;
    }

    public static zzbmm zza(zzdtu<Context> zzdtu, zzdtu<zzty> zzdtu2) {
        return new zzbmm(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return new zzbml(this.zzeoj.get(), this.zzffq.get());
    }
}
