package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@zzard
final class zzbbf<T> implements zzbbh<T> {
    private final Throwable cause;
    private final zzbbi zzdzy = new zzbbi();

    zzbbf(Throwable th) {
        this.cause = th;
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

    public final T get() throws ExecutionException {
        throw new ExecutionException(this.cause);
    }

    public final T get(long j, TimeUnit timeUnit) throws ExecutionException {
        throw new ExecutionException(this.cause);
    }

    public final void zza(Runnable runnable, Executor executor) {
        this.zzdzy.zza(runnable, executor);
    }
}
