package com.uxcam.internals;

/* renamed from: com.uxcam.internals.gp */
public final class C3219gp {
    /* renamed from: a */
    public static void m2180a(C3232hc hcVar) {
        hcVar.mo38522a(1);
        hcVar.mo38521a();
    }

    /* renamed from: a */
    public static void m2181a(C3232hc hcVar, int i) {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= 15) {
                i2 = 0;
                break;
            }
            int i4 = (1 << i2) + i3;
            if (i < i4) {
                break;
            }
            i2++;
            i3 = i4;
        }
        hcVar.mo38523a(0, i2);
        hcVar.mo38522a(1);
        hcVar.mo38523a(i - i3, i2);
    }

    /* renamed from: a */
    public static void m2182a(C3232hc hcVar, long j, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            hcVar.mo38522a(((int) (j >> ((i - i2) - 1))) & 1);
        }
    }

    /* renamed from: a */
    public static void m2183a(C3232hc hcVar, boolean z) {
        hcVar.mo38522a(z ? 1 : 0);
    }

    /* renamed from: b */
    public static void m2184b(C3232hc hcVar, int i) {
        m2181a(hcVar, C3245ho.m2231c(i));
    }
}
