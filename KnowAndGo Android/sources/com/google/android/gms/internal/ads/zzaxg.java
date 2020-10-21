package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@zzard
public final class zzaxg {
    public static final zzbbl zzdvp = zzbbm.zza(new ThreadPoolExecutor(2, Integer.MAX_VALUE, 10, TimeUnit.SECONDS, new SynchronousQueue(), zzdx("Default")));
    public static final zzbbl zzdvq;
    public static final ScheduledExecutorService zzdvr = new ScheduledThreadPoolExecutor(3, zzdx("Schedule"));

    public static <T> zzbbh<T> zza(Callable<T> callable) {
        return zzdvp.zza(callable);
    }

    private static ThreadFactory zzdx(String str) {
        return new zzaxh(str);
    }

    public static zzbbh<?> zzc(Runnable runnable) {
        return zzdvp.zze(runnable);
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), zzdx("Loader"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        zzdvq = zzbbm.zza(threadPoolExecutor);
    }
}
