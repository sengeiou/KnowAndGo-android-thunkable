package com.uxcam.internals;

/* renamed from: com.uxcam.internals.df */
public final class C3057df extends C3024cg {

    /* renamed from: a */
    private final C3000bv f1896a;

    /* renamed from: b */
    private final C3132ep f1897b;

    public C3057df(C3000bv bvVar, C3132ep epVar) {
        this.f1896a = bvVar;
        this.f1897b = epVar;
    }

    /* renamed from: a */
    public final C3007by mo38187a() {
        String a = this.f1896a.mo38113a("Content-Type");
        if (a != null) {
            return C3007by.m1329a(a);
        }
        return null;
    }

    /* renamed from: b */
    public final long mo38188b() {
        return C3054dc.m1500a(this.f1896a);
    }

    /* renamed from: c */
    public final C3132ep mo38189c() {
        return this.f1897b;
    }
}
