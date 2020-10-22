package com.uxcam.internals;

import java.nio.charset.Charset;
import kotlin.UShort;

/* renamed from: com.uxcam.internals.fe */
public final class C3151fe {

    /* renamed from: a */
    public static final Charset f2202a = Charset.forName("UTF-8");

    /* renamed from: a */
    public static int m1945a(int i) {
        return ((i & 255) << 24) | ((-16777216 & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8);
    }

    /* renamed from: a */
    public static short m1946a(short s) {
        short s2 = s & UShort.MAX_VALUE;
        return (short) (((s2 & 255) << 8) | ((65280 & s2) >>> 8));
    }

    /* renamed from: a */
    public static void m1947a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}));
        }
    }

    /* renamed from: a */
    public static void m1948a(Throwable th) {
        throw th;
    }

    /* renamed from: a */
    public static boolean m1949a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }
}
