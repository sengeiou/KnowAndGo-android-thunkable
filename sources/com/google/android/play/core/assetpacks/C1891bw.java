package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C1982af;
import com.google.android.play.core.internal.C2040cj;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.google.android.play.core.assetpacks.bw */
final class C1891bw {

    /* renamed from: a */
    private static final C1982af f478a = new C1982af("ExtractorLooper");

    /* renamed from: b */
    private final C1911cp f479b;

    /* renamed from: c */
    private final C1888bt f480c;

    /* renamed from: d */
    private final C1944dv f481d;

    /* renamed from: e */
    private final C1928df f482e;

    /* renamed from: f */
    private final C1932dj f483f;

    /* renamed from: g */
    private final C1937do f484g;

    /* renamed from: h */
    private final C2040cj<C1966w> f485h;

    /* renamed from: i */
    private final C1914cs f486i;

    /* renamed from: j */
    private final AtomicBoolean f487j = new AtomicBoolean(false);

    C1891bw(C1911cp cpVar, C2040cj<C1966w> cjVar, C1888bt btVar, C1944dv dvVar, C1928df dfVar, C1932dj djVar, C1937do doVar, C1914cs csVar) {
        this.f479b = cpVar;
        this.f485h = cjVar;
        this.f480c = btVar;
        this.f481d = dvVar;
        this.f482e = dfVar;
        this.f483f = djVar;
        this.f484g = doVar;
        this.f486i = csVar;
    }

    /* renamed from: a */
    private final void m402a(int i, Exception exc) {
        try {
            this.f479b.mo33455d(i);
            this.f479b.mo33442a(i);
        } catch (C1890bv unused) {
            f478a.mo33552b("Error during error handling: %s", exc.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo33431a() {
        f478a.mo33550a("Run extractor loop", new Object[0]);
        if (this.f487j.compareAndSet(false, true)) {
            while (true) {
                C1887bs bsVar = null;
                try {
                    bsVar = this.f486i.mo33456a();
                } catch (C1890bv e) {
                    f478a.mo33552b("Error while getting next extraction task: %s", e.getMessage());
                    if (e.f477a >= 0) {
                        this.f485h.mo33606a().mo33357a(e.f477a);
                        m402a(e.f477a, e);
                    }
                }
                if (bsVar != null) {
                    try {
                        if (bsVar instanceof C1887bs) {
                            this.f480c.mo33430a(bsVar);
                        } else if (bsVar instanceof C1943du) {
                            this.f481d.mo33502a((C1943du) bsVar);
                        } else if (bsVar instanceof C1927de) {
                            this.f482e.mo33475a(bsVar);
                        } else if (bsVar instanceof C1930dh) {
                            this.f483f.mo33477a(bsVar);
                        } else if (bsVar instanceof C1936dn) {
                            this.f484g.mo33479a(bsVar);
                        } else {
                            f478a.mo33552b("Unknown task type: %s", bsVar.getClass().getName());
                        }
                    } catch (Exception e2) {
                        f478a.mo33552b("Error during extraction task: %s", e2.getMessage());
                        this.f485h.mo33606a().mo33357a(bsVar.f550j);
                        m402a(bsVar.f550j, e2);
                    }
                } else {
                    this.f487j.set(false);
                    return;
                }
            }
        } else {
            f478a.mo33554d("runLoop already looping; return", new Object[0]);
        }
    }
}
