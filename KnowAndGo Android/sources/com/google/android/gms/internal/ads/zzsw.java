package com.google.android.gms.internal.ads;

import android.os.SystemClock;

public final class zzsw implements zzso {
    private boolean started;
    private zzln zzasc = zzln.zzaug;
    private long zzbno;
    private long zzbnp;

    public final void start() {
        if (!this.started) {
            this.zzbnp = SystemClock.elapsedRealtime();
            this.started = true;
        }
    }

    public final void stop() {
        if (this.started) {
            zzdj(zzdv());
            this.started = false;
        }
    }

    public final void zzdj(long j) {
        this.zzbno = j;
        if (this.started) {
            this.zzbnp = SystemClock.elapsedRealtime();
        }
    }

    public final void zza(zzso zzso) {
        zzdj(zzso.zzdv());
        this.zzasc = zzso.zzhq();
    }

    public final long zzdv() {
        long j = this.zzbno;
        if (!this.started) {
            return j;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.zzbnp;
        if (this.zzasc.zzauh == 1.0f) {
            return j + zzkt.zzea(elapsedRealtime);
        }
        return j + this.zzasc.zzef(elapsedRealtime);
    }

    public final zzln zzb(zzln zzln) {
        if (this.started) {
            zzdj(zzdv());
        }
        this.zzasc = zzln;
        return zzln;
    }

    public final zzln zzhq() {
        return this.zzasc;
    }
}
