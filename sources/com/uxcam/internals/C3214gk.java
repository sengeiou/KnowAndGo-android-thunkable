package com.uxcam.internals;

/* renamed from: com.uxcam.internals.gk */
public final class C3214gk {
    /* renamed from: a */
    public static int m2149a(C3231hb hbVar) {
        int i = 0;
        while (hbVar.mo38517a() == 0 && i < 31) {
            i++;
        }
        if (i <= 0) {
            return 0;
        }
        return (int) (((long) ((1 << i) - 1)) + ((long) hbVar.mo38518a(i)));
    }

    /* renamed from: b */
    public static int m2150b(C3231hb hbVar) {
        return m2149a(hbVar);
    }

    /* renamed from: c */
    public static int m2151c(C3231hb hbVar) {
        int a = m2149a(hbVar);
        int i = a & 1;
        return ((a >> 1) + i) * ((i << 1) - 1);
    }

    /* renamed from: d */
    public static boolean m2152d(C3231hb hbVar) {
        return hbVar.mo38517a() != 0;
    }
}
