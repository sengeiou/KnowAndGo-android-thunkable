package com.uxcam.internals;

import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.uxcam.internals.ak */
public final class C2949ak {

    /* renamed from: a */
    public String f1281a;

    /* renamed from: b */
    public int f1282b;

    /* renamed from: c */
    public float f1283c;

    /* renamed from: d */
    public int f1284d;

    /* renamed from: e */
    public int f1285e;

    /* renamed from: f */
    public int f1286f;

    /* renamed from: g */
    public int f1287g;

    /* renamed from: h */
    public int f1288h;

    /* renamed from: i */
    public Boolean f1289i = Boolean.FALSE;

    /* renamed from: j */
    public boolean f1290j = false;

    /* renamed from: k */
    public boolean f1291k = false;

    /* renamed from: l */
    public C3152ff f1292l;

    /* renamed from: m */
    public ArrayList f1293m = new ArrayList();

    public C2949ak() {
    }

    public C2949ak(int i, float f, int i2, int i3, int i4, int i5) {
        this.f1282b = i;
        this.f1283c = f;
        this.f1284d = i2;
        this.f1285e = i3;
        this.f1286f = i4;
        this.f1287g = i5;
    }

    private C2949ak(int i, float f, int i2, int i3, int i4, int i5, int i6, Boolean bool, boolean z) {
        this.f1282b = i;
        this.f1283c = f;
        this.f1284d = i2;
        this.f1285e = i3;
        this.f1287g = i5;
        this.f1286f = i4;
        this.f1288h = i6;
        this.f1289i = bool;
        this.f1290j = z;
    }

    /* renamed from: a */
    public final C2949ak mo38042a() {
        return new C2949ak(this.f1282b, this.f1283c, this.f1284d, this.f1285e, this.f1286f, this.f1287g, this.f1288h, this.f1289i, this.f1290j);
    }

    /* renamed from: a */
    public final void mo38043a(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.f1283c = f;
    }

    /* renamed from: a */
    public final void mo38044a(int i, int i2) {
        this.f1284d -= i;
        this.f1285e -= i2;
        Iterator it = this.f1293m.iterator();
        while (it.hasNext()) {
            C2949ak akVar = (C2949ak) it.next();
            akVar.f1284d -= i;
            akVar.f1285e -= i2;
        }
    }

    /* renamed from: b */
    public final void mo38045b() {
        Iterator it = this.f1293m.iterator();
        while (it.hasNext()) {
            ((C2949ak) it.next()).f1282b = 2;
        }
        if (!this.f1293m.isEmpty()) {
            ((C2949ak) this.f1293m.get(0)).f1282b = 1;
            ((C2949ak) this.f1293m.get(this.f1293m.size() - 1)).f1282b = 3;
        }
    }

    /* renamed from: b */
    public final void mo38046b(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        mo38043a(this.f1283c - f);
        Iterator it = this.f1293m.iterator();
        while (it.hasNext()) {
            C2949ak akVar = (C2949ak) it.next();
            akVar.mo38043a(akVar.f1283c - f);
        }
    }

    /* renamed from: c */
    public final boolean mo38047c() {
        return this.f1282b == 4 || this.f1282b == 5 || this.f1282b == 2 || this.f1282b == 3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("gesture: ");
        sb.append(this.f1282b);
        sb.append(" x: ");
        sb.append(this.f1284d);
        sb.append(" y: ");
        sb.append(this.f1285e);
        sb.append(" time: ");
        sb.append(this.f1283c);
        sb.append(" responsive: ");
        sb.append(this.f1289i);
        sb.append(" screenAction: ");
        sb.append(this.f1292l == null ? "" : this.f1292l.mo38435a());
        return sb.toString();
    }
}
