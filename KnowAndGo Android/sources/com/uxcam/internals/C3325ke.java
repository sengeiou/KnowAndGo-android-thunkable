package com.uxcam.internals;

/* renamed from: com.uxcam.internals.ke */
public final class C3325ke implements C3324kd {

    /* renamed from: a */
    private static final int f2865a = m2374a(0.71414d);

    /* renamed from: b */
    private static final int f2866b = m2374a(1.772d);

    /* renamed from: c */
    private static final int f2867c = (-m2374a(0.34414d));

    /* renamed from: d */
    private static final int f2868d = m2374a(1.402d);

    /* renamed from: a */
    private static final int m2374a(double d) {
        return (int) ((d * 1024.0d) + 0.5d);
    }

    /* renamed from: a */
    public static final void m2375a(int i, int i2, int i3, int[] iArr, int i4) {
        int i5 = i << 10;
        int i6 = i2 - 128;
        int i7 = i3 - 128;
        int i8 = (((f2868d * i7) + 512) + i5) >> 10;
        iArr[i4] = C3245ho.m2229a((i5 + ((f2866b * i6) + 512)) >> 10);
        iArr[i4 + 1] = C3245ho.m2229a(((((f2867c * i6) - (f2865a * i7)) + 512) + i5) >> 10);
        iArr[i4 + 2] = C3245ho.m2229a(i8);
    }

    /* renamed from: a */
    public final void mo38565a(C3239hi hiVar, C3239hi hiVar2) {
        C3239hi hiVar3 = hiVar;
        C3239hi hiVar4 = hiVar2;
        int[] iArr = hiVar3.f2535d[0];
        int[] iArr2 = hiVar3.f2535d[1];
        int[] iArr3 = hiVar3.f2535d[2];
        int[] iArr4 = hiVar4.f2535d[0];
        int i = hiVar4.f2533b;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < (hiVar4.f2534c >> 1); i4++) {
            int i5 = i3;
            for (int i6 = 0; i6 < (hiVar4.f2533b >> 1); i6++) {
                int i7 = (i6 << 1) + i2;
                m2375a(iArr[i7], iArr2[i5], iArr3[i5], iArr4, i7 * 3);
                int i8 = i7 + 1;
                m2375a(iArr[i8], iArr2[i5], iArr3[i5], iArr4, i8 * 3);
                int i9 = i7 + i;
                m2375a(iArr[i9], iArr2[i5], iArr3[i5], iArr4, i9 * 3);
                int i10 = i9 + 1;
                m2375a(iArr[i10], iArr2[i5], iArr3[i5], iArr4, i10 * 3);
                i5++;
            }
            if ((hiVar4.f2533b & 1) != 0) {
                int i11 = (hiVar4.f2533b - 1) + i2;
                m2375a(iArr[i11], iArr2[i5], iArr3[i5], iArr4, i11 * 3);
                int i12 = i11 + i;
                m2375a(iArr[i12], iArr2[i5], iArr3[i5], iArr4, i12 * 3);
                i5++;
            }
            i3 = i5;
            i2 += i * 2;
        }
        if ((hiVar4.f2534c & 1) != 0) {
            for (int i13 = 0; i13 < (hiVar4.f2533b >> 1); i13++) {
                int i14 = (i13 << 1) + i2;
                m2375a(iArr[i14], iArr2[i3], iArr3[i3], iArr4, i14 * 3);
                int i15 = i14 + 1;
                m2375a(iArr[i15], iArr2[i3], iArr3[i3], iArr4, i15 * 3);
                i3++;
            }
            if ((hiVar4.f2533b & 1) != 0) {
                int i16 = i2 + (hiVar4.f2533b - 1);
                m2375a(iArr[i16], iArr2[i3], iArr3[i3], iArr4, i16 * 3);
            }
        }
    }
}
