package com.uxcam.internals;

import android.support.p002v4.media.session.PlaybackStateCompat;
import com.polidea.rxandroidble.ClientComponent;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.List;

/* renamed from: com.uxcam.internals.dt */
public final class C3096dt {

    /* renamed from: k */
    static final /* synthetic */ boolean f2059k = (!C3096dt.class.desiredAssertionStatus());

    /* renamed from: a */
    long f2060a = 0;

    /* renamed from: b */
    long f2061b;

    /* renamed from: c */
    final int f2062c;

    /* renamed from: d */
    final C3078dr f2063d;

    /* renamed from: e */
    List f2064e;

    /* renamed from: f */
    final C3098ab f2065f;

    /* renamed from: g */
    final C3097aa f2066g;

    /* renamed from: h */
    final C3099ac f2067h = new C3099ac();

    /* renamed from: i */
    final C3099ac f2068i = new C3099ac();

    /* renamed from: j */
    C3070dm f2069j = null;

    /* renamed from: l */
    private final List f2070l;

    /* renamed from: com.uxcam.internals.dt$aa */
    final class C3097aa implements C3147fb {

        /* renamed from: c */
        static final /* synthetic */ boolean f2071c = (!C3096dt.class.desiredAssertionStatus());

        /* renamed from: a */
        boolean f2072a;

        /* renamed from: b */
        boolean f2073b;

        /* renamed from: e */
        private final C3130en f2075e = new C3130en();

        C3097aa() {
        }

        /* JADX INFO: finally extract failed */
        /* renamed from: a */
        private void m1637a(boolean z) {
            long min;
            synchronized (C3096dt.this) {
                C3096dt.this.f2068i.mo38344a_();
                while (C3096dt.this.f2061b <= 0 && !this.f2073b && !this.f2072a && C3096dt.this.f2069j == null) {
                    try {
                        C3096dt.this.mo38289h();
                    } catch (Throwable th) {
                        C3096dt.this.f2068i.mo38293b();
                        throw th;
                    }
                }
                C3096dt.this.f2068i.mo38293b();
                C3096dt.this.mo38288g();
                min = Math.min(C3096dt.this.f2061b, this.f2075e.f2158b);
                C3096dt.this.f2061b -= min;
            }
            C3096dt.this.f2068i.mo38344a_();
            try {
                C3096dt.this.f2063d.mo38257a(C3096dt.this.f2062c, z && min == this.f2075e.f2158b, this.f2075e, min);
            } finally {
                C3096dt.this.f2068i.mo38293b();
            }
        }

        /* renamed from: a */
        public final C3149fd mo38241a() {
            return C3096dt.this.f2068i;
        }

        /* renamed from: a_ */
        public final void mo38242a_(C3130en enVar, long j) {
            if (f2071c || !Thread.holdsLock(C3096dt.this)) {
                this.f2075e.mo38242a_(enVar, j);
                while (this.f2075e.f2158b >= PlaybackStateCompat.ACTION_PREPARE) {
                    m1637a(false);
                }
                return;
            }
            throw new AssertionError();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
            if (r8.f2074d.f2066g.f2073b != false) goto L_0x004b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002e, code lost:
            if (r8.f2075e.f2158b <= 0) goto L_0x003c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0036, code lost:
            if (r8.f2075e.f2158b <= 0) goto L_0x004b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0038, code lost:
            m1637a(true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x003c, code lost:
            r8.f2074d.f2063d.mo38257a(r8.f2074d.f2062c, true, (com.uxcam.internals.C3130en) null, 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x004b, code lost:
            r2 = r8.f2074d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x004d, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            r8.f2072a = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0050, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0051, code lost:
            r8.f2074d.f2063d.f2002q.mo38302b();
            r8.f2074d.mo38287f();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x005f, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void close() {
            /*
                r8 = this;
                boolean r0 = f2071c
                if (r0 != 0) goto L_0x0013
                com.uxcam.internals.dt r0 = com.uxcam.internals.C3096dt.this
                boolean r0 = java.lang.Thread.holdsLock(r0)
                if (r0 != 0) goto L_0x000d
                goto L_0x0013
            L_0x000d:
                java.lang.AssertionError r0 = new java.lang.AssertionError
                r0.<init>()
                throw r0
            L_0x0013:
                com.uxcam.internals.dt r0 = com.uxcam.internals.C3096dt.this
                monitor-enter(r0)
                boolean r1 = r8.f2072a     // Catch:{ all -> 0x0063 }
                if (r1 == 0) goto L_0x001c
                monitor-exit(r0)     // Catch:{ all -> 0x0063 }
                return
            L_0x001c:
                monitor-exit(r0)     // Catch:{ all -> 0x0063 }
                com.uxcam.internals.dt r0 = com.uxcam.internals.C3096dt.this
                com.uxcam.internals.dt$aa r0 = r0.f2066g
                boolean r0 = r0.f2073b
                r1 = 1
                if (r0 != 0) goto L_0x004b
                com.uxcam.internals.en r0 = r8.f2075e
                long r2 = r0.f2158b
                r4 = 0
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x003c
            L_0x0030:
                com.uxcam.internals.en r0 = r8.f2075e
                long r2 = r0.f2158b
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x004b
                r8.m1637a(r1)
                goto L_0x0030
            L_0x003c:
                com.uxcam.internals.dt r0 = com.uxcam.internals.C3096dt.this
                com.uxcam.internals.dr r2 = r0.f2063d
                com.uxcam.internals.dt r0 = com.uxcam.internals.C3096dt.this
                int r3 = r0.f2062c
                r4 = 1
                r5 = 0
                r6 = 0
                r2.mo38257a((int) r3, (boolean) r4, (com.uxcam.internals.C3130en) r5, (long) r6)
            L_0x004b:
                com.uxcam.internals.dt r2 = com.uxcam.internals.C3096dt.this
                monitor-enter(r2)
                r8.f2072a = r1     // Catch:{ all -> 0x0060 }
                monitor-exit(r2)     // Catch:{ all -> 0x0060 }
                com.uxcam.internals.dt r0 = com.uxcam.internals.C3096dt.this
                com.uxcam.internals.dr r0 = r0.f2063d
                com.uxcam.internals.du r0 = r0.f2002q
                r0.mo38302b()
                com.uxcam.internals.dt r0 = com.uxcam.internals.C3096dt.this
                r0.mo38287f()
                return
            L_0x0060:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0060 }
                throw r0
            L_0x0063:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0063 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C3096dt.C3097aa.close():void");
        }

        public final void flush() {
            if (f2071c || !Thread.holdsLock(C3096dt.this)) {
                synchronized (C3096dt.this) {
                    C3096dt.this.mo38288g();
                }
                while (this.f2075e.f2158b > 0) {
                    m1637a(false);
                    C3096dt.this.f2063d.f2002q.mo38302b();
                }
                return;
            }
            throw new AssertionError();
        }
    }

    /* renamed from: com.uxcam.internals.dt$ab */
    final class C3098ab implements C3148fc {

        /* renamed from: c */
        static final /* synthetic */ boolean f2076c = (!C3096dt.class.desiredAssertionStatus());

        /* renamed from: a */
        boolean f2077a;

        /* renamed from: b */
        boolean f2078b;

        /* renamed from: e */
        private final C3130en f2080e = new C3130en();

        /* renamed from: f */
        private final C3130en f2081f = new C3130en();

        /* renamed from: g */
        private final long f2082g;

        C3098ab(long j) {
            this.f2082g = j;
        }

        /* renamed from: b */
        private void m1640b() {
            C3096dt.this.f2067h.mo38344a_();
            while (this.f2081f.f2158b == 0 && !this.f2078b && !this.f2077a && C3096dt.this.f2069j == null) {
                try {
                    C3096dt.this.mo38289h();
                } finally {
                    C3096dt.this.f2067h.mo38293b();
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0061, code lost:
            r10 = r7.f2079d.f2063d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0065, code lost:
            monitor-enter(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            r7.f2079d.f2063d.f1996k += r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0085, code lost:
            if (r7.f2079d.f2063d.f1996k < ((long) (r7.f2079d.f2063d.f1998m.mo38311b() / 2))) goto L_0x009b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0087, code lost:
            r7.f2079d.f2063d.mo38255a(0, r7.f2079d.f2063d.f1996k);
            r7.f2079d.f2063d.f1996k = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x009b, code lost:
            monitor-exit(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x009c, code lost:
            return r8;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final long mo38196a(com.uxcam.internals.C3130en r8, long r9) {
            /*
                r7 = this;
                r0 = 0
                int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r2 < 0) goto L_0x00b5
                com.uxcam.internals.dt r2 = com.uxcam.internals.C3096dt.this
                monitor-enter(r2)
                r7.m1640b()     // Catch:{ all -> 0x00b2 }
                boolean r3 = r7.f2077a     // Catch:{ all -> 0x00b2 }
                if (r3 != 0) goto L_0x00aa
                com.uxcam.internals.dt r3 = com.uxcam.internals.C3096dt.this     // Catch:{ all -> 0x00b2 }
                com.uxcam.internals.dm r3 = r3.f2069j     // Catch:{ all -> 0x00b2 }
                if (r3 != 0) goto L_0x00a0
                com.uxcam.internals.en r3 = r7.f2081f     // Catch:{ all -> 0x00b2 }
                long r3 = r3.f2158b     // Catch:{ all -> 0x00b2 }
                int r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
                if (r3 != 0) goto L_0x0022
                r8 = -1
                monitor-exit(r2)     // Catch:{ all -> 0x00b2 }
                return r8
            L_0x0022:
                com.uxcam.internals.en r3 = r7.f2081f     // Catch:{ all -> 0x00b2 }
                com.uxcam.internals.en r4 = r7.f2081f     // Catch:{ all -> 0x00b2 }
                long r4 = r4.f2158b     // Catch:{ all -> 0x00b2 }
                long r9 = java.lang.Math.min(r9, r4)     // Catch:{ all -> 0x00b2 }
                long r8 = r3.mo38196a((com.uxcam.internals.C3130en) r8, (long) r9)     // Catch:{ all -> 0x00b2 }
                com.uxcam.internals.dt r10 = com.uxcam.internals.C3096dt.this     // Catch:{ all -> 0x00b2 }
                long r3 = r10.f2060a     // Catch:{ all -> 0x00b2 }
                r5 = 0
                long r3 = r3 + r8
                r10.f2060a = r3     // Catch:{ all -> 0x00b2 }
                com.uxcam.internals.dt r10 = com.uxcam.internals.C3096dt.this     // Catch:{ all -> 0x00b2 }
                long r3 = r10.f2060a     // Catch:{ all -> 0x00b2 }
                com.uxcam.internals.dt r10 = com.uxcam.internals.C3096dt.this     // Catch:{ all -> 0x00b2 }
                com.uxcam.internals.dr r10 = r10.f2063d     // Catch:{ all -> 0x00b2 }
                com.uxcam.internals.dy r10 = r10.f1998m     // Catch:{ all -> 0x00b2 }
                int r10 = r10.mo38311b()     // Catch:{ all -> 0x00b2 }
                int r10 = r10 / 2
                long r5 = (long) r10     // Catch:{ all -> 0x00b2 }
                int r10 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r10 < 0) goto L_0x0060
                com.uxcam.internals.dt r10 = com.uxcam.internals.C3096dt.this     // Catch:{ all -> 0x00b2 }
                com.uxcam.internals.dr r10 = r10.f2063d     // Catch:{ all -> 0x00b2 }
                com.uxcam.internals.dt r3 = com.uxcam.internals.C3096dt.this     // Catch:{ all -> 0x00b2 }
                int r3 = r3.f2062c     // Catch:{ all -> 0x00b2 }
                com.uxcam.internals.dt r4 = com.uxcam.internals.C3096dt.this     // Catch:{ all -> 0x00b2 }
                long r4 = r4.f2060a     // Catch:{ all -> 0x00b2 }
                r10.mo38255a((int) r3, (long) r4)     // Catch:{ all -> 0x00b2 }
                com.uxcam.internals.dt r10 = com.uxcam.internals.C3096dt.this     // Catch:{ all -> 0x00b2 }
                r10.f2060a = r0     // Catch:{ all -> 0x00b2 }
            L_0x0060:
                monitor-exit(r2)     // Catch:{ all -> 0x00b2 }
                com.uxcam.internals.dt r10 = com.uxcam.internals.C3096dt.this
                com.uxcam.internals.dr r10 = r10.f2063d
                monitor-enter(r10)
                com.uxcam.internals.dt r2 = com.uxcam.internals.C3096dt.this     // Catch:{ all -> 0x009d }
                com.uxcam.internals.dr r2 = r2.f2063d     // Catch:{ all -> 0x009d }
                long r3 = r2.f1996k     // Catch:{ all -> 0x009d }
                r5 = 0
                long r3 = r3 + r8
                r2.f1996k = r3     // Catch:{ all -> 0x009d }
                com.uxcam.internals.dt r2 = com.uxcam.internals.C3096dt.this     // Catch:{ all -> 0x009d }
                com.uxcam.internals.dr r2 = r2.f2063d     // Catch:{ all -> 0x009d }
                long r2 = r2.f1996k     // Catch:{ all -> 0x009d }
                com.uxcam.internals.dt r4 = com.uxcam.internals.C3096dt.this     // Catch:{ all -> 0x009d }
                com.uxcam.internals.dr r4 = r4.f2063d     // Catch:{ all -> 0x009d }
                com.uxcam.internals.dy r4 = r4.f1998m     // Catch:{ all -> 0x009d }
                int r4 = r4.mo38311b()     // Catch:{ all -> 0x009d }
                int r4 = r4 / 2
                long r4 = (long) r4     // Catch:{ all -> 0x009d }
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 < 0) goto L_0x009b
                com.uxcam.internals.dt r2 = com.uxcam.internals.C3096dt.this     // Catch:{ all -> 0x009d }
                com.uxcam.internals.dr r2 = r2.f2063d     // Catch:{ all -> 0x009d }
                r3 = 0
                com.uxcam.internals.dt r4 = com.uxcam.internals.C3096dt.this     // Catch:{ all -> 0x009d }
                com.uxcam.internals.dr r4 = r4.f2063d     // Catch:{ all -> 0x009d }
                long r4 = r4.f1996k     // Catch:{ all -> 0x009d }
                r2.mo38255a((int) r3, (long) r4)     // Catch:{ all -> 0x009d }
                com.uxcam.internals.dt r2 = com.uxcam.internals.C3096dt.this     // Catch:{ all -> 0x009d }
                com.uxcam.internals.dr r2 = r2.f2063d     // Catch:{ all -> 0x009d }
                r2.f1996k = r0     // Catch:{ all -> 0x009d }
            L_0x009b:
                monitor-exit(r10)     // Catch:{ all -> 0x009d }
                return r8
            L_0x009d:
                r8 = move-exception
                monitor-exit(r10)     // Catch:{ all -> 0x009d }
                throw r8
            L_0x00a0:
                com.uxcam.internals.dz r8 = new com.uxcam.internals.dz     // Catch:{ all -> 0x00b2 }
                com.uxcam.internals.dt r9 = com.uxcam.internals.C3096dt.this     // Catch:{ all -> 0x00b2 }
                com.uxcam.internals.dm r9 = r9.f2069j     // Catch:{ all -> 0x00b2 }
                r8.<init>(r9)     // Catch:{ all -> 0x00b2 }
                throw r8     // Catch:{ all -> 0x00b2 }
            L_0x00aa:
                java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x00b2 }
                java.lang.String r9 = "stream closed"
                r8.<init>(r9)     // Catch:{ all -> 0x00b2 }
                throw r8     // Catch:{ all -> 0x00b2 }
            L_0x00b2:
                r8 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x00b2 }
                throw r8
            L_0x00b5:
                java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
                java.lang.String r9 = java.lang.String.valueOf(r9)
                java.lang.String r10 = "byteCount < 0: "
                java.lang.String r9 = r10.concat(r9)
                r8.<init>(r9)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C3096dt.C3098ab.mo38196a(com.uxcam.internals.en, long):long");
        }

        /* renamed from: a */
        public final C3149fd mo38197a() {
            return C3096dt.this.f2067h;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final void mo38290a(C3132ep epVar, long j) {
            boolean z;
            boolean z2;
            boolean z3;
            if (f2076c || !Thread.holdsLock(C3096dt.this)) {
                while (j > 0) {
                    synchronized (C3096dt.this) {
                        z = this.f2078b;
                        z2 = false;
                        z3 = this.f2081f.f2158b + j > this.f2082g;
                    }
                    if (z3) {
                        epVar.mo38382f(j);
                        C3096dt.this.mo38281b(C3070dm.FLOW_CONTROL_ERROR);
                        return;
                    } else if (z) {
                        epVar.mo38382f(j);
                        return;
                    } else {
                        long a = epVar.mo38196a(this.f2080e, j);
                        if (a != -1) {
                            j -= a;
                            synchronized (C3096dt.this) {
                                if (this.f2081f.f2158b == 0) {
                                    z2 = true;
                                }
                                this.f2081f.mo38351a((C3148fc) this.f2080e);
                                if (z2) {
                                    C3096dt.this.notifyAll();
                                }
                            }
                        } else {
                            throw new EOFException();
                        }
                    }
                }
                return;
            }
            throw new AssertionError();
        }

        public final void close() {
            synchronized (C3096dt.this) {
                this.f2077a = true;
                this.f2081f.mo38398o();
                C3096dt.this.notifyAll();
            }
            C3096dt.this.mo38287f();
        }
    }

    /* renamed from: com.uxcam.internals.dt$ac */
    class C3099ac extends C3125el {
        C3099ac() {
        }

        /* renamed from: a */
        public final IOException mo38291a(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException(ClientComponent.NamedSchedulers.TIMEOUT);
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        /* renamed from: a */
        public final void mo38292a() {
            C3096dt.this.mo38281b(C3070dm.CANCEL);
        }

        /* renamed from: b */
        public final void mo38293b() {
            if (mo38346b_()) {
                throw mo38291a((IOException) null);
            }
        }
    }

    C3096dt(int i, C3078dr drVar, boolean z, boolean z2, List list) {
        if (drVar == null) {
            throw new NullPointerException("connection == null");
        } else if (list != null) {
            this.f2062c = i;
            this.f2063d = drVar;
            this.f2061b = (long) drVar.f1999n.mo38311b();
            this.f2065f = new C3098ab((long) drVar.f1998m.mo38311b());
            this.f2066g = new C3097aa();
            this.f2065f.f2078b = z2;
            this.f2066g.f2073b = z;
            this.f2070l = list;
        } else {
            throw new NullPointerException("requestHeaders == null");
        }
    }

    /* renamed from: d */
    private boolean m1624d(C3070dm dmVar) {
        if (f2059k || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.f2069j != null) {
                    return false;
                }
                if (this.f2065f.f2078b && this.f2066g.f2073b) {
                    return false;
                }
                this.f2069j = dmVar;
                notifyAll();
                this.f2063d.mo38260b(this.f2062c);
                return true;
            }
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo38278a(long j) {
        this.f2061b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* renamed from: a */
    public final void mo38279a(C3070dm dmVar) {
        if (m1624d(dmVar)) {
            this.f2063d.mo38262b(this.f2062c, dmVar);
        }
    }

    /* renamed from: a */
    public final synchronized boolean mo38280a() {
        if (this.f2069j != null) {
            return false;
        }
        return (!this.f2065f.f2078b && !this.f2065f.f2077a) || (!this.f2066g.f2073b && !this.f2066g.f2072a) || this.f2064e == null;
    }

    /* renamed from: b */
    public final void mo38281b(C3070dm dmVar) {
        if (m1624d(dmVar)) {
            this.f2063d.mo38256a(this.f2062c, dmVar);
        }
    }

    /* renamed from: b */
    public final boolean mo38282b() {
        return this.f2063d.f1987b == ((this.f2062c & 1) == 1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0027, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0028, code lost:
        r2.f2067h.mo38293b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002d, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.util.List mo38283c() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.uxcam.internals.dt$ac r0 = r2.f2067h     // Catch:{ all -> 0x002e }
            r0.mo38344a_()     // Catch:{ all -> 0x002e }
        L_0x0006:
            java.util.List r0 = r2.f2064e     // Catch:{ all -> 0x0027 }
            if (r0 != 0) goto L_0x0012
            com.uxcam.internals.dm r0 = r2.f2069j     // Catch:{ all -> 0x0027 }
            if (r0 != 0) goto L_0x0012
            r2.mo38289h()     // Catch:{ all -> 0x0027 }
            goto L_0x0006
        L_0x0012:
            com.uxcam.internals.dt$ac r0 = r2.f2067h     // Catch:{ all -> 0x002e }
            r0.mo38293b()     // Catch:{ all -> 0x002e }
            java.util.List r0 = r2.f2064e     // Catch:{ all -> 0x002e }
            if (r0 == 0) goto L_0x001f
            java.util.List r0 = r2.f2064e     // Catch:{ all -> 0x002e }
            monitor-exit(r2)
            return r0
        L_0x001f:
            com.uxcam.internals.dz r0 = new com.uxcam.internals.dz     // Catch:{ all -> 0x002e }
            com.uxcam.internals.dm r1 = r2.f2069j     // Catch:{ all -> 0x002e }
            r0.<init>(r1)     // Catch:{ all -> 0x002e }
            throw r0     // Catch:{ all -> 0x002e }
        L_0x0027:
            r0 = move-exception
            com.uxcam.internals.dt$ac r1 = r2.f2067h     // Catch:{ all -> 0x002e }
            r1.mo38293b()     // Catch:{ all -> 0x002e }
            throw r0     // Catch:{ all -> 0x002e }
        L_0x002e:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C3096dt.mo38283c():java.util.List");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final synchronized void mo38284c(C3070dm dmVar) {
        if (this.f2069j == null) {
            this.f2069j = dmVar;
            notifyAll();
        }
    }

    /* renamed from: d */
    public final C3147fb mo38285d() {
        synchronized (this) {
            if (this.f2064e == null) {
                if (!mo38282b()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            }
        }
        return this.f2066g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final void mo38286e() {
        boolean a;
        if (f2059k || !Thread.holdsLock(this)) {
            synchronized (this) {
                this.f2065f.f2078b = true;
                a = mo38280a();
                notifyAll();
            }
            if (!a) {
                this.f2063d.mo38260b(this.f2062c);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final void mo38287f() {
        boolean z;
        boolean a;
        if (f2059k || !Thread.holdsLock(this)) {
            synchronized (this) {
                z = !this.f2065f.f2078b && this.f2065f.f2077a && (this.f2066g.f2073b || this.f2066g.f2072a);
                a = mo38280a();
            }
            if (z) {
                mo38279a(C3070dm.CANCEL);
            } else if (!a) {
                this.f2063d.mo38260b(this.f2062c);
            }
        } else {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public final void mo38288g() {
        if (this.f2066g.f2072a) {
            throw new IOException("stream closed");
        } else if (this.f2066g.f2073b) {
            throw new IOException("stream finished");
        } else if (this.f2069j != null) {
            throw new C3107dz(this.f2069j);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public final void mo38289h() {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }
}
