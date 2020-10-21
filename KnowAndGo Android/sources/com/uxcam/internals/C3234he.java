package com.uxcam.internals;

/* renamed from: com.uxcam.internals.he */
public final class C3234he {

    /* renamed from: a */
    C3226gw f2486a = new C3226gw();

    /* renamed from: b */
    private C3226gw f2487b = new C3226gw();

    /* renamed from: c */
    private C3225gv f2488c = new C3225gv();

    /* renamed from: d */
    private C3225gv f2489d = new C3225gv();

    /* renamed from: a */
    private C3234he m2220a(int i, int i2, int i3) {
        this.f2488c.mo38513a(i << (32 - i2));
        this.f2489d.mo38513a(i2);
        this.f2486a.mo38516a(i3, this.f2488c.f2467b - 1);
        this.f2487b.mo38516a(this.f2488c.f2467b - 1, i3);
        return this;
    }

    /* renamed from: a */
    public final C3233hd mo38526a() {
        return new C3233hd(this.f2488c.mo38515a(), this.f2489d.mo38515a()) {
            /* renamed from: a */
            public final void mo38525a(C3232hc hcVar, int i) {
                C3226gw gwVar = C3234he.this.f2486a;
                super.mo38525a(hcVar, (i >= gwVar.f2469a.length ? null : Integer.valueOf(gwVar.f2469a[i])).intValue());
            }
        };
    }

    /* renamed from: a */
    public final C3234he mo38527a(int i, String str) {
        m2220a(Integer.parseInt(str, 2), str.length(), i);
        return this;
    }
}
