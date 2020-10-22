package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzbpk {
    private volatile boolean zzarx = true;
    private final Executor zzffi;
    private final ScheduledExecutorService zzfiw;
    private final zzbbh<zzbph> zzfix;

    public zzbpk(Executor executor, ScheduledExecutorService scheduledExecutorService, zzbbh<zzbph> zzbbh) {
        this.zzffi = executor;
        this.zzfiw = scheduledExecutorService;
        this.zzfix = zzbbh;
    }

    public final void zza(zzban<zzbpc> zzban) {
        zzbar.zza(this.zzfix, new zzbpo(this, zzban), this.zzffi);
    }

    /* access modifiers changed from: private */
    public final void zza(List<? extends zzbbh<? extends zzbpc>> list, zzban<zzbpc> zzban) {
        if (list == null || list.isEmpty()) {
            this.zzffi.execute(new zzbpl(zzban));
            return;
        }
        zzbbh<B> zzm = zzbar.zzm(null);
        for (zzbbh zzbpn : list) {
            zzm = zzbar.zza(zzbar.zza(zzm, Throwable.class, new zzbpm(zzban), this.zzffi), new zzbpn(this, zzban, zzbpn), this.zzffi);
        }
        zzbar.zza(zzm, new zzbpp(this, zzban), this.zzffi);
    }

    public final boolean isLoading() {
        return this.zzarx;
    }

    /* access modifiers changed from: private */
    public final void zzafz() {
        this.zzarx = false;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh zza(zzban zzban, zzbbh zzbbh, zzbpc zzbpc) throws Exception {
        if (zzbpc != null) {
            zzban.zzk(zzbpc);
        }
        return zzbar.zza(zzbbh, ((Long) zzyt.zzpe().zzd(zzacu.zzcqx)).longValue(), TimeUnit.MILLISECONDS, this.zzfiw);
    }
}
