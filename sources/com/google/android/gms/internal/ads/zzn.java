package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

public final class zzn extends Thread {
    private final zzm zzaa;
    private final zzb zzj;
    private final zzab zzk;
    private volatile boolean zzl = false;
    private final BlockingQueue<zzr<?>> zzz;

    public zzn(BlockingQueue<zzr<?>> blockingQueue, zzm zzm, zzb zzb, zzab zzab) {
        this.zzz = blockingQueue;
        this.zzaa = zzm;
        this.zzj = zzb;
        this.zzk = zzab;
    }

    public final void quit() {
        this.zzl = true;
        interrupt();
    }

    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                processRequest();
            } catch (InterruptedException unused) {
                if (this.zzl) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzag.m184e("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    private final void processRequest() throws InterruptedException {
        zzr take = this.zzz.take();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        take.zza(3);
        try {
            take.zzb("network-queue-take");
            take.isCanceled();
            TrafficStats.setThreadStatsTag(take.zzd());
            zzp zzc = this.zzaa.zzc(take);
            take.zzb("network-http-complete");
            if (!zzc.zzac || !take.zzl()) {
                zzy zza = take.zza(zzc);
                take.zzb("network-parse-complete");
                if (take.zzh() && zza.zzbh != null) {
                    this.zzj.zza(take.zze(), zza.zzbh);
                    take.zzb("network-cache-written");
                }
                take.zzk();
                this.zzk.zzb(take, zza);
                take.zza((zzy<?>) zza);
                take.zza(4);
                return;
            }
            take.zzc("not-modified");
            take.zzm();
        } catch (zzaf e) {
            e.zza(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.zzk.zza(take, e);
            take.zzm();
        } catch (Exception e2) {
            zzag.zza(e2, "Unhandled exception %s", e2.toString());
            zzaf zzaf = new zzaf((Throwable) e2);
            zzaf.zza(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.zzk.zza(take, zzaf);
            take.zzm();
        } finally {
            take.zza(4);
        }
    }
}
