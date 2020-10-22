package com.uxcam.internals;

import androidx.core.view.ViewCompat;
import java.nio.ByteBuffer;

/* renamed from: com.uxcam.internals.in */
public class C3273in extends C3255hx {

    /* renamed from: a */
    protected byte f2648a;

    /* renamed from: b */
    protected int f2649b;

    public C3273in(C3277ir irVar) {
        super(irVar);
    }

    /* renamed from: a */
    public final void mo38543a(int i) {
        this.f2649b = i;
    }

    /* renamed from: a */
    public void mo38506a(ByteBuffer byteBuffer) {
        byteBuffer.putInt((this.f2648a << 24) | (this.f2649b & ViewCompat.MEASURED_SIZE_MASK));
    }
}
