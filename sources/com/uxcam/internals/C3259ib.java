package com.uxcam.internals;

import java.nio.ByteBuffer;

/* renamed from: com.uxcam.internals.ib */
public class C3259ib extends C3255hx {

    /* renamed from: a */
    private int f2615a;

    /* renamed from: b */
    private int f2616b;

    /* renamed from: c */
    private int f2617c;

    /* renamed from: e */
    private int f2618e;

    /* renamed from: f */
    private int f2619f;

    /* renamed from: g */
    private int f2620g;

    /* renamed from: h */
    private int f2621h;

    /* renamed from: i */
    private int f2622i;

    public C3259ib() {
        super(new C3277ir("clap"));
    }

    /* renamed from: a */
    public static String m2252a() {
        return "clap";
    }

    /* renamed from: a */
    public final void mo38506a(ByteBuffer byteBuffer) {
        byteBuffer.putInt(this.f2622i);
        byteBuffer.putInt(this.f2621h);
        byteBuffer.putInt(this.f2620g);
        byteBuffer.putInt(this.f2619f);
        byteBuffer.putInt(this.f2618e);
        byteBuffer.putInt(this.f2617c);
        byteBuffer.putInt(this.f2616b);
        byteBuffer.putInt(this.f2615a);
    }
}
