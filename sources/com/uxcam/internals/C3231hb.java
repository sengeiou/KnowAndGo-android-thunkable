package com.uxcam.internals;

import java.nio.ByteBuffer;
import kotlin.UByte;

/* renamed from: com.uxcam.internals.hb */
public final class C3231hb {

    /* renamed from: a */
    protected int f2474a = 0;

    /* renamed from: b */
    protected int f2475b = m2207c();

    /* renamed from: c */
    private ByteBuffer f2476c;

    /* renamed from: d */
    private int f2477d;

    public C3231hb(ByteBuffer byteBuffer) {
        this.f2476c = byteBuffer;
        this.f2477d = byteBuffer.position();
    }

    /* renamed from: c */
    private int m2207c() {
        if (this.f2476c.remaining() < 4) {
            return m2208d();
        }
        this.f2474a -= 32;
        return ((this.f2476c.get() & UByte.MAX_VALUE) << 24) | ((this.f2476c.get() & UByte.MAX_VALUE) << 16) | ((this.f2476c.get() & UByte.MAX_VALUE) << 8) | (this.f2476c.get() & UByte.MAX_VALUE);
    }

    /* renamed from: d */
    private int m2208d() {
        this.f2474a -= this.f2476c.remaining() << 3;
        byte b = 0;
        if (this.f2476c.hasRemaining()) {
            b = 0 | (this.f2476c.get() & UByte.MAX_VALUE);
        }
        int i = b << 8;
        if (this.f2476c.hasRemaining()) {
            i |= this.f2476c.get() & UByte.MAX_VALUE;
        }
        int i2 = i << 8;
        if (this.f2476c.hasRemaining()) {
            i2 |= this.f2476c.get() & UByte.MAX_VALUE;
        }
        int i3 = i2 << 8;
        return this.f2476c.hasRemaining() ? i3 | (this.f2476c.get() & UByte.MAX_VALUE) : i3;
    }

    /* renamed from: a */
    public final int mo38517a() {
        int i = this.f2475b >>> 31;
        this.f2475b <<= 1;
        this.f2474a++;
        if (this.f2474a == 32) {
            this.f2475b = m2207c();
        }
        return i;
    }

    /* renamed from: a */
    public final int mo38518a(int i) {
        if (i <= 32) {
            int i2 = 0;
            if (this.f2474a + i > 31) {
                i -= 32 - this.f2474a;
                i2 = ((this.f2475b >>> this.f2474a) | 0) << i;
                this.f2474a = 32;
                this.f2475b = m2207c();
            }
            if (i == 0) {
                return i2;
            }
            int i3 = i2 | (this.f2475b >>> (32 - i));
            this.f2475b <<= i;
            this.f2474a += i;
            return i3;
        }
        throw new IllegalArgumentException("Can not read more then 32 bit");
    }

    /* renamed from: b */
    public final int mo38519b() {
        return ((this.f2476c.remaining() << 3) + 32) - this.f2474a;
    }

    /* renamed from: b */
    public final int mo38520b(int i) {
        if (i <= 24) {
            while (this.f2474a + i > 32) {
                this.f2474a -= 8;
                this.f2475b |= (this.f2476c.hasRemaining() ? this.f2476c.get() & UByte.MAX_VALUE : 0) << this.f2474a;
            }
            return this.f2475b >>> (32 - i);
        }
        throw new IllegalArgumentException("Can not check more then 24 bit");
    }
}
