package com.uxcam.internals;

/* renamed from: com.uxcam.internals.hl */
public final class C3242hl {

    /* renamed from: a */
    public int f2543a;

    /* renamed from: b */
    public int f2544b;

    public C3242hl(int i, int i2) {
        this.f2543a = i;
        this.f2544b = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C3242hl hlVar = (C3242hl) obj;
        return this.f2544b == hlVar.f2544b && this.f2543a == hlVar.f2543a;
    }

    public final int hashCode() {
        return ((this.f2544b + 31) * 31) + this.f2543a;
    }
}
