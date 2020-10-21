package com.uxcam.internals;

/* renamed from: com.uxcam.internals.hk */
public final class C3241hk {

    /* renamed from: a */
    public int f2539a;

    /* renamed from: b */
    public int f2540b;

    /* renamed from: c */
    private int f2541c;

    /* renamed from: d */
    private int f2542d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C3241hk hkVar = (C3241hk) obj;
        return this.f2540b == hkVar.f2540b && this.f2539a == hkVar.f2539a && this.f2541c == hkVar.f2541c && this.f2542d == hkVar.f2542d;
    }

    public final int hashCode() {
        return ((((((this.f2540b + 31) * 31) + this.f2539a) * 31) + this.f2541c) * 31) + this.f2542d;
    }

    public final String toString() {
        return "Rect [x=" + this.f2541c + ", y=" + this.f2542d + ", width=" + this.f2539a + ", height=" + this.f2540b + "]";
    }
}
