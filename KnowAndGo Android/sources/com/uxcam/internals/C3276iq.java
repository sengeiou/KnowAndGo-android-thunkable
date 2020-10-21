package com.uxcam.internals;

import java.nio.ByteBuffer;

/* renamed from: com.uxcam.internals.iq */
public class C3276iq extends C3273in {

    /* renamed from: c */
    private String f2656c;

    /* renamed from: e */
    private String f2657e;

    /* renamed from: f */
    private String f2658f;

    /* renamed from: g */
    private int f2659g;

    /* renamed from: h */
    private int f2660h;

    /* renamed from: i */
    private String f2661i;

    public C3276iq() {
        super(new C3277ir("hdlr"));
    }

    public C3276iq(String str, String str2, String str3) {
        super(new C3277ir("hdlr"));
        this.f2656c = str;
        this.f2657e = str2;
        this.f2658f = str3;
        this.f2659g = 0;
        this.f2660h = 0;
        this.f2661i = "";
    }

    /* renamed from: a */
    public static String m2279a() {
        return "hdlr";
    }

    /* renamed from: a */
    public final void mo38506a(ByteBuffer byteBuffer) {
        super.mo38506a(byteBuffer);
        byteBuffer.put(C3227gx.m2197a(this.f2656c));
        byteBuffer.put(C3227gx.m2197a(this.f2657e));
        byteBuffer.put(C3227gx.m2197a(this.f2658f));
        byteBuffer.putInt(this.f2659g);
        byteBuffer.putInt(this.f2660h);
        if (this.f2661i != null) {
            byteBuffer.put(C3227gx.m2197a(this.f2661i));
        }
    }
}
