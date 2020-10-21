package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

public final class zzchp implements zzdti<zzchl> {
    private final zzdtu<zzcji> zzeqw;
    private final zzdtu<zzbtg> zzerw;
    private final zzdtu<zzcgn> zzerz;
    private final zzdtu<zzbbl> zzfgh;
    private final zzdtu<zzcxv> zzfhr;
    private final zzdtu<ScheduledExecutorService> zzfjc;

    private zzchp(zzdtu<zzbtg> zzdtu, zzdtu<zzcxv> zzdtu2, zzdtu<zzcgn> zzdtu3, zzdtu<zzbbl> zzdtu4, zzdtu<ScheduledExecutorService> zzdtu5, zzdtu<zzcji> zzdtu6) {
        this.zzerw = zzdtu;
        this.zzfhr = zzdtu2;
        this.zzerz = zzdtu3;
        this.zzfgh = zzdtu4;
        this.zzfjc = zzdtu5;
        this.zzeqw = zzdtu6;
    }

    public static zzchp zza(zzdtu<zzbtg> zzdtu, zzdtu<zzcxv> zzdtu2, zzdtu<zzcgn> zzdtu3, zzdtu<zzbbl> zzdtu4, zzdtu<ScheduledExecutorService> zzdtu5, zzdtu<zzcji> zzdtu6) {
        return new zzchp(zzdtu, zzdtu2, zzdtu3, zzdtu4, zzdtu5, zzdtu6);
    }

    public final /* synthetic */ Object get() {
        return new zzchl(this.zzerw.get(), this.zzfhr.get(), this.zzerz.get(), this.zzfgh.get(), this.zzfjc.get(), this.zzeqw.get());
    }
}
