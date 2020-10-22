package com.uxcam.internals;

/* renamed from: com.uxcam.internals.ki */
public final class C3329ki implements C3324kd {
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
                C3325ke.m2375a(iArr[i5], iArr2[i4], iArr3[i4], iArr4, i5 * 3);
                int i7 = i5 + 1;
                C3325ke.m2375a(iArr[i7], iArr2[i4], iArr3[i4], iArr4, i7 * 3);
                i5 += 2;
                i4++;
            }
            i++;
            i2 = i5;
            i3 = i4;
        }
    }
}
