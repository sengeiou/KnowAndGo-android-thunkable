package com.uxcam.internals;

/* renamed from: com.uxcam.internals.gs */
public final class C3222gs {
    /* renamed from: a */
    public static final int m2188a(int[] iArr) {
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        return i;
    }

    /* renamed from: a */
    public static int m2189a(int[] iArr, int i) {
        int i2 = 0;
        for (int i3 = i; i3 < i + 16; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    /* renamed from: a */
    public static final void m2190a(int[] iArr, int i, int i2) {
        int i3 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i3;
    }
}
