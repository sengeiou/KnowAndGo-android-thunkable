package com.uxcam.internals;

import java.nio.ByteBuffer;

/* renamed from: com.uxcam.internals.it */
public class C3279it extends C3255hx {

    /* renamed from: a */
    private int f2666a;

    /* renamed from: b */
    private int f2667b;

    /* renamed from: c */
    private int f2668c;

    /* renamed from: e */
    private int f2669e;

    public C3279it() {
        super(new C3277ir("load"));
    }

    /* renamed from: a */
    public static String m2284a() {
        return "load";
    }

    /* renamed from: a */
    public final void mo38506a(ByteBuffer byteBuffer) {
        byteBuffer.putInt(this.f2666a);
        byteBuffer.putInt(this.f2667b);
        byteBuffer.putInt(this.f2668c);
        byteBuffer.putInt(this.f2669e);
    }
}
