package com.uxcam.internals;

import java.nio.ByteBuffer;

/* renamed from: com.uxcam.internals.jk */
public class C3298jk extends C3273in {

    /* renamed from: c */
    private C3299aa[] f2701c;

    /* renamed from: com.uxcam.internals.jk$aa */
    public static class C3299aa {

        /* renamed from: a */
        int f2702a;

        /* renamed from: b */
        int f2703b;

        public C3299aa(int i, int i2) {
            this.f2702a = i;
            this.f2703b = i2;
        }
    }

    public C3298jk() {
        super(new C3277ir("stts"));
    }

    public C3298jk(C3299aa[] aaVarArr) {
        super(new C3277ir("stts"));
        this.f2701c = aaVarArr;
    }

    /* renamed from: a */
    public static String m2320a() {
        return "stts";
    }

    /* renamed from: a */
    public final void mo38506a(ByteBuffer byteBuffer) {
        super.mo38506a(byteBuffer);
        byteBuffer.putInt(this.f2701c.length);
        for (C3299aa aaVar : this.f2701c) {
            byteBuffer.putInt(aaVar.f2702a);
            byteBuffer.putInt(aaVar.f2703b);
        }
    }
}
