package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;

public final class zzbne implements zzdti<zzbtb> {
    private final zzdtu<Clock> zzfgj;
    private final zzdtu<ScheduledExecutorService> zzfgw;

    public zzbne(zzdtu<ScheduledExecutorService> zzdtu, zzdtu<Clock> zzdtu2) {
        this.zzfgw = zzdtu;
        this.zzfgj = zzdtu2;
    }

    public static zzbtb zza(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        return (zzbtb) zzdto.zza(new zzbtb(scheduledExecutorService, clock), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzfgw.get(), this.zzfgj.get());
    }
}
