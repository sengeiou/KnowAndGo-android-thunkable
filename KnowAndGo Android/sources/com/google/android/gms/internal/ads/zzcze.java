package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class zzcze<E, V> implements zzbbh<V> {
    private final E zzgme;
    private final String zzgmf;
    private final zzbbh<V> zzgmg;

    @VisibleForTesting(otherwise = 3)
    public zzcze(E e, String str, zzbbh<V> zzbbh) {
        this.zzgme = e;
        this.zzgmf = str;
        this.zzgmg = zzbbh;
    }

    public final void zza(Runnable runnable, Executor executor) {
        this.zzgmg.zza(runnable, executor);
    }

    public final boolean cancel(boolean z) {
        return this.zzgmg.cancel(z);
    }

    public final V get() throws InterruptedException, ExecutionException {
        return this.zzgmg.get();
    }

    public final V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.zzgmg.get(j, timeUnit);
    }

    public final boolean isCancelled() {
        return this.zzgmg.isCancelled();
    }

    public final boolean isDone() {
        return this.zzgmg.isDone();
    }

    public final E zzanb() {
        return this.zzgme;
    }

    public final String zzanc() {
        return this.zzgmf;
    }

    public final String toString() {
        String str = this.zzgmf;
        int identityHashCode = System.identityHashCode(this);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
        sb.append(str);
        sb.append("@");
        sb.append(identityHashCode);
        return sb.toString();
    }
}
