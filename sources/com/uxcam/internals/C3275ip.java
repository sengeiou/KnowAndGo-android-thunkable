package com.uxcam.internals;

import java.nio.ByteBuffer;

/* renamed from: com.uxcam.internals.ip */
public class C3275ip extends C3273in {

    /* renamed from: c */
    private short f2651c;

    /* renamed from: e */
    private short f2652e;

    /* renamed from: f */
    private short f2653f;

    /* renamed from: g */
    private short f2654g;

    /* renamed from: h */
    private short f2655h;

    public C3275ip() {
        this(new C3277ir("gmin"));
    }

    private C3275ip(C3277ir irVar) {
        super(irVar);
    }

    /* renamed from: a */
    public static String m2277a() {
        return "gmin";
    }

    /* renamed from: a */
    public final void mo38506a(ByteBuffer byteBuffer) {
        super.mo38506a(byteBuffer);
        byteBuffer.putShort(this.f2651c);
        byteBuffer.putShort(this.f2652e);
        byteBuffer.putShort(this.f2653f);
        byteBuffer.putShort(this.f2654g);
        byteBuffer.putShort(this.f2655h);
        byteBuffer.putShort(0);
    }
}
