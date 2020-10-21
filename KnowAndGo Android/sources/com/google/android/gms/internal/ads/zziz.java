package com.google.android.gms.internal.ads;

final class zziz {
    public final int[] zzahp;
    public final long[] zzahq;
    public final int[] zzajr;
    public final int zzand;
    public final long[] zzane;

    zziz(long[] jArr, int[] iArr, long[] jArr2, int[] iArr2) {
        boolean z = false;
        zzkh.checkArgument(iArr.length == jArr2.length);
        zzkh.checkArgument(jArr.length == jArr2.length);
        zzkh.checkArgument(iArr2.length == jArr2.length ? true : z);
        this.zzahq = jArr;
        this.zzahp = iArr;
        this.zzane = jArr2;
        this.zzajr = iArr2;
        this.zzand = jArr.length;
    }
}
