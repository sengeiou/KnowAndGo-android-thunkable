package com.google.android.gms.internal.ads;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

public final class zzd extends Thread {
    private static final boolean DEBUG = zzag.DEBUG;
    private final BlockingQueue<zzr<?>> zzh;
    /* access modifiers changed from: private */
    public final BlockingQueue<zzr<?>> zzi;
    private final zzb zzj;
    /* access modifiers changed from: private */
    public final zzab zzk;
    private volatile boolean zzl = false;
    private final zzf zzm;

    public zzd(BlockingQueue<zzr<?>> blockingQueue, BlockingQueue<zzr<?>> blockingQueue2, zzb zzb, zzab zzab) {
        this.zzh = blockingQueue;
        this.zzi = blockingQueue2;
        this.zzj = zzb;
        this.zzk = zzab;
        this.zzm = new zzf(this);
    }

    public final void quit() {
        this.zzl = true;
        interrupt();
    }

    public final void run() {
        if (DEBUG) {
            zzag.m185v("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.zzj.zza();
        while (true) {
            try {
                processRequest();
            } catch (InterruptedException unused) {
                if (this.zzl) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzag.m184e("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    private final void processRequest() throws InterruptedException {
        zzr take = this.zzh.take();
        take.zzb("cache-queue-take");
        take.zza(1);
        try {
            take.isCanceled();
            zzc zza = this.zzj.zza(take.zze());
            if (zza == null) {
                take.zzb("cache-miss");
                if (!this.zzm.zzb(take)) {
                    this.zzi.put(take);
                }
            } else if (zza.isExpired()) {
                take.zzb("cache-hit-expired");
                take.zza(zza);
                if (!this.zzm.zzb(take)) {
                    this.zzi.put(take);
                }
                take.zza(2);
            } else {
                take.zzb("cache-hit");
                zzy zza2 = take.zza(new zzp(zza.data, zza.zzf));
                take.zzb("cache-hit-parsed");
                if (!(zza.zze < System.currentTimeMillis())) {
                    this.zzk.zzb(take, zza2);
                } else {
                    take.zzb("cache-hit-refresh-needed");
                    take.zza(zza);
                    zza2.zzbj = true;
                    if (!this.zzm.zzb(take)) {
                        this.zzk.zza(take, zza2, new zze(this, take));
                    } else {
                        this.zzk.zzb(take, zza2);
                    }
                }
                take.zza(2);
            }
        } finally {
            take.zza(2);
        }
    }
}
