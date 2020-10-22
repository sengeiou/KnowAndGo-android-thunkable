package com.uxcam.internals;

import java.nio.ByteBuffer;

/* renamed from: com.uxcam.internals.jl */
public class C3300jl extends C3273in {

    /* renamed from: c */
    private short f2704c;

    /* renamed from: e */
    private short f2705e;

    /* renamed from: f */
    private short f2706f;

    /* renamed from: g */
    private short[] f2707g;

    /* renamed from: h */
    private short[] f2708h;

    /* renamed from: i */
    private String f2709i;

    private C3300jl(C3277ir irVar) {
        super(irVar);
        this.f2707g = new short[3];
        this.f2708h = new short[3];
    }

    public C3300jl(short[] sArr, short[] sArr2, String str) {
        this(new C3277ir("tcmi"));
        this.f2704c = 0;
        this.f2705e = 0;
        this.f2706f = 12;
        this.f2707g = sArr;
        this.f2708h = sArr2;
        this.f2709i = str;
    }

    /* renamed from: a */
    public static String m2322a() {
        return "tcmi";
    }

    /* renamed from: a */
    public final void mo38506a(ByteBuffer byteBuffer) {
        super.mo38506a(byteBuffer);
        byteBuffer.putShort(this.f2704c);
        byteBuffer.putShort(this.f2705e);
        byteBuffer.putShort(this.f2706f);
        byteBuffer.putShort(0);
        byteBuffer.putShort(this.f2707g[0]);
        byteBuffer.putShort(this.f2707g[1]);
        byteBuffer.putShort(this.f2707g[2]);
        byteBuffer.putShort(this.f2708h[0]);
        byteBuffer.putShort(this.f2708h[1]);
        byteBuffer.putShort(this.f2708h[2]);
        String str = this.f2709i;
        byteBuffer.put((byte) str.length());
        byteBuffer.put(C3227gx.m2197a(str));
    }
}
