package com.uxcam.internals;

import java.nio.ByteBuffer;

/* renamed from: com.uxcam.internals.if */
public class C3263if extends C3273in {

    /* renamed from: c */
    private C3264aa[] f2634c;

    /* renamed from: com.uxcam.internals.if$aa */
    public static class C3264aa {

        /* renamed from: a */
        public int f2635a;

        /* renamed from: b */
        public int f2636b;

        public C3264aa(int i, int i2) {
            this.f2635a = i;
            this.f2636b = i2;
        }
    }

    public C3263if() {
        super(new C3277ir("ctts"));
    }

    public C3263if(C3264aa[] aaVarArr) {
        super(new C3277ir("ctts"));
        this.f2634c = aaVarArr;
    }

    /* renamed from: a */
    public static String m2260a() {
        return "ctts";
    }

    /* renamed from: a */
    public final void mo38506a(ByteBuffer byteBuffer) {
        super.mo38506a(byteBuffer);
        byteBuffer.putInt(this.f2634c.length);
        for (int i = 0; i < this.f2634c.length; i++) {
            byteBuffer.putInt(this.f2634c[i].f2635a);
            byteBuffer.putInt(this.f2634c[i].f2636b);
        }
    }
}
