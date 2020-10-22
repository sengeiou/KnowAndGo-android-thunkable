package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

public final class zzcuq implements zzdti<zzcul> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<zzcpf> zzeow;
    private final zzdtu<zzbbl> zzfgh;
    private final zzdtu<String> zzfgq;
    private final zzdtu<zzcxv> zzfhr;
    private final zzdtu<ScheduledExecutorService> zzfjc;

    private zzcuq(zzdtu<zzbbl> zzdtu, zzdtu<ScheduledExecutorService> zzdtu2, zzdtu<String> zzdtu3, zzdtu<zzcpf> zzdtu4, zzdtu<Context> zzdtu5, zzdtu<zzcxv> zzdtu6) {
        this.zzfgh = zzdtu;
        this.zzfjc = zzdtu2;
        this.zzfgq = zzdtu3;
        this.zzeow = zzdtu4;
        this.zzeoj = zzdtu5;
        this.zzfhr = zzdtu6;
    }

    public static zzcuq zzb(zzdtu<zzbbl> zzdtu, zzdtu<ScheduledExecutorService> zzdtu2, zzdtu<String> zzdtu3, zzdtu<zzcpf> zzdtu4, zzdtu<Context> zzdtu5, zzdtu<zzcxv> zzdtu6) {
        return new zzcuq(zzdtu, zzdtu2, zzdtu3, zzdtu4, zzdtu5, zzdtu6);
    }

    public final /* synthetic */ Object get() {
        return new zzcul(this.zzfgh.get(), this.zzfjc.get(), this.zzfgq.get(), this.zzeow.get(), this.zzeoj.get(), this.zzfhr.get());
    }
}
