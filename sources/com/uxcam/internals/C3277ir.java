package com.uxcam.internals;

import java.nio.ByteBuffer;

/* renamed from: com.uxcam.internals.ir */
public final class C3277ir {

    /* renamed from: a */
    String f2662a;

    /* renamed from: b */
    long f2663b;

    /* renamed from: c */
    private boolean f2664c;

    public C3277ir(String str) {
        this.f2662a = str;
    }

    public C3277ir(String str, long j) {
        this.f2663b = j;
        this.f2662a = str;
    }

    /* renamed from: a */
    public final long mo38544a() {
        return (this.f2664c || this.f2663b > 4294967296L) ? 16 : 8;
    }

    /* renamed from: a */
    public final void mo38545a(ByteBuffer byteBuffer) {
        byteBuffer.putInt(this.f2663b > 4294967296L ? 1 : (int) this.f2663b);
        byteBuffer.put(C3227gx.m2197a(this.f2662a));
        if (this.f2663b > 4294967296L) {
            byteBuffer.putLong(this.f2663b);
        }
    }
}
