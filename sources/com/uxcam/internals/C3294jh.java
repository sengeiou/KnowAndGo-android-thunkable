package com.uxcam.internals;

import java.nio.ByteBuffer;

/* renamed from: com.uxcam.internals.jh */
public class C3294jh extends C3273in {

    /* renamed from: c */
    private C3295aa[] f2695c;

    /* renamed from: com.uxcam.internals.jh$aa */
    public static class C3295aa {

        /* renamed from: a */
        long f2696a;

        /* renamed from: b */
        int f2697b;

        /* renamed from: c */
        int f2698c;

        public C3295aa(long j, int i, int i2) {
            this.f2696a = j;
            this.f2697b = i;
            this.f2698c = i2;
        }
    }

    public C3294jh() {
        super(new C3277ir("stsc"));
    }

    public C3294jh(C3295aa[] aaVarArr) {
        super(new C3277ir("stsc"));
        this.f2695c = aaVarArr;
    }

    /* renamed from: a */
    public static String m2314a() {
        return "stsc";
    }

    /* renamed from: a */
    public final void mo38506a(ByteBuffer byteBuffer) {
        super.mo38506a(byteBuffer);
        byteBuffer.putInt(this.f2695c.length);
        for (C3295aa aaVar : this.f2695c) {
            byteBuffer.putInt((int) aaVar.f2696a);
            byteBuffer.putInt(aaVar.f2697b);
            byteBuffer.putInt(aaVar.f2698c);
        }
    }
}
