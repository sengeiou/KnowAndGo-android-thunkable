package com.uxcam.internals;

/* renamed from: com.uxcam.internals.kg */
public final class C3327kg implements C3324kd {

    /* renamed from: a */
    private final int f2870a = 0;

    /* renamed from: b */
    private final int f2871b = 0;

    /* renamed from: a */
    public final void mo38565a(C3239hi hiVar, C3239hi hiVar2) {
        C3239hi hiVar3 = hiVar;
        C3239hi hiVar4 = hiVar2;
        int[] iArr = hiVar3.f2535d[0];
        int i = 1;
        int[] iArr2 = hiVar3.f2535d[1];
        int[] iArr3 = hiVar3.f2535d[2];
        int[] iArr4 = hiVar4.f2535d[0];
        int i2 = hiVar4.f2533b;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < (hiVar4.f2534c >> i)) {
            int i6 = i5;
            int i7 = 0;
            while (i7 < (hiVar4.f2533b >> i)) {
                int i8 = (i7 << 1) + i4;
                C3331kk.m2385a((iArr[i8] << this.f2871b) >> this.f2870a, (iArr2[i6] << this.f2871b) >> this.f2870a, (iArr3[i6] << this.f2871b) >> this.f2870a, iArr4, i8 * 3);
                int i9 = i8 + 1;
                C3331kk.m2385a((iArr[i9] << this.f2871b) >> this.f2870a, (iArr2[i6] << this.f2871b) >> this.f2870a, (iArr3[i6] << this.f2871b) >> this.f2870a, iArr4, i9 * 3);
                int i10 = i8 + i2;
                C3331kk.m2385a((iArr[i10] << this.f2871b) >> this.f2870a, (iArr2[i6] << this.f2871b) >> this.f2870a, (iArr3[i6] << this.f2871b) >> this.f2870a, iArr4, i10 * 3);
                int i11 = i10 + 1;
                C3331kk.m2385a((iArr[i11] << this.f2871b) >> this.f2870a, (iArr2[i6] << this.f2871b) >> this.f2870a, (iArr3[i6] << this.f2871b) >> this.f2870a, iArr4, i11 * 3);
                i6++;
                i7++;
                i3 = i3;
                i = 1;
            }
            int i12 = i3;
            if ((hiVar4.f2533b & 1) != 0) {
                int i13 = (hiVar4.f2533b - 1) + i4;
                C3331kk.m2385a((iArr[i13] << this.f2871b) >> this.f2870a, (iArr2[i6] << this.f2871b) >> this.f2870a, (iArr3[i6] << this.f2871b) >> this.f2870a, iArr4, i13 * 3);
                int i14 = i13 + i2;
                C3331kk.m2385a((iArr[i14] << this.f2871b) >> this.f2870a, (iArr2[i6] << this.f2871b) >> this.f2870a, (iArr3[i6] << this.f2871b) >> this.f2870a, iArr4, i14 * 3);
                i6++;
            }
            i5 = i6;
            i4 += i2 * 2;
            i3 = i12 + 1;
            i = 1;
        }
        if ((hiVar4.f2534c & 1) != 0) {
            int i15 = 0;
            for (int i16 = 1; i15 < (hiVar4.f2533b >> i16); i16 = 1) {
                int i17 = (i15 << 1) + i4;
                C3331kk.m2385a((iArr[i17] << this.f2871b) >> this.f2870a, (iArr2[i5] << this.f2871b) >> this.f2870a, (iArr3[i5] << this.f2871b) >> this.f2870a, iArr4, i17 * 3);
                int i18 = i17 + 1;
                C3331kk.m2385a((iArr[i18] << this.f2871b) >> this.f2870a, (iArr2[i5] << this.f2871b) >> this.f2870a, (iArr3[i5] << this.f2871b) >> this.f2870a, iArr4, i18 * 3);
                i5++;
                i15++;
            }
            if ((hiVar4.f2533b & 1) != 0) {
                int i19 = i4 + (hiVar4.f2533b - 1);
                C3331kk.m2385a((iArr[i19] << this.f2871b) >> this.f2870a, (iArr2[i5] << this.f2871b) >> this.f2870a, (iArr3[i5] << this.f2871b) >> this.f2870a, iArr4, i19 * 3);
            }
        }
    }
}
