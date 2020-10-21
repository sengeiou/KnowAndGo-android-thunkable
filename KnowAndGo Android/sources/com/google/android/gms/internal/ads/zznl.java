package com.google.android.gms.internal.ads;

public final class zznl implements zznu {
    private final int length;
    private final long zzack;
    private final int[] zzahp;
    private final long[] zzahq;
    private final long[] zzahr;
    private final long[] zzahs;

    public zznl(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.zzahp = iArr;
        this.zzahq = jArr;
        this.zzahr = jArr2;
        this.zzahs = jArr3;
        this.length = iArr.length;
        if (this.length > 0) {
            this.zzack = jArr2[this.length - 1] + jArr3[this.length - 1];
        } else {
            this.zzack = 0;
        }
    }

    public final boolean zzfc() {
        return true;
    }

    public final long getDurationUs() {
        return this.zzack;
    }

    public final long zzdq(long j) {
        return this.zzahq[zzsy.zza(this.zzahs, j, true, true)];
    }
}
