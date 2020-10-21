package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzcwq implements zzcva<zzcwp> {
    private ApplicationInfo applicationInfo;
    private boolean zzdou;
    private ScheduledExecutorService zzfiw;
    private zzamg zzgjk;

    public zzcwq(zzamg zzamg, ScheduledExecutorService scheduledExecutorService, boolean z, ApplicationInfo applicationInfo2) {
        this.zzgjk = zzamg;
        this.zzfiw = scheduledExecutorService;
        this.zzdou = z;
        this.applicationInfo = applicationInfo2;
    }

    public final zzbbh<zzcwp> zzalm() {
        if (!this.zzdou) {
            return zzbar.zzd(new Exception("Auto Collect Location is false."));
        }
        return zzbar.zza(zzbar.zza(this.zzgjk.zza(this.applicationInfo), ((Long) zzyt.zzpe().zzd(zzacu.zzcsq)).longValue(), TimeUnit.MILLISECONDS, this.zzfiw), zzcwr.zzdrn, (Executor) zzaxg.zzdvp);
    }
}
