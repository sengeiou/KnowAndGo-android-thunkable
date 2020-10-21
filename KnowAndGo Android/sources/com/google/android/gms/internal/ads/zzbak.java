package com.google.android.gms.internal.ads;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RunnableFuture;
import javax.annotation.Nullable;

@zzard
public abstract class zzbak extends AbstractExecutorService implements zzbbl {
    /* access modifiers changed from: protected */
    public final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new zzbbk(runnable, t);
    }

    /* access modifiers changed from: protected */
    public final <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new zzbbk(callable);
    }

    /* renamed from: zze */
    public final zzbbh<?> submit(Runnable runnable) throws RejectedExecutionException {
        return (zzbbh) super.submit(runnable);
    }

    /* renamed from: zza */
    public final <T> zzbbh<T> submit(Callable<T> callable) throws RejectedExecutionException {
        return (zzbbh) super.submit(callable);
    }

    public /* synthetic */ Future submit(Runnable runnable, @Nullable Object obj) {
        return (zzbbh) super.submit(runnable, obj);
    }
}
