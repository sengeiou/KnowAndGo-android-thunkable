package com.uxcam.internals;

import java.nio.ByteBuffer;

/* renamed from: com.uxcam.internals.jj */
public class C3297jj extends C3273in {

    /* renamed from: c */
    private int[] f2700c;

    public C3297jj() {
        super(new C3277ir("stss"));
    }

    public C3297jj(C3277ir irVar) {
        super(irVar);
    }

    public C3297jj(int[] iArr) {
        this();
        this.f2700c = iArr;
    }

    /* renamed from: b */
    public static String m2318b() {
        return "stss";
    }

    /* renamed from: a */
    public final void mo38506a(ByteBuffer byteBuffer) {
        super.mo38506a(byteBuffer);
        byteBuffer.putInt(this.f2700c.length);
        for (int putInt : this.f2700c) {
            byteBuffer.putInt(putInt);
        }
    }
}
