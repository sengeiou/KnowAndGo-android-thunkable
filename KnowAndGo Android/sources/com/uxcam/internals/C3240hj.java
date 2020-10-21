package com.uxcam.internals;

/* renamed from: com.uxcam.internals.hj */
public final class C3240hj {

    /* renamed from: a */
    public final int f2537a;

    /* renamed from: b */
    public final int f2538b;

    public C3240hj(int i, int i2) {
        this.f2537a = i;
        this.f2538b = i2;
    }

    /* renamed from: a */
    public final C3240hj mo38530a() {
        return new C3240hj(this.f2538b, this.f2537a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C3240hj hjVar = (C3240hj) obj;
        return this.f2538b == hjVar.f2538b && this.f2537a == hjVar.f2537a;
    }

    public final int hashCode() {
        return ((this.f2538b + 31) * 31) + this.f2537a;
    }
}
