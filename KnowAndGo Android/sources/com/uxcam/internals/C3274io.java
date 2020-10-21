package com.uxcam.internals;

import java.nio.ByteBuffer;

/* renamed from: com.uxcam.internals.io */
public class C3274io extends C3255hx {

    /* renamed from: a */
    private float f2650a;

    /* renamed from: a */
    public static String m2275a() {
        return "gama";
    }

    /* renamed from: a */
    public final void mo38506a(ByteBuffer byteBuffer) {
        byteBuffer.putInt((int) (this.f2650a * 65536.0f));
    }
}
