package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class zzbpq implements zzdti<zzbpk> {
    private final zzdtu<Executor> zzfgh;
    private final zzdtu<ScheduledExecutorService> zzfjc;
    private final zzdtu<zzbbh<zzbph>> zzfjd;

    public zzbpq(zzdtu<Executor> zzdtu, zzdtu<ScheduledExecutorService> zzdtu2, zzdtu<zzbbh<zzbph>> zzdtu3) {
        this.zzfgh = zzdtu;
        this.zzfjc = zzdtu2;
        this.zzfjd = zzdtu3;
    }

    public final /* synthetic */ Object get() {
        return new zzbpk(this.zzfgh.get(), this.zzfjc.get(), this.zzfjd.get());
    }
}
