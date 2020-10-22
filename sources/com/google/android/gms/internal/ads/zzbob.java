package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

public final class zzbob implements zzdti<zzcva<zzcrd>> {
    private final zzdtu<ScheduledExecutorService> zzfgw;
    private final zzdtu<zzcre> zzfhu;

    public zzbob(zzdtu<zzcre> zzdtu, zzdtu<ScheduledExecutorService> zzdtu2) {
        this.zzfhu = zzdtu;
        this.zzfgw = zzdtu2;
    }

    public final /* synthetic */ Object get() {
        return (zzcva) zzdto.zza(new zzctz(this.zzfhu.get(), 0, this.zzfgw.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
