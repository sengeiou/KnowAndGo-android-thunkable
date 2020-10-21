package com.uxcam.internals;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;

/* renamed from: com.uxcam.internals.cp */
public final class C3037cp implements Closeable, Flushable {

    /* renamed from: a */
    static final Pattern f1818a = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: j */
    static final /* synthetic */ boolean f1819j = (!C3037cp.class.desiredAssertionStatus());

    /* renamed from: b */
    final C3108ea f1820b;

    /* renamed from: c */
    final int f1821c;

    /* renamed from: d */
    C3131eo f1822d;

    /* renamed from: e */
    final LinkedHashMap f1823e;

    /* renamed from: f */
    int f1824f;

    /* renamed from: g */
    boolean f1825g;

    /* renamed from: h */
    boolean f1826h;

    /* renamed from: i */
    boolean f1827i;

    /* renamed from: k */
    private long f1828k;

    /* renamed from: l */
    private long f1829l;

    /* renamed from: m */
    private final Executor f1830m;

    /* renamed from: n */
    private final Runnable f1831n;

    /* renamed from: com.uxcam.internals.cp$aa */
    public final class C3038aa {

        /* renamed from: a */
        final C3039ab f1832a;

        /* renamed from: b */
        boolean f1833b;

        /* renamed from: c */
        final /* synthetic */ C3037cp f1834c;
    }

    /* renamed from: com.uxcam.internals.cp$ab */
    final class C3039ab {

        /* renamed from: a */
        final String f1835a;

        /* renamed from: b */
        final long[] f1836b;

        /* renamed from: c */
        final File[] f1837c;

        /* renamed from: d */
        final File[] f1838d;

        /* renamed from: e */
        boolean f1839e;

        /* renamed from: f */
        C3038aa f1840f;

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final void mo38202a(C3131eo eoVar) {
            for (long j : this.f1836b) {
                eoVar.mo38387h(32).mo38393j(j);
            }
        }
    }

    /* renamed from: a */
    private synchronized void m1447a(C3038aa aaVar) {
        C3131eo eoVar;
        C3039ab abVar = aaVar.f1832a;
        if (abVar.f1840f == aaVar) {
            for (int i = 0; i < this.f1821c; i++) {
                this.f1820b.mo38312a(abVar.f1838d[i]);
            }
            this.f1824f++;
            abVar.f1840f = null;
            if (false || abVar.f1839e) {
                abVar.f1839e = true;
                this.f1822d.mo38364b("CLEAN").mo38387h(32);
                this.f1822d.mo38364b(abVar.f1835a);
                abVar.mo38202a(this.f1822d);
                eoVar = this.f1822d;
            } else {
                this.f1823e.remove(abVar.f1835a);
                this.f1822d.mo38364b("REMOVE").mo38387h(32);
                this.f1822d.mo38364b(abVar.f1835a);
                eoVar = this.f1822d;
            }
            eoVar.mo38387h(10);
            this.f1822d.flush();
            if (this.f1829l > this.f1828k || m1448a()) {
                this.f1830m.execute(this.f1831n);
            }
        } else {
            throw new IllegalStateException();
        }
    }

    /* renamed from: a */
    private boolean m1448a() {
        return this.f1824f >= 2000 && this.f1824f >= this.f1823e.size();
    }

    /* renamed from: a */
    private boolean m1449a(C3039ab abVar) {
        if (abVar.f1840f != null) {
            C3038aa aaVar = abVar.f1840f;
            if (aaVar.f1832a.f1840f == aaVar) {
                for (int i = 0; i < aaVar.f1834c.f1821c; i++) {
                    try {
                        aaVar.f1834c.f1820b.mo38312a(aaVar.f1832a.f1838d[i]);
                    } catch (IOException unused) {
                    }
                }
                aaVar.f1832a.f1840f = null;
            }
        }
        for (int i2 = 0; i2 < this.f1821c; i2++) {
            this.f1820b.mo38312a(abVar.f1837c[i2]);
            this.f1829l -= abVar.f1836b[i2];
            abVar.f1836b[i2] = 0;
        }
        this.f1824f++;
        this.f1822d.mo38364b("REMOVE").mo38387h(32).mo38364b(abVar.f1835a).mo38387h(10);
        this.f1823e.remove(abVar.f1835a);
        if (m1448a()) {
            this.f1830m.execute(this.f1831n);
        }
        return true;
    }

    /* renamed from: b */
    private synchronized boolean m1450b() {
        return this.f1826h;
    }

    /* renamed from: c */
    private synchronized void m1451c() {
        if (m1450b()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* renamed from: d */
    private void m1452d() {
        while (this.f1829l > this.f1828k) {
            m1449a((C3039ab) this.f1823e.values().iterator().next());
        }
        this.f1827i = false;
    }

    public final synchronized void close() {
        if (this.f1825g) {
            if (!this.f1826h) {
                for (C3039ab abVar : (C3039ab[]) this.f1823e.values().toArray(new C3039ab[this.f1823e.size()])) {
                    if (abVar.f1840f != null) {
                        C3038aa aaVar = abVar.f1840f;
                        synchronized (aaVar.f1834c) {
                            if (!aaVar.f1833b) {
                                if (aaVar.f1832a.f1840f == aaVar) {
                                    aaVar.f1834c.m1447a(aaVar);
                                }
                                aaVar.f1833b = true;
                            } else {
                                throw new IllegalStateException();
                            }
                        }
                    }
                }
                m1452d();
                this.f1822d.close();
                this.f1822d = null;
                this.f1826h = true;
                return;
            }
        }
        this.f1826h = true;
    }

    public final synchronized void flush() {
        if (this.f1825g) {
            m1451c();
            m1452d();
            this.f1822d.flush();
        }
    }
}
