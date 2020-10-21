package com.uxcam.internals;

import com.uxcam.internals.C3000bv;
import java.io.Closeable;

/* renamed from: com.uxcam.internals.cf */
public final class C3022cf implements Closeable {

    /* renamed from: a */
    public final C3017cd f1740a;

    /* renamed from: b */
    final C3014cb f1741b;

    /* renamed from: c */
    public final int f1742c;

    /* renamed from: d */
    public final String f1743d;

    /* renamed from: e */
    public final C2999bu f1744e;

    /* renamed from: f */
    public final C3000bv f1745f;

    /* renamed from: g */
    public final C3024cg f1746g;

    /* renamed from: h */
    final C3022cf f1747h;

    /* renamed from: i */
    final C3022cf f1748i;

    /* renamed from: j */
    final C3022cf f1749j;

    /* renamed from: k */
    public final long f1750k;

    /* renamed from: l */
    public final long f1751l;

    /* renamed from: m */
    private volatile C2978bh f1752m;

    /* renamed from: com.uxcam.internals.cf$aa */
    public static class C3023aa {

        /* renamed from: a */
        public C3017cd f1753a;

        /* renamed from: b */
        public C3014cb f1754b;

        /* renamed from: c */
        public int f1755c;

        /* renamed from: d */
        public String f1756d;

        /* renamed from: e */
        public C2999bu f1757e;

        /* renamed from: f */
        C3000bv.C3001aa f1758f;

        /* renamed from: g */
        public C3024cg f1759g;

        /* renamed from: h */
        C3022cf f1760h;

        /* renamed from: i */
        C3022cf f1761i;

        /* renamed from: j */
        public C3022cf f1762j;

        /* renamed from: k */
        public long f1763k;

        /* renamed from: l */
        public long f1764l;

        public C3023aa() {
            this.f1755c = -1;
            this.f1758f = new C3000bv.C3001aa();
        }

        C3023aa(C3022cf cfVar) {
            this.f1755c = -1;
            this.f1753a = cfVar.f1740a;
            this.f1754b = cfVar.f1741b;
            this.f1755c = cfVar.f1742c;
            this.f1756d = cfVar.f1743d;
            this.f1757e = cfVar.f1744e;
            this.f1758f = cfVar.f1745f.mo38111a();
            this.f1759g = cfVar.f1746g;
            this.f1760h = cfVar.f1747h;
            this.f1761i = cfVar.f1748i;
            this.f1762j = cfVar.f1749j;
            this.f1763k = cfVar.f1750k;
            this.f1764l = cfVar.f1751l;
        }

        /* renamed from: a */
        private static void m1391a(String str, C3022cf cfVar) {
            if (cfVar.f1746g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            } else if (cfVar.f1747h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            } else if (cfVar.f1748i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            } else if (cfVar.f1749j != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        /* renamed from: a */
        public final C3023aa mo38182a(C3000bv bvVar) {
            this.f1758f = bvVar.mo38111a();
            return this;
        }

        /* renamed from: a */
        public final C3023aa mo38183a(C3022cf cfVar) {
            if (cfVar != null) {
                m1391a("networkResponse", cfVar);
            }
            this.f1760h = cfVar;
            return this;
        }

        /* renamed from: a */
        public final C3023aa mo38184a(String str, String str2) {
            C3000bv.C3001aa aaVar = this.f1758f;
            C3000bv.C3001aa.m1289b(str, str2);
            aaVar.mo38119a(str, str2);
            return this;
        }

        /* renamed from: a */
        public final C3022cf mo38185a() {
            if (this.f1753a == null) {
                throw new IllegalStateException("request == null");
            } else if (this.f1754b == null) {
                throw new IllegalStateException("protocol == null");
            } else if (this.f1755c >= 0) {
                return new C3022cf(this);
            } else {
                throw new IllegalStateException("code < 0: " + this.f1755c);
            }
        }

        /* renamed from: b */
        public final C3023aa mo38186b(C3022cf cfVar) {
            if (cfVar != null) {
                m1391a("cacheResponse", cfVar);
            }
            this.f1761i = cfVar;
            return this;
        }
    }

    C3022cf(C3023aa aaVar) {
        this.f1740a = aaVar.f1753a;
        this.f1741b = aaVar.f1754b;
        this.f1742c = aaVar.f1755c;
        this.f1743d = aaVar.f1756d;
        this.f1744e = aaVar.f1757e;
        this.f1745f = aaVar.f1758f.mo38120a();
        this.f1746g = aaVar.f1759g;
        this.f1747h = aaVar.f1760h;
        this.f1748i = aaVar.f1761i;
        this.f1749j = aaVar.f1762j;
        this.f1750k = aaVar.f1763k;
        this.f1751l = aaVar.f1764l;
    }

    /* renamed from: a */
    public final String mo38175a(String str) {
        return mo38178b(str);
    }

    /* renamed from: a */
    public final boolean mo38176a() {
        return this.f1742c >= 200 && this.f1742c < 300;
    }

    /* renamed from: b */
    public final C3023aa mo38177b() {
        return new C3023aa(this);
    }

    /* renamed from: b */
    public final String mo38178b(String str) {
        String a = this.f1745f.mo38113a(str);
        if (a != null) {
            return a;
        }
        return null;
    }

    /* renamed from: c */
    public final C2978bh mo38179c() {
        C2978bh bhVar = this.f1752m;
        if (bhVar != null) {
            return bhVar;
        }
        C2978bh a = C2978bh.m1244a(this.f1745f);
        this.f1752m = a;
        return a;
    }

    public final void close() {
        this.f1746g.close();
    }

    public final String toString() {
        return "Response{protocol=" + this.f1741b + ", code=" + this.f1742c + ", message=" + this.f1743d + ", url=" + this.f1740a.f1723a + '}';
    }
}
