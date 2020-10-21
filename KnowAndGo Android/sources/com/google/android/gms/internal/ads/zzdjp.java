package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;

public final class zzdjp {
    private static final Charset UTF_8 = Charset.forName("UTF-8");

    public static byte[] decode(String str) {
        byte[] bytes = str.getBytes(UTF_8);
        int length = bytes.length;
        zzdjr zzdjr = new zzdjr(2, new byte[((length * 3) / 4)]);
        if (!zzdjr.zzb(bytes, 0, length, true)) {
            throw new IllegalArgumentException("bad base-64");
        } else if (zzdjr.zzgya == zzdjr.zzgxz.length) {
            return zzdjr.zzgxz;
        } else {
            byte[] bArr = new byte[zzdjr.zzgya];
            System.arraycopy(zzdjr.zzgxz, 0, bArr, 0, zzdjr.zzgya);
            return bArr;
        }
    }
}
