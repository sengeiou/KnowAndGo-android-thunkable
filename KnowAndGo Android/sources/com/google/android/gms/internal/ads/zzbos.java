package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbos implements zzdti<zzbol> {
    private final zzdtu<zzbry> zzexa;
    private final zzdtu<zzbso> zzexw;
    private final zzdtu<Runnable> zzfbt;
    private final zzdtu<zzcxu> zzfff;
    private final zzdtu<zzaga> zzfgm;
    private final zzdtu<Executor> zzfhi;
    private final zzdtu<zzcxm> zzfhj;
    private final zzdtu<String> zzfhk;

    public zzbos(zzdtu<zzaga> zzdtu, zzdtu<Runnable> zzdtu2, zzdtu<Executor> zzdtu3, zzdtu<zzcxu> zzdtu4, zzdtu<zzcxm> zzdtu5, zzdtu<zzbry> zzdtu6, zzdtu<zzbso> zzdtu7, zzdtu<String> zzdtu8) {
        this.zzfgm = zzdtu;
        this.zzfbt = zzdtu2;
        this.zzfhi = zzdtu3;
        this.zzfff = zzdtu4;
        this.zzfhj = zzdtu5;
        this.zzexa = zzdtu6;
        this.zzexw = zzdtu7;
        this.zzfhk = zzdtu8;
    }

    public final /* synthetic */ Object get() {
        zzbol zzbol = new zzbol(this.zzfgm.get(), this.zzfbt.get(), this.zzfhi.get());
        zzbql.zza((zzbpc) zzbol, this.zzfff.get());
        zzbql.zza((zzbpc) zzbol, this.zzfhj.get());
        zzbql.zza((zzbpc) zzbol, this.zzexa.get());
        zzbql.zza((zzbpc) zzbol, this.zzexw.get());
        zzbql.zza((zzbpc) zzbol, this.zzfhk.get());
        return zzbol;
    }
}
