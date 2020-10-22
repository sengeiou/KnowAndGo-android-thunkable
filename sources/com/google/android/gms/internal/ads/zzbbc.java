package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzbbc<V> {
    private final zzbbr<Void> zzdzv = new zzbbr<>();

    zzbbc(Iterable<? extends zzbbh<? extends V>> iterable) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (zzbbh zzb : iterable) {
            atomicInteger.incrementAndGet();
            zzbar.zza(this.zzdzv, zzb);
        }
        if (atomicInteger.get() == 0) {
            this.zzdzv.set(null);
            return;
        }
        for (zzbbh zza : iterable) {
            zza.zza(new zzbbd(this, atomicInteger), zzbbm.zzeaf);
        }
    }

    public final <C> zzbbh<C> zza(Callable<C> callable, Executor executor) {
        return zzbar.zza(this.zzdzv, new zzbbe(callable), executor);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(AtomicInteger atomicInteger) {
        if (atomicInteger.decrementAndGet() == 0) {
            this.zzdzv.set(null);
        }
    }
}
