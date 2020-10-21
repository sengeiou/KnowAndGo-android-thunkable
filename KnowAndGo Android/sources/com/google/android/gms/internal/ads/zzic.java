package com.google.android.gms.internal.ads;

import java.io.IOException;

public class zzic implements zzip {
    private volatile zzhj zzado;
    private final zzik zzahw;
    private final zzhm zzahx = new zzhm(0);
    private boolean zzahy = true;
    private long zzahz = Long.MIN_VALUE;
    private long zzaia = Long.MIN_VALUE;
    private volatile long zzaib = Long.MIN_VALUE;

    public zzic(zzjl zzjl) {
        this.zzahw = new zzik(zzjl);
    }

    public final void clear() {
        this.zzahw.clear();
        this.zzahy = true;
        this.zzahz = Long.MIN_VALUE;
        this.zzaia = Long.MIN_VALUE;
        this.zzaib = Long.MIN_VALUE;
    }

    public final boolean zzfd() {
        return this.zzado != null;
    }

    public final zzhj zzfe() {
        return this.zzado;
    }

    public final long zzff() {
        return this.zzaib;
    }

    public final boolean isEmpty() {
        return !zzfg();
    }

    public final boolean zza(zzhm zzhm) {
        if (!zzfg()) {
            return false;
        }
        this.zzahw.zzc(zzhm);
        this.zzahy = false;
        this.zzahz = zzhm.zzaga;
        return true;
    }

    public final void zzdr(long j) {
        while (this.zzahw.zzb(this.zzahx) && this.zzahx.zzaga < j) {
            this.zzahw.zzfs();
            this.zzahy = true;
        }
        this.zzahz = Long.MIN_VALUE;
    }

    public final boolean zzds(long j) {
        return this.zzahw.zzds(j);
    }

    private final boolean zzfg() {
        boolean zzb = this.zzahw.zzb(this.zzahx);
        if (this.zzahy) {
            while (zzb && !this.zzahx.zzep()) {
                this.zzahw.zzfs();
                zzb = this.zzahw.zzb(this.zzahx);
            }
        }
        if (!zzb) {
            return false;
        }
        if (this.zzaia == Long.MIN_VALUE || this.zzahx.zzaga < this.zzaia) {
            return true;
        }
        return false;
    }

    public final void zza(zzhj zzhj) {
        this.zzado = zzhj;
    }

    public final int zza(zzie zzie, int i) throws IOException, InterruptedException {
        return this.zzahw.zzb(zzie, i);
    }

    public final void zza(zzkm zzkm, int i) {
        this.zzahw.zzb(zzkm, i);
    }

    public void zza(long j, int i, int i2, int i3, byte[] bArr) {
        this.zzaib = Math.max(this.zzaib, j);
        int i4 = i2;
        this.zzahw.zza(j, i, (this.zzahw.zzft() - ((long) i4)) - ((long) i3), i4, bArr);
    }
}
