package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzdad implements zzdti<zzalr> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<zzbai> zzfjy;
    private final zzdac zzgnq;

    public zzdad(zzdac zzdac, zzdtu<Context> zzdtu, zzdtu<zzbai> zzdtu2) {
        this.zzgnq = zzdac;
        this.zzeoj = zzdtu;
        this.zzfjy = zzdtu2;
    }

    public final /* synthetic */ Object get() {
        return (zzalr) zzdto.zza(new zzalk().zzb(this.zzeoj.get(), this.zzfjy.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
