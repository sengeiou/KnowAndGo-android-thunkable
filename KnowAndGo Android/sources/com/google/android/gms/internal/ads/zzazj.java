package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import javax.annotation.concurrent.GuardedBy;

@zzard
public final class zzazj {
    private final Object lock = new Object();
    private long zzdxx;
    @GuardedBy("lock")
    private long zzdxy = Long.MIN_VALUE;

    public zzazj(long j) {
        this.zzdxx = j;
    }

    public final boolean tryAcquire() {
        synchronized (this.lock) {
            long elapsedRealtime = zzk.zzln().elapsedRealtime();
            if (this.zzdxy + this.zzdxx > elapsedRealtime) {
                return false;
            }
            this.zzdxy = elapsedRealtime;
            return true;
        }
    }

    public final void zzfe(long j) {
        synchronized (this.lock) {
            this.zzdxx = j;
        }
    }
}
