package com.uxcam.internals;

/* renamed from: com.uxcam.internals.hg */
public enum C3237hg {
    RGB(3, new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}),
    YUV420(3, new int[]{0, 1, 2}, new int[]{0, 1, 1}, new int[]{0, 1, 1}),
    YUV420J(3, new int[]{0, 1, 2}, new int[]{0, 1, 1}, new int[]{0, 1, 1}),
    YUV422(3, new int[]{0, 1, 2}, new int[]{0, 1, 1}, new int[]{0, 0, 0}),
    YUV422J(3, new int[]{0, 1, 2}, new int[]{0, 1, 1}, new int[]{0, 0, 0}),
    YUV444(3, new int[]{0, 1, 2}, new int[]{0, 0, 0}, new int[]{0, 0, 0}),
    YUV444J(3, new int[]{0, 1, 2}, new int[]{0, 0, 0}, new int[]{0, 0, 0}),
    YUV422_10(3, new int[]{0, 1, 2}, new int[]{0, 1, 1}, new int[]{0, 0, 0}),
    GREY(1, new int[]{0}, new int[]{0}, new int[]{0}),
    MONO(1, new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}),
    YUV444_10(3, new int[]{0, 1, 2}, new int[]{0, 0, 0}, new int[]{0, 0, 0});
    

    /* renamed from: l */
    public int f2520l;

    /* renamed from: m */
    public int[] f2521m;

    /* renamed from: n */
    public int[] f2522n;

    /* renamed from: o */
    public int[] f2523o;

    private C3237hg(int i, int[] iArr, int[] iArr2, int[] iArr3) {
        this.f2520l = i;
        this.f2521m = iArr;
        this.f2522n = iArr2;
        this.f2523o = iArr3;
    }
}
