package com.uxcam.internals;

import com.uxcam.internals.C3000bv;

/* renamed from: com.uxcam.internals.cd */
public final class C3017cd {

    /* renamed from: a */
    public final C3002bw f1723a;

    /* renamed from: b */
    public final String f1724b;

    /* renamed from: c */
    public final C3000bv f1725c;

    /* renamed from: d */
    public final C3019ce f1726d;

    /* renamed from: e */
    final Object f1727e;

    /* renamed from: f */
    private volatile C2978bh f1728f;

    /* renamed from: com.uxcam.internals.cd$aa */
    public static class C3018aa {

        /* renamed from: a */
        C3002bw f1729a;

        /* renamed from: b */
        String f1730b;

        /* renamed from: c */
        public C3000bv.C3001aa f1731c;

        /* renamed from: d */
        C3019ce f1732d;

        /* renamed from: e */
        Object f1733e;

        public C3018aa() {
            this.f1730b = "GET";
            this.f1731c = new C3000bv.C3001aa();
        }

        C3018aa(C3017cd cdVar) {
            this.f1729a = cdVar.f1723a;
            this.f1730b = cdVar.f1724b;
            this.f1732d = cdVar.f1726d;
            this.f1733e = cdVar.f1727e;
            this.f1731c = cdVar.f1725c.mo38111a();
        }

        /* renamed from: a */
        public final C3018aa mo38169a(C3002bw bwVar) {
            if (bwVar != null) {
                this.f1729a = bwVar;
                return this;
            }
            throw new NullPointerException("url == null");
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x003f  */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0044  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.uxcam.internals.C3017cd.C3018aa mo38170a(java.lang.String r7) {
            /*
                r6 = this;
                if (r7 == 0) goto L_0x0054
                r1 = 1
                r2 = 0
                java.lang.String r3 = "ws:"
                r4 = 0
                r5 = 3
                r0 = r7
                boolean r0 = r0.regionMatches(r1, r2, r3, r4, r5)
                if (r0 == 0) goto L_0x0023
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r1 = "http:"
                r0.<init>(r1)
                r1 = 3
            L_0x0017:
                java.lang.String r7 = r7.substring(r1)
                r0.append(r7)
                java.lang.String r7 = r0.toString()
                goto L_0x0039
            L_0x0023:
                r1 = 1
                r2 = 0
                java.lang.String r3 = "wss:"
                r4 = 0
                r5 = 4
                r0 = r7
                boolean r0 = r0.regionMatches(r1, r2, r3, r4, r5)
                if (r0 == 0) goto L_0x0039
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r1 = "https:"
                r0.<init>(r1)
                r1 = 4
                goto L_0x0017
            L_0x0039:
                com.uxcam.internals.bw r0 = com.uxcam.internals.C3002bw.m1305d(r7)
                if (r0 == 0) goto L_0x0044
                com.uxcam.internals.cd$aa r7 = r6.mo38169a((com.uxcam.internals.C3002bw) r0)
                return r7
            L_0x0044:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.String r7 = java.lang.String.valueOf(r7)
                java.lang.String r1 = "unexpected url: "
                java.lang.String r7 = r1.concat(r7)
                r0.<init>(r7)
                throw r0
            L_0x0054:
                java.lang.NullPointerException r7 = new java.lang.NullPointerException
                java.lang.String r0 = "url == null"
                r7.<init>(r0)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C3017cd.C3018aa.mo38170a(java.lang.String):com.uxcam.internals.cd$aa");
        }

        /* renamed from: a */
        public final C3018aa mo38171a(String str, C3019ce ceVar) {
            if (str == null) {
                throw new NullPointerException("method == null");
            } else if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            } else if (ceVar != null && !C3055dd.m1507b(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            } else if (ceVar != null || !C3055dd.m1506a(str)) {
                this.f1730b = str;
                this.f1732d = ceVar;
                return this;
            } else {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
        }

        /* renamed from: a */
        public final C3018aa mo38172a(String str, String str2) {
            C3000bv.C3001aa aaVar = this.f1731c;
            C3000bv.C3001aa.m1289b(str, str2);
            aaVar.mo38118a(str);
            aaVar.mo38119a(str, str2);
            return this;
        }

        /* renamed from: a */
        public final C3017cd mo38173a() {
            if (this.f1729a != null) {
                return new C3017cd(this);
            }
            throw new IllegalStateException("url == null");
        }

        /* renamed from: b */
        public final C3018aa mo38174b(String str) {
            this.f1731c.mo38118a(str);
            return this;
        }
    }

    C3017cd(C3018aa aaVar) {
        this.f1723a = aaVar.f1729a;
        this.f1724b = aaVar.f1730b;
        this.f1725c = aaVar.f1731c.mo38120a();
        this.f1726d = aaVar.f1732d;
        this.f1727e = aaVar.f1733e != null ? aaVar.f1733e : this;
    }

    /* renamed from: a */
    public final C3018aa mo38165a() {
        return new C3018aa(this);
    }

    /* renamed from: a */
    public final String mo38166a(String str) {
        return this.f1725c.mo38113a(str);
    }

    /* renamed from: b */
    public final C2978bh mo38167b() {
        C2978bh bhVar = this.f1728f;
        if (bhVar != null) {
            return bhVar;
        }
        C2978bh a = C2978bh.m1244a(this.f1725c);
        this.f1728f = a;
        return a;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Request{method=");
        sb.append(this.f1724b);
        sb.append(", url=");
        sb.append(this.f1723a);
        sb.append(", tag=");
        sb.append(this.f1727e != this ? this.f1727e : null);
        sb.append('}');
        return sb.toString();
    }
}
