package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

public final class zzdaa implements zzdti<zzczt> {
    private final zzdtu<zzczu> zzera;
    private final zzdtu<zzbbl> zzfgh;
    private final zzdtu<ScheduledExecutorService> zzfgw;

    private zzdaa(zzdtu<zzbbl> zzdtu, zzdtu<ScheduledExecutorService> zzdtu2, zzdtu<zzczu> zzdtu3) {
        this.zzfgh = zzdtu;
        this.zzfgw = zzdtu2;
        this.zzera = zzdtu3;
    }

    public static zzdaa zzq(zzdtu<zzbbl> zzdtu, zzdtu<ScheduledExecutorService> zzdtu2, zzdtu<zzczu> zzdtu3) {
        return new zzdaa(zzdtu, zzdtu2, zzdtu3);
    }

    public final /* synthetic */ Object get() {
        return new zzczt(this.zzfgh.get(), this.zzfgw.get(), this.zzera.get());
    }
}
