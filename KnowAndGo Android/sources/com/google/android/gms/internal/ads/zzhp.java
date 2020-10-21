package com.google.android.gms.internal.ads;

public abstract class zzhp implements zzgf {
    private int state;

    /* access modifiers changed from: protected */
    public abstract long getDurationUs();

    /* access modifiers changed from: protected */
    public abstract boolean isReady();

    /* access modifiers changed from: protected */
    public void onStarted() throws zzgd {
    }

    /* access modifiers changed from: protected */
    public void onStopped() throws zzgd {
    }

    /* access modifiers changed from: protected */
    public abstract void seekTo(long j) throws zzgd;

    public void zza(int i, Object obj) throws zzgd {
    }

    /* access modifiers changed from: protected */
    public abstract void zza(long j, long j2) throws zzgd;

    /* access modifiers changed from: protected */
    public void zzb(long j, boolean z) throws zzgd {
    }

    /* access modifiers changed from: protected */
    public abstract int zzdl(long j) throws zzgd;

    /* access modifiers changed from: protected */
    public abstract long zzdu();

    /* access modifiers changed from: protected */
    public boolean zzdw() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract boolean zzdx();

    /* access modifiers changed from: protected */
    public abstract long zzdy();

    /* access modifiers changed from: protected */
    public void zzdz() throws zzgd {
    }

    /* access modifiers changed from: protected */
    public void zzee() throws zzgd {
    }

    /* access modifiers changed from: protected */
    public final int getState() {
        return this.state;
    }

    /* access modifiers changed from: package-private */
    public final int zzdm(long j) throws zzgd {
        boolean z = false;
        zzkh.checkState(this.state == 0);
        this.state = zzdl(j);
        if (this.state == 0 || this.state == 1 || this.state == -1) {
            z = true;
        }
        zzkh.checkState(z);
        return this.state;
    }

    /* access modifiers changed from: package-private */
    public final void zzc(long j, boolean z) throws zzgd {
        boolean z2 = true;
        if (this.state != 1) {
            z2 = false;
        }
        zzkh.checkState(z2);
        this.state = 2;
        zzb(j, z);
    }

    /* access modifiers changed from: package-private */
    public final void start() throws zzgd {
        zzkh.checkState(this.state == 2);
        this.state = 3;
        onStarted();
    }

    /* access modifiers changed from: package-private */
    public final void stop() throws zzgd {
        zzkh.checkState(this.state == 3);
        this.state = 2;
        onStopped();
    }

    /* access modifiers changed from: package-private */
    public final void disable() throws zzgd {
        zzkh.checkState(this.state == 2);
        this.state = 1;
        zzdz();
    }

    /* access modifiers changed from: package-private */
    public final void release() throws zzgd {
        zzkh.checkState((this.state == 2 || this.state == 3 || this.state == -2) ? false : true);
        this.state = -2;
        zzee();
    }
}
