package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;

public final class zzczh {
    private final E zzgme;
    private final List<zzbbh<?>> zzgmj;
    private final /* synthetic */ zzczf zzgmk;

    private zzczh(zzczf zzczf, E e, List<zzbbh<?>> list) {
        this.zzgmk = zzczf;
        this.zzgme = e;
        this.zzgmj = list;
    }

    public final <O> zzczl<O> zzc(Callable<O> callable) {
        zzbbc<V> zzf = zzbar.zzf(this.zzgmj);
        return new zzczl(this.zzgmk, this.zzgme, (String) null, zzf.zza(zzczi.zzghi, zzbbm.zzeaf), this.zzgmj, zzf.zza(callable, this.zzgmk.zzfqw), (zzczg) null);
    }
}
