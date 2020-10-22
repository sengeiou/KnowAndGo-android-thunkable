package com.uxcam.internals;

import java.nio.ByteBuffer;

/* renamed from: com.uxcam.internals.ie */
public class C3262ie extends C3255hx {

    /* renamed from: a */
    private final String f2630a = "nclc";

    /* renamed from: b */
    private short f2631b;

    /* renamed from: c */
    private short f2632c;

    /* renamed from: e */
    private short f2633e;

    public C3262ie() {
        super(new C3277ir("colr"));
    }

    /* renamed from: a */
    public static String m2258a() {
        return "colr";
    }

    /* renamed from: a */
    public final void mo38506a(ByteBuffer byteBuffer) {
        byteBuffer.put(C3227gx.m2197a("nclc"));
        byteBuffer.putShort(this.f2631b);
        byteBuffer.putShort(this.f2632c);
        byteBuffer.putShort(this.f2633e);
    }
}
