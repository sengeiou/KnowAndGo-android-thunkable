package com.uxcam.internals;

/* renamed from: com.uxcam.internals.hi */
public final class C3239hi {

    /* renamed from: a */
    public C3237hg f2532a;

    /* renamed from: b */
    public int f2533b;

    /* renamed from: c */
    public int f2534c;

    /* renamed from: d */
    public int[][] f2535d;

    /* renamed from: e */
    public C3241hk f2536e = null;

    private C3239hi(int i, int i2, int[][] iArr, C3237hg hgVar) {
        this.f2533b = i;
        this.f2534c = i2;
        this.f2535d = iArr;
        this.f2532a = hgVar;
    }

    /* renamed from: a */
    public static C3239hi m2224a(int i, int i2, C3237hg hgVar) {
        return m2225b(i, i2, hgVar);
    }

    /* renamed from: b */
    public static C3239hi m2225b(int i, int i2, C3237hg hgVar) {
        int[] iArr = new int[4];
        for (int i3 = 0; i3 < hgVar.f2520l; i3++) {
            int i4 = hgVar.f2521m[i3];
            iArr[i4] = iArr[i4] + ((i >> hgVar.f2522n[i3]) * (i2 >> hgVar.f2523o[i3]));
        }
        int i5 = 0;
        for (int i6 = 0; i6 < 4; i6++) {
            i5 += iArr[i6] != 0 ? 1 : 0;
        }
        int[][] iArr2 = new int[i5][];
        int i7 = 0;
        for (int i8 = 0; i8 < 4; i8++) {
            if (iArr[i8] != 0) {
                iArr2[i7] = new int[iArr[i8]];
                i7++;
            }
        }
        return new C3239hi(i, i2, iArr2, hgVar);
    }

    /* renamed from: a */
    public final int mo38528a(int i) {
        return this.f2533b >> this.f2532a.f2522n[i];
    }

    /* renamed from: b */
    public final int mo38529b(int i) {
        return this.f2534c >> this.f2532a.f2523o[i];
    }
}
