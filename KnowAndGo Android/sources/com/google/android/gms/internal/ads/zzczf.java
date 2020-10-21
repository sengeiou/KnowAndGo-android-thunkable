package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;

public abstract class zzczf<E> {
    /* access modifiers changed from: private */
    public static final zzbbh<?> zzgmh = zzbar.zzm(null);
    /* access modifiers changed from: private */
    public final ScheduledExecutorService zzfkf;
    /* access modifiers changed from: private */
    public final zzbbl zzfqw;
    /* access modifiers changed from: private */
    public final zzczr<E> zzgmi;

    public zzczf(zzbbl zzbbl, ScheduledExecutorService scheduledExecutorService, zzczr<E> zzczr) {
        this.zzfqw = zzbbl;
        this.zzfkf = scheduledExecutorService;
        this.zzgmi = zzczr;
    }

    /* access modifiers changed from: protected */
    public abstract String zzw(E e);

    public final zzczj zzv(E e) {
        return new zzczj(this, e);
    }

    public final <I> zzczl<I> zza(E e, zzbbh<I> zzbbh) {
        return new zzczl(this, e, (String) null, zzbbh, Collections.singletonList(zzbbh), zzbbh, (zzczg) null);
    }

    public final zzczh zza(E e, zzbbh<?>... zzbbhArr) {
        return new zzczh(this, e, Arrays.asList(zzbbhArr));
    }
}
