package com.uxcam.internals;

import com.uxcam.internals.C3093ds;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.uxcam.internals.dr */
public final class C3078dr implements Closeable {

    /* renamed from: a */
    static final ExecutorService f1985a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), C3030cl.m1426a("OkHttp FramedConnection", true));

    /* renamed from: t */
    static final /* synthetic */ boolean f1986t = (!C3078dr.class.desiredAssertionStatus());

    /* renamed from: b */
    final boolean f1987b;

    /* renamed from: c */
    final C3087ab f1988c;

    /* renamed from: d */
    final Map f1989d = new LinkedHashMap();

    /* renamed from: e */
    final String f1990e;

    /* renamed from: f */
    int f1991f;

    /* renamed from: g */
    int f1992g;

    /* renamed from: h */
    boolean f1993h;

    /* renamed from: i */
    final ExecutorService f1994i;

    /* renamed from: j */
    final C3104dx f1995j;

    /* renamed from: k */
    long f1996k = 0;

    /* renamed from: l */
    long f1997l;

    /* renamed from: m */
    C3106dy f1998m = new C3106dy();

    /* renamed from: n */
    final C3106dy f1999n = new C3106dy();

    /* renamed from: o */
    boolean f2000o = false;

    /* renamed from: p */
    final Socket f2001p;

    /* renamed from: q */
    final C3100du f2002q;

    /* renamed from: r */
    final C3089ac f2003r;

    /* renamed from: s */
    final Set f2004s = new LinkedHashSet();

    /* renamed from: u */
    private Map f2005u;

    /* renamed from: v */
    private int f2006v;

    /* renamed from: com.uxcam.internals.dr$aa */
    public static class C3086aa {

        /* renamed from: a */
        Socket f2033a;

        /* renamed from: b */
        String f2034b;

        /* renamed from: c */
        C3132ep f2035c;

        /* renamed from: d */
        C3131eo f2036d;

        /* renamed from: e */
        public C3087ab f2037e = C3087ab.f2040l;

        /* renamed from: f */
        C3104dx f2038f = C3104dx.f2101a;

        /* renamed from: g */
        boolean f2039g = true;

        /* renamed from: a */
        public final C3086aa mo38266a(Socket socket, String str, C3132ep epVar, C3131eo eoVar) {
            this.f2033a = socket;
            this.f2034b = str;
            this.f2035c = epVar;
            this.f2036d = eoVar;
            return this;
        }

        /* renamed from: a */
        public final C3078dr mo38267a() {
            return new C3078dr(this);
        }
    }

    /* renamed from: com.uxcam.internals.dr$ab */
    public static abstract class C3087ab {

        /* renamed from: l */
        public static final C3087ab f2040l = new C3087ab() {
            /* renamed from: a */
            public final void mo38208a(C3096dt dtVar) {
                dtVar.mo38279a(C3070dm.REFUSED_STREAM);
            }
        };

        /* renamed from: a */
        public void mo38207a(C3078dr drVar) {
        }

        /* renamed from: a */
        public abstract void mo38208a(C3096dt dtVar);
    }

    /* renamed from: com.uxcam.internals.dr$ac */
    class C3089ac extends C3029ck implements C3093ds.C3095ab {

        /* renamed from: a */
        final C3093ds f2041a;

        C3089ac(C3093ds dsVar) {
            super("OkHttp %s", C3078dr.this.f1990e);
            this.f2041a = dsVar;
        }

        /* renamed from: a */
        public final void mo38268a(int i) {
            C3096dt[] dtVarArr;
            synchronized (C3078dr.this) {
                dtVarArr = (C3096dt[]) C3078dr.this.f1989d.values().toArray(new C3096dt[C3078dr.this.f1989d.size()]);
                C3078dr.this.f1993h = true;
            }
            for (C3096dt dtVar : dtVarArr) {
                if (dtVar.f2062c > i && dtVar.mo38282b()) {
                    dtVar.mo38284c(C3070dm.REFUSED_STREAM);
                    C3078dr.this.mo38260b(dtVar.f2062c);
                }
            }
        }

        /* renamed from: a */
        public final void mo38269a(int i, long j) {
            if (i == 0) {
                synchronized (C3078dr.this) {
                    C3078dr.this.f1997l += j;
                    C3078dr.this.notifyAll();
                }
                return;
            }
            C3096dt a = C3078dr.this.mo38253a(i);
            if (a != null) {
                synchronized (a) {
                    a.mo38278a(j);
                }
            }
        }

        /* renamed from: a */
        public final void mo38270a(int i, C3070dm dmVar) {
            if (C3078dr.m1571d(i)) {
                C3078dr drVar = C3078dr.this;
                drVar.f1994i.execute(new C3029ck("OkHttp %s Push Reset[%s]", new Object[]{drVar.f1990e, Integer.valueOf(i)}, i, dmVar) {

                    /* renamed from: a */
                    final /* synthetic */ int f2030a;

                    /* renamed from: c */
                    final /* synthetic */ C3070dm f2031c;

                    {
                        this.f2030a = r4;
                        this.f2031c = r5;
                    }

                    /* renamed from: b */
                    public final void mo38164b() {
                        synchronized (C3078dr.this) {
                            C3078dr.this.f2004s.remove(Integer.valueOf(this.f2030a));
                        }
                    }
                });
                return;
            }
            C3096dt b = C3078dr.this.mo38260b(i);
            if (b != null) {
                b.mo38284c(dmVar);
            }
        }

        /* renamed from: a */
        public final void mo38271a(int i, List list) {
            C3078dr drVar = C3078dr.this;
            synchronized (drVar) {
                if (drVar.f2004s.contains(Integer.valueOf(i))) {
                    drVar.mo38256a(i, C3070dm.PROTOCOL_ERROR);
                    return;
                }
                drVar.f2004s.add(Integer.valueOf(i));
                drVar.f1994i.execute(new C3029ck("OkHttp %s Push Request[%s]", new Object[]{drVar.f1990e, Integer.valueOf(i)}, i, list) {

                    /* renamed from: a */
                    final /* synthetic */ int f2018a;

                    /* renamed from: c */
                    final /* synthetic */ List f2019c;

                    {
                        this.f2018a = r4;
                        this.f2019c = r5;
                    }

                    /* renamed from: b */
                    public final void mo38164b() {
                        try {
                            C3078dr.this.f2002q.mo38296a(this.f2018a, C3070dm.CANCEL);
                            synchronized (C3078dr.this) {
                                C3078dr.this.f2004s.remove(Integer.valueOf(this.f2018a));
                            }
                        } catch (IOException unused) {
                        }
                    }
                });
            }
        }

        /* JADX WARNING: type inference failed for: r12v18, types: [java.lang.Object[]] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void mo38272a(final com.uxcam.internals.C3106dy r12) {
            /*
                r11 = this;
                com.uxcam.internals.dr r0 = com.uxcam.internals.C3078dr.this
                monitor-enter(r0)
                com.uxcam.internals.dr r1 = com.uxcam.internals.C3078dr.this     // Catch:{ all -> 0x00b6 }
                com.uxcam.internals.dy r1 = r1.f1999n     // Catch:{ all -> 0x00b6 }
                int r1 = r1.mo38311b()     // Catch:{ all -> 0x00b6 }
                com.uxcam.internals.dr r2 = com.uxcam.internals.C3078dr.this     // Catch:{ all -> 0x00b6 }
                com.uxcam.internals.dy r2 = r2.f1999n     // Catch:{ all -> 0x00b6 }
                r3 = 0
                r4 = 0
            L_0x0011:
                r5 = 10
                if (r4 >= r5) goto L_0x0025
                boolean r5 = r12.mo38310a(r4)     // Catch:{ all -> 0x00b6 }
                if (r5 == 0) goto L_0x0022
                int[] r5 = r12.f2103b     // Catch:{ all -> 0x00b6 }
                r5 = r5[r4]     // Catch:{ all -> 0x00b6 }
                r2.mo38309a(r4, r5)     // Catch:{ all -> 0x00b6 }
            L_0x0022:
                int r4 = r4 + 1
                goto L_0x0011
            L_0x0025:
                java.util.concurrent.ExecutorService r2 = com.uxcam.internals.C3078dr.f1985a     // Catch:{ all -> 0x00b6 }
                com.uxcam.internals.dr$ac$3 r4 = new com.uxcam.internals.dr$ac$3     // Catch:{ all -> 0x00b6 }
                java.lang.String r5 = "OkHttp %s ACK Settings"
                r6 = 1
                java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ all -> 0x00b6 }
                com.uxcam.internals.dr r8 = com.uxcam.internals.C3078dr.this     // Catch:{ all -> 0x00b6 }
                java.lang.String r8 = r8.f1990e     // Catch:{ all -> 0x00b6 }
                r7[r3] = r8     // Catch:{ all -> 0x00b6 }
                r4.<init>(r5, r7, r12)     // Catch:{ all -> 0x00b6 }
                r2.execute(r4)     // Catch:{ all -> 0x00b6 }
                com.uxcam.internals.dr r12 = com.uxcam.internals.C3078dr.this     // Catch:{ all -> 0x00b6 }
                com.uxcam.internals.dy r12 = r12.f1999n     // Catch:{ all -> 0x00b6 }
                int r12 = r12.mo38311b()     // Catch:{ all -> 0x00b6 }
                r2 = -1
                r4 = 0
                r7 = 0
                if (r12 == r2) goto L_0x0089
                if (r12 == r1) goto L_0x0089
                int r12 = r12 - r1
                long r1 = (long) r12     // Catch:{ all -> 0x00b6 }
                com.uxcam.internals.dr r12 = com.uxcam.internals.C3078dr.this     // Catch:{ all -> 0x00b6 }
                boolean r12 = r12.f2000o     // Catch:{ all -> 0x00b6 }
                if (r12 != 0) goto L_0x0065
                com.uxcam.internals.dr r12 = com.uxcam.internals.C3078dr.this     // Catch:{ all -> 0x00b6 }
                long r8 = r12.f1997l     // Catch:{ all -> 0x00b6 }
                r10 = 0
                long r8 = r8 + r1
                r12.f1997l = r8     // Catch:{ all -> 0x00b6 }
                int r8 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
                if (r8 <= 0) goto L_0x0061
                r12.notifyAll()     // Catch:{ all -> 0x00b6 }
            L_0x0061:
                com.uxcam.internals.dr r12 = com.uxcam.internals.C3078dr.this     // Catch:{ all -> 0x00b6 }
                r12.f2000o = r6     // Catch:{ all -> 0x00b6 }
            L_0x0065:
                com.uxcam.internals.dr r12 = com.uxcam.internals.C3078dr.this     // Catch:{ all -> 0x00b6 }
                java.util.Map r12 = r12.f1989d     // Catch:{ all -> 0x00b6 }
                boolean r12 = r12.isEmpty()     // Catch:{ all -> 0x00b6 }
                if (r12 != 0) goto L_0x008a
                com.uxcam.internals.dr r12 = com.uxcam.internals.C3078dr.this     // Catch:{ all -> 0x00b6 }
                java.util.Map r12 = r12.f1989d     // Catch:{ all -> 0x00b6 }
                java.util.Collection r12 = r12.values()     // Catch:{ all -> 0x00b6 }
                com.uxcam.internals.dr r7 = com.uxcam.internals.C3078dr.this     // Catch:{ all -> 0x00b6 }
                java.util.Map r7 = r7.f1989d     // Catch:{ all -> 0x00b6 }
                int r7 = r7.size()     // Catch:{ all -> 0x00b6 }
                com.uxcam.internals.dt[] r7 = new com.uxcam.internals.C3096dt[r7]     // Catch:{ all -> 0x00b6 }
                java.lang.Object[] r12 = r12.toArray(r7)     // Catch:{ all -> 0x00b6 }
                r7 = r12
                com.uxcam.internals.dt[] r7 = (com.uxcam.internals.C3096dt[]) r7     // Catch:{ all -> 0x00b6 }
                goto L_0x008a
            L_0x0089:
                r1 = r4
            L_0x008a:
                java.util.concurrent.ExecutorService r12 = com.uxcam.internals.C3078dr.f1985a     // Catch:{ all -> 0x00b6 }
                com.uxcam.internals.dr$ac$2 r8 = new com.uxcam.internals.dr$ac$2     // Catch:{ all -> 0x00b6 }
                java.lang.String r9 = "OkHttp %s settings"
                java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x00b6 }
                com.uxcam.internals.dr r10 = com.uxcam.internals.C3078dr.this     // Catch:{ all -> 0x00b6 }
                java.lang.String r10 = r10.f1990e     // Catch:{ all -> 0x00b6 }
                r6[r3] = r10     // Catch:{ all -> 0x00b6 }
                r8.<init>(r9, r6)     // Catch:{ all -> 0x00b6 }
                r12.execute(r8)     // Catch:{ all -> 0x00b6 }
                monitor-exit(r0)     // Catch:{ all -> 0x00b6 }
                if (r7 == 0) goto L_0x00b5
                int r12 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
                if (r12 == 0) goto L_0x00b5
                int r12 = r7.length
            L_0x00a6:
                if (r3 >= r12) goto L_0x00b5
                r0 = r7[r3]
                monitor-enter(r0)
                r0.mo38278a((long) r1)     // Catch:{ all -> 0x00b2 }
                monitor-exit(r0)     // Catch:{ all -> 0x00b2 }
                int r3 = r3 + 1
                goto L_0x00a6
            L_0x00b2:
                r12 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x00b2 }
                throw r12
            L_0x00b5:
                return
            L_0x00b6:
                r12 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x00b6 }
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C3078dr.C3089ac.mo38272a(com.uxcam.internals.dy):void");
        }

        /* renamed from: a */
        public final void mo38273a(boolean z, int i, int i2) {
            if (z) {
                C3103dw c = C3078dr.this.mo38263c(i);
                if (c == null) {
                    return;
                }
                if (c.f2100c != -1 || c.f2099b == -1) {
                    throw new IllegalStateException();
                }
                c.f2100c = System.nanoTime();
                c.f2098a.countDown();
                return;
            }
            C3078dr drVar = C3078dr.this;
            C3078dr.f1985a.execute(new C3029ck("OkHttp %s ping %08x%08x", new Object[]{drVar.f1990e, Integer.valueOf(i), Integer.valueOf(i2)}, i, i2) {

                /* renamed from: a */
                final /* synthetic */ boolean f2013a = true;

                /* renamed from: c */
                final /* synthetic */ int f2014c;

                /* renamed from: d */
                final /* synthetic */ int f2015d;

                /* renamed from: e */
                final /* synthetic */ C3103dw f2016e;

                {
                    this.f2014c = r4;
                    this.f2015d = r5;
                    this.f2016e = null;
                }

                /* renamed from: b */
                public final void mo38164b() {
                    try {
                        C3078dr.this.mo38259a(this.f2013a, this.f2014c, this.f2015d, this.f2016e);
                    } catch (IOException unused) {
                    }
                }
            });
        }

        /* renamed from: a */
        public final void mo38274a(boolean z, int i, C3132ep epVar, int i2) {
            if (C3078dr.m1571d(i)) {
                C3078dr drVar = C3078dr.this;
                C3130en enVar = new C3130en();
                long j = (long) i2;
                epVar.mo38360a(j);
                epVar.mo38196a(enVar, j);
                if (enVar.f2158b == j) {
                    drVar.f1994i.execute(new C3029ck("OkHttp %s Push Data[%s]", new Object[]{drVar.f1990e, Integer.valueOf(i)}, i, enVar, i2, z) {

                        /* renamed from: a */
                        final /* synthetic */ int f2025a;

                        /* renamed from: c */
                        final /* synthetic */ C3130en f2026c;

                        /* renamed from: d */
                        final /* synthetic */ int f2027d;

                        /* renamed from: e */
                        final /* synthetic */ boolean f2028e;

                        {
                            this.f2025a = r4;
                            this.f2026c = r5;
                            this.f2027d = r6;
                            this.f2028e = r7;
                        }

                        /* renamed from: b */
                        public final void mo38164b() {
                            try {
                                C3078dr.this.f1995j.mo38307a(this.f2026c, this.f2027d);
                                C3078dr.this.f2002q.mo38296a(this.f2025a, C3070dm.CANCEL);
                                synchronized (C3078dr.this) {
                                    C3078dr.this.f2004s.remove(Integer.valueOf(this.f2025a));
                                }
                            } catch (IOException unused) {
                            }
                        }
                    });
                    return;
                }
                throw new IOException(enVar.f2158b + " != " + i2);
            }
            C3096dt a = C3078dr.this.mo38253a(i);
            if (a == null) {
                C3078dr.this.mo38256a(i, C3070dm.PROTOCOL_ERROR);
                epVar.mo38382f((long) i2);
            } else if (C3096dt.f2059k || !Thread.holdsLock(a)) {
                a.f2065f.mo38290a(epVar, (long) i2);
                if (z) {
                    a.mo38286e();
                }
            } else {
                throw new AssertionError();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0088, code lost:
            if (com.uxcam.internals.C3096dt.f2059k != false) goto L_0x0097;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x008e, code lost:
            if (java.lang.Thread.holdsLock(r4) != false) goto L_0x0091;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0096, code lost:
            throw new java.lang.AssertionError();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0097, code lost:
            monitor-enter(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x009a, code lost:
            if (r4.f2064e != null) goto L_0x00a6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x009c, code lost:
            r4.f2064e = r15;
            r2 = r4.mo38280a();
            r4.notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a6, code lost:
            r14 = new java.util.ArrayList();
            r14.addAll(r4.f2064e);
            r14.addAll(r15);
            r4.f2064e = r14;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b5, code lost:
            monitor-exit(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b6, code lost:
            if (r2 != false) goto L_0x00bf;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b8, code lost:
            r4.f2063d.mo38260b(r4.f2062c);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00bf, code lost:
            if (r13 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00c1, code lost:
            r4.mo38286e();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
            return;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void mo38275a(boolean r13, int r14, java.util.List r15) {
            /*
                r12 = this;
                boolean r0 = com.uxcam.internals.C3078dr.m1571d(r14)
                r1 = 0
                r2 = 1
                r3 = 2
                if (r0 == 0) goto L_0x0028
                com.uxcam.internals.dr r5 = com.uxcam.internals.C3078dr.this
                java.util.concurrent.ExecutorService r0 = r5.f1994i
                com.uxcam.internals.dr$5 r11 = new com.uxcam.internals.dr$5
                java.lang.String r6 = "OkHttp %s Push Headers[%s]"
                java.lang.Object[] r7 = new java.lang.Object[r3]
                java.lang.String r3 = r5.f1990e
                r7[r1] = r3
                java.lang.Integer r1 = java.lang.Integer.valueOf(r14)
                r7[r2] = r1
                r4 = r11
                r8 = r14
                r9 = r15
                r10 = r13
                r4.<init>(r6, r7, r8, r9, r10)
                r0.execute(r11)
                return
            L_0x0028:
                com.uxcam.internals.dr r0 = com.uxcam.internals.C3078dr.this
                monitor-enter(r0)
                com.uxcam.internals.dr r4 = com.uxcam.internals.C3078dr.this     // Catch:{ all -> 0x00c8 }
                boolean r4 = r4.f1993h     // Catch:{ all -> 0x00c8 }
                if (r4 == 0) goto L_0x0033
                monitor-exit(r0)     // Catch:{ all -> 0x00c8 }
                return
            L_0x0033:
                com.uxcam.internals.dr r4 = com.uxcam.internals.C3078dr.this     // Catch:{ all -> 0x00c8 }
                com.uxcam.internals.dt r4 = r4.mo38253a((int) r14)     // Catch:{ all -> 0x00c8 }
                if (r4 != 0) goto L_0x0085
                com.uxcam.internals.dr r4 = com.uxcam.internals.C3078dr.this     // Catch:{ all -> 0x00c8 }
                int r4 = r4.f1991f     // Catch:{ all -> 0x00c8 }
                if (r14 > r4) goto L_0x0043
                monitor-exit(r0)     // Catch:{ all -> 0x00c8 }
                return
            L_0x0043:
                int r4 = r14 % 2
                com.uxcam.internals.dr r5 = com.uxcam.internals.C3078dr.this     // Catch:{ all -> 0x00c8 }
                int r5 = r5.f1992g     // Catch:{ all -> 0x00c8 }
                int r5 = r5 % r3
                if (r4 != r5) goto L_0x004e
                monitor-exit(r0)     // Catch:{ all -> 0x00c8 }
                return
            L_0x004e:
                com.uxcam.internals.dt r10 = new com.uxcam.internals.dt     // Catch:{ all -> 0x00c8 }
                com.uxcam.internals.dr r6 = com.uxcam.internals.C3078dr.this     // Catch:{ all -> 0x00c8 }
                r7 = 0
                r4 = r10
                r5 = r14
                r8 = r13
                r9 = r15
                r4.<init>(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00c8 }
                com.uxcam.internals.dr r13 = com.uxcam.internals.C3078dr.this     // Catch:{ all -> 0x00c8 }
                r13.f1991f = r14     // Catch:{ all -> 0x00c8 }
                com.uxcam.internals.dr r13 = com.uxcam.internals.C3078dr.this     // Catch:{ all -> 0x00c8 }
                java.util.Map r13 = r13.f1989d     // Catch:{ all -> 0x00c8 }
                java.lang.Integer r15 = java.lang.Integer.valueOf(r14)     // Catch:{ all -> 0x00c8 }
                r13.put(r15, r10)     // Catch:{ all -> 0x00c8 }
                java.util.concurrent.ExecutorService r13 = com.uxcam.internals.C3078dr.f1985a     // Catch:{ all -> 0x00c8 }
                com.uxcam.internals.dr$ac$1 r15 = new com.uxcam.internals.dr$ac$1     // Catch:{ all -> 0x00c8 }
                java.lang.String r4 = "OkHttp %s stream %d"
                java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x00c8 }
                com.uxcam.internals.dr r5 = com.uxcam.internals.C3078dr.this     // Catch:{ all -> 0x00c8 }
                java.lang.String r5 = r5.f1990e     // Catch:{ all -> 0x00c8 }
                r3[r1] = r5     // Catch:{ all -> 0x00c8 }
                java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ all -> 0x00c8 }
                r3[r2] = r14     // Catch:{ all -> 0x00c8 }
                r15.<init>(r4, r3, r10)     // Catch:{ all -> 0x00c8 }
                r13.execute(r15)     // Catch:{ all -> 0x00c8 }
                monitor-exit(r0)     // Catch:{ all -> 0x00c8 }
                return
            L_0x0085:
                monitor-exit(r0)     // Catch:{ all -> 0x00c8 }
                boolean r14 = com.uxcam.internals.C3096dt.f2059k
                if (r14 != 0) goto L_0x0097
                boolean r14 = java.lang.Thread.holdsLock(r4)
                if (r14 != 0) goto L_0x0091
                goto L_0x0097
            L_0x0091:
                java.lang.AssertionError r13 = new java.lang.AssertionError
                r13.<init>()
                throw r13
            L_0x0097:
                monitor-enter(r4)
                java.util.List r14 = r4.f2064e     // Catch:{ all -> 0x00c5 }
                if (r14 != 0) goto L_0x00a6
                r4.f2064e = r15     // Catch:{ all -> 0x00c5 }
                boolean r2 = r4.mo38280a()     // Catch:{ all -> 0x00c5 }
                r4.notifyAll()     // Catch:{ all -> 0x00c5 }
                goto L_0x00b5
            L_0x00a6:
                java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x00c5 }
                r14.<init>()     // Catch:{ all -> 0x00c5 }
                java.util.List r0 = r4.f2064e     // Catch:{ all -> 0x00c5 }
                r14.addAll(r0)     // Catch:{ all -> 0x00c5 }
                r14.addAll(r15)     // Catch:{ all -> 0x00c5 }
                r4.f2064e = r14     // Catch:{ all -> 0x00c5 }
            L_0x00b5:
                monitor-exit(r4)     // Catch:{ all -> 0x00c5 }
                if (r2 != 0) goto L_0x00bf
                com.uxcam.internals.dr r14 = r4.f2063d
                int r15 = r4.f2062c
                r14.mo38260b(r15)
            L_0x00bf:
                if (r13 == 0) goto L_0x00c4
                r4.mo38286e()
            L_0x00c4:
                return
            L_0x00c5:
                r13 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x00c5 }
                throw r13
            L_0x00c8:
                r13 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x00c8 }
                throw r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C3078dr.C3089ac.mo38275a(boolean, int, java.util.List):void");
        }

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x006f */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void mo38164b() {
            /*
                r10 = this;
                com.uxcam.internals.dm r0 = com.uxcam.internals.C3070dm.INTERNAL_ERROR
                com.uxcam.internals.dm r1 = com.uxcam.internals.C3070dm.INTERNAL_ERROR
                com.uxcam.internals.dr r2 = com.uxcam.internals.C3078dr.this     // Catch:{ IOException -> 0x006f }
                boolean r2 = r2.f1987b     // Catch:{ IOException -> 0x006f }
                if (r2 != 0) goto L_0x0054
                com.uxcam.internals.ds r2 = r10.f2041a     // Catch:{ IOException -> 0x006f }
                boolean r3 = r2.f2050c     // Catch:{ IOException -> 0x006f }
                if (r3 != 0) goto L_0x0054
                com.uxcam.internals.ep r2 = r2.f2049b     // Catch:{ IOException -> 0x006f }
                com.uxcam.internals.eq r3 = com.uxcam.internals.C3075dp.f1966a     // Catch:{ IOException -> 0x006f }
                int r3 = r3.mo38415g()     // Catch:{ IOException -> 0x006f }
                long r3 = (long) r3     // Catch:{ IOException -> 0x006f }
                com.uxcam.internals.eq r2 = r2.mo38370c(r3)     // Catch:{ IOException -> 0x006f }
                java.util.logging.Logger r3 = com.uxcam.internals.C3093ds.f2048a     // Catch:{ IOException -> 0x006f }
                java.util.logging.Level r4 = java.util.logging.Level.FINE     // Catch:{ IOException -> 0x006f }
                boolean r3 = r3.isLoggable(r4)     // Catch:{ IOException -> 0x006f }
                r4 = 0
                r5 = 1
                if (r3 == 0) goto L_0x003c
                java.util.logging.Logger r3 = com.uxcam.internals.C3093ds.f2048a     // Catch:{ IOException -> 0x006f }
                java.lang.String r6 = "<< CONNECTION %s"
                java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch:{ IOException -> 0x006f }
                java.lang.String r8 = r2.mo38412e()     // Catch:{ IOException -> 0x006f }
                r7[r4] = r8     // Catch:{ IOException -> 0x006f }
                java.lang.String r6 = com.uxcam.internals.C3030cl.m1422a((java.lang.String) r6, (java.lang.Object[]) r7)     // Catch:{ IOException -> 0x006f }
                r3.fine(r6)     // Catch:{ IOException -> 0x006f }
            L_0x003c:
                com.uxcam.internals.eq r3 = com.uxcam.internals.C3075dp.f1966a     // Catch:{ IOException -> 0x006f }
                boolean r3 = r3.equals(r2)     // Catch:{ IOException -> 0x006f }
                if (r3 == 0) goto L_0x0045
                goto L_0x0054
            L_0x0045:
                java.lang.String r3 = "Expected a connection header but was %s"
                java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ IOException -> 0x006f }
                java.lang.String r2 = r2.mo38404a()     // Catch:{ IOException -> 0x006f }
                r5[r4] = r2     // Catch:{ IOException -> 0x006f }
                java.io.IOException r2 = com.uxcam.internals.C3075dp.m1564b(r3, r5)     // Catch:{ IOException -> 0x006f }
                throw r2     // Catch:{ IOException -> 0x006f }
            L_0x0054:
                com.uxcam.internals.ds r2 = r10.f2041a     // Catch:{ IOException -> 0x006f }
                boolean r2 = r2.mo38276a((com.uxcam.internals.C3093ds.C3095ab) r10)     // Catch:{ IOException -> 0x006f }
                if (r2 != 0) goto L_0x0054
                com.uxcam.internals.dm r2 = com.uxcam.internals.C3070dm.NO_ERROR     // Catch:{ IOException -> 0x006f }
                com.uxcam.internals.dm r0 = com.uxcam.internals.C3070dm.CANCEL     // Catch:{ IOException -> 0x006b }
                com.uxcam.internals.dr r1 = com.uxcam.internals.C3078dr.this     // Catch:{ IOException -> 0x0065 }
            L_0x0062:
                r1.mo38258a((com.uxcam.internals.C3070dm) r2, (com.uxcam.internals.C3070dm) r0)     // Catch:{ IOException -> 0x0065 }
            L_0x0065:
                com.uxcam.internals.ds r0 = r10.f2041a
                com.uxcam.internals.C3030cl.m1428a((java.io.Closeable) r0)
                return
            L_0x006b:
                r0 = r2
                goto L_0x006f
            L_0x006d:
                r2 = move-exception
                goto L_0x007a
            L_0x006f:
                com.uxcam.internals.dm r2 = com.uxcam.internals.C3070dm.PROTOCOL_ERROR     // Catch:{ all -> 0x006d }
                com.uxcam.internals.dm r0 = com.uxcam.internals.C3070dm.PROTOCOL_ERROR     // Catch:{ all -> 0x0076 }
                com.uxcam.internals.dr r1 = com.uxcam.internals.C3078dr.this     // Catch:{ IOException -> 0x0065 }
                goto L_0x0062
            L_0x0076:
                r0 = move-exception
                r9 = r2
                r2 = r0
                r0 = r9
            L_0x007a:
                com.uxcam.internals.dr r3 = com.uxcam.internals.C3078dr.this     // Catch:{ IOException -> 0x007f }
                r3.mo38258a((com.uxcam.internals.C3070dm) r0, (com.uxcam.internals.C3070dm) r1)     // Catch:{ IOException -> 0x007f }
            L_0x007f:
                com.uxcam.internals.ds r0 = r10.f2041a
                com.uxcam.internals.C3030cl.m1428a((java.io.Closeable) r0)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C3078dr.C3089ac.mo38164b():void");
        }
    }

    C3078dr(C3086aa aaVar) {
        this.f1995j = aaVar.f2038f;
        this.f1987b = aaVar.f2039g;
        this.f1988c = aaVar.f2037e;
        int i = 2;
        this.f1992g = aaVar.f2039g ? 1 : 2;
        if (aaVar.f2039g) {
            this.f1992g += 2;
        }
        this.f2006v = aaVar.f2039g ? 1 : i;
        if (aaVar.f2039g) {
            this.f1998m.mo38309a(7, 16777216);
        }
        this.f1990e = aaVar.f2034b;
        this.f1994i = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), C3030cl.m1426a(C3030cl.m1422a("OkHttp %s Push Observer", this.f1990e), true));
        this.f1999n.mo38309a(7, 65535);
        this.f1999n.mo38309a(5, 16384);
        this.f1997l = (long) this.f1999n.mo38311b();
        this.f2001p = aaVar.f2033a;
        this.f2002q = new C3100du(aaVar.f2036d, this.f1987b);
        this.f2003r = new C3089ac(new C3093ds(aaVar.f2035c, this.f1987b));
    }

    /* renamed from: a */
    private void m1570a(C3070dm dmVar) {
        synchronized (this.f2002q) {
            synchronized (this) {
                if (!this.f1993h) {
                    this.f1993h = true;
                    int i = this.f1991f;
                    this.f2002q.mo38297a(i, dmVar, C3030cl.f1780a);
                }
            }
        }
    }

    /* renamed from: d */
    static boolean m1571d(int i) {
        return i != 0 && (i & 1) == 0;
    }

    /* renamed from: a */
    public final synchronized int mo38252a() {
        C3106dy dyVar = this.f1999n;
        if ((dyVar.f2102a & 16) == 0) {
            return Integer.MAX_VALUE;
        }
        return dyVar.f2103b[4];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized C3096dt mo38253a(int i) {
        return (C3096dt) this.f1989d.get(Integer.valueOf(i));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0037  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.uxcam.internals.C3096dt mo38254a(java.util.List r11, boolean r12) {
        /*
            r10 = this;
            r6 = r12 ^ 1
            com.uxcam.internals.du r7 = r10.f2002q
            monitor-enter(r7)
            monitor-enter(r10)     // Catch:{ all -> 0x0058 }
            boolean r0 = r10.f1993h     // Catch:{ all -> 0x0055 }
            if (r0 != 0) goto L_0x004f
            int r8 = r10.f1992g     // Catch:{ all -> 0x0055 }
            int r0 = r10.f1992g     // Catch:{ all -> 0x0055 }
            int r0 = r0 + 2
            r10.f1992g = r0     // Catch:{ all -> 0x0055 }
            com.uxcam.internals.dt r9 = new com.uxcam.internals.dt     // Catch:{ all -> 0x0055 }
            r4 = 0
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r5 = r11
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0055 }
            if (r12 == 0) goto L_0x0030
            long r0 = r10.f1997l     // Catch:{ all -> 0x0055 }
            r2 = 0
            int r12 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r12 == 0) goto L_0x0030
            long r0 = r9.f2061b     // Catch:{ all -> 0x0055 }
            int r12 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r12 != 0) goto L_0x002e
            goto L_0x0030
        L_0x002e:
            r12 = 0
            goto L_0x0031
        L_0x0030:
            r12 = 1
        L_0x0031:
            boolean r0 = r9.mo38280a()     // Catch:{ all -> 0x0055 }
            if (r0 == 0) goto L_0x0040
            java.util.Map r0 = r10.f1989d     // Catch:{ all -> 0x0055 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0055 }
            r0.put(r1, r9)     // Catch:{ all -> 0x0055 }
        L_0x0040:
            monitor-exit(r10)     // Catch:{ all -> 0x0055 }
            com.uxcam.internals.du r0 = r10.f2002q     // Catch:{ all -> 0x0058 }
            r0.mo38301a((boolean) r6, (int) r8, (java.util.List) r11)     // Catch:{ all -> 0x0058 }
            monitor-exit(r7)     // Catch:{ all -> 0x0058 }
            if (r12 == 0) goto L_0x004e
            com.uxcam.internals.du r11 = r10.f2002q
            r11.mo38302b()
        L_0x004e:
            return r9
        L_0x004f:
            com.uxcam.internals.dl r11 = new com.uxcam.internals.dl     // Catch:{ all -> 0x0055 }
            r11.<init>()     // Catch:{ all -> 0x0055 }
            throw r11     // Catch:{ all -> 0x0055 }
        L_0x0055:
            r11 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0055 }
            throw r11     // Catch:{ all -> 0x0058 }
        L_0x0058:
            r11 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0058 }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C3078dr.mo38254a(java.util.List, boolean):com.uxcam.internals.dt");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo38255a(int i, long j) {
        final int i2 = i;
        final long j2 = j;
        f1985a.execute(new C3029ck("OkHttp Window Update %s stream %d", new Object[]{this.f1990e, Integer.valueOf(i)}) {
            /* renamed from: b */
            public final void mo38164b() {
                try {
                    C3078dr.this.f2002q.mo38295a(i2, j2);
                } catch (IOException unused) {
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo38256a(int i, C3070dm dmVar) {
        final int i2 = i;
        final C3070dm dmVar2 = dmVar;
        f1985a.execute(new C3029ck("OkHttp %s stream %d", new Object[]{this.f1990e, Integer.valueOf(i)}) {
            /* renamed from: b */
            public final void mo38164b() {
                try {
                    C3078dr.this.mo38262b(i2, dmVar2);
                } catch (IOException unused) {
                }
            }
        });
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:26|27|28) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r8.f1997l), r8.f2002q.f2085a);
        r6 = (long) r3;
        r8.f1997l -= r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005e, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0059 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo38257a(int r9, boolean r10, com.uxcam.internals.C3130en r11, long r12) {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x000d
            com.uxcam.internals.du r12 = r8.f2002q
            r12.mo38300a((boolean) r10, (int) r9, (com.uxcam.internals.C3130en) r11, (int) r0)
            return
        L_0x000d:
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x0061
            monitor-enter(r8)
        L_0x0012:
            long r3 = r8.f1997l     // Catch:{ InterruptedException -> 0x0059 }
            int r3 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r3 > 0) goto L_0x0030
            java.util.Map r3 = r8.f1989d     // Catch:{ InterruptedException -> 0x0059 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch:{ InterruptedException -> 0x0059 }
            boolean r3 = r3.containsKey(r4)     // Catch:{ InterruptedException -> 0x0059 }
            if (r3 == 0) goto L_0x0028
            r8.wait()     // Catch:{ InterruptedException -> 0x0059 }
            goto L_0x0012
        L_0x0028:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ InterruptedException -> 0x0059 }
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch:{ InterruptedException -> 0x0059 }
            throw r9     // Catch:{ InterruptedException -> 0x0059 }
        L_0x0030:
            long r3 = r8.f1997l     // Catch:{ all -> 0x0057 }
            long r3 = java.lang.Math.min(r12, r3)     // Catch:{ all -> 0x0057 }
            int r3 = (int) r3     // Catch:{ all -> 0x0057 }
            com.uxcam.internals.du r4 = r8.f2002q     // Catch:{ all -> 0x0057 }
            int r4 = r4.f2085a     // Catch:{ all -> 0x0057 }
            int r3 = java.lang.Math.min(r3, r4)     // Catch:{ all -> 0x0057 }
            long r4 = r8.f1997l     // Catch:{ all -> 0x0057 }
            long r6 = (long) r3     // Catch:{ all -> 0x0057 }
            long r4 = r4 - r6
            r8.f1997l = r4     // Catch:{ all -> 0x0057 }
            monitor-exit(r8)     // Catch:{ all -> 0x0057 }
            r4 = 0
            long r12 = r12 - r6
            com.uxcam.internals.du r4 = r8.f2002q
            if (r10 == 0) goto L_0x0052
            int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r5 != 0) goto L_0x0052
            r5 = 1
            goto L_0x0053
        L_0x0052:
            r5 = 0
        L_0x0053:
            r4.mo38300a((boolean) r5, (int) r9, (com.uxcam.internals.C3130en) r11, (int) r3)
            goto L_0x000d
        L_0x0057:
            r9 = move-exception
            goto L_0x005f
        L_0x0059:
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch:{ all -> 0x0057 }
            r9.<init>()     // Catch:{ all -> 0x0057 }
            throw r9     // Catch:{ all -> 0x0057 }
        L_0x005f:
            monitor-exit(r8)     // Catch:{ all -> 0x0057 }
            throw r9
        L_0x0061:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C3078dr.mo38257a(int, boolean, com.uxcam.internals.en, long):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo38258a(C3070dm dmVar, C3070dm dmVar2) {
        C3096dt[] dtVarArr;
        if (f1986t || !Thread.holdsLock(this)) {
            C3103dw[] dwVarArr = null;
            try {
                m1570a(dmVar);
                e = null;
            } catch (IOException e) {
                e = e;
            }
            synchronized (this) {
                if (!this.f1989d.isEmpty()) {
                    dtVarArr = (C3096dt[]) this.f1989d.values().toArray(new C3096dt[this.f1989d.size()]);
                    this.f1989d.clear();
                } else {
                    dtVarArr = null;
                }
                if (this.f2005u != null) {
                    this.f2005u = null;
                    dwVarArr = (C3103dw[]) this.f2005u.values().toArray(new C3103dw[this.f2005u.size()]);
                }
            }
            if (dtVarArr != null) {
                IOException iOException = e;
                for (C3096dt a : dtVarArr) {
                    try {
                        a.mo38279a(dmVar2);
                    } catch (IOException e2) {
                        if (iOException != null) {
                            iOException = e2;
                        }
                    }
                }
                e = iOException;
            }
            if (dwVarArr != null) {
                for (C3103dw a2 : dwVarArr) {
                    a2.mo38306a();
                }
            }
            try {
                this.f2002q.close();
            } catch (IOException e3) {
                if (e == null) {
                    e = e3;
                }
            }
            try {
                this.f2001p.close();
            } catch (IOException e4) {
                e = e4;
            }
            if (e != null) {
                throw e;
            }
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo38259a(boolean z, int i, int i2, C3103dw dwVar) {
        synchronized (this.f2002q) {
            if (dwVar != null) {
                try {
                    if (dwVar.f2099b == -1) {
                        dwVar.f2099b = System.nanoTime();
                    } else {
                        throw new IllegalStateException();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.f2002q.mo38299a(z, i, i2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final synchronized C3096dt mo38260b(int i) {
        C3096dt dtVar;
        dtVar = (C3096dt) this.f1989d.remove(Integer.valueOf(i));
        notifyAll();
        return dtVar;
    }

    /* renamed from: b */
    public final void mo38261b() {
        this.f2002q.mo38294a();
        this.f2002q.mo38303b(this.f1998m);
        int b = this.f1998m.mo38311b();
        if (b != 65535) {
            this.f2002q.mo38295a(0, (long) (b - 65535));
        }
        new Thread(this.f2003r).start();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo38262b(int i, C3070dm dmVar) {
        this.f2002q.mo38296a(i, dmVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final synchronized C3103dw mo38263c(int i) {
        if (this.f2005u == null) {
            return null;
        }
        return (C3103dw) this.f2005u.remove(Integer.valueOf(i));
    }

    /* renamed from: c */
    public final synchronized boolean mo38264c() {
        return this.f1993h;
    }

    public final void close() {
        mo38258a(C3070dm.NO_ERROR, C3070dm.CANCEL);
    }
}
