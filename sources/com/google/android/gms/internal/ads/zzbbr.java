package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
@zzard
public class zzbbr<T> implements zzbbh<T> {
    private final Object lock = new Object();
    @GuardedBy("lock")
    private T value;
    private final zzbbi zzdzy = new zzbbi();
    @GuardedBy("lock")
    private Throwable zzeal;
    @GuardedBy("lock")
    private boolean zzeam;
    @GuardedBy("lock")
    private boolean zzean;

    public final void zza(Runnable runnable, Executor executor) {
        this.zzdzy.zza(runnable, executor);
    }

    public final void set(@Nullable T t) {
        synchronized (this.lock) {
            if (!this.zzean) {
                if (zzxf()) {
                    zzk.zzlk().zzb(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture.set");
                    return;
                }
                this.zzeam = true;
                this.value = t;
                this.lock.notifyAll();
                this.zzdzy.zzxd();
            }
        }
    }

    public final void setException(Throwable th) {
        synchronized (this.lock) {
            if (!this.zzean) {
                if (zzxf()) {
                    zzk.zzlk().zzb(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture.setException");
                    return;
                }
                this.zzeal = th;
                this.lock.notifyAll();
                this.zzdzy.zzxd();
            }
        }
    }

    public T get() throws CancellationException, ExecutionException, InterruptedException {
        T t;
        synchronized (this.lock) {
            while (!zzxf()) {
                this.lock.wait();
            }
            if (this.zzeal != null) {
                throw new ExecutionException(this.zzeal);
            } else if (!this.zzean) {
                t = this.value;
            } else {
                throw new CancellationException("SettableFuture was cancelled.");
            }
        }
        return t;
    }

    public T get(long j, TimeUnit timeUnit) throws CancellationException, ExecutionException, InterruptedException, TimeoutException {
        T t;
        synchronized (this.lock) {
            long millis = timeUnit.toMillis(j);
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = millis + currentTimeMillis;
            while (!zzxf() && currentTimeMillis < j2) {
                this.lock.wait(j2 - currentTimeMillis);
                currentTimeMillis = System.currentTimeMillis();
            }
            if (this.zzean) {
                throw new CancellationException("SettableFuture was cancelled.");
            } else if (this.zzeal != null) {
                throw new ExecutionException(this.zzeal);
            } else if (this.zzeam) {
                t = this.value;
            } else {
                throw new TimeoutException("SettableFuture timed out.");
            }
        }
        return t;
    }

    public boolean cancel(boolean z) {
        if (!z) {
            return false;
        }
        synchronized (this.lock) {
            if (zzxf()) {
                return false;
            }
            this.zzean = true;
            this.zzeam = true;
            this.lock.notifyAll();
            this.zzdzy.zzxd();
            return true;
        }
    }

    public boolean isCancelled() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzean;
        }
        return z;
    }

    public boolean isDone() {
        boolean zzxf;
        synchronized (this.lock) {
            zzxf = zzxf();
        }
        return zzxf;
    }

    @GuardedBy("lock")
    private final boolean zzxf() {
        return this.zzeal != null || this.zzeam;
    }
}
