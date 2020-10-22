package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

public final class zzvi {
    final long value;
    final int zzbvw;
    final String zzbwd;

    zzvi(long j, String str, int i) {
        this.value = j;
        this.zzbwd = str;
        this.zzbvw = i;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == null || !(obj instanceof zzvi)) {
            return false;
        }
        zzvi zzvi = (zzvi) obj;
        if (zzvi.value == this.value && zzvi.zzbvw == this.zzbvw) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (int) this.value;
    }
}
