package com.google.android.gms.internal.ads;

import java.util.Arrays;

public class zzrd implements zzrm {
    private final int length;
    private int zzafx;
    private final zzlh[] zzbju;
    private final zzra zzbky;
    private final int[] zzbkz;
    private final long[] zzbla;

    public zzrd(zzra zzra, int... iArr) {
        zzsk.checkState(iArr.length > 0);
        this.zzbky = (zzra) zzsk.checkNotNull(zzra);
        this.length = iArr.length;
        this.zzbju = new zzlh[this.length];
        for (int i = 0; i < iArr.length; i++) {
            this.zzbju[i] = zzra.zzbf(iArr[i]);
        }
        Arrays.sort(this.zzbju, new zzrf());
        this.zzbkz = new int[this.length];
        for (int i2 = 0; i2 < this.length; i2++) {
            this.zzbkz[i2] = zzra.zzh(this.zzbju[i2]);
        }
        this.zzbla = new long[this.length];
    }

    public final zzra zzjr() {
        return this.zzbky;
    }

    public final int length() {
        return this.zzbkz.length;
    }

    public final zzlh zzbf(int i) {
        return this.zzbju[i];
    }

    public final int zzbh(int i) {
        return this.zzbkz[0];
    }

    public int hashCode() {
        if (this.zzafx == 0) {
            this.zzafx = (System.identityHashCode(this.zzbky) * 31) + Arrays.hashCode(this.zzbkz);
        }
        return this.zzafx;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzrd zzrd = (zzrd) obj;
        return this.zzbky == zzrd.zzbky && Arrays.equals(this.zzbkz, zzrd.zzbkz);
    }
}
