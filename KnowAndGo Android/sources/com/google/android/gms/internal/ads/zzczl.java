package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public final class zzczl<O> {
    private final E zzgme;
    @Nullable
    private final String zzgmf;
    private final List<zzbbh<?>> zzgmj;
    final /* synthetic */ zzczf zzgmk;
    private final zzbbh<?> zzgmm;
    private final zzbbh<O> zzgmn;

    private zzczl(zzczf zzczf, E e, String str, zzbbh<?> zzbbh, List<zzbbh<?>> list, zzbbh<O> zzbbh2) {
        this.zzgmk = zzczf;
        this.zzgme = e;
        this.zzgmf = str;
        this.zzgmm = zzbbh;
        this.zzgmj = list;
        this.zzgmn = zzbbh2;
    }

    public final zzczl<O> zzfy(String str) {
        return new zzczl(this.zzgmk, this.zzgme, str, this.zzgmm, this.zzgmj, this.zzgmn);
    }

    public final <O2> zzczl<O2> zzb(zzczc<O, O2> zzczc) {
        return zza(new zzczm(zzczc));
    }

    public final <O2> zzczl<O2> zza(zzbal<O, O2> zzbal) {
        return zza(zzbal, (Executor) this.zzgmk.zzfqw);
    }

    private final <O2> zzczl<O2> zza(zzbal<O, O2> zzbal, Executor executor) {
        return new zzczl(this.zzgmk, this.zzgme, this.zzgmf, this.zzgmm, this.zzgmj, zzbar.zza(this.zzgmn, zzbal, executor));
    }

    public final <O2> zzczl<O2> zzb(zzbbh<O2> zzbbh) {
        return zza(new zzczn(zzbbh), zzbbm.zzeaf);
    }

    public final <T extends Throwable> zzczl<O> zza(Class<T> cls, zzczc<T, O> zzczc) {
        return zza(cls, new zzczo(zzczc));
    }

    public final <T extends Throwable> zzczl<O> zza(Class<T> cls, zzbal<T, O> zzbal) {
        return new zzczl(this.zzgmk, this.zzgme, this.zzgmf, this.zzgmm, this.zzgmj, zzbar.zza(this.zzgmn, cls, zzbal, (Executor) this.zzgmk.zzfqw));
    }

    public final zzczl<O> zza(long j, TimeUnit timeUnit) {
        return new zzczl(this.zzgmk, this.zzgme, this.zzgmf, this.zzgmm, this.zzgmj, zzbar.zza(this.zzgmn, j, timeUnit, this.zzgmk.zzfkf));
    }

    public final zzcze<E, O> zzane() {
        zzcze<E, O> zzcze = new zzcze<>(this.zzgme, this.zzgmf == null ? this.zzgmk.zzw(this.zzgme) : this.zzgmf, this.zzgmn);
        this.zzgmk.zzgmi.zza(zzcze);
        this.zzgmm.zza(new zzczp(this, zzcze), zzbbm.zzeaf);
        zzbar.zza(zzcze, new zzczq(this, zzcze), zzbbm.zzeaf);
        return zzcze;
    }

    public final zzczl<O> zzx(E e) {
        return this.zzgmk.zza(e, zzane());
    }

    /* synthetic */ zzczl(zzczf zzczf, Object obj, String str, zzbbh zzbbh, List list, zzbbh zzbbh2, zzczg zzczg) {
        this(zzczf, obj, (String) null, zzbbh, list, zzbbh2);
    }
}
