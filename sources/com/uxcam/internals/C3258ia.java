package com.uxcam.internals;

import java.nio.ByteBuffer;

/* renamed from: com.uxcam.internals.ia */
public class C3258ia extends C3273in {

    /* renamed from: c */
    private long[] f2614c;

    public C3258ia() {
        super(new C3277ir("stco"));
    }

    /* renamed from: a */
    public static String m2250a() {
        return "stco";
    }

    /* renamed from: a */
    public final void mo38506a(ByteBuffer byteBuffer) {
        super.mo38506a(byteBuffer);
        byteBuffer.putInt(this.f2614c.length);
        for (long j : this.f2614c) {
            byteBuffer.putInt((int) j);
        }
    }
}
