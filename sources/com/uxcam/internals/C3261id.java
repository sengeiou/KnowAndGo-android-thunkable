package com.uxcam.internals;

import java.nio.ByteBuffer;

/* renamed from: com.uxcam.internals.id */
public class C3261id extends C3255hx {

    /* renamed from: a */
    private short f2625a;

    /* renamed from: b */
    private short f2626b;

    /* renamed from: c */
    private short f2627c;

    /* renamed from: e */
    private short f2628e;

    /* renamed from: f */
    private short f2629f;

    public C3261id() {
        super(new C3277ir("crgn"));
    }

    /* renamed from: a */
    public static String m2256a() {
        return "crgn";
    }

    /* renamed from: a */
    public final void mo38506a(ByteBuffer byteBuffer) {
        byteBuffer.putShort(this.f2625a);
        byteBuffer.putShort(this.f2626b);
        byteBuffer.putShort(this.f2627c);
        byteBuffer.putShort(this.f2628e);
        byteBuffer.putShort(this.f2629f);
    }
}
