package com.uxcam.internals;

import java.nio.ByteBuffer;

/* renamed from: com.uxcam.internals.hz */
public class C3257hz extends C3273in {

    /* renamed from: c */
    private long[] f2613c;

    public C3257hz() {
        super(new C3277ir("co64", 0));
    }

    public C3257hz(long[] jArr) {
        this();
        this.f2613c = jArr;
    }

    /* renamed from: a */
    public static String m2248a() {
        return "co64";
    }

    /* renamed from: a */
    public final void mo38506a(ByteBuffer byteBuffer) {
        super.mo38506a(byteBuffer);
        byteBuffer.putInt(this.f2613c.length);
        for (long putLong : this.f2613c) {
            byteBuffer.putLong(putLong);
        }
    }
}
