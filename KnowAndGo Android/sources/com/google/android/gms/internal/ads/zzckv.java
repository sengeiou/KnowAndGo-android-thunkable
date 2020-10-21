package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzckv implements zzcjv<zzbnf> {
    private final ScheduledExecutorService zzfiw;
    /* access modifiers changed from: private */
    public final zzbrm zzfkw;
    private final zzbbl zzfqw;
    private final zzboc zzgad;
    private final zzckb zzgae;

    public zzckv(zzboc zzboc, zzckb zzckb, zzbrm zzbrm, ScheduledExecutorService scheduledExecutorService, zzbbl zzbbl) {
        this.zzgad = zzboc;
        this.zzgae = zzckb;
        this.zzfkw = zzbrm;
        this.zzfiw = scheduledExecutorService;
        this.zzfqw = zzbbl;
    }

    public final boolean zza(zzcxu zzcxu, zzcxm zzcxm) {
        return zzcxu.zzgkx.zzfjp.zzamn() != null && this.zzgae.zza(zzcxu, zzcxm);
    }

    public final zzbbh<zzbnf> zzb(zzcxu zzcxu, zzcxm zzcxm) {
        return this.zzfqw.zza(new zzckw(this, zzcxu, zzcxm));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbnf zzc(zzcxu zzcxu, zzcxm zzcxm) throws Exception {
        return this.zzgad.zza(new zzbpr(zzcxu, zzcxm, (String) null), new zzbop(zzcxu.zzgkx.zzfjp.zzamn(), new zzckx(this, zzcxu, zzcxm))).zzaeb();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzcxu zzcxu, zzcxm zzcxm) {
        zzbar.zza(zzbar.zza(this.zzgae.zzb(zzcxu, zzcxm), (long) zzcxm.zzgkn, TimeUnit.SECONDS, this.zzfiw), new zzcky(this), (Executor) this.zzfqw);
    }
}
