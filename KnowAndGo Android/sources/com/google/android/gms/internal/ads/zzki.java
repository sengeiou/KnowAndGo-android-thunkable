package com.google.android.gms.internal.ads;

import android.util.Pair;

public final class zzki {
    private static final byte[] zzaqt = {0, 0, 0, 1};
    private static final int[] zzaqu = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    private static final int[] zzaqv = {0, 1, 2, 3, 4, 5, 6, 8};

    public static Pair<Integer, Integer> zzd(byte[] bArr) {
        boolean z = false;
        int i = (bArr[0] >> 3) & 31;
        int i2 = (i == 5 || i == 29) ? 1 : 0;
        int i3 = i2 + 1;
        int i4 = ((bArr[i2] & 7) << 1) | ((bArr[i3] >> 7) & 1);
        if (i4 < 13) {
            z = true;
        }
        zzkh.checkState(z);
        return Pair.create(Integer.valueOf(zzaqu[i4]), Integer.valueOf((bArr[i3] >> 3) & 15));
    }

    public static byte[] zza(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[(zzaqt.length + i2)];
        System.arraycopy(zzaqt, 0, bArr2, 0, zzaqt.length);
        System.arraycopy(bArr, i, bArr2, zzaqt.length, i2);
        return bArr2;
    }
}
