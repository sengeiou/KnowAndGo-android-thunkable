package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzra {
    public final int length;
    private int zzafx;
    private final zzlh[] zzbju;

    public zzra(zzlh... zzlhArr) {
        zzsk.checkState(zzlhArr.length > 0);
        this.zzbju = zzlhArr;
        this.length = zzlhArr.length;
    }

    public final zzlh zzbf(int i) {
        return this.zzbju[i];
    }

    public final int zzh(zzlh zzlh) {
        for (int i = 0; i < this.zzbju.length; i++) {
            if (zzlh == this.zzbju[i]) {
                return i;
            }
        }
        return -1;
    }

    public final int hashCode() {
        if (this.zzafx == 0) {
            this.zzafx = Arrays.hashCode(this.zzbju) + 527;
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
        zzra zzra = (zzra) obj;
        return this.length == zzra.length && Arrays.equals(this.zzbju, zzra.zzbju);
    }
}
