package com.uxcam.internals;

import com.uxcam.internals.C3005bx;
import java.util.List;

/* renamed from: com.uxcam.internals.de */
public final class C3056de implements C3005bx.C3006aa {

    /* renamed from: a */
    public final C3047cx f1889a;

    /* renamed from: b */
    final C3051da f1890b;

    /* renamed from: c */
    public final C3017cd f1891c;

    /* renamed from: d */
    private final List f1892d;

    /* renamed from: e */
    private final C2986bm f1893e;

    /* renamed from: f */
    private final int f1894f;

    /* renamed from: g */
    private int f1895g;

    public C3056de(List list, C3047cx cxVar, C3051da daVar, C2986bm bmVar, int i, C3017cd cdVar) {
        this.f1892d = list;
        this.f1893e = bmVar;
        this.f1889a = cxVar;
        this.f1890b = daVar;
        this.f1894f = i;
        this.f1891c = cdVar;
    }

    /* renamed from: a */
    private boolean m1508a(C3002bw bwVar) {
        return bwVar.f1610b.equals(this.f1893e.mo38085a().f1768a.f1397a.f1610b) && bwVar.f1611c == this.f1893e.mo38085a().f1768a.f1397a.f1611c;
    }

    /* renamed from: a */
    public final C3017cd mo38137a() {
        return this.f1891c;
    }

    /* renamed from: a */
    public final C3022cf mo38138a(C3017cd cdVar) {
        return mo38234a(cdVar, this.f1889a, this.f1890b, this.f1893e);
    }

    /* renamed from: a */
    public final C3022cf mo38234a(C3017cd cdVar, C3047cx cxVar, C3051da daVar, C2986bm bmVar) {
        if (this.f1894f < this.f1892d.size()) {
            this.f1895g++;
            if (this.f1890b != null && !m1508a(cdVar.f1723a)) {
                throw new IllegalStateException("network interceptor " + this.f1892d.get(this.f1894f - 1) + " must retain the same host and port");
            } else if (this.f1890b == null || this.f1895g <= 1) {
                C3056de deVar = new C3056de(this.f1892d, cxVar, daVar, bmVar, this.f1894f + 1, cdVar);
                C3005bx bxVar = (C3005bx) this.f1892d.get(this.f1894f);
                C3022cf a = bxVar.mo38068a(deVar);
                if (daVar != null && this.f1894f + 1 < this.f1892d.size() && deVar.f1895g != 1) {
                    throw new IllegalStateException("network interceptor " + bxVar + " must call proceed() exactly once");
                } else if (a != null) {
                    return a;
                } else {
                    throw new NullPointerException("interceptor " + bxVar + " returned null");
                }
            } else {
                throw new IllegalStateException("network interceptor " + this.f1892d.get(this.f1894f - 1) + " must call proceed() exactly once");
            }
        } else {
            throw new AssertionError();
        }
    }
}
