package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import javax.annotation.concurrent.GuardedBy;

public final class zzcxk {
    private final Object lock = new Object();
    private final Clock zzbsa;
    private volatile long zzdtz = 0;
    @GuardedBy("lock")
    private volatile int zzgjt = zzcxl.zzgju;

    public zzcxk(Clock clock) {
        this.zzbsa = clock;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzs(int r5, int r6) {
        /*
            r4 = this;
            r4.zzamk()
            com.google.android.gms.common.util.Clock r0 = r4.zzbsa
            long r0 = r0.currentTimeMillis()
            java.lang.Object r2 = r4.lock
            monitor-enter(r2)
            int r3 = r4.zzgjt     // Catch:{ all -> 0x001e }
            if (r3 == r5) goto L_0x0012
            monitor-exit(r2)     // Catch:{ all -> 0x001e }
            return
        L_0x0012:
            r4.zzgjt = r6     // Catch:{ all -> 0x001e }
            int r5 = r4.zzgjt     // Catch:{ all -> 0x001e }
            int r6 = com.google.android.gms.internal.ads.zzcxl.zzgjw     // Catch:{ all -> 0x001e }
            if (r5 != r6) goto L_0x001c
            r4.zzdtz = r0     // Catch:{ all -> 0x001e }
        L_0x001c:
            monitor-exit(r2)     // Catch:{ all -> 0x001e }
            return
        L_0x001e:
            r5 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x001e }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcxk.zzs(int, int):void");
    }

    private final void zzamk() {
        long currentTimeMillis = this.zzbsa.currentTimeMillis();
        synchronized (this.lock) {
            if (this.zzgjt == zzcxl.zzgjw) {
                if (this.zzdtz + ((Long) zzyt.zzpe().zzd(zzacu.zzcwe)).longValue() <= currentTimeMillis) {
                    this.zzgjt = zzcxl.zzgju;
                }
            }
        }
    }

    public final void zzbb(boolean z) {
        if (z) {
            zzs(zzcxl.zzgju, zzcxl.zzgjv);
        } else {
            zzs(zzcxl.zzgjv, zzcxl.zzgju);
        }
    }

    public final boolean zzaml() {
        boolean z;
        synchronized (this.lock) {
            zzamk();
            z = this.zzgjt == zzcxl.zzgjv;
        }
        return z;
    }

    public final boolean zzamm() {
        boolean z;
        synchronized (this.lock) {
            zzamk();
            z = this.zzgjt == zzcxl.zzgjw;
        }
        return z;
    }

    public final void zzuy() {
        zzs(zzcxl.zzgjv, zzcxl.zzgjw);
    }
}
