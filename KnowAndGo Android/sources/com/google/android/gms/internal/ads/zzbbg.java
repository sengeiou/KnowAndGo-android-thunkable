package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@zzard
final class zzbbg<T> implements zzbbh<T> {
    private final T value;
    private final zzbbi zzdzy = new zzbbi();

    zzbbg(T t) {
        this.value = t;
        this.zzdzy.zzxd();
    }

    public final boolean cancel(boolean z) {
        return false;
    }

    public final boolean isCancelled() {
        return false;
    }

    public final boolean isDone() {
        return true;
    }

    public final T get() {
        return this.value;
    }

    public final T get(long j, TimeUnit timeUnit) {
        return this.value;
    }

    public final void zza(Runnable runnable, Executor executor) {
        this.zzdzy.zza(runnable, executor);
    }
}
