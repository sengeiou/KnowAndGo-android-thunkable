package com.uxcam.internals;

import java.nio.ByteBuffer;

/* renamed from: com.uxcam.internals.jf */
public class C3292jf extends C3286ja {

    /* renamed from: a */
    private short f2691a;

    public C3292jf(C3277ir irVar) {
        super(irVar);
    }

    public C3292jf(C3277ir irVar, byte b) {
        super(irVar);
        this.f2691a = 1;
    }

    /* renamed from: a */
    public void mo38506a(ByteBuffer byteBuffer) {
        byteBuffer.put(new byte[]{0, 0, 0, 0, 0, 0});
        byteBuffer.putShort(this.f2691a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final void mo38550c(ByteBuffer byteBuffer) {
        super.mo38506a(byteBuffer);
    }
}
