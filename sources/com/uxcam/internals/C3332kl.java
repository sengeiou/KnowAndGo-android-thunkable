package com.uxcam.internals;

/* renamed from: com.uxcam.internals.kl */
public final class C3332kl implements C3324kd {

    /* renamed from: a */
    public static int f2877a = 9362;

    /* renamed from: b */
    private int f2878b;

    /* renamed from: c */
    private int f2879c;

    /* renamed from: d */
    private int f2880d;

    public C3332kl(int i) {
        int i2 = i + 13;
        this.f2878b = i2 + 0;
        if (this.f2878b >= 0) {
            this.f2879c = 128 << Math.max(i + 0, 0);
            this.f2880d = 128 << Math.max(0 - i, 0);
            return;
        }
        throw new IllegalArgumentException("Maximum upshift allowed: " + i2);
    }

    /* renamed from: a */
    private void m2387a(int[] iArr, int[] iArr2, int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < i2 / 2) {
            int i6 = i5;
            int i7 = i4;
            int i8 = 0;
            while (i8 < i) {
                iArr2[i6] = ((((((iArr[i7] - this.f2879c) * f2877a) >> this.f2878b) + this.f2880d) + ((((iArr[i7 + i] - this.f2879c) * f2877a) >> this.f2878b) + this.f2880d)) + 1) >> 1;
                i8++;
                i6++;
                i7++;
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
            iArr2[i] = ((iArr[i] - 16) * f2877a) >> this.f2878b;
        }
        m2387a(hiVar.f2535d[1], hiVar2.f2535d[1], hiVar.mo38528a(1), hiVar.mo38529b(1));
        m2387a(hiVar.f2535d[2], hiVar2.f2535d[2], hiVar.mo38528a(2), hiVar.mo38529b(2));
    }
}
