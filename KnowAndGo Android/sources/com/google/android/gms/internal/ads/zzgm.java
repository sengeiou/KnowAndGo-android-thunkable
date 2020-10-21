package com.google.android.gms.internal.ads;

import android.os.SystemClock;

final class zzgm {
    private boolean started;
    private long zzacl;
    private long zzacx;

    zzgm() {
    }

    public final void start() {
        if (!this.started) {
            this.started = true;
            this.zzacx = zzdk(this.zzacl);
        }
    }

    public final void stop() {
        if (this.started) {
            this.zzacl = zzdk(this.zzacx);
            this.started = false;
        }
    }

    public final void zzdj(long j) {
        this.zzacl = j;
        this.zzacx = zzdk(j);
    }

    public final long zzdv() {
        return this.started ? zzdk(this.zzacx) : this.zzacl;
    }

    private static long zzdk(long j) {
        return (SystemClock.elapsedRealtime() * 1000) - j;
    }
}
