package com.uxcam.internals;

/* renamed from: com.uxcam.internals.kf */
public final class C3326kf implements C3324kd {

    /* renamed from: a */
    public static int f2869a = 7168;

    /* renamed from: a */
    public final void mo38565a(C3239hi hiVar, C3239hi hiVar2) {
        int[] iArr = hiVar.f2535d[0];
        int[] iArr2 = hiVar2.f2535d[0];
        for (int i = 0; i < hiVar.mo38528a(0) * hiVar.mo38529b(0); i++) {
            iArr2[i] = ((iArr[i] * f2869a) >> 13) + 16;
        }
        int[] iArr3 = hiVar.f2535d[1];
        int[] iArr4 = hiVar2.f2535d[1];
        for (int i2 = 0; i2 < hiVar.mo38528a(1) * hiVar.mo38529b(1); i2++) {
            iArr4[i2] = (((iArr3[i2] - 128) * f2869a) >> 13) + 128;
        }
        int[] iArr5 = hiVar.f2535d[2];
        int[] iArr6 = hiVar2.f2535d[2];
        for (int i3 = 0; i3 < hiVar.mo38528a(2) * hiVar.mo38529b(2); i3++) {
            iArr6[i3] = (((iArr5[i3] - 128) * f2869a) >> 13) + 128;
        }
    }
}
