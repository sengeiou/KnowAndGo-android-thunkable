package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzkk {
    private int size;
    private long[] zzaqw;

    public zzkk() {
        this(32);
    }

    private zzkk(int i) {
        this.zzaqw = new long[32];
    }

    public final void add(long j) {
        if (this.size == this.zzaqw.length) {
            this.zzaqw = Arrays.copyOf(this.zzaqw, this.size << 1);
        }
        long[] jArr = this.zzaqw;
        int i = this.size;
        this.size = i + 1;
        jArr[i] = j;
    }

    public final long get(int i) {
        if (i >= 0 && i < this.size) {
            return this.zzaqw[i];
        }
        int i2 = this.size;
        StringBuilder sb = new StringBuilder(45);
        sb.append("Invalid size ");
        sb.append(i);
        sb.append(", size is ");
        sb.append(i2);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final int size() {
        return this.size;
    }
}
