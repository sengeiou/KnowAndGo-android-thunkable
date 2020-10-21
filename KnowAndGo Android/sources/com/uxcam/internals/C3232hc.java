package com.uxcam.internals;

import java.nio.ByteBuffer;

/* renamed from: com.uxcam.internals.hc */
public final class C3232hc {

    /* renamed from: a */
    public final ByteBuffer f2478a;

    /* renamed from: b */
    public int f2479b;

    /* renamed from: c */
    public int f2480c;

    /* renamed from: d */
    public int f2481d;

    public C3232hc(ByteBuffer byteBuffer) {
        this.f2478a = byteBuffer;
        this.f2481d = byteBuffer.position();
    }

    public C3232hc(ByteBuffer byteBuffer, int i, int i2, int i3) {
        this.f2478a = byteBuffer;
        this.f2480c = i;
        this.f2479b = i2;
        this.f2481d = i3;
    }

    /* renamed from: b */
    private final void m2213b(int i) {
        this.f2478a.put((byte) (i >>> 24));
        this.f2478a.put((byte) (i >> 16));
        this.f2478a.put((byte) (i >> 8));
        this.f2478a.put((byte) i);
    }

    /* renamed from: a */
    public final void mo38521a() {
        int i = (this.f2480c + 7) >> 3;
        for (int i2 = 0; i2 < i; i2++) {
            this.f2478a.put((byte) (this.f2479b >>> 24));
            this.f2479b <<= 8;
        }
    }

    /* renamed from: a */
    public final void mo38522a(int i) {
        this.f2479b = (i << ((32 - this.f2480c) - 1)) | this.f2479b;
        this.f2480c++;
        if (this.f2480c == 32) {
            m2213b(this.f2479b);
            this.f2480c = 0;
            this.f2479b = 0;
        }
    }

    /* renamed from: a */
    public final void mo38523a(int i, int i2) {
        if (i2 > 32) {
            throw new IllegalArgumentException("Max 32 bit to write");
        } else if (i2 != 0) {
            int i3 = i & (-1 >>> (32 - i2));
            if (32 - this.f2480c >= i2) {
                this.f2479b = (i3 << ((32 - this.f2480c) - i2)) | this.f2479b;
                this.f2480c += i2;
                if (this.f2480c == 32) {
                    m2213b(this.f2479b);
                    this.f2480c = 0;
                    this.f2479b = 0;
                    return;
                }
                return;
            }
            int i4 = i2 - (32 - this.f2480c);
            this.f2479b |= i3 >>> i4;
            m2213b(this.f2479b);
            this.f2479b = i3 << (32 - i4);
            this.f2480c = i4;
        }
    }

    /* renamed from: b */
    public final int mo38524b() {
        return ((this.f2478a.position() - this.f2481d) << 3) + this.f2480c;
    }
}
