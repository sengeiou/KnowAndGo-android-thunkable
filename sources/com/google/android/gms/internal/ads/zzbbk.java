package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import javax.annotation.Nullable;

@zzard
final class zzbbk<V> extends FutureTask<V> implements zzbbh<V> {
    private final zzbbi zzdzy = new zzbbi();

    zzbbk(Callable<V> callable) {
        super(callable);
    }

    zzbbk(Runnable runnable, @Nullable V v) {
        super(runnable, v);
    }

    public final void zza(Runnable runnable, Executor executor) {
        this.zzdzy.zza(runnable, executor);
    }

    /* access modifiers changed from: protected */
    public final void done() {
        this.zzdzy.zzxd();
    }
}
