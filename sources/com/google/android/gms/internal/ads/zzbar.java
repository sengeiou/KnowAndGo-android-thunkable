package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@zzard
public final class zzbar {
    public static <V> void zza(zzbbh<V> zzbbh, zzban<? super V> zzban, Executor executor) {
        zzbbh.zza(new zzbas(zzban, zzbbh), executor);
    }

    public static <A, B> zzbbh<B> zza(zzbbh<A> zzbbh, zzbam<A, B> zzbam, Executor executor) {
        zzbbr zzbbr = new zzbbr();
        zzbbh.zza(new zzbat(zzbbr, zzbam, zzbbh), executor);
        zza(zzbbr, zzbbh);
        return zzbbr;
    }

    public static <A, B> zzbbh<B> zza(zzbbh<A> zzbbh, zzbal<? super A, ? extends B> zzbal, Executor executor) {
        zzbbr zzbbr = new zzbbr();
        zzbbh.zza(new zzbau(zzbbr, zzbal, zzbbh), executor);
        zza(zzbbr, zzbbh);
        return zzbbr;
    }

    public static <V> zzbbh<List<V>> zze(Iterable<? extends zzbbh<? extends V>> iterable) {
        zzbbr zzbbr = new zzbbr();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (zzbbh zza : iterable) {
            atomicInteger.incrementAndGet();
            zza(zzbbr, zza);
        }
        zzbav zzbav = new zzbav(iterable, zzbbr);
        for (zzbbh zzbbh : iterable) {
            zzbbh.zza(new zzbaw(zzbbh, atomicInteger, zzbav, zzbbr), zzbbm.zzeaf);
        }
        return zzbbr;
    }

    public static <V> zzbbh<V> zza(zzbbh<V> zzbbh, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        zzbbr zzbbr = new zzbbr();
        zza(zzbbr, zzbbh);
        ScheduledFuture<?> schedule = scheduledExecutorService.schedule(new zzbax(zzbbr), j, timeUnit);
        zza(zzbbh, zzbbr);
        zzbbr.zza(new zzbay(schedule), zzbbm.zzeaf);
        return zzbbr;
    }

    public static <V, X extends Throwable> zzbbh<V> zza(zzbbh<? extends V> zzbbh, Class<X> cls, zzbal<? super X, ? extends V> zzbal, Executor executor) {
        zzbbr zzbbr = new zzbbr();
        zza(zzbbr, zzbbh);
        zzbbh.zza(new zzbaz(zzbbr, zzbbh, cls, zzbal, executor), zzbbm.zzeaf);
        return zzbbr;
    }

    public static <V> zzbbc<V> zza(zzbbh<? extends V>... zzbbhArr) {
        return zzf(Arrays.asList(zzbbhArr));
    }

    public static <V> zzbbc<V> zzf(Iterable<? extends zzbbh<? extends V>> iterable) {
        return new zzbbc<>(iterable);
    }

    public static <T> zzbbg<T> zzm(T t) {
        return new zzbbg<>(t);
    }

    public static <T> zzbbf<T> zzd(Throwable th) {
        return new zzbbf<>(th);
    }

    private static <V> void zza(zzbbh<? extends V> zzbbh, zzbbr<V> zzbbr) {
        zza(zzbbr, zzbbh);
        zzbbh.zza(new zzbba(zzbbr, zzbbh), zzbbm.zzeaf);
    }

    /* access modifiers changed from: private */
    public static <A, B> void zza(zzbbh<A> zzbbh, Future<B> future) {
        zzbbh.zza(new zzbbb(zzbbh, future), zzbbm.zzeaf);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001e  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static final /* synthetic */ void zza(com.google.android.gms.internal.ads.zzbbr r1, com.google.android.gms.internal.ads.zzbbh r2, java.lang.Class r3, com.google.android.gms.internal.ads.zzbal r4, java.util.concurrent.Executor r5) {
        /*
            java.lang.Object r2 = r2.get()     // Catch:{ ExecutionException -> 0x0013, InterruptedException -> 0x000a, Exception -> 0x0008 }
            r1.set(r2)     // Catch:{ ExecutionException -> 0x0013, InterruptedException -> 0x000a, Exception -> 0x0008 }
            return
        L_0x0008:
            r2 = move-exception
            goto L_0x0018
        L_0x000a:
            r2 = move-exception
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
            goto L_0x0018
        L_0x0013:
            r2 = move-exception
            java.lang.Throwable r2 = r2.getCause()
        L_0x0018:
            boolean r3 = r3.isInstance(r2)
            if (r3 == 0) goto L_0x002a
            com.google.android.gms.internal.ads.zzbbg r2 = zzm(r2)
            com.google.android.gms.internal.ads.zzbbh r2 = zza(r2, r4, (java.util.concurrent.Executor) r5)
            zza(r2, r1)
            return
        L_0x002a:
            r1.setException(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbar.zza(com.google.android.gms.internal.ads.zzbbr, com.google.android.gms.internal.ads.zzbbh, java.lang.Class, com.google.android.gms.internal.ads.zzbal, java.util.concurrent.Executor):void");
    }

    static final /* synthetic */ void zza(zzbbr zzbbr, zzbal zzbal, zzbbh zzbbh) {
        if (!zzbbr.isCancelled()) {
            try {
                zza(zzbal.zzf(zzbbh.get()), zzbbr);
            } catch (CancellationException unused) {
                zzbbr.cancel(true);
            } catch (ExecutionException e) {
                zzbbr.setException(e.getCause());
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                zzbbr.setException(e2);
            } catch (Exception e3) {
                zzbbr.setException(e3);
            }
        }
    }
}
