package com.uxcam.internals;

/* renamed from: com.uxcam.internals.ey */
final class C3144ey {

    /* renamed from: a */
    final byte[] f2187a;

    /* renamed from: b */
    int f2188b;

    /* renamed from: c */
    int f2189c;

    /* renamed from: d */
    boolean f2190d;

    /* renamed from: e */
    boolean f2191e;

    /* renamed from: f */
    C3144ey f2192f;

    /* renamed from: g */
    C3144ey f2193g;

    C3144ey() {
        this.f2187a = new byte[8192];
        this.f2191e = true;
        this.f2190d = false;
    }

    C3144ey(C3144ey eyVar) {
        this(eyVar.f2187a, eyVar.f2188b, eyVar.f2189c);
        eyVar.f2190d = true;
    }

    C3144ey(byte[] bArr, int i, int i2) {
        this.f2187a = bArr;
        this.f2188b = i;
        this.f2189c = i2;
        this.f2191e = false;
        this.f2190d = true;
    }

    /* renamed from: a */
    public final C3144ey mo38432a() {
        C3144ey eyVar = this.f2192f != this ? this.f2192f : null;
        this.f2193g.f2192f = this.f2192f;
        this.f2192f.f2193g = this.f2193g;
        this.f2192f = null;
        this.f2193g = null;
        return eyVar;
    }

    /* renamed from: a */
    public final C3144ey mo38433a(C3144ey eyVar) {
        eyVar.f2193g = this;
        eyVar.f2192f = this.f2192f;
        this.f2192f.f2193g = eyVar;
        this.f2192f = eyVar;
        return eyVar;
    }

    /* renamed from: a */
    public final void mo38434a(C3144ey eyVar, int i) {
        if (eyVar.f2191e) {
            if (eyVar.f2189c + i > 8192) {
                if (eyVar.f2190d) {
                    throw new IllegalArgumentException();
                } else if ((eyVar.f2189c + i) - eyVar.f2188b <= 8192) {
                    System.arraycopy(eyVar.f2187a, eyVar.f2188b, eyVar.f2187a, 0, eyVar.f2189c - eyVar.f2188b);
                    eyVar.f2189c -= eyVar.f2188b;
                    eyVar.f2188b = 0;
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f2187a, this.f2188b, eyVar.f2187a, eyVar.f2189c, i);
            eyVar.f2189c += i;
            this.f2188b += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
