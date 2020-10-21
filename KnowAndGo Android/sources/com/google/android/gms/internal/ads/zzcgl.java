package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class zzcgl implements zzdti<zzcgb> {
    private final zzdtu<zzclc> zzeog;
    private final zzdtu<Context> zzeoj;
    private final zzdtu<Executor> zzfgh;
    private final zzdtu<Executor> zzfhi;
    private final zzdtu<ScheduledExecutorService> zzfjc;

    public zzcgl(zzdtu<Executor> zzdtu, zzdtu<Context> zzdtu2, zzdtu<Executor> zzdtu3, zzdtu<zzclc> zzdtu4, zzdtu<ScheduledExecutorService> zzdtu5) {
        this.zzfhi = zzdtu;
        this.zzeoj = zzdtu2;
        this.zzfgh = zzdtu3;
        this.zzeog = zzdtu4;
        this.zzfjc = zzdtu5;
    }

    public final /* synthetic */ Object get() {
        return new zzcgb(this.zzfhi.get(), this.zzeoj.get(), this.zzfgh.get(), this.zzeog.get(), this.zzfjc.get());
    }
}
