package com.uxcam.internals;

import com.facebook.imageutils.JfifUtil;

/* renamed from: com.uxcam.internals.kp */
public final class C3336kp implements C3324kd {

    /* renamed from: a */
    private int f2884a;

    /* renamed from: b */
    private int f2885b = 0;

    public C3336kp(int i) {
        this.f2884a = i;
    }

    /* renamed from: a */
    private static int m2396a(int i) {
        if (i < 0) {
            return 0;
        }
        if (i > 255) {
            return 255;
        }
        return i;
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
            int i6 = 0;
            while (i6 < hiVar2.f2533b) {
                int i7 = (iArr[i5] << this.f2885b) >> this.f2884a;
                int i8 = ((iArr2[i5] << this.f2885b) >> this.f2884a) - 128;
                int i9 = ((iArr3[i5] << this.f2885b) >> this.f2884a) - 128;
                int i10 = (i7 - 16) * 298;
                iArr4[i4] = m2396a(((i10 + (i8 * 516)) + 128) >> 8);
                iArr4[i4 + 1] = m2396a((((i10 - (i8 * 100)) - (i9 * JfifUtil.MARKER_RST0)) + 128) >> 8);
                iArr4[i4 + 2] = m2396a((((i9 * 409) + i10) + 128) >> 8);
                i6++;
                i5++;
                i4 += 3;
            }
            i++;
            i2 = i5;
            i3 = i4;
        }
    }
}
