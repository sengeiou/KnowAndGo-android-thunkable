package com.uxcam.internals;

/* renamed from: com.uxcam.internals.km */
public final class C3333km implements C3324kd {

    /* renamed from: a */
    private int f2881a = 0;

    /* renamed from: b */
    private int f2882b;

    public C3333km(int i) {
        this.f2882b = i;
    }

    /* renamed from: a */
    private static void m2389a(int[] iArr, int i) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = iArr[i2] >> i;
        }
    }

    /* renamed from: a */
    private static void m2390a(int[] iArr, int[] iArr2, int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i2 / 2; i5++) {
            int i6 = i3;
            int i7 = 0;
            while (i7 < i) {
                iArr2[i4] = ((iArr[i6] + iArr[i6 + i]) + 1) >> 1;
                i7++;
                i4++;
                i6++;
            }
            i3 = i6 + i;
        }
    }

    /* renamed from: b */
    private static void m2391b(int[] iArr, int i) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = iArr[i2] << i;
        }
    }

    /* renamed from: a */
    public final void mo38565a(C3239hi hiVar, C3239hi hiVar2) {
        System.arraycopy(hiVar.f2535d[0], 0, hiVar2.f2535d[0], 0, hiVar.f2533b * hiVar.f2534c);
        m2390a(hiVar.f2535d[1], hiVar2.f2535d[1], hiVar.mo38528a(1), hiVar.mo38529b(1));
        m2390a(hiVar.f2535d[2], hiVar2.f2535d[2], hiVar.mo38528a(2), hiVar.mo38529b(2));
        if (this.f2881a > this.f2882b) {
            m2391b(hiVar2.f2535d[0], this.f2881a - this.f2882b);
            m2391b(hiVar2.f2535d[1], this.f2881a - this.f2882b);
            m2391b(hiVar2.f2535d[2], this.f2881a - this.f2882b);
        } else if (this.f2882b > this.f2881a) {
            m2389a(hiVar2.f2535d[0], this.f2882b - this.f2881a);
            m2389a(hiVar2.f2535d[1], this.f2882b - this.f2881a);
            m2389a(hiVar2.f2535d[2], this.f2882b - this.f2881a);
        }
    }
}
