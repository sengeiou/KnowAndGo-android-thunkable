package com.uxcam.internals;

/* renamed from: com.uxcam.internals.hd */
public class C3233hd {

    /* renamed from: a */
    private int[] f2482a;

    /* renamed from: b */
    private int[] f2483b;

    /* renamed from: c */
    private int[] f2484c;

    /* renamed from: d */
    private int[] f2485d;

    public C3233hd(int[] iArr, int[] iArr2) {
        this.f2482a = iArr;
        this.f2483b = iArr2;
        C3225gv gvVar = new C3225gv();
        C3225gv gvVar2 = new C3225gv();
        m2218a(0, 0, 0, gvVar, gvVar2);
        this.f2484c = gvVar.mo38515a();
        this.f2485d = gvVar2.mo38515a();
    }

    /* renamed from: a */
    private int m2218a(int i, int i2, int i3, C3225gv gvVar, C3225gv gvVar2) {
        int i4 = i;
        C3225gv gvVar3 = gvVar;
        C3225gv gvVar4 = gvVar2;
        int i5 = i4 + 256;
        gvVar3.mo38514a(i4, i5, -1);
        gvVar4.mo38514a(i4, i5, 0);
        int i6 = i2 << 3;
        int i7 = i5;
        for (int i8 = 0; i8 < this.f2483b.length; i8++) {
            if (this.f2483b[i8] > i6) {
                if (i2 <= 0) {
                    int i9 = i3;
                } else if ((this.f2482a[i8] >>> (32 - i6)) != i3) {
                }
                int i10 = this.f2482a[i8] >>> ((32 - i6) - 8);
                int i11 = i10 & 255;
                int i12 = this.f2483b[i8] - i6;
                if (i12 <= 8) {
                    for (int i13 = 0; i13 < (1 << (8 - i12)); i13++) {
                        int i14 = i4 + i11 + i13;
                        gvVar3.f2466a[i14] = i8;
                        gvVar4.f2466a[i14] = i12;
                    }
                } else {
                    int i15 = i11 + i4;
                    if (gvVar3.f2466a[i15] == -1) {
                        gvVar3.f2466a[i15] = i7;
                        i7 = m2218a(i7, i2 + 1, i10, gvVar, gvVar2);
                    }
                }
            } else {
                int i16 = i3;
            }
        }
        return i7;
    }

    /* renamed from: a */
    public void mo38525a(C3232hc hcVar, int i) {
        hcVar.mo38523a(this.f2482a[i] >>> (32 - this.f2483b[i]), this.f2483b[i]);
    }
}
