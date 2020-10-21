package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class zzcmz<AdT> implements zzdti<zzcmx<AdT>> {
    private final zzdtu<zzdae> zzerp;
    private final zzdtu<zzbpe<AdT>> zzfgg;
    private final zzdtu<Executor> zzfgh;
    private final zzdtu<ScheduledExecutorService> zzfgw;
    private final zzdtu<zzczt> zzfhv;
    private final zzdtu<zzbrm> zzgah;
    private final zzdtu<zzcmu> zzgbp;

    private zzcmz(zzdtu<zzczt> zzdtu, zzdtu<zzcmu> zzdtu2, zzdtu<zzbrm> zzdtu3, zzdtu<zzdae> zzdtu4, zzdtu<zzbpe<AdT>> zzdtu5, zzdtu<Executor> zzdtu6, zzdtu<ScheduledExecutorService> zzdtu7) {
        this.zzfhv = zzdtu;
        this.zzgbp = zzdtu2;
        this.zzgah = zzdtu3;
        this.zzerp = zzdtu4;
        this.zzfgg = zzdtu5;
        this.zzfgh = zzdtu6;
        this.zzfgw = zzdtu7;
    }

    public static <AdT> zzcmz<AdT> zza(zzdtu<zzczt> zzdtu, zzdtu<zzcmu> zzdtu2, zzdtu<zzbrm> zzdtu3, zzdtu<zzdae> zzdtu4, zzdtu<zzbpe<AdT>> zzdtu5, zzdtu<Executor> zzdtu6, zzdtu<ScheduledExecutorService> zzdtu7) {
        return new zzcmz(zzdtu, zzdtu2, zzdtu3, zzdtu4, zzdtu5, zzdtu6, zzdtu7);
    }

    public final /* synthetic */ Object get() {
        return new zzcmx(this.zzfhv.get(), this.zzgbp.get(), this.zzgah.get(), this.zzerp.get(), this.zzfgg.get(), this.zzfgh.get(), this.zzfgw.get());
    }
}
