package com.google.android.gms.internal.ads;

import android.util.Pair;

public final class zzsl {
    private static final byte[] zzaqt = {0, 0, 0, 1};
    private static final int[] zzaqu = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    private static final int[] zzaqv = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static Pair<Integer, Integer> zzf(byte[] bArr) {
        zzss zzss = new zzss(bArr);
        int zza = zza(zzss);
        int zzb = zzb(zzss);
        int zzbn = zzss.zzbn(4);
        if (zza == 5 || zza == 29) {
            zzb = zzb(zzss);
            if (zza(zzss) == 22) {
                zzbn = zzss.zzbn(4);
            }
        }
        int i = zzaqv[zzbn];
        zzsk.checkArgument(i != -1);
        return Pair.create(Integer.valueOf(zzb), Integer.valueOf(i));
    }

    public static byte[] zza(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[(zzaqt.length + i2)];
        System.arraycopy(zzaqt, 0, bArr2, 0, zzaqt.length);
        System.arraycopy(bArr, i, bArr2, zzaqt.length, i2);
        return bArr2;
    }

    private static int zza(zzss zzss) {
        int zzbn = zzss.zzbn(5);
        return zzbn == 31 ? zzss.zzbn(6) + 32 : zzbn;
    }

    private static int zzb(zzss zzss) {
        int zzbn = zzss.zzbn(4);
        if (zzbn == 15) {
            return zzss.zzbn(24);
        }
        zzsk.checkArgument(zzbn < 13);
        return zzaqu[zzbn];
    }
}
