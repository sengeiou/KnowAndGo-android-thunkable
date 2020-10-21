package com.uxcam.internals;

import java.lang.reflect.Array;
import java.util.Arrays;

/* renamed from: com.uxcam.internals.gl */
public final class C3215gl {

    /* renamed from: a */
    public static int[] f2432a = {0, 1, 4, 8, 5, 2, 3, 6, 9, 12, 13, 10, 7, 11, 14, 15};

    /* renamed from: b */
    static int[][] f2433b = {new int[]{10, 13, 10, 13, 13, 16, 13, 16, 10, 13, 10, 13, 13, 16, 13, 16}, new int[]{11, 14, 11, 14, 14, 18, 14, 18, 11, 14, 11, 14, 14, 18, 14, 18}, new int[]{13, 16, 13, 16, 16, 20, 16, 20, 13, 16, 13, 16, 16, 20, 16, 20}, new int[]{14, 18, 14, 18, 18, 23, 18, 23, 14, 18, 14, 18, 18, 23, 18, 23}, new int[]{16, 20, 16, 20, 20, 25, 20, 25, 16, 20, 16, 20, 20, 25, 20, 25}, new int[]{18, 23, 18, 23, 23, 29, 23, 29, 18, 23, 18, 23, 23, 29, 23, 29}};

    /* renamed from: c */
    static int[][] f2434c = ((int[][]) Array.newInstance(int.class, new int[]{6, 64}));

    /* renamed from: d */
    static int[][] f2435d = {new int[]{20, 18, 32, 19, 25, 24}, new int[]{22, 19, 35, 21, 28, 26}, new int[]{26, 23, 42, 24, 33, 31}, new int[]{28, 25, 45, 26, 35, 33}, new int[]{32, 28, 51, 30, 40, 38}, new int[]{36, 32, 58, 34, 46, 43}};

    /* renamed from: e */
    public static int[] f2436e = {0, 1, 8, 16, 9, 2, 3, 10, 17, 24, 32, 25, 18, 11, 4, 5, 12, 19, 26, 33, 40, 48, 41, 34, 27, 20, 13, 6, 7, 14, 21, 28, 35, 42, 49, 56, 57, 50, 43, 36, 29, 22, 15, 23, 30, 37, 44, 51, 58, 59, 52, 45, 38, 31, 39, 46, 53, 60, 61, 54, 47, 55, 62, 63};

    /* renamed from: f */
    private static final int[][] f2437f = {new int[]{13107, 8066, 13107, 8066, 8066, 5243, 8066, 5243, 13107, 8066, 13107, 8066, 8066, 5243, 8066, 5243}, new int[]{11916, 7490, 11916, 7490, 7490, 4660, 7490, 4660, 11916, 7490, 11916, 7490, 7490, 4660, 7490, 4660}, new int[]{10082, 6554, 10082, 6554, 6554, 4194, 6554, 4194, 10082, 6554, 10082, 6554, 6554, 4194, 6554, 4194}, new int[]{9362, 5825, 9362, 5825, 5825, 3647, 5825, 3647, 9362, 5825, 9362, 5825, 5825, 3647, 5825, 3647}, new int[]{8192, 5243, 8192, 5243, 5243, 3355, 5243, 3355, 8192, 5243, 8192, 5243, 5243, 3355, 5243, 3355}, new int[]{7282, 4559, 7282, 4559, 4559, 2893, 4559, 2893, 7282, 4559, 7282, 4559, 4559, 2893, 4559, 2893}};

    static {
        for (int i = 0; i < 6; i++) {
            Arrays.fill(f2434c[i], f2435d[i][5]);
            for (int i2 = 0; i2 < 8; i2 += 4) {
                for (int i3 = 0; i3 < 8; i3 += 4) {
                    f2434c[i][(i2 << 3) + i3] = f2435d[i][0];
                }
            }
            for (int i4 = 1; i4 < 8; i4 += 2) {
                for (int i5 = 1; i5 < 8; i5 += 2) {
                    f2434c[i][(i4 << 3) + i5] = f2435d[i][1];
                }
            }
            for (int i6 = 2; i6 < 8; i6 += 4) {
                for (int i7 = 2; i7 < 8; i7 += 4) {
                    f2434c[i][(i6 << 3) + i7] = f2435d[i][2];
                }
            }
            for (int i8 = 0; i8 < 8; i8 += 4) {
                for (int i9 = 1; i9 < 8; i9 += 2) {
                    f2434c[i][(i8 << 3) + i9] = f2435d[i][3];
                }
            }
            for (int i10 = 1; i10 < 8; i10 += 2) {
                for (int i11 = 0; i11 < 8; i11 += 4) {
                    f2434c[i][(i10 << 3) + i11] = f2435d[i][3];
                }
            }
            for (int i12 = 0; i12 < 8; i12 += 4) {
                for (int i13 = 2; i13 < 8; i13 += 4) {
                    f2434c[i][(i12 << 3) + i13] = f2435d[i][4];
                }
            }
            for (int i14 = 2; i14 < 8; i14 += 4) {
                for (int i15 = 0; i15 < 8; i15 += 4) {
                    f2434c[i][(i14 << 3) + i15] = f2435d[i][4];
                }
            }
        }
    }

    /* renamed from: a */
    public static void m2153a() {
    }

    /* renamed from: a */
    public static final void m2154a(int[] iArr) {
        for (int i = 0; i < 16; i += 4) {
            int i2 = i + 2;
            int i3 = iArr[i] + iArr[i2];
            int i4 = iArr[i] - iArr[i2];
            int i5 = i + 1;
            int i6 = i + 3;
            int i7 = (iArr[i5] >> 1) - iArr[i6];
            int i8 = iArr[i5] + (iArr[i6] >> 1);
            iArr[i] = i3 + i8;
            iArr[i5] = i4 + i7;
            iArr[i2] = i4 - i7;
            iArr[i6] = i3 - i8;
        }
        for (int i9 = 0; i9 < 4; i9++) {
            int i10 = i9 + 8;
            int i11 = iArr[i9] + iArr[i10];
            int i12 = iArr[i9] - iArr[i10];
            int i13 = i9 + 4;
            int i14 = i9 + 12;
            int i15 = (iArr[i13] >> 1) - iArr[i14];
            int i16 = iArr[i13] + (iArr[i14] >> 1);
            iArr[i9] = i11 + i16;
            iArr[i13] = i12 + i15;
            iArr[i10] = i12 - i15;
            iArr[i14] = i11 - i16;
        }
        for (int i17 = 0; i17 < 16; i17++) {
            iArr[i17] = (iArr[i17] + 32) >> 6;
        }
    }

    /* renamed from: b */
    public static void m2155b() {
    }

    /* renamed from: b */
    public static void m2156b(int[] iArr) {
        for (int i = 0; i < 16; i += 4) {
            int i2 = i + 3;
            int i3 = iArr[i] + iArr[i2];
            int i4 = i + 1;
            int i5 = i + 2;
            int i6 = iArr[i4] + iArr[i5];
            int i7 = iArr[i4] - iArr[i5];
            int i8 = iArr[i] - iArr[i2];
            iArr[i] = i3 + i6;
            iArr[i4] = (i8 << 1) + i7;
            iArr[i5] = i3 - i6;
            iArr[i2] = i8 - (i7 << 1);
        }
        for (int i9 = 0; i9 < 4; i9++) {
            int i10 = i9 + 12;
            int i11 = iArr[i9] + iArr[i10];
            int i12 = i9 + 4;
            int i13 = i9 + 8;
            int i14 = iArr[i12] + iArr[i13];
            int i15 = iArr[i12] - iArr[i13];
            int i16 = iArr[i9] - iArr[i10];
            iArr[i9] = i11 + i14;
            iArr[i12] = (i16 << 1) + i15;
            iArr[i13] = i11 - i14;
            iArr[i10] = i16 - (i15 << 1);
        }
    }

    /* renamed from: c */
    public static void m2157c() {
    }

    /* renamed from: c */
    public static void m2158c(int[] iArr) {
        for (int i = 0; i < 16; i += 4) {
            int i2 = i + 2;
            int i3 = iArr[i] + iArr[i2];
            int i4 = iArr[i] - iArr[i2];
            int i5 = i + 1;
            int i6 = i + 3;
            int i7 = iArr[i5] - iArr[i6];
            int i8 = iArr[i5] + iArr[i6];
            iArr[i] = i3 + i8;
            iArr[i5] = i4 + i7;
            iArr[i2] = i4 - i7;
            iArr[i6] = i3 - i8;
        }
        for (int i9 = 0; i9 < 4; i9++) {
            int i10 = i9 + 8;
            int i11 = iArr[i9] + iArr[i10];
            int i12 = iArr[i9] - iArr[i10];
            int i13 = i9 + 4;
            int i14 = i9 + 12;
            int i15 = iArr[i13] - iArr[i14];
            int i16 = iArr[i13] + iArr[i14];
            iArr[i9] = i11 + i16;
            iArr[i13] = i12 + i15;
            iArr[i10] = i12 - i15;
            iArr[i14] = i11 - i16;
        }
    }

    /* renamed from: d */
    public static void m2159d() {
    }

    /* renamed from: d */
    public static void m2160d(int[] iArr) {
        for (int i = 0; i < 16; i += 4) {
            int i2 = i + 3;
            int i3 = iArr[i] + iArr[i2];
            int i4 = i + 1;
            int i5 = i + 2;
            int i6 = iArr[i4] + iArr[i5];
            int i7 = iArr[i4] - iArr[i5];
            int i8 = iArr[i] - iArr[i2];
            iArr[i] = i3 + i6;
            iArr[i4] = i8 + i7;
            iArr[i5] = i3 - i6;
            iArr[i2] = i8 - i7;
        }
        for (int i9 = 0; i9 < 4; i9++) {
            int i10 = i9 + 12;
            int i11 = iArr[i9] + iArr[i10];
            int i12 = i9 + 4;
            int i13 = i9 + 8;
            int i14 = iArr[i12] + iArr[i13];
            int i15 = iArr[i12] - iArr[i13];
            int i16 = iArr[i9] - iArr[i10];
            iArr[i9] = (i11 + i14) >> 1;
            iArr[i12] = (i15 + i16) >> 1;
            iArr[i13] = (i11 - i14) >> 1;
            iArr[i10] = (i16 - i15) >> 1;
        }
    }

    /* renamed from: e */
    public static void m2161e(int[] iArr) {
        for (int i = 0; i < 16; i++) {
            iArr[i] = ((iArr[i] * (f2433b[2][i] << 4)) + 1) >> 1;
        }
    }

    /* renamed from: f */
    public static void m2162f(int[] iArr) {
        for (int i = 1; i < 16; i++) {
            int i2 = iArr[i] >> 31;
            iArr[i] = ((((((iArr[i] ^ i2) - i2) * f2437f[2][i]) + 87296) >> 18) ^ i2) - i2;
        }
    }

    /* renamed from: g */
    public static void m2163g(int[] iArr) {
        for (int i = 0; i < 16; i++) {
            iArr[i] = ((iArr[i] * (f2433b[2][0] << 4)) + 4) >> 3;
        }
    }

    /* renamed from: h */
    public static void m2164h(int[] iArr) {
        for (int i = 0; i < 16; i++) {
            int i2 = iArr[i] >> 31;
            iArr[i] = ((((((iArr[i] ^ i2) - i2) * f2437f[2][0]) + 174592) >> 19) ^ i2) - i2;
        }
    }

    /* renamed from: i */
    public static void m2165i(int[] iArr) {
        int i = iArr[0] + iArr[1];
        int i2 = iArr[0] - iArr[1];
        int i3 = iArr[2] + iArr[3];
        int i4 = iArr[2] - iArr[3];
        iArr[0] = i + i3;
        iArr[1] = i2 + i4;
        iArr[2] = i - i3;
        iArr[3] = i2 - i4;
    }

    /* renamed from: j */
    public static void m2166j(int[] iArr) {
        m2165i(iArr);
    }

    /* renamed from: k */
    public static void m2167k(int[] iArr) {
        for (int i = 0; i < 4; i++) {
            iArr[i] = ((iArr[i] * f2433b[2][0]) << 3) >> 1;
        }
    }

    /* renamed from: l */
    public static void m2168l(int[] iArr) {
        for (int i = 0; i < 4; i++) {
            int i2 = iArr[i] >> 31;
            iArr[i] = ((((((iArr[i] ^ i2) - i2) * f2437f[2][0]) + 174592) >> 19) ^ i2) - i2;
        }
    }

    /* renamed from: m */
    public static void m2169m(int[] iArr) {
        C3222gs.m2190a(iArr, 2, 4);
        C3222gs.m2190a(iArr, 3, 5);
        C3222gs.m2190a(iArr, 10, 12);
        C3222gs.m2190a(iArr, 11, 13);
    }
}
