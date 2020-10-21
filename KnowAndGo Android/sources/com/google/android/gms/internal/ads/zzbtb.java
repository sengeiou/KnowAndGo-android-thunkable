package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Clock;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

public final class zzbtb extends zzbts<zzbtf> {
    private final Clock zzbsa;
    @GuardedBy("this")
    private boolean zzfgb = false;
    private final ScheduledExecutorService zzfkf;
    @GuardedBy("this")
    private long zzfkg = -1;
    @GuardedBy("this")
    private long zzfkh = -1;
    @GuardedBy("this")
    @Nullable
    private ScheduledFuture<?> zzfki;

    public zzbtb(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        super(Collections.emptySet());
        this.zzfkf = scheduledExecutorService;
        this.zzbsa = clock;
    }

    public final synchronized void onPause() {
        if (!this.zzfgb) {
            if (this.zzfki == null || this.zzfki.isCancelled()) {
                this.zzfkh = -1;
            } else {
                this.zzfki.cancel(true);
                this.zzfkh = this.zzfkg - this.zzbsa.elapsedRealtime();
            }
            this.zzfgb = true;
        }
    }

    public final synchronized void onResume() {
        if (this.zzfgb) {
            if (this.zzfkh > 0 && this.zzfki.isCancelled()) {
                zzfg(this.zzfkh);
            }
            this.zzfgb = false;
        }
    }

    public final synchronized void zzagi() {
        this.zzfgb = false;
        zzfg(0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0043, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzdk(int r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            if (r7 > 0) goto L_0x0005
            monitor-exit(r6)
            return
        L_0x0005:
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x0044 }
            long r1 = (long) r7     // Catch:{ all -> 0x0044 }
            long r0 = r0.toMillis(r1)     // Catch:{ all -> 0x0044 }
            boolean r7 = r6.zzfgb     // Catch:{ all -> 0x0044 }
            if (r7 == 0) goto L_0x0025
            long r2 = r6.zzfkh     // Catch:{ all -> 0x0044 }
            r4 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 <= 0) goto L_0x001f
            long r2 = r6.zzfkh     // Catch:{ all -> 0x0044 }
            int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r7 >= 0) goto L_0x001f
            goto L_0x0021
        L_0x001f:
            long r0 = r6.zzfkh     // Catch:{ all -> 0x0044 }
        L_0x0021:
            r6.zzfkh = r0     // Catch:{ all -> 0x0044 }
            monitor-exit(r6)
            return
        L_0x0025:
            com.google.android.gms.common.util.Clock r7 = r6.zzbsa     // Catch:{ all -> 0x0044 }
            long r2 = r7.elapsedRealtime()     // Catch:{ all -> 0x0044 }
            long r4 = r6.zzfkg     // Catch:{ all -> 0x0044 }
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 > 0) goto L_0x003f
            long r2 = r6.zzfkg     // Catch:{ all -> 0x0044 }
            com.google.android.gms.common.util.Clock r7 = r6.zzbsa     // Catch:{ all -> 0x0044 }
            long r4 = r7.elapsedRealtime()     // Catch:{ all -> 0x0044 }
            r7 = 0
            long r2 = r2 - r4
            int r7 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r7 <= 0) goto L_0x0042
        L_0x003f:
            r6.zzfg(r0)     // Catch:{ all -> 0x0044 }
        L_0x0042:
            monitor-exit(r6)
            return
        L_0x0044:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbtb.zzdk(int):void");
    }

    private final synchronized void zzfg(long j) {
        if (this.zzfki != null && !this.zzfki.isDone()) {
            this.zzfki.cancel(true);
        }
        this.zzfkg = this.zzbsa.elapsedRealtime() + j;
        this.zzfki = this.zzfkf.schedule(new zzbte(this), j, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: private */
    public final void zzagj() {
        zza(zzbtc.zzfka);
    }
}
