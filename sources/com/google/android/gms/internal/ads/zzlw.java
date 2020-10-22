package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import java.util.Arrays;

@TargetApi(21)
public final class zzlw {
    private static final zzlw zzave = new zzlw(new int[]{2}, 2);
    private final int[] zzavf;
    private final int zzavg = 2;

    private zzlw(int[] iArr, int i) {
        this.zzavf = Arrays.copyOf(iArr, iArr.length);
        Arrays.sort(this.zzavf);
    }

    public final boolean zzaf(int i) {
        return Arrays.binarySearch(this.zzavf, i) >= 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzlw)) {
            return false;
        }
        zzlw zzlw = (zzlw) obj;
        return Arrays.equals(this.zzavf, zzlw.zzavf) && this.zzavg == zzlw.zzavg;
    }

    public final int hashCode() {
        return this.zzavg + (Arrays.hashCode(this.zzavf) * 31);
    }

    public final String toString() {
        int i = this.zzavg;
        String arrays = Arrays.toString(this.zzavf);
        StringBuilder sb = new StringBuilder(String.valueOf(arrays).length() + 67);
        sb.append("AudioCapabilities[maxChannelCount=");
        sb.append(i);
        sb.append(", supportedEncodings=");
        sb.append(arrays);
        sb.append("]");
        return sb.toString();
    }
}
