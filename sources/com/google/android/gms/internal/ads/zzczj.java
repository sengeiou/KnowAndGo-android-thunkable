package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.concurrent.Callable;

public final class zzczj {
    private final E zzgme;
    private final /* synthetic */ zzczf zzgmk;

    private zzczj(zzczf zzczf, E e) {
        this.zzgmk = zzczf;
        this.zzgme = e;
    }

    public final <O> zzczl<O> zzb(zzbbh<O> zzbbh) {
        return new zzczl(this.zzgmk, this.zzgme, (String) null, zzczf.zzgmh, Collections.emptyList(), zzbbh, (zzczg) null);
    }

    public final <O> zzczl<O> zzd(Callable<O> callable) {
        return zza(callable, this.zzgmk.zzfqw);
    }

    private final <O> zzczl<O> zza(Callable<O> callable, zzbbl zzbbl) {
        return new zzczl(this.zzgmk, this.zzgme, (String) null, zzczf.zzgmh, Collections.emptyList(), zzbbl.zza(callable), (zzczg) null);
    }

    public final zzczl<?> zza(zzczd zzczd, zzbbl zzbbl) {
        return zza(new zzczk(zzczd), zzbbl);
    }
}
