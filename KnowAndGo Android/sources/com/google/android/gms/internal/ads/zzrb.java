package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzrb {
    public static final zzrb zzbkw = new zzrb(new zzra[0]);
    public final int length;
    private int zzafx;
    private final zzra[] zzbkx;

    public zzrb(zzra... zzraArr) {
        this.zzbkx = zzraArr;
        this.length = zzraArr.length;
    }

    public final zzra zzbg(int i) {
        return this.zzbkx[i];
    }

    public final int zza(zzra zzra) {
        for (int i = 0; i < this.length; i++) {
            if (this.zzbkx[i] == zzra) {
                return i;
            }
        }
        return -1;
    }

    public final int hashCode() {
        if (this.zzafx == 0) {
            this.zzafx = Arrays.hashCode(this.zzbkx);
        }
        return this.zzafx;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzrb zzrb = (zzrb) obj;
        return this.length == zzrb.length && Arrays.equals(this.zzbkx, zzrb.zzbkx);
    }
}
