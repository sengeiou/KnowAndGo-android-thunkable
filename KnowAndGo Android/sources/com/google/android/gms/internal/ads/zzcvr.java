package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class zzcvr implements zzdti<zzcvo> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<Executor> zzfgh;
    private final zzdtu<ScheduledExecutorService> zzfjc;
    private final zzdtu<zzawi> zzgit;

    public zzcvr(zzdtu<zzawi> zzdtu, zzdtu<Context> zzdtu2, zzdtu<ScheduledExecutorService> zzdtu3, zzdtu<Executor> zzdtu4) {
        this.zzgit = zzdtu;
        this.zzeoj = zzdtu2;
        this.zzfjc = zzdtu3;
        this.zzfgh = zzdtu4;
    }

    public final /* synthetic */ Object get() {
        return new zzcvo(this.zzgit.get(), this.zzeoj.get(), this.zzfjc.get(), this.zzfgh.get());
    }
}
