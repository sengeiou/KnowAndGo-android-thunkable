package com.uxcam.internals;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/* renamed from: com.uxcam.internals.cx */
public final class C3047cx {

    /* renamed from: b */
    static final /* synthetic */ boolean f1871b = (!C3047cx.class.desiredAssertionStatus());

    /* renamed from: a */
    public final C2974be f1872a;

    /* renamed from: c */
    private C3026ch f1873c;

    /* renamed from: d */
    private final C2987bn f1874d;

    /* renamed from: e */
    private final Object f1875e;

    /* renamed from: f */
    private final C3046cw f1876f;

    /* renamed from: g */
    private int f1877g;

    /* renamed from: h */
    private C3043ct f1878h;

    /* renamed from: i */
    private boolean f1879i;

    /* renamed from: j */
    private boolean f1880j;

    /* renamed from: k */
    private C3051da f1881k;

    /* renamed from: com.uxcam.internals.cx$aa */
    public static final class C3048aa extends WeakReference {

        /* renamed from: a */
        public final Object f1882a;

        C3048aa(C3047cx cxVar, Object obj) {
            super(cxVar);
            this.f1882a = obj;
        }
    }

    public C3047cx(C2987bn bnVar, C2974be beVar, Object obj) {
        this.f1874d = bnVar;
        this.f1872a = beVar;
        this.f1876f = new C3046cw(beVar, m1479e());
        this.f1875e = obj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002c, code lost:
        if (r1 != null) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002e, code lost:
        r1 = r8.f1876f.mo38214a();
        r0 = r8.f1874d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0036, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r8.f1873c = r1;
        r8.f1877g = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003c, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0041, code lost:
        r0 = new com.uxcam.internals.C3043ct(r1);
        r1 = r8.f1874d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0048, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        mo38220a(r0);
        com.uxcam.internals.C3028cj.f1778a.mo38153b(r8.f1874d, r0);
        r8.f1878h = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0057, code lost:
        if (r8.f1880j != false) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0059, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x005a, code lost:
        r0.mo38206a(r9, r10, r11, r8.f1872a.f1402f, r12);
        m1479e().mo38212b(r0.f1846a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x006f, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0077, code lost:
        throw new java.io.IOException("Canceled");
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.uxcam.internals.C3043ct m1476a(int r9, int r10, int r11, boolean r12) {
        /*
            r8 = this;
            com.uxcam.internals.bn r0 = r8.f1874d
            monitor-enter(r0)
            boolean r1 = r8.f1879i     // Catch:{ all -> 0x0093 }
            if (r1 != 0) goto L_0x008b
            com.uxcam.internals.da r1 = r8.f1881k     // Catch:{ all -> 0x0093 }
            if (r1 != 0) goto L_0x0083
            boolean r1 = r8.f1880j     // Catch:{ all -> 0x0093 }
            if (r1 != 0) goto L_0x007b
            com.uxcam.internals.ct r1 = r8.f1878h     // Catch:{ all -> 0x0093 }
            if (r1 == 0) goto L_0x0019
            boolean r2 = r1.f1855j     // Catch:{ all -> 0x0093 }
            if (r2 != 0) goto L_0x0019
            monitor-exit(r0)     // Catch:{ all -> 0x0093 }
            return r1
        L_0x0019:
            com.uxcam.internals.cj r1 = com.uxcam.internals.C3028cj.f1778a     // Catch:{ all -> 0x0093 }
            com.uxcam.internals.bn r2 = r8.f1874d     // Catch:{ all -> 0x0093 }
            com.uxcam.internals.be r3 = r8.f1872a     // Catch:{ all -> 0x0093 }
            com.uxcam.internals.ct r1 = r1.mo38147a((com.uxcam.internals.C2987bn) r2, (com.uxcam.internals.C2974be) r3, (com.uxcam.internals.C3047cx) r8)     // Catch:{ all -> 0x0093 }
            if (r1 == 0) goto L_0x0029
            r8.f1878h = r1     // Catch:{ all -> 0x0093 }
            monitor-exit(r0)     // Catch:{ all -> 0x0093 }
            return r1
        L_0x0029:
            com.uxcam.internals.ch r1 = r8.f1873c     // Catch:{ all -> 0x0093 }
            monitor-exit(r0)     // Catch:{ all -> 0x0093 }
            if (r1 != 0) goto L_0x0041
            com.uxcam.internals.cw r0 = r8.f1876f
            com.uxcam.internals.ch r1 = r0.mo38214a()
            com.uxcam.internals.bn r0 = r8.f1874d
            monitor-enter(r0)
            r8.f1873c = r1     // Catch:{ all -> 0x003e }
            r2 = 0
            r8.f1877g = r2     // Catch:{ all -> 0x003e }
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            goto L_0x0041
        L_0x003e:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            throw r9
        L_0x0041:
            com.uxcam.internals.ct r0 = new com.uxcam.internals.ct
            r0.<init>(r1)
            com.uxcam.internals.bn r1 = r8.f1874d
            monitor-enter(r1)
            r8.mo38220a((com.uxcam.internals.C3043ct) r0)     // Catch:{ all -> 0x0078 }
            com.uxcam.internals.cj r2 = com.uxcam.internals.C3028cj.f1778a     // Catch:{ all -> 0x0078 }
            com.uxcam.internals.bn r3 = r8.f1874d     // Catch:{ all -> 0x0078 }
            r2.mo38153b(r3, r0)     // Catch:{ all -> 0x0078 }
            r8.f1878h = r0     // Catch:{ all -> 0x0078 }
            boolean r2 = r8.f1880j     // Catch:{ all -> 0x0078 }
            if (r2 != 0) goto L_0x0070
            monitor-exit(r1)     // Catch:{ all -> 0x0078 }
            com.uxcam.internals.be r1 = r8.f1872a
            java.util.List r6 = r1.f1402f
            r2 = r0
            r3 = r9
            r4 = r10
            r5 = r11
            r7 = r12
            r2.mo38206a(r3, r4, r5, r6, r7)
            com.uxcam.internals.cu r9 = r8.m1479e()
            com.uxcam.internals.ch r10 = r0.f1846a
            r9.mo38212b(r10)
            return r0
        L_0x0070:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ all -> 0x0078 }
            java.lang.String r10 = "Canceled"
            r9.<init>(r10)     // Catch:{ all -> 0x0078 }
            throw r9     // Catch:{ all -> 0x0078 }
        L_0x0078:
            r9 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0078 }
            throw r9
        L_0x007b:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ all -> 0x0093 }
            java.lang.String r10 = "Canceled"
            r9.<init>(r10)     // Catch:{ all -> 0x0093 }
            throw r9     // Catch:{ all -> 0x0093 }
        L_0x0083:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0093 }
            java.lang.String r10 = "codec != null"
            r9.<init>(r10)     // Catch:{ all -> 0x0093 }
            throw r9     // Catch:{ all -> 0x0093 }
        L_0x008b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0093 }
            java.lang.String r10 = "released"
            r9.<init>(r10)     // Catch:{ all -> 0x0093 }
            throw r9     // Catch:{ all -> 0x0093 }
        L_0x0093:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0093 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C3047cx.m1476a(int, int, int, boolean):com.uxcam.internals.ct");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        if (r0.mo38209a(r8) != false) goto L_0x001a;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.uxcam.internals.C3043ct m1477a(int r4, int r5, int r6, boolean r7, boolean r8) {
        /*
            r3 = this;
        L_0x0000:
            com.uxcam.internals.ct r0 = r3.m1476a(r4, r5, r6, r7)
            com.uxcam.internals.bn r1 = r3.f1874d
            monitor-enter(r1)
            int r2 = r0.f1850e     // Catch:{ all -> 0x001b }
            if (r2 != 0) goto L_0x000d
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return r0
        L_0x000d:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            boolean r1 = r0.mo38209a((boolean) r8)
            if (r1 != 0) goto L_0x001a
            r0 = 1
            r1 = 0
            r3.mo38223a(r0, r1, r1)
            goto L_0x0000
        L_0x001a:
            return r0
        L_0x001b:
            r4 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C3047cx.m1477a(int, int, int, boolean, boolean):com.uxcam.internals.ct");
    }

    /* renamed from: b */
    private void m1478b(C3043ct ctVar) {
        int size = ctVar.f1854i.size();
        for (int i = 0; i < size; i++) {
            if (((Reference) ctVar.f1854i.get(i)).get() == this) {
                ctVar.f1854i.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    /* renamed from: e */
    private C3044cu m1479e() {
        return C3028cj.f1778a.mo38148a(this.f1874d);
    }

    /* renamed from: a */
    public final C3051da mo38218a() {
        C3051da daVar;
        synchronized (this.f1874d) {
            daVar = this.f1881k;
        }
        return daVar;
    }

    /* renamed from: a */
    public final C3051da mo38219a(C3011ca caVar, boolean z) {
        C3051da daVar;
        int i = caVar.f1682y;
        int i2 = caVar.f1683z;
        int i3 = caVar.f1658A;
        try {
            C3043ct a = m1477a(i, i2, i3, caVar.f1681x, z);
            if (a.f1849d != null) {
                daVar = new C3076dq(caVar, this, a.f1849d);
            } else {
                a.f1847b.setSoTimeout(i2);
                a.f1851f.mo38197a().mo38421a((long) i2, TimeUnit.MILLISECONDS);
                a.f1852g.mo38241a().mo38421a((long) i3, TimeUnit.MILLISECONDS);
                daVar = new C3062dk(caVar, this, a.f1851f, a.f1852g);
            }
            synchronized (this.f1874d) {
                this.f1881k = daVar;
            }
            return daVar;
        } catch (IOException e) {
            throw new C3045cv(e);
        }
    }

    /* renamed from: a */
    public final void mo38220a(C3043ct ctVar) {
        if (f1871b || Thread.holdsLock(this.f1874d)) {
            ctVar.f1854i.add(new C3048aa(this, this.f1875e));
            return;
        }
        throw new AssertionError();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002f, code lost:
        if ((r9.f1878h.f1849d != null) != false) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0033, code lost:
        if ((r10 instanceof com.uxcam.internals.C3069dl) != false) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0039, code lost:
        if (r9.f1878h.f1850e != 0) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003d, code lost:
        if (r9.f1873c == null) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003f, code lost:
        if (r10 == null) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0041, code lost:
        r1 = r9.f1876f;
        r5 = r9.f1873c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004d, code lost:
        if (r5.f1769b.type() == java.net.Proxy.Type.DIRECT) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0053, code lost:
        if (r1.f1862a.f1403g == null) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0055, code lost:
        r1.f1862a.f1403g.connectFailed(r1.f1862a.f1397a.mo38121a(), r5.f1769b.address(), r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x006a, code lost:
        r1.f1863b.mo38211a(r5);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo38221a(java.io.IOException r10) {
        /*
            r9 = this;
            com.uxcam.internals.bn r0 = r9.f1874d
            monitor-enter(r0)
            boolean r1 = r10 instanceof com.uxcam.internals.C3107dz     // Catch:{ all -> 0x0079 }
            r2 = 0
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0022
            com.uxcam.internals.dz r10 = (com.uxcam.internals.C3107dz) r10     // Catch:{ all -> 0x0079 }
            com.uxcam.internals.dm r1 = r10.f2104a     // Catch:{ all -> 0x0079 }
            com.uxcam.internals.dm r5 = com.uxcam.internals.C3070dm.REFUSED_STREAM     // Catch:{ all -> 0x0079 }
            if (r1 != r5) goto L_0x0017
            int r1 = r9.f1877g     // Catch:{ all -> 0x0079 }
            int r1 = r1 + r4
            r9.f1877g = r1     // Catch:{ all -> 0x0079 }
        L_0x0017:
            com.uxcam.internals.dm r10 = r10.f2104a     // Catch:{ all -> 0x0079 }
            com.uxcam.internals.dm r1 = com.uxcam.internals.C3070dm.REFUSED_STREAM     // Catch:{ all -> 0x0079 }
            if (r10 != r1) goto L_0x006f
            int r10 = r9.f1877g     // Catch:{ all -> 0x0079 }
            if (r10 <= r4) goto L_0x0073
            goto L_0x006f
        L_0x0022:
            com.uxcam.internals.ct r1 = r9.f1878h     // Catch:{ all -> 0x0079 }
            if (r1 == 0) goto L_0x0031
            com.uxcam.internals.ct r1 = r9.f1878h     // Catch:{ all -> 0x0079 }
            com.uxcam.internals.dr r1 = r1.f1849d     // Catch:{ all -> 0x0079 }
            if (r1 == 0) goto L_0x002e
            r1 = 1
            goto L_0x002f
        L_0x002e:
            r1 = 0
        L_0x002f:
            if (r1 == 0) goto L_0x0035
        L_0x0031:
            boolean r1 = r10 instanceof com.uxcam.internals.C3069dl     // Catch:{ all -> 0x0079 }
            if (r1 == 0) goto L_0x0073
        L_0x0035:
            com.uxcam.internals.ct r1 = r9.f1878h     // Catch:{ all -> 0x0079 }
            int r1 = r1.f1850e     // Catch:{ all -> 0x0079 }
            if (r1 != 0) goto L_0x0071
            com.uxcam.internals.ch r1 = r9.f1873c     // Catch:{ all -> 0x0079 }
            if (r1 == 0) goto L_0x006f
            if (r10 == 0) goto L_0x006f
            com.uxcam.internals.cw r1 = r9.f1876f     // Catch:{ all -> 0x0079 }
            com.uxcam.internals.ch r5 = r9.f1873c     // Catch:{ all -> 0x0079 }
            java.net.Proxy r6 = r5.f1769b     // Catch:{ all -> 0x0079 }
            java.net.Proxy$Type r6 = r6.type()     // Catch:{ all -> 0x0079 }
            java.net.Proxy$Type r7 = java.net.Proxy.Type.DIRECT     // Catch:{ all -> 0x0079 }
            if (r6 == r7) goto L_0x006a
            com.uxcam.internals.be r6 = r1.f1862a     // Catch:{ all -> 0x0079 }
            java.net.ProxySelector r6 = r6.f1403g     // Catch:{ all -> 0x0079 }
            if (r6 == 0) goto L_0x006a
            com.uxcam.internals.be r6 = r1.f1862a     // Catch:{ all -> 0x0079 }
            java.net.ProxySelector r6 = r6.f1403g     // Catch:{ all -> 0x0079 }
            com.uxcam.internals.be r7 = r1.f1862a     // Catch:{ all -> 0x0079 }
            com.uxcam.internals.bw r7 = r7.f1397a     // Catch:{ all -> 0x0079 }
            java.net.URI r7 = r7.mo38121a()     // Catch:{ all -> 0x0079 }
            java.net.Proxy r8 = r5.f1769b     // Catch:{ all -> 0x0079 }
            java.net.SocketAddress r8 = r8.address()     // Catch:{ all -> 0x0079 }
            r6.connectFailed(r7, r8, r10)     // Catch:{ all -> 0x0079 }
        L_0x006a:
            com.uxcam.internals.cu r10 = r1.f1863b     // Catch:{ all -> 0x0079 }
            r10.mo38211a(r5)     // Catch:{ all -> 0x0079 }
        L_0x006f:
            r9.f1873c = r2     // Catch:{ all -> 0x0079 }
        L_0x0071:
            r10 = 1
            goto L_0x0074
        L_0x0073:
            r10 = 0
        L_0x0074:
            monitor-exit(r0)     // Catch:{ all -> 0x0079 }
            r9.mo38223a(r10, r3, r4)
            return
        L_0x0079:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0079 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C3047cx.mo38221a(java.io.IOException):void");
    }

    /* renamed from: a */
    public final void mo38222a(boolean z, C3051da daVar) {
        synchronized (this.f1874d) {
            if (daVar != null) {
                if (daVar == this.f1881k) {
                    if (!z) {
                        this.f1878h.f1850e++;
                    }
                }
            }
            throw new IllegalStateException("expected " + this.f1881k + " but was " + daVar);
        }
        mo38223a(z, false, true);
    }

    /* renamed from: a */
    public final void mo38223a(boolean z, boolean z2, boolean z3) {
        C3043ct ctVar;
        synchronized (this.f1874d) {
            if (z3) {
                try {
                    this.f1881k = null;
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            if (z2) {
                this.f1879i = true;
            }
            if (this.f1878h != null) {
                if (z) {
                    this.f1878h.f1855j = true;
                }
                if (this.f1881k == null && (this.f1879i || this.f1878h.f1855j)) {
                    m1478b(this.f1878h);
                    if (this.f1878h.f1854i.isEmpty()) {
                        this.f1878h.f1856k = System.nanoTime();
                        if (C3028cj.f1778a.mo38152a(this.f1874d, this.f1878h)) {
                            ctVar = this.f1878h;
                            this.f1878h = null;
                        }
                    }
                    ctVar = null;
                    this.f1878h = null;
                }
            }
            ctVar = null;
        }
        if (ctVar != null) {
            C3030cl.m1429a(ctVar.f1847b);
        }
    }

    /* renamed from: b */
    public final synchronized C3043ct mo38224b() {
        return this.f1878h;
    }

    /* renamed from: c */
    public final void mo38225c() {
        mo38223a(false, true, false);
    }

    /* renamed from: d */
    public final boolean mo38226d() {
        if (this.f1873c == null) {
            C3046cw cwVar = this.f1876f;
            return cwVar.mo38216c() || cwVar.mo38215b() || cwVar.mo38217d();
        }
    }

    public final String toString() {
        return this.f1872a.toString();
    }
}
