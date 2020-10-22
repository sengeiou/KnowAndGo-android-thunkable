package com.uxcam.internals;

import java.nio.ByteBuffer;

/* renamed from: com.uxcam.internals.jg */
public class C3293jg extends C3273in {

    /* renamed from: c */
    private int f2692c;

    /* renamed from: e */
    private int f2693e;

    /* renamed from: f */
    private int[] f2694f;

    public C3293jg() {
        super(new C3277ir("stsz"));
    }

    public C3293jg(int[] iArr) {
        this();
        this.f2694f = iArr;
    }

    /* renamed from: a */
    public static String m2312a() {
        return "stsz";
    }

    /* renamed from: a */
    public final void mo38506a(ByteBuffer byteBuffer) {
        super.mo38506a(byteBuffer);
        byteBuffer.putInt(this.f2692c);
        if (this.f2692c == 0) {
            byteBuffer.putInt(this.f2694f.length);
            for (int i : this.f2694f) {
                byteBuffer.putInt((int) ((long) i));
            }
            return;
        }
        byteBuffer.putInt(this.f2693e);
    }
}
