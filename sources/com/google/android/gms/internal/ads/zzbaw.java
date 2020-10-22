package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

final /* synthetic */ class zzbaw implements Runnable {
    private final zzbbr zzbxg;
    private final zzbbh zzdzo;
    private final AtomicInteger zzdzp;
    private final Runnable zzdzq;

    zzbaw(zzbbh zzbbh, AtomicInteger atomicInteger, Runnable runnable, zzbbr zzbbr) {
        this.zzdzo = zzbbh;
        this.zzdzp = atomicInteger;
        this.zzdzq = runnable;
        this.zzbxg = zzbbr;
    }

    public final void run() {
        zzbbh zzbbh = this.zzdzo;
        AtomicInteger atomicInteger = this.zzdzp;
        Runnable runnable = this.zzdzq;
        zzbbr zzbbr = this.zzbxg;
        try {
            zzbbh.get();
            if (atomicInteger.decrementAndGet() == 0) {
                runnable.run();
            }
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
