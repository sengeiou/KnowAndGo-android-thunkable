package com.uxcam.internals;

import java.nio.ByteBuffer;

/* renamed from: com.uxcam.internals.ic */
public class C3260ic extends C3273in {

    /* renamed from: c */
    private float f2623c;

    /* renamed from: e */
    private float f2624e;

    public C3260ic() {
        super(new C3277ir("clef"));
    }

    public C3260ic(int i, int i2) {
        this();
        this.f2623c = (float) i;
        this.f2624e = (float) i2;
    }

    public C3260ic(C3277ir irVar) {
        super(irVar);
    }

    public C3260ic(C3277ir irVar, int i, int i2) {
        super(irVar);
        this.f2623c = (float) i;
        this.f2624e = (float) i2;
    }

    /* renamed from: a */
    public static String m2254a() {
        return "clef";
    }

    /* renamed from: a */
    public final void mo38506a(ByteBuffer byteBuffer) {
        super.mo38506a(byteBuffer);
        byteBuffer.putInt((int) (this.f2623c * 65536.0f));
        byteBuffer.putInt((int) (this.f2624e * 65536.0f));
    }
}
