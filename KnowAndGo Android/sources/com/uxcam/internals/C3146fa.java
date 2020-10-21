package com.uxcam.internals;

import java.util.Arrays;

/* renamed from: com.uxcam.internals.fa */
final class C3146fa extends C3133eq {

    /* renamed from: f */
    final transient byte[][] f2196f;

    /* renamed from: g */
    final transient int[] f2197g;

    C3146fa(C3130en enVar, int i) {
        super((byte[]) null);
        C3151fe.m1947a(enVar.f2158b, 0, (long) i);
        int i2 = 0;
        C3144ey eyVar = enVar.f2157a;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (eyVar.f2189c != eyVar.f2188b) {
                i3 += eyVar.f2189c - eyVar.f2188b;
                i4++;
                eyVar = eyVar.f2192f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f2196f = new byte[i4][];
        this.f2197g = new int[(i4 * 2)];
        C3144ey eyVar2 = enVar.f2157a;
        int i5 = 0;
        while (i2 < i) {
            this.f2196f[i5] = eyVar2.f2187a;
            i2 += eyVar2.f2189c - eyVar2.f2188b;
            if (i2 > i) {
                i2 = i;
            }
            this.f2197g[i5] = i2;
            this.f2197g[this.f2196f.length + i5] = eyVar2.f2188b;
            eyVar2.f2190d = true;
            i5++;
            eyVar2 = eyVar2.f2192f;
        }
    }

    /* renamed from: b */
    private int m1915b(int i) {
        int binarySearch = Arrays.binarySearch(this.f2197g, 0, this.f2196f.length, i + 1);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    /* renamed from: i */
    private C3133eq m1916i() {
        return new C3133eq(mo38416h());
    }

    /* renamed from: a */
    public final byte mo38402a(int i) {
        C3151fe.m1947a((long) this.f2197g[this.f2196f.length - 1], (long) i, 1);
        int b = m1915b(i);
        return this.f2196f[b][(i - (b == 0 ? 0 : this.f2197g[b - 1])) + this.f2197g[this.f2196f.length + b]];
    }

    /* renamed from: a */
    public final C3133eq mo38403a(int i, int i2) {
        return m1916i().mo38403a(i, i2);
    }

    /* renamed from: a */
    public final String mo38404a() {
        return m1916i().mo38404a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo38405a(C3130en enVar) {
        int length = this.f2196f.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = this.f2197g[length + i];
            int i4 = this.f2197g[i];
            C3144ey eyVar = new C3144ey(this.f2196f[i], i3, (i3 + i4) - i2);
            if (enVar.f2157a == null) {
                eyVar.f2193g = eyVar;
                eyVar.f2192f = eyVar;
                enVar.f2157a = eyVar;
            } else {
                enVar.f2157a.f2193g.mo38433a(eyVar);
            }
            i++;
            i2 = i4;
        }
        enVar.f2158b += (long) i2;
    }

    /* renamed from: a */
    public final boolean mo38406a(int i, C3133eq eqVar, int i2, int i3) {
        if (mo38415g() - i3 < 0) {
            return false;
        }
        int b = m1915b(0);
        while (i3 > 0) {
            int i4 = b == 0 ? 0 : this.f2197g[b - 1];
            int min = Math.min(i3, ((this.f2197g[b] - i4) + i4) - i);
            if (!eqVar.mo38407a(i2, this.f2196f[b], (i - i4) + this.f2197g[this.f2196f.length + b], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b++;
        }
        return true;
    }

    /* renamed from: a */
    public final boolean mo38407a(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > mo38415g() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int b = m1915b(i);
        while (i3 > 0) {
            int i4 = b == 0 ? 0 : this.f2197g[b - 1];
            int min = Math.min(i3, ((this.f2197g[b] - i4) + i4) - i);
            if (!C3151fe.m1949a(this.f2196f[b], (i - i4) + this.f2197g[this.f2196f.length + b], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b++;
        }
        return true;
    }

    /* renamed from: b */
    public final String mo38408b() {
        return m1916i().mo38408b();
    }

    /* renamed from: c */
    public final C3133eq mo38409c() {
        return m1916i().mo38409c();
    }

    /* renamed from: d */
    public final C3133eq mo38411d() {
        return m1916i().mo38411d();
    }

    /* renamed from: e */
    public final String mo38412e() {
        return m1916i().mo38412e();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C3133eq) {
            C3133eq eqVar = (C3133eq) obj;
            return eqVar.mo38415g() == mo38415g() && mo38406a(0, eqVar, 0, mo38415g());
        }
    }

    /* renamed from: f */
    public final C3133eq mo38414f() {
        return m1916i().mo38414f();
    }

    /* renamed from: g */
    public final int mo38415g() {
        return this.f2197g[this.f2196f.length - 1];
    }

    /* renamed from: h */
    public final byte[] mo38416h() {
        byte[] bArr = new byte[this.f2197g[this.f2196f.length - 1]];
        int length = this.f2196f.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = this.f2197g[length + i];
            int i4 = this.f2197g[i];
            System.arraycopy(this.f2196f[i], i3, bArr, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr;
    }

    public final int hashCode() {
        int i = this.f2162d;
        if (i != 0) {
            return i;
        }
        int length = this.f2196f.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < length) {
            byte[] bArr = this.f2196f[i2];
            int i5 = this.f2197g[length + i2];
            int i6 = this.f2197g[i2];
            int i7 = (i6 - i3) + i5;
            while (i5 < i7) {
                i4 = (i4 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i3 = i6;
        }
        this.f2162d = i4;
        return i4;
    }

    public final String toString() {
        return m1916i().toString();
    }
}
