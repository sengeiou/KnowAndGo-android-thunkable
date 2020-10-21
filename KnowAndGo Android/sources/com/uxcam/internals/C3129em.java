package com.uxcam.internals;

import java.io.UnsupportedEncodingException;
import kotlin.UByte;

/* renamed from: com.uxcam.internals.em */
final class C3129em {

    /* renamed from: a */
    private static final byte[] f2154a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: b */
    private static final byte[] f2155b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* renamed from: a */
    public static String m1743a(byte[] bArr) {
        return m1744a(bArr, f2154a);
    }

    /* renamed from: a */
    private static String m1744a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(((bArr.length + 2) / 3) * 4)];
        int length = bArr.length - (bArr.length % 3);
        int i = 0;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int i3 = i + 1;
            bArr3[i] = bArr2[(bArr[i2] & UByte.MAX_VALUE) >> 2];
            int i4 = i3 + 1;
            int i5 = i2 + 1;
            bArr3[i3] = bArr2[((bArr[i2] & 3) << 4) | ((bArr[i5] & UByte.MAX_VALUE) >> 4)];
            int i6 = i4 + 1;
            int i7 = i2 + 2;
            bArr3[i4] = bArr2[((bArr[i5] & 15) << 2) | ((bArr[i7] & UByte.MAX_VALUE) >> 6)];
            i = i6 + 1;
            bArr3[i6] = bArr2[bArr[i7] & 63];
        }
        switch (bArr.length % 3) {
            case 1:
                int i8 = i + 1;
                bArr3[i] = bArr2[(bArr[length] & UByte.MAX_VALUE) >> 2];
                int i9 = i8 + 1;
                bArr3[i8] = bArr2[(bArr[length] & 3) << 4];
                bArr3[i9] = 61;
                bArr3[i9 + 1] = 61;
                break;
            case 2:
                int i10 = i + 1;
                bArr3[i] = bArr2[(bArr[length] & UByte.MAX_VALUE) >> 2];
                int i11 = i10 + 1;
                int i12 = length + 1;
                bArr3[i10] = bArr2[((bArr[length] & 3) << 4) | ((bArr[i12] & UByte.MAX_VALUE) >> 4)];
                bArr3[i11] = bArr2[(bArr[i12] & 15) << 2];
                bArr3[i11 + 1] = 61;
                break;
        }
        try {
            return new String(bArr3, "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
