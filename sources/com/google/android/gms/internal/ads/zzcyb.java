package com.google.android.gms.internal.ads;

import java.util.Deque;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;
import javax.annotation.concurrent.GuardedBy;

public final class zzcyb<T> {
    private final zzbbl zzfqw;
    @GuardedBy("this")
    private final Deque<zzbbh<T>> zzglk = new LinkedBlockingDeque();
    private final Callable<T> zzgll;

    public zzcyb(Callable<T> callable, zzbbl zzbbl) {
        this.zzgll = callable;
        this.zzfqw = zzbbl;
    }

    public final synchronized void zzdq(int i) {
        int size = i - this.zzglk.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.zzglk.add(this.zzfqw.zza(this.zzgll));
        }
    }

    public final synchronized zzbbh<T> zzamr() {
        zzdq(1);
        return this.zzglk.poll();
    }

    public final synchronized void zza(zzbbh<T> zzbbh) {
        this.zzglk.addFirst(zzbbh);
    }
}
