package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzbzp implements zzdti<zzbzl> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<zzaxb> zzerj;
    private final zzdtu<zzbyx> zzews;
    private final zzdtu<zzbzt> zzeyl;
    private final zzdtu<Executor> zzfgh;
    private final zzdtu<Executor> zzfhi;
    private final zzdtu<zzcxv> zzfhr;
    private final zzdtu<zzbyt> zzfnh;

    private zzbzp(zzdtu<Context> zzdtu, zzdtu<zzaxb> zzdtu2, zzdtu<zzcxv> zzdtu3, zzdtu<zzbyx> zzdtu4, zzdtu<zzbyt> zzdtu5, zzdtu<zzbzt> zzdtu6, zzdtu<Executor> zzdtu7, zzdtu<Executor> zzdtu8) {
        this.zzeoj = zzdtu;
        this.zzerj = zzdtu2;
        this.zzfhr = zzdtu3;
        this.zzews = zzdtu4;
        this.zzfnh = zzdtu5;
        this.zzeyl = zzdtu6;
        this.zzfhi = zzdtu7;
        this.zzfgh = zzdtu8;
    }

    public static zzbzp zza(zzdtu<Context> zzdtu, zzdtu<zzaxb> zzdtu2, zzdtu<zzcxv> zzdtu3, zzdtu<zzbyx> zzdtu4, zzdtu<zzbyt> zzdtu5, zzdtu<zzbzt> zzdtu6, zzdtu<Executor> zzdtu7, zzdtu<Executor> zzdtu8) {
        return new zzbzp(zzdtu, zzdtu2, zzdtu3, zzdtu4, zzdtu5, zzdtu6, zzdtu7, zzdtu8);
    }

    public final /* synthetic */ Object get() {
        return new zzbzl(this.zzeoj.get(), this.zzerj.get(), this.zzfhr.get(), this.zzews.get(), this.zzfnh.get(), this.zzeyl.get(), this.zzfhi.get(), this.zzfgh.get());
    }
}
