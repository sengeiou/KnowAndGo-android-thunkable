package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzrz implements zzrt {
    private final int zzaph;
    private int zzapi;
    private final boolean zzbme;
    private final byte[] zzbmf;
    private final zzrs[] zzbmg;
    private int zzbmh;
    private int zzbmi;
    private zzrs[] zzbmj;

    public zzrz(boolean z, int i) {
        this(true, 65536, 0);
    }

    private zzrz(boolean z, int i, int i2) {
        zzsk.checkArgument(true);
        zzsk.checkArgument(true);
        this.zzbme = true;
        this.zzaph = 65536;
        this.zzbmi = 0;
        this.zzbmj = new zzrs[100];
        this.zzbmf = null;
        this.zzbmg = new zzrs[1];
    }

    public final synchronized void reset() {
        if (this.zzbme) {
            zzbl(0);
        }
    }

    public final synchronized void zzbl(int i) {
        boolean z = i < this.zzbmh;
        this.zzbmh = i;
        if (z) {
            zzn();
        }
    }

    public final synchronized zzrs zzjt() {
        zzrs zzrs;
        this.zzapi++;
        if (this.zzbmi > 0) {
            zzrs[] zzrsArr = this.zzbmj;
            int i = this.zzbmi - 1;
            this.zzbmi = i;
            zzrs = zzrsArr[i];
            this.zzbmj[this.zzbmi] = null;
        } else {
            zzrs = new zzrs(new byte[this.zzaph], 0);
        }
        return zzrs;
    }

    public final synchronized void zza(zzrs zzrs) {
        this.zzbmg[0] = zzrs;
        zza(this.zzbmg);
    }

    public final synchronized void zza(zzrs[] zzrsArr) {
        boolean z;
        if (this.zzbmi + zzrsArr.length >= this.zzbmj.length) {
            this.zzbmj = (zzrs[]) Arrays.copyOf(this.zzbmj, Math.max(this.zzbmj.length << 1, this.zzbmi + zzrsArr.length));
        }
        for (zzrs zzrs : zzrsArr) {
            if (zzrs.data != null) {
                if (zzrs.data.length != this.zzaph) {
                    z = false;
                    zzsk.checkArgument(z);
                    zzrs[] zzrsArr2 = this.zzbmj;
                    int i = this.zzbmi;
                    this.zzbmi = i + 1;
                    zzrsArr2[i] = zzrs;
                }
            }
            z = true;
            zzsk.checkArgument(z);
            zzrs[] zzrsArr22 = this.zzbmj;
            int i2 = this.zzbmi;
            this.zzbmi = i2 + 1;
            zzrsArr22[i2] = zzrs;
        }
        this.zzapi -= zzrsArr.length;
        notifyAll();
    }

    public final synchronized void zzn() {
        int max = Math.max(0, zzsy.zzb(this.zzbmh, this.zzaph) - this.zzapi);
        if (max < this.zzbmi) {
            Arrays.fill(this.zzbmj, max, this.zzbmi, (Object) null);
            this.zzbmi = max;
        }
    }

    public final synchronized int zzga() {
        return this.zzapi * this.zzaph;
    }

    public final int zzfz() {
        return this.zzaph;
    }
}
