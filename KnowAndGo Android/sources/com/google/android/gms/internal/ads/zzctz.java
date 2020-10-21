package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcuz;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzctz<S extends zzcuz> implements zzcva<S> {
    private final ScheduledExecutorService zzfkf;
    private final zzcva<S> zzggw;
    private final long zzgho;

    public zzctz(zzcva<S> zzcva, long j, ScheduledExecutorService scheduledExecutorService) {
        this.zzggw = zzcva;
        this.zzgho = j;
        this.zzfkf = scheduledExecutorService;
    }

    public final zzbbh<S> zzalm() {
        zzbbh zzalm = this.zzggw.zzalm();
        if (this.zzgho > 0) {
            zzalm = zzbar.zza(zzalm, this.zzgho, TimeUnit.MILLISECONDS, this.zzfkf);
        }
        return zzbar.zza(zzalm, Throwable.class, zzcua.zzbqz, zzbbm.zzeaf);
    }
}
