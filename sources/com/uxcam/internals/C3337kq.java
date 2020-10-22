package com.uxcam.internals;

/* renamed from: com.uxcam.internals.kq */
public final class C3337kq implements C3324kd {

    /* renamed from: a */
    private int f2886a = 0;

    /* renamed from: b */
    private int f2887b;

    public C3337kq(int i) {
        this.f2887b = i;
    }

    /* renamed from: a */
    private static void m2398a(int[] iArr, int i) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = iArr[i2] >> i;
        }
    }

    /* renamed from: a */
    private static void m2399a(int[] iArr, int[] iArr2, int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < (i2 >> 1); i5++) {
            int i6 = i3;
            int i7 = 0;
            while (i7 < i) {
                int i8 = i6 + i;
                iArr2[i4] = ((((iArr[i6] + iArr[i6 + 1]) + iArr[i8]) + iArr[i8 + 1]) + 2) >> 2;
                i7 += 2;
                i4++;
                i6 += 2;
            }
            i3 = i6 + i;
        }
    }

    /* renamed from: b */
    private static void m2400b(int[] iArr, int i) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = iArr[i2] << i;
        }
    }

    /* renamed from: a */
    public final void mo38565a(C3239hi hiVar, C3239hi hiVar2) {
        System.arraycopy(hiVar.f2535d[0], 0, hiVar2.f2535d[0], 0, hiVar.f2533b * hiVar.f2534c);
        m2399a(hiVar.f2535d[1], hiVar2.f2535d[1], hiVar.mo38528a(1), hiVar.mo38529b(1));
        m2399a(hiVar.f2535d[2], hiVar2.f2535d[2], hiVar.mo38528a(2), hiVar.mo38529b(2));
        if (this.f2886a > this.f2887b) {
            m2400b(hiVar2.f2535d[0], this.f2886a - this.f2887b);
            m2400b(hiVar2.f2535d[1], this.f2886a - this.f2887b);
            m2400b(hiVar2.f2535d[2], this.f2886a - this.f2887b);
        } else if (this.f2887b > this.f2886a) {
            m2398a(hiVar2.f2535d[0], this.f2887b - this.f2886a);
            m2398a(hiVar2.f2535d[1], this.f2887b - this.f2886a);
            m2398a(hiVar2.f2535d[2], this.f2887b - this.f2886a);
        }
    }
}
