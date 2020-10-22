package com.uxcam.internals;

import java.nio.ByteBuffer;

/* renamed from: com.uxcam.internals.iz */
public class C3285iz extends C3255hx {

    /* renamed from: a */
    private String f2684a;

    public C3285iz() {
        super(new C3277ir("name"));
    }

    public C3285iz(String str) {
        this();
        this.f2684a = str;
    }

    /* renamed from: a */
    public static String m2295a() {
        return "name";
    }

    /* renamed from: a */
    public final void mo38506a(ByteBuffer byteBuffer) {
        byteBuffer.put(C3227gx.m2197a(this.f2684a));
        byteBuffer.putInt(0);
    }
}
