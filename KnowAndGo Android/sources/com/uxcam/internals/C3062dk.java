package com.uxcam.internals;

import com.uxcam.internals.C3000bv;
import com.uxcam.internals.C3022cf;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import org.apache.commons.p032io.IOUtils;

/* renamed from: com.uxcam.internals.dk */
public final class C3062dk implements C3051da {

    /* renamed from: a */
    final C3011ca f1906a;

    /* renamed from: b */
    final C3047cx f1907b;

    /* renamed from: c */
    final C3132ep f1908c;

    /* renamed from: d */
    final C3131eo f1909d;

    /* renamed from: e */
    int f1910e = 0;

    /* renamed from: com.uxcam.internals.dk$aa */
    abstract class C3063aa implements C3148fc {

        /* renamed from: a */
        protected final C3135es f1911a;

        /* renamed from: b */
        protected boolean f1912b;

        private C3063aa() {
            this.f1911a = new C3135es(C3062dk.this.f1908c.mo38197a());
        }

        /* synthetic */ C3063aa(C3062dk dkVar, byte b) {
            this();
        }

        /* renamed from: a */
        public final C3149fd mo38197a() {
            return this.f1911a;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final void mo38240a(boolean z) {
            if (C3062dk.this.f1910e != 6) {
                if (C3062dk.this.f1910e == 5) {
                    C3062dk.m1522a(this.f1911a);
                    C3062dk.this.f1910e = 6;
                    if (C3062dk.this.f1907b != null) {
                        C3062dk.this.f1907b.mo38222a(!z, (C3051da) C3062dk.this);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("state: " + C3062dk.this.f1910e);
            }
        }
    }

    /* renamed from: com.uxcam.internals.dk$ab */
    final class C3064ab implements C3147fb {

        /* renamed from: b */
        private final C3135es f1915b = new C3135es(C3062dk.this.f1909d.mo38241a());

        /* renamed from: c */
        private boolean f1916c;

        C3064ab() {
        }

        /* renamed from: a */
        public final C3149fd mo38241a() {
            return this.f1915b;
        }

        /* renamed from: a_ */
        public final void mo38242a_(C3130en enVar, long j) {
            if (this.f1916c) {
                throw new IllegalStateException("closed");
            } else if (j != 0) {
                C3062dk.this.f1909d.mo38391i(j);
                C3062dk.this.f1909d.mo38364b(IOUtils.LINE_SEPARATOR_WINDOWS);
                C3062dk.this.f1909d.mo38242a_(enVar, j);
                C3062dk.this.f1909d.mo38364b(IOUtils.LINE_SEPARATOR_WINDOWS);
            }
        }

        public final synchronized void close() {
            if (!this.f1916c) {
                this.f1916c = true;
                C3062dk.this.f1909d.mo38364b("0\r\n\r\n");
                C3062dk.m1522a(this.f1915b);
                C3062dk.this.f1910e = 3;
            }
        }

        public final synchronized void flush() {
            if (!this.f1916c) {
                C3062dk.this.f1909d.flush();
            }
        }
    }

    /* renamed from: com.uxcam.internals.dk$ac */
    class C3065ac extends C3063aa {

        /* renamed from: e */
        private final C3002bw f1918e;

        /* renamed from: f */
        private long f1919f = -1;

        /* renamed from: g */
        private boolean f1920g = true;

        C3065ac(C3002bw bwVar) {
            super(C3062dk.this, (byte) 0);
            this.f1918e = bwVar;
        }

        /* renamed from: a */
        public final long mo38196a(C3130en enVar, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            } else if (this.f1912b) {
                throw new IllegalStateException("closed");
            } else if (!this.f1920g) {
                return -1;
            } else {
                if (this.f1919f == 0 || this.f1919f == -1) {
                    if (this.f1919f != -1) {
                        C3062dk.this.f1908c.mo38396m();
                    }
                    try {
                        this.f1919f = C3062dk.this.f1908c.mo38392j();
                        String trim = C3062dk.this.f1908c.mo38396m().trim();
                        if (this.f1919f < 0 || (!trim.isEmpty() && !trim.startsWith(";"))) {
                            throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f1919f + trim + "\"");
                        }
                        if (this.f1919f == 0) {
                            this.f1920g = false;
                            C3054dc.m1503a(C3062dk.this.f1906a.f1667j, this.f1918e, C3062dk.this.mo38239d());
                            mo38240a(true);
                        }
                        if (!this.f1920g) {
                            return -1;
                        }
                    } catch (NumberFormatException e) {
                        throw new ProtocolException(e.getMessage());
                    }
                }
                long a = C3062dk.this.f1908c.mo38196a(enVar, Math.min(j, this.f1919f));
                if (a != -1) {
                    this.f1919f -= a;
                    return a;
                }
                mo38240a(false);
                throw new ProtocolException("unexpected end of stream");
            }
        }

        public final void close() {
            if (!this.f1912b) {
                if (this.f1920g && !C3030cl.m1431a((C3148fc) this, TimeUnit.MILLISECONDS)) {
                    mo38240a(false);
                }
                this.f1912b = true;
            }
        }
    }

    /* renamed from: com.uxcam.internals.dk$ad */
    final class C3066ad implements C3147fb {

        /* renamed from: b */
        private final C3135es f1922b = new C3135es(C3062dk.this.f1909d.mo38241a());

        /* renamed from: c */
        private boolean f1923c;

        /* renamed from: d */
        private long f1924d;

        C3066ad(long j) {
            this.f1924d = j;
        }

        /* renamed from: a */
        public final C3149fd mo38241a() {
            return this.f1922b;
        }

        /* renamed from: a_ */
        public final void mo38242a_(C3130en enVar, long j) {
            if (!this.f1923c) {
                C3030cl.m1427a(enVar.f2158b, j);
                if (j <= this.f1924d) {
                    C3062dk.this.f1909d.mo38242a_(enVar, j);
                    this.f1924d -= j;
                    return;
                }
                throw new ProtocolException("expected " + this.f1924d + " bytes but received " + j);
            }
            throw new IllegalStateException("closed");
        }

        public final void close() {
            if (!this.f1923c) {
                this.f1923c = true;
                if (this.f1924d <= 0) {
                    C3062dk.m1522a(this.f1922b);
                    C3062dk.this.f1910e = 3;
                    return;
                }
                throw new ProtocolException("unexpected end of stream");
            }
        }

        public final void flush() {
            if (!this.f1923c) {
                C3062dk.this.f1909d.flush();
            }
        }
    }

    /* renamed from: com.uxcam.internals.dk$ae */
    class C3067ae extends C3063aa {

        /* renamed from: e */
        private long f1926e;

        public C3067ae(long j) {
            super(C3062dk.this, (byte) 0);
            this.f1926e = j;
            if (this.f1926e == 0) {
                mo38240a(true);
            }
        }

        /* renamed from: a */
        public final long mo38196a(C3130en enVar, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            } else if (this.f1912b) {
                throw new IllegalStateException("closed");
            } else if (this.f1926e == 0) {
                return -1;
            } else {
                long a = C3062dk.this.f1908c.mo38196a(enVar, Math.min(this.f1926e, j));
                if (a != -1) {
                    this.f1926e -= a;
                    if (this.f1926e == 0) {
                        mo38240a(true);
                    }
                    return a;
                }
                mo38240a(false);
                throw new ProtocolException("unexpected end of stream");
            }
        }

        public final void close() {
            if (!this.f1912b) {
                if (this.f1926e != 0 && !C3030cl.m1431a((C3148fc) this, TimeUnit.MILLISECONDS)) {
                    mo38240a(false);
                }
                this.f1912b = true;
            }
        }
    }

    /* renamed from: com.uxcam.internals.dk$af */
    class C3068af extends C3063aa {

        /* renamed from: e */
        private boolean f1928e;

        C3068af() {
            super(C3062dk.this, (byte) 0);
        }

        /* renamed from: a */
        public final long mo38196a(C3130en enVar, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            } else if (this.f1912b) {
                throw new IllegalStateException("closed");
            } else if (this.f1928e) {
                return -1;
            } else {
                long a = C3062dk.this.f1908c.mo38196a(enVar, j);
                if (a != -1) {
                    return a;
                }
                this.f1928e = true;
                mo38240a(true);
                return -1;
            }
        }

        public final void close() {
            if (!this.f1912b) {
                if (!this.f1928e) {
                    mo38240a(false);
                }
                this.f1912b = true;
            }
        }
    }

    public C3062dk(C3011ca caVar, C3047cx cxVar, C3132ep epVar, C3131eo eoVar) {
        this.f1906a = caVar;
        this.f1907b = cxVar;
        this.f1908c = epVar;
        this.f1909d = eoVar;
    }

    /* renamed from: a */
    static void m1522a(C3135es esVar) {
        C3149fd fdVar = esVar.f2165a;
        C3149fd fdVar2 = C3149fd.f2198b;
        if (fdVar2 != null) {
            esVar.f2165a = fdVar2;
            fdVar.mo38426e_();
            fdVar.mo38424d();
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    /* renamed from: a */
    public final C3024cg mo38228a(C3022cf cfVar) {
        C3148fc fcVar;
        if (!C3054dc.m1505b(cfVar)) {
            fcVar = mo38236a(0);
        } else if ("chunked".equalsIgnoreCase(cfVar.mo38178b("Transfer-Encoding"))) {
            C3002bw bwVar = cfVar.f1740a.f1723a;
            if (this.f1910e == 4) {
                this.f1910e = 5;
                fcVar = new C3065ac(bwVar);
            } else {
                throw new IllegalStateException("state: " + this.f1910e);
            }
        } else {
            long a = C3054dc.m1501a(cfVar);
            if (a != -1) {
                fcVar = mo38236a(a);
            } else if (this.f1910e != 4) {
                throw new IllegalStateException("state: " + this.f1910e);
            } else if (this.f1907b != null) {
                this.f1910e = 5;
                this.f1907b.mo38223a(true, false, false);
                fcVar = new C3068af();
            } else {
                throw new IllegalStateException("streamAllocation == null");
            }
        }
        return new C3057df(cfVar.f1745f, C3138ev.m1863a(fcVar));
    }

    /* renamed from: a */
    public final C3147fb mo38229a(C3017cd cdVar, long j) {
        if ("chunked".equalsIgnoreCase(cdVar.mo38166a("Transfer-Encoding"))) {
            if (this.f1910e == 1) {
                this.f1910e = 2;
                return new C3064ab();
            }
            throw new IllegalStateException("state: " + this.f1910e);
        } else if (j == -1) {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        } else if (this.f1910e == 1) {
            this.f1910e = 2;
            return new C3066ad(j);
        } else {
            throw new IllegalStateException("state: " + this.f1910e);
        }
    }

    /* renamed from: a */
    public final C3148fc mo38236a(long j) {
        if (this.f1910e == 4) {
            this.f1910e = 5;
            return new C3067ae(j);
        }
        throw new IllegalStateException("state: " + this.f1910e);
    }

    /* renamed from: a */
    public final void mo38230a() {
        this.f1909d.flush();
    }

    /* renamed from: a */
    public final void mo38237a(C3000bv bvVar, String str) {
        if (this.f1910e == 0) {
            this.f1909d.mo38364b(str).mo38364b(IOUtils.LINE_SEPARATOR_WINDOWS);
            int length = bvVar.f1606a.length / 2;
            for (int i = 0; i < length; i++) {
                this.f1909d.mo38364b(bvVar.mo38112a(i)).mo38364b(": ").mo38364b(bvVar.mo38114b(i)).mo38364b(IOUtils.LINE_SEPARATOR_WINDOWS);
            }
            this.f1909d.mo38364b(IOUtils.LINE_SEPARATOR_WINDOWS);
            this.f1910e = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.f1910e);
    }

    /* renamed from: a */
    public final void mo38231a(C3017cd cdVar) {
        Proxy.Type type = this.f1907b.mo38224b().f1846a.f1769b.type();
        StringBuilder sb = new StringBuilder();
        sb.append(cdVar.f1724b);
        sb.append(' ');
        if (!cdVar.f1723a.mo38122b() && type == Proxy.Type.HTTP) {
            sb.append(cdVar.f1723a);
        } else {
            sb.append(C3058dg.m1515a(cdVar.f1723a));
        }
        sb.append(" HTTP/1.1");
        mo38237a(cdVar.f1725c, sb.toString());
    }

    /* renamed from: b */
    public final C3022cf.C3023aa mo38232b() {
        return mo38238c();
    }

    /* renamed from: c */
    public final C3022cf.C3023aa mo38238c() {
        C3060di a;
        C3022cf.C3023aa a2;
        if (this.f1910e == 1 || this.f1910e == 3) {
            do {
                try {
                    a = C3060di.m1521a(this.f1908c.mo38396m());
                    C3022cf.C3023aa aaVar = new C3022cf.C3023aa();
                    aaVar.f1754b = a.f1903a;
                    aaVar.f1755c = a.f1904b;
                    aaVar.f1756d = a.f1905c;
                    a2 = aaVar.mo38182a(mo38239d());
                } catch (EOFException e) {
                    IOException iOException = new IOException("unexpected end of stream on " + this.f1907b);
                    iOException.initCause(e);
                    throw iOException;
                }
            } while (a.f1904b == 100);
            this.f1910e = 4;
            return a2;
        }
        throw new IllegalStateException("state: " + this.f1910e);
    }

    /* renamed from: d */
    public final C3000bv mo38239d() {
        C3000bv.C3001aa aaVar = new C3000bv.C3001aa();
        while (true) {
            String m = this.f1908c.mo38396m();
            if (m.length() == 0) {
                return aaVar.mo38120a();
            }
            C3028cj.f1778a.mo38150a(aaVar, m);
        }
    }
}
