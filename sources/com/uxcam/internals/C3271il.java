package com.uxcam.internals;

import java.nio.ByteBuffer;

/* renamed from: com.uxcam.internals.il */
public class C3271il extends C3255hx {

    /* renamed from: a */
    private int f2643a;

    /* renamed from: b */
    private int f2644b;

    public C3271il() {
        super(new C3277ir("fiel"));
    }

    /* renamed from: a */
    public static String m2269a() {
        return "fiel";
    }

    /* renamed from: a */
    public final void mo38506a(ByteBuffer byteBuffer) {
        byteBuffer.put((byte) this.f2643a);
        byteBuffer.put((byte) this.f2644b);
    }
}
