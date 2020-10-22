package com.uxcam.internals;

import com.google.android.exoplayer2.extractor.p012ts.TsExtractor;

/* renamed from: com.uxcam.internals.kb */
public final class C3322kb implements C3324kd {

    /* renamed from: a */
    private int f2859a = 0;

    /* renamed from: b */
    private int f2860b = 0;

    /* renamed from: c */
    private int f2861c = 2;

    /* renamed from: a */
    private static final int m2369a(int i) {
        if (i < 0) {
            return 0;
        }
        if (i > 255) {
            return 255;
        }
        return i;
    }

    /* renamed from: a */
    public static final void m2370a(int i, int i2, int i3, int[] iArr, int i4, int[] iArr2, int i5, int[] iArr3, int i6) {
        int i7 = (i * 66) + (i2 * TsExtractor.TS_STREAM_TYPE_AC3) + (i3 * 25);
        iArr[i4] = m2369a(((i7 + 128) >> 8) + 16);
        iArr2[i5] = iArr2[i5] + m2369a((((((i * -38) - (i2 * 74)) + (i3 * 112)) + 128) >> 8) + 128);
        iArr3[i6] = iArr3[i6] + m2369a((((((i * 112) - (i2 * 94)) - (i3 * 18)) + 128) >> 8) + 128);
    }

    /* renamed from: a */
    public final void mo38565a(C3239hi hiVar, C3239hi hiVar2) {
        C3239hi hiVar3 = hiVar;
        C3239hi hiVar4 = hiVar2;
        int[] iArr = hiVar3.f2535d[0];
        int[][] iArr2 = hiVar4.f2535d;
        int i = hiVar3.f2533b * 3;
        int i2 = hiVar4.f2533b;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i3 < (hiVar3.f2534c >> 1)) {
            int i7 = i5;
            int i8 = i4;
            for (int i9 = 0; i9 < (hiVar3.f2533b >> 1); i9++) {
                iArr2[1][i8] = 0;
                iArr2[2][i8] = 0;
                int i10 = i8;
                int i11 = i8;
                m2370a(iArr[i6], iArr[i6 + 1], iArr[i6 + 2], iArr2[0], i7, iArr2[1], i10, iArr2[2], i11);
                iArr2[0][i7] = (iArr2[0][i7] << this.f2859a) >> this.f2860b;
                int i12 = i6 + i;
                int i13 = i7 + i2;
                m2370a(iArr[i12], iArr[i12 + 1], iArr[i12 + 2], iArr2[0], i13, iArr2[1], i10, iArr2[2], i11);
                iArr2[0][i13] = (iArr2[0][i13] << this.f2859a) >> this.f2860b;
                int i14 = i7 + 1;
                m2370a(iArr[i6 + 3], iArr[i6 + 4], iArr[i6 + 5], iArr2[0], i14, iArr2[1], i10, iArr2[2], i11);
                iArr2[0][i14] = (iArr2[0][i14] << this.f2859a) >> this.f2860b;
                int i15 = i14 + i2;
                m2370a(iArr[i12 + 3], iArr[i12 + 4], iArr[i12 + 5], iArr2[0], i15, iArr2[1], i10, iArr2[2], i11);
                iArr2[0][i15] = (iArr2[0][i15] << this.f2859a) >> this.f2860b;
                i7 = i14 + 1;
                iArr2[1][i8] = (iArr2[1][i8] << this.f2859a) >> this.f2861c;
                iArr2[2][i8] = (iArr2[2][i8] << this.f2859a) >> this.f2861c;
                i8++;
                i6 += 6;
            }
            i6 += i;
            i3++;
            int i16 = i8;
            i5 = i7 + i2;
            i4 = i16;
        }
    }
}
