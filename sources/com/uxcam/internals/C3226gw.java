package com.uxcam.internals;

import java.util.Arrays;

/* renamed from: com.uxcam.internals.gw */
public final class C3226gw {

    /* renamed from: a */
    public int[] f2469a = new int[128];

    /* renamed from: b */
    private int f2470b;

    public C3226gw() {
        Arrays.fill(this.f2469a, Integer.MIN_VALUE);
    }

    /* renamed from: a */
    public final void mo38516a(int i, int i2) {
        if (i2 != Integer.MIN_VALUE) {
            if (this.f2469a.length <= i) {
                int[] iArr = new int[(i + 128)];
                System.arraycopy(this.f2469a, 0, iArr, 0, this.f2469a.length);
                Arrays.fill(iArr, this.f2469a.length, iArr.length, Integer.MIN_VALUE);
                this.f2469a = iArr;
            }
            if (this.f2469a[i] == Integer.MIN_VALUE) {
                this.f2470b++;
            }
            this.f2469a[i] = i2;
            return;
        }
        throw new IllegalArgumentException("This implementation can not store -2147483648");
    }
}
