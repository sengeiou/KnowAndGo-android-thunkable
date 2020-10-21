package com.uxcam.internals;

import java.util.Arrays;

/* renamed from: com.uxcam.internals.gv */
public final class C3225gv {

    /* renamed from: a */
    public int[] f2466a;

    /* renamed from: b */
    public int f2467b;

    /* renamed from: c */
    private int f2468c;

    public C3225gv() {
        this((byte) 0);
    }

    private C3225gv(byte b) {
        this.f2468c = 128;
        this.f2466a = new int[128];
    }

    /* renamed from: a */
    public final void mo38513a(int i) {
        if (this.f2467b >= this.f2466a.length) {
            int[] iArr = new int[(this.f2466a.length + this.f2468c)];
            System.arraycopy(this.f2466a, 0, iArr, 0, this.f2466a.length);
            this.f2466a = iArr;
        }
        int[] iArr2 = this.f2466a;
        int i2 = this.f2467b;
        this.f2467b = i2 + 1;
        iArr2[i2] = i;
    }

    /* renamed from: a */
    public final void mo38514a(int i, int i2, int i3) {
        if (i2 > this.f2466a.length) {
            int[] iArr = new int[(this.f2468c + i2)];
            System.arraycopy(this.f2466a, 0, iArr, 0, this.f2466a.length);
            this.f2466a = iArr;
        }
        Arrays.fill(this.f2466a, i, i2, i3);
        this.f2467b = Math.max(this.f2467b, i2);
    }

    /* renamed from: a */
    public final int[] mo38515a() {
        int[] iArr = new int[this.f2467b];
        System.arraycopy(this.f2466a, 0, iArr, 0, this.f2467b);
        return iArr;
    }
}
