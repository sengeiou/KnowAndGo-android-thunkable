package com.uxcam.internals;

/* renamed from: com.uxcam.internals.kh */
public final class C3328kh implements C3324kd {

    /* renamed from: a */
    private int f2872a = 0;

    /* renamed from: b */
    private int f2873b;

    public C3328kh(int i) {
        this.f2873b = i;
    }

    /* renamed from: a */
    private static final void m2379a(int[] iArr, int[] iArr2, int i, int i2, int i3, int i4, int i5) {
        int i6 = (i * i3) + 0;
        int i7 = 0;
        int i8 = 0;
        while (i7 < i4) {
            int i9 = i8;
            int i10 = i6;
            int i11 = 0;
            while (i11 < i2) {
                iArr2[i10] = (iArr[i9] & 255) << 2;
                i10++;
                i11++;
                i9++;
            }
            int i12 = i10 - 1;
            for (int i13 = i2 * 1; i13 < i3; i13++) {
                iArr2[i10] = iArr2[i12];
                i10++;
            }
            i6 = (i3 * 1) + i10;
            i7++;
            i8 = i9;
        }
        int i14 = i6 - (i3 * 2);
        for (int i15 = i4 * 2; i15 < i5; i15 += 2) {
            for (int i16 = 0; i16 < i3; i16++) {
                iArr2[i6] = iArr2[i14 + i16];
                i6++;
            }
            i6 += i3 * 1;
        }
    }

    /* renamed from: a */
    public final void mo38565a(C3239hi hiVar, C3239hi hiVar2) {
        C3239hi hiVar3 = hiVar;
        C3239hi hiVar4 = hiVar2;
        int[] iArr = hiVar3.f2535d[0];
        int[] iArr2 = hiVar4.f2535d[0];
        int i = hiVar3.f2533b;
        int i2 = hiVar4.f2533b;
        int i3 = hiVar4.f2534c;
        int length = iArr.length / i;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < length) {
            int i7 = i6;
            int i8 = i5;
            int i9 = 0;
            while (i9 < i) {
                iArr2[i8] = (iArr[i7] & 255) << 2;
                i9++;
                i8++;
                i7++;
            }
            int i10 = i;
            while (i10 < i2) {
                iArr2[i8] = iArr2[i - 1];
                i10++;
                i8++;
            }
            i4++;
            i5 = i8;
            i6 = i7;
        }
        int i11 = (length - 1) * i2;
        while (length < i3) {
            int i12 = 0;
            while (i12 < i2) {
                iArr2[i5] = iArr2[i11 + i12];
                i12++;
                i5++;
            }
            length++;
        }
        m2379a(hiVar3.f2535d[1], hiVar4.f2535d[1], 0, hiVar3.f2533b >> 1, hiVar4.f2533b >> 1, hiVar3.f2534c >> 1, hiVar4.f2534c);
        m2379a(hiVar3.f2535d[1], hiVar4.f2535d[1], 1, hiVar3.f2533b >> 1, hiVar4.f2533b >> 1, hiVar3.f2534c >> 1, hiVar4.f2534c);
        m2379a(hiVar3.f2535d[2], hiVar4.f2535d[2], 0, hiVar3.f2533b >> 1, hiVar4.f2533b >> 1, hiVar3.f2534c >> 1, hiVar4.f2534c);
        m2379a(hiVar3.f2535d[2], hiVar4.f2535d[2], 1, hiVar3.f2533b >> 1, hiVar4.f2533b >> 1, hiVar3.f2534c >> 1, hiVar4.f2534c);
    }
}
