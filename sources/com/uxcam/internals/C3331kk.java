package com.uxcam.internals;

import com.facebook.imageutils.JfifUtil;

/* renamed from: com.uxcam.internals.kk */
public final class C3331kk implements C3324kd {

    /* renamed from: a */
    private int f2875a;

    /* renamed from: b */
    private int f2876b = 0;

    public C3331kk(int i) {
        this.f2875a = i;
    }

    /* renamed from: a */
    private static int m2384a(int i) {
        if (i < 0) {
            return 0;
        }
        if (i > 255) {
            return 255;
        }
        return i;
    }

    /* renamed from: a */
    public static final void m2385a(int i, int i2, int i3, int[] iArr, int i4) {
        int i5 = i2 - 128;
        int i6 = i3 - 128;
        int i7 = (i - 16) * 298;
        iArr[i4] = m2384a(((i7 + (i5 * 516)) + 128) >> 8);
        iArr[i4 + 1] = m2384a((((i7 - (i5 * 100)) - (i6 * JfifUtil.MARKER_RST0)) + 128) >> 8);
        iArr[i4 + 2] = m2384a((((i6 * 409) + i7) + 128) >> 8);
    }

    /* renamed from: a */
    public final void mo38565a(C3239hi hiVar, C3239hi hiVar2) {
        int[] iArr = hiVar.f2535d[0];
        int[] iArr2 = hiVar.f2535d[1];
        int[] iArr3 = hiVar.f2535d[2];
        int[] iArr4 = hiVar2.f2535d[0];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < hiVar2.f2534c) {
            int i4 = i3;
            int i5 = i2;
            for (int i6 = 0; i6 < hiVar2.f2533b; i6 += 2) {
                m2385a((iArr[i5] << this.f2876b) >> this.f2875a, (iArr2[i4] << this.f2876b) >> this.f2875a, (iArr3[i4] << this.f2876b) >> this.f2875a, iArr4, i5 * 3);
                int i7 = i5 + 1;
                m2385a((iArr[i7] << this.f2876b) >> this.f2875a, (iArr2[i4] << this.f2876b) >> this.f2875a, (iArr3[i4] << this.f2876b) >> this.f2875a, iArr4, i7 * 3);
                i5 += 2;
                i4++;
            }
            i++;
            i2 = i5;
            i3 = i4;
        }
    }
}
