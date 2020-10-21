package com.uxcam.internals;

import java.util.Date;

/* renamed from: com.uxcam.internals.co */
public final class C3035co {

    /* renamed from: a */
    public final C3017cd f1804a;

    /* renamed from: b */
    public final C3022cf f1805b;

    /* renamed from: com.uxcam.internals.co$aa */
    public static class C3036aa {

        /* renamed from: a */
        final long f1806a;

        /* renamed from: b */
        final C3017cd f1807b;

        /* renamed from: c */
        final C3022cf f1808c;

        /* renamed from: d */
        Date f1809d;

        /* renamed from: e */
        String f1810e;

        /* renamed from: f */
        Date f1811f;

        /* renamed from: g */
        String f1812g;

        /* renamed from: h */
        Date f1813h;

        /* renamed from: i */
        long f1814i;

        /* renamed from: j */
        long f1815j;

        /* renamed from: k */
        String f1816k;

        /* renamed from: l */
        int f1817l = -1;

        public C3036aa(long j, C3017cd cdVar, C3022cf cfVar) {
            this.f1806a = j;
            this.f1807b = cdVar;
            this.f1808c = cfVar;
            if (cfVar != null) {
                this.f1814i = cfVar.f1750k;
                this.f1815j = cfVar.f1751l;
                C3000bv bvVar = cfVar.f1745f;
                int length = bvVar.f1606a.length / 2;
                for (int i = 0; i < length; i++) {
                    String a = bvVar.mo38112a(i);
                    String b = bvVar.mo38114b(i);
                    if ("Date".equalsIgnoreCase(a)) {
                        this.f1809d = C3052db.m1497a(b);
                        this.f1810e = b;
                    } else if ("Expires".equalsIgnoreCase(a)) {
                        this.f1813h = C3052db.m1497a(b);
                    } else if ("Last-Modified".equalsIgnoreCase(a)) {
                        this.f1811f = C3052db.m1497a(b);
                        this.f1812g = b;
                    } else if ("ETag".equalsIgnoreCase(a)) {
                        this.f1816k = b;
                    } else if ("Age".equalsIgnoreCase(a)) {
                        this.f1817l = C3054dc.m1504b(b, -1);
                    }
                }
            }
        }
    }

    C3035co(C3017cd cdVar, C3022cf cfVar) {
        this.f1804a = cdVar;
        this.f1805b = cfVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
        if (r3.mo38179c().f1416f == false) goto L_0x003b;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m1446a(com.uxcam.internals.C3022cf r3, com.uxcam.internals.C3017cd r4) {
        /*
            int r0 = r3.f1742c
            r1 = 0
            switch(r0) {
                case 200: goto L_0x0029;
                case 203: goto L_0x0029;
                case 204: goto L_0x0029;
                case 300: goto L_0x0029;
                case 301: goto L_0x0029;
                case 302: goto L_0x0007;
                case 307: goto L_0x0007;
                case 308: goto L_0x0029;
                case 404: goto L_0x0029;
                case 405: goto L_0x0029;
                case 410: goto L_0x0029;
                case 414: goto L_0x0029;
                case 501: goto L_0x0029;
                default: goto L_0x0006;
            }
        L_0x0006:
            goto L_0x003b
        L_0x0007:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.mo38178b(r0)
            if (r0 != 0) goto L_0x0029
            com.uxcam.internals.bh r0 = r3.mo38179c()
            int r0 = r0.f1415e
            r2 = -1
            if (r0 != r2) goto L_0x0029
            com.uxcam.internals.bh r0 = r3.mo38179c()
            boolean r0 = r0.f1417g
            if (r0 != 0) goto L_0x0029
            com.uxcam.internals.bh r0 = r3.mo38179c()
            boolean r0 = r0.f1416f
            if (r0 != 0) goto L_0x0029
            goto L_0x003b
        L_0x0029:
            com.uxcam.internals.bh r3 = r3.mo38179c()
            boolean r3 = r3.f1414d
            if (r3 != 0) goto L_0x003b
            com.uxcam.internals.bh r3 = r4.mo38167b()
            boolean r3 = r3.f1414d
            if (r3 != 0) goto L_0x003b
            r3 = 1
            return r3
        L_0x003b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C3035co.m1446a(com.uxcam.internals.cf, com.uxcam.internals.cd):boolean");
    }
}
