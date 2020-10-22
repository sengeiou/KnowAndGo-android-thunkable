package com.uxcam.internals;

/* renamed from: com.uxcam.internals.kc */
public final class C3323kc implements C3324kd {

    /* renamed from: a */
    private int f2862a;

    /* renamed from: b */
    private int f2863b = 0;

    /* renamed from: c */
    private int f2864c = 1;

    public C3323kc(int i) {
        this.f2862a = i;
    }

    /* renamed from: a */
    public final void mo38565a(C3239hi hiVar, C3239hi hiVar2) {
        C3239hi hiVar3 = hiVar;
        int[] iArr = hiVar3.f2535d[0];
        int[][] iArr2 = hiVar2.f2535d;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < hiVar3.f2534c) {
            int i4 = i2;
            int i5 = 0;
            while (i5 < (hiVar3.f2533b >> 1)) {
                iArr2[1][i4] = 0;
                iArr2[2][i4] = 0;
                int i6 = i4 << 1;
                int i7 = i3 + 1;
                int i8 = i7 + 1;
                int i9 = i8 + 1;
                int i10 = i4;
                int i11 = i4;
                C3322kb.m2370a(iArr[i3], iArr[i7], iArr[i8], iArr2[0], i6, iArr2[1], i10, iArr2[2], i11);
                iArr2[0][i6] = (iArr2[0][i6] << this.f2862a) >> this.f2863b;
                int i12 = i9 + 1;
                int i13 = iArr[i9];
                int i14 = i12 + 1;
                int i15 = iArr[i12];
                int i16 = i14 + 1;
                int i17 = i6 + 1;
                int i18 = i13;
                int i19 = i15;
                C3322kb.m2370a(i18, i19, iArr[i14], iArr2[0], i17, iArr2[1], i10, iArr2[2], i11);
                iArr2[0][i17] = (iArr2[0][i17] << this.f2862a) >> this.f2863b;
                iArr2[1][i4] = (iArr2[1][i4] << this.f2862a) >> this.f2864c;
                iArr2[2][i4] = (iArr2[2][i4] << this.f2862a) >> this.f2864c;
                i4++;
                i5++;
                i3 = i16;
            }
            i++;
            i2 = i4;
        }
    }
}
