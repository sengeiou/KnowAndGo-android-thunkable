package com.google.android.gms.internal.ads;

public final class zzia implements zzio {
    private final int length;
    private final int[] zzahp;
    private final long[] zzahq;
    private final long[] zzahr;
    private final long[] zzahs;

    public zzia(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.length = iArr.length;
        this.zzahp = iArr;
        this.zzahq = jArr;
        this.zzahr = jArr2;
        this.zzahs = jArr3;
    }

    public final boolean zzfc() {
        return true;
    }

    public final long zzdq(long j) {
        return this.zzahq[zzkq.zza(this.zzahs, j, true, true)];
    }
}
