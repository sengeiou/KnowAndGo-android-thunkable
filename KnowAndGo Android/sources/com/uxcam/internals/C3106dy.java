package com.uxcam.internals;

/* renamed from: com.uxcam.internals.dy */
public final class C3106dy {

    /* renamed from: a */
    int f2102a;

    /* renamed from: b */
    final int[] f2103b = new int[10];

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final int mo38308a() {
        if ((this.f2102a & 2) != 0) {
            return this.f2103b[1];
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final C3106dy mo38309a(int i, int i2) {
        if (i >= this.f2103b.length) {
            return this;
        }
        this.f2102a = (1 << i) | this.f2102a;
        this.f2103b[i] = i2;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo38310a(int i) {
        return ((1 << i) & this.f2102a) != 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final int mo38311b() {
        if ((this.f2102a & 128) != 0) {
            return this.f2103b[7];
        }
        return 65535;
    }
}
