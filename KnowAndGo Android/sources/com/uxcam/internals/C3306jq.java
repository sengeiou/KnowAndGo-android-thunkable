package com.uxcam.internals;

import java.nio.ByteBuffer;

/* renamed from: com.uxcam.internals.jq */
public class C3306jq extends C3273in {

    /* renamed from: c */
    int f2727c;

    /* renamed from: e */
    int f2728e;

    /* renamed from: f */
    int f2729f;

    /* renamed from: g */
    int f2730g;

    public C3306jq() {
        super(new C3277ir("vmhd"));
    }

    public C3306jq(byte b) {
        super(new C3277ir("vmhd"));
        this.f2727c = 0;
        this.f2728e = 0;
        this.f2729f = 0;
        this.f2730g = 0;
    }

    /* renamed from: a */
    public static String m2332a() {
        return "vmhd";
    }

    /* renamed from: a */
    public final void mo38506a(ByteBuffer byteBuffer) {
        super.mo38506a(byteBuffer);
        byteBuffer.putShort((short) this.f2727c);
        byteBuffer.putShort((short) this.f2728e);
        byteBuffer.putShort((short) this.f2729f);
        byteBuffer.putShort((short) this.f2730g);
    }
}
