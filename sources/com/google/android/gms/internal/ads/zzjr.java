package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzjr implements zzjl {
    private final int zzaph = 262144;
    private int zzapi;
    private int zzapj;
    private zzjk[] zzapk = new zzjk[100];

    public zzjr(int i) {
        zzkh.checkArgument(true);
    }

    public final synchronized zzjk zzfy() {
        this.zzapi++;
        if (this.zzapj > 0) {
            zzjk[] zzjkArr = this.zzapk;
            int i = this.zzapj - 1;
            this.zzapj = i;
            return zzjkArr[i];
        }
        return new zzjk(new byte[this.zzaph], 0);
    }

    public final synchronized void zza(zzjk zzjk) {
        zzkh.checkArgument(zzjk.data.length == this.zzaph);
        this.zzapi--;
        if (this.zzapj == this.zzapk.length) {
            this.zzapk = (zzjk[]) Arrays.copyOf(this.zzapk, this.zzapk.length << 1);
        }
        zzjk[] zzjkArr = this.zzapk;
        int i = this.zzapj;
        this.zzapj = i + 1;
        zzjkArr[i] = zzjk;
        notifyAll();
    }

    public final synchronized void zzz(int i) {
        int max = Math.max(0, zzkq.zzb(0, this.zzaph) - this.zzapi);
        if (max < this.zzapj) {
            Arrays.fill(this.zzapk, max, this.zzapj, (Object) null);
            this.zzapj = max;
        }
    }

    private final synchronized int zzga() {
        return this.zzapi * this.zzaph;
    }

    public final int zzfz() {
        return this.zzaph;
    }

    public final synchronized void zzaa(int i) throws InterruptedException {
        while (zzga() > i) {
            wait();
        }
    }
}
