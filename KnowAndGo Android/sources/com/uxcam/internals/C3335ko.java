package com.uxcam.internals;

/* renamed from: com.uxcam.internals.ko */
public final class C3335ko implements C3324kd {

    /* renamed from: a */
    public static int f2883a = 7168;

    /* renamed from: a */
    private static void m2394a(int[] iArr, int[] iArr2, int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < (i2 >> 1)) {
            int i6 = i5;
            int i7 = i4;
            int i8 = 0;
            while (i8 < i) {
                int i9 = i7 + i;
                iArr2[i6] = ((((((((iArr[i7] - 128) * f2883a) >> 13) + 128) + ((((iArr[i7 + 1] - 128) * f2883a) >> 13) + 128)) + ((((iArr[i9] - 128) * f2883a) >> 13) + 128)) + ((((iArr[i9 + 1] - 128) * f2883a) >> 13) + 128)) + 2) >> 2;
                i8 += 2;
                i6++;
                i7 += 2;
            }
            i4 = i7 + i;
            i3++;
            i5 = i6;
        }
    }

    /* renamed from: a */
    public final void mo38565a(C3239hi hiVar, C3239hi hiVar2) {
        int[] iArr = hiVar.f2535d[0];
        int[] iArr2 = hiVar2.f2535d[0];
        for (int i = 0; i < hiVar.mo38528a(0) * hiVar.mo38529b(0); i++) {
            iArr2[i] = ((iArr[i] * f2883a) >> 13) + 16;
        }
        m2394a(hiVar.f2535d[1], hiVar2.f2535d[1], hiVar.mo38528a(1), hiVar.mo38529b(1));
        m2394a(hiVar.f2535d[2], hiVar2.f2535d[2], hiVar.mo38528a(2), hiVar.mo38529b(2));
    }
}
