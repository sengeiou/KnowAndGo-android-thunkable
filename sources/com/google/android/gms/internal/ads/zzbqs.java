package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbqs implements zzdti<zzbqr> {
    private final zzdtu<zzcgb> zzeox;
    private final zzdtu<zzaxb> zzerj;
    private final zzdtu<zzbai> zzfgp;
    private final zzdtu<zzcxv> zzfhr;
    private final zzdtu<Context> zzfjq;

    private zzbqs(zzdtu<Context> zzdtu, zzdtu<zzcxv> zzdtu2, zzdtu<zzbai> zzdtu3, zzdtu<zzaxb> zzdtu4, zzdtu<zzcgb> zzdtu5) {
        this.zzfjq = zzdtu;
        this.zzfhr = zzdtu2;
        this.zzfgp = zzdtu3;
        this.zzerj = zzdtu4;
        this.zzeox = zzdtu5;
    }

    public static zzbqs zzb(zzdtu<Context> zzdtu, zzdtu<zzcxv> zzdtu2, zzdtu<zzbai> zzdtu3, zzdtu<zzaxb> zzdtu4, zzdtu<zzcgb> zzdtu5) {
        return new zzbqs(zzdtu, zzdtu2, zzdtu3, zzdtu4, zzdtu5);
    }

    public final /* synthetic */ Object get() {
        return new zzbqr(this.zzfjq.get(), this.zzfhr.get(), this.zzfgp.get(), this.zzerj.get(), this.zzeox.get());
    }
}
