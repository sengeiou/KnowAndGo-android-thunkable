package com.uxcam.internals;

import java.nio.ByteBuffer;

/* renamed from: com.uxcam.internals.ji */
public class C3296ji extends C3273in {

    /* renamed from: c */
    private short f2699c;

    public C3296ji() {
        super(new C3277ir("smhd"));
    }

    /* renamed from: a */
    public static String m2316a() {
        return "smhd";
    }

    /* renamed from: a */
    public final void mo38506a(ByteBuffer byteBuffer) {
        super.mo38506a(byteBuffer);
        byteBuffer.putShort(this.f2699c);
        byteBuffer.putShort(0);
    }
}
