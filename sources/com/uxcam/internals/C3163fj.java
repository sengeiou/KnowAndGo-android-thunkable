package com.uxcam.internals;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.uxcam.internals.fj */
public final class C3163fj {

    /* renamed from: a */
    private int f2254a;

    /* renamed from: b */
    private float f2255b;

    /* renamed from: c */
    private int f2256c;

    /* renamed from: d */
    private ArrayList f2257d = new ArrayList();

    /* renamed from: e */
    private int f2258e;

    /* renamed from: f */
    private C3164aa f2259f;

    /* renamed from: com.uxcam.internals.fj$aa */
    public interface C3164aa {
        /* renamed from: a */
        void mo38444a(List list);
    }

    public C3163fj(int i, float f, int i2, C3164aa aaVar) {
        this.f2254a = i;
        this.f2255b = f;
        this.f2256c = i2;
        this.f2259f = aaVar;
    }

    /* renamed from: b */
    private void m1965b(C2949ak akVar) {
        this.f2257d.add(akVar);
        if (akVar.f1282b == 0) {
            this.f2258e++;
        } else if (akVar.f1282b == 1) {
            this.f2258e += 2;
        }
    }

    /* renamed from: a */
    public final void mo38442a() {
        if (this.f2258e >= this.f2254a && this.f2259f != null) {
            this.f2259f.mo38444a(this.f2257d);
        }
    }

    /* renamed from: a */
    public final void mo38443a(C2949ak akVar) {
        if (this.f2257d.isEmpty()) {
            m1965b(akVar);
            return;
        }
        boolean z = true;
        C2949ak akVar2 = (C2949ak) this.f2257d.get(this.f2257d.size() - 1);
        int i = akVar.f1284d - akVar2.f1284d;
        int i2 = akVar.f1285e - akVar2.f1285e;
        float sqrt = (float) Math.sqrt((double) ((i * i) + (i2 * i2)));
        float f = akVar.f1283c - akVar2.f1283c;
        if ((akVar2.f1282b != 0 || sqrt > ((float) this.f2256c) || f > this.f2255b) && (akVar2.f1282b != 1 || sqrt > ((float) (this.f2256c * 2)) || f > this.f2255b * 2.0f)) {
            z = false;
        }
        if (z) {
            m1965b(akVar);
            return;
        }
        mo38442a();
        this.f2257d = new ArrayList();
        this.f2258e = 0;
        m1965b(akVar);
    }
}
