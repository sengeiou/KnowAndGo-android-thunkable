package com.google.android.gms.internal.ads;

import java.io.IOException;

public abstract class zzks implements zzlo, zzlp {
    private int index;
    private int state;
    private final int zzara;
    private zzlq zzarb;
    private zzqw zzarc;
    private long zzard;
    private boolean zzare = true;
    private boolean zzarf;

    public zzks(int i) {
        this.zzara = i;
    }

    /* access modifiers changed from: protected */
    public void onStarted() throws zzku {
    }

    /* access modifiers changed from: protected */
    public void onStopped() throws zzku {
    }

    public void zza(int i, Object obj) throws zzku {
    }

    /* access modifiers changed from: protected */
    public void zza(zzlh[] zzlhArr, long j) throws zzku {
    }

    /* access modifiers changed from: protected */
    public void zzd(long j, boolean z) throws zzku {
    }

    /* access modifiers changed from: protected */
    public void zzdz() {
    }

    /* access modifiers changed from: protected */
    public void zzg(boolean z) throws zzku {
    }

    public final zzlp zzgi() {
        return this;
    }

    public zzso zzgj() {
        return null;
    }

    public int zzgp() throws zzku {
        return 0;
    }

    public final int getTrackType() {
        return this.zzara;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public final int getState() {
        return this.state;
    }

    public final void zza(zzlq zzlq, zzlh[] zzlhArr, zzqw zzqw, long j, boolean z, long j2) throws zzku {
        zzsk.checkState(this.state == 0);
        this.zzarb = zzlq;
        this.state = 1;
        zzg(z);
        zza(zzlhArr, zzqw, j2);
        zzd(j, z);
    }

    public final void start() throws zzku {
        boolean z = true;
        if (this.state != 1) {
            z = false;
        }
        zzsk.checkState(z);
        this.state = 2;
        onStarted();
    }

    public final void zza(zzlh[] zzlhArr, zzqw zzqw, long j) throws zzku {
        zzsk.checkState(!this.zzarf);
        this.zzarc = zzqw;
        this.zzare = false;
        this.zzard = j;
        zza(zzlhArr, j);
    }

    public final zzqw zzgk() {
        return this.zzarc;
    }

    public final boolean zzgl() {
        return this.zzare;
    }

    public final void zzgm() {
        this.zzarf = true;
    }

    public final boolean zzgn() {
        return this.zzarf;
    }

    public final void zzgo() throws IOException {
        this.zzarc.zzjb();
    }

    public final void zzdx(long j) throws zzku {
        this.zzarf = false;
        this.zzare = false;
        zzd(j, false);
    }

    public final void stop() throws zzku {
        zzsk.checkState(this.state == 2);
        this.state = 1;
        onStopped();
    }

    public final void disable() {
        boolean z = true;
        if (this.state != 1) {
            z = false;
        }
        zzsk.checkState(z);
        this.state = 0;
        this.zzarc = null;
        this.zzarf = false;
        zzdz();
    }

    /* access modifiers changed from: protected */
    public final zzlq zzgq() {
        return this.zzarb;
    }

    /* access modifiers changed from: protected */
    public final int getIndex() {
        return this.index;
    }

    /* access modifiers changed from: protected */
    public final int zza(zzlj zzlj, zznd zznd, boolean z) {
        int zzb = this.zzarc.zzb(zzlj, zznd, z);
        if (zzb == -4) {
            if (zznd.zzic()) {
                this.zzare = true;
                if (this.zzarf) {
                    return -4;
                }
                return -3;
            }
            zznd.zzaga += this.zzard;
        } else if (zzb == -5) {
            zzlh zzlh = zzlj.zzaue;
            if (zzlh.zzaua != Long.MAX_VALUE) {
                zzlj.zzaue = zzlh.zzed(zzlh.zzaua + this.zzard);
            }
        }
        return zzb;
    }

    /* access modifiers changed from: protected */
    public final void zzdy(long j) {
        this.zzarc.zzeo(j - this.zzard);
    }

    /* access modifiers changed from: protected */
    public final boolean zzgr() {
        return this.zzare ? this.zzarf : this.zzarc.isReady();
    }
}
