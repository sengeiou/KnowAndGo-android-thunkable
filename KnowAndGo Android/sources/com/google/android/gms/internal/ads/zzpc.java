package com.google.android.gms.internal.ads;

final class zzpc {
    public final int[] zzahp;
    public final long[] zzahq;
    public final int[] zzajr;
    public final int zzand;
    public final long[] zzane;
    public final int zzbet;

    public zzpc(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2) {
        boolean z = false;
        zzsk.checkArgument(iArr.length == jArr2.length);
        zzsk.checkArgument(jArr.length == jArr2.length);
        zzsk.checkArgument(iArr2.length == jArr2.length ? true : z);
        this.zzahq = jArr;
        this.zzahp = iArr;
        this.zzbet = i;
        this.zzane = jArr2;
        this.zzajr = iArr2;
        this.zzand = jArr.length;
    }

    public final int zzej(long j) {
        for (int zza = zzsy.zza(this.zzane, j, true, false); zza >= 0; zza--) {
            if ((this.zzajr[zza] & 1) != 0) {
                return zza;
            }
        }
        return -1;
    }

    public final int zzek(long j) {
        for (int zzb = zzsy.zzb(this.zzane, j, true, false); zzb < this.zzane.length; zzb++) {
            if ((this.zzajr[zzb] & 1) != 0) {
                return zzb;
            }
        }
        return -1;
    }
}
