package com.uxcam.internals;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.text.Typography;

/* renamed from: com.uxcam.internals.bz */
public final class C3008bz extends C3019ce {

    /* renamed from: a */
    public static final C3007by f1638a = C3007by.m1329a("multipart/mixed");

    /* renamed from: b */
    public static final C3007by f1639b = C3007by.m1329a("multipart/alternative");

    /* renamed from: c */
    public static final C3007by f1640c = C3007by.m1329a("multipart/digest");

    /* renamed from: d */
    public static final C3007by f1641d = C3007by.m1329a("multipart/parallel");

    /* renamed from: e */
    public static final C3007by f1642e = C3007by.m1329a("multipart/form-data");

    /* renamed from: f */
    private static final byte[] f1643f = {58, 32};

    /* renamed from: g */
    private static final byte[] f1644g = {13, 10};

    /* renamed from: h */
    private static final byte[] f1645h = {45, 45};

    /* renamed from: i */
    private final C3133eq f1646i;

    /* renamed from: j */
    private final C3007by f1647j;

    /* renamed from: k */
    private final C3007by f1648k;

    /* renamed from: l */
    private final List f1649l;

    /* renamed from: m */
    private long f1650m = -1;

    /* renamed from: com.uxcam.internals.bz$aa */
    public static final class C3009aa {

        /* renamed from: a */
        private final C3133eq f1651a;

        /* renamed from: b */
        private C3007by f1652b;

        /* renamed from: c */
        private final List f1653c;

        public C3009aa() {
            this(UUID.randomUUID().toString());
        }

        private C3009aa(String str) {
            this.f1652b = C3008bz.f1638a;
            this.f1653c = new ArrayList();
            this.f1651a = C3133eq.m1828a(str);
        }

        /* renamed from: a */
        private C3009aa m1335a(C3010ab abVar) {
            if (abVar != null) {
                this.f1653c.add(abVar);
                return this;
            }
            throw new NullPointerException("part == null");
        }

        /* renamed from: a */
        public final C3009aa mo38142a(C3007by byVar) {
            if (byVar == null) {
                throw new NullPointerException("type == null");
            } else if (byVar.f1634a.equals("multipart")) {
                this.f1652b = byVar;
                return this;
            } else {
                throw new IllegalArgumentException("multipart != ".concat(String.valueOf(byVar)));
            }
        }

        /* renamed from: a */
        public final C3009aa mo38143a(String str, String str2) {
            return m1335a(C3010ab.m1341a(str, str2));
        }

        /* renamed from: a */
        public final C3009aa mo38144a(String str, String str2, C3019ce ceVar) {
            return m1335a(C3010ab.m1342a(str, str2, ceVar));
        }

        /* renamed from: a */
        public final C3008bz mo38145a() {
            if (!this.f1653c.isEmpty()) {
                return new C3008bz(this.f1651a, this.f1652b, this.f1653c);
            }
            throw new IllegalStateException("Multipart body must have at least one part.");
        }
    }

    /* renamed from: com.uxcam.internals.bz$ab */
    public static final class C3010ab {

        /* renamed from: a */
        final C3000bv f1654a;

        /* renamed from: b */
        final C3019ce f1655b;

        private C3010ab(C3000bv bvVar, C3019ce ceVar) {
            this.f1654a = bvVar;
            this.f1655b = ceVar;
        }

        /* renamed from: a */
        private static C3010ab m1340a(C3000bv bvVar, C3019ce ceVar) {
            if (ceVar == null) {
                throw new NullPointerException("body == null");
            } else if (bvVar != null && bvVar.mo38113a("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            } else if (bvVar == null || bvVar.mo38113a("Content-Length") == null) {
                return new C3010ab(bvVar, ceVar);
            } else {
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
        }

        /* renamed from: a */
        public static C3010ab m1341a(String str, String str2) {
            return m1342a(str, (String) null, C3019ce.m1375a(str2));
        }

        /* renamed from: a */
        public static C3010ab m1342a(String str, String str2, C3019ce ceVar) {
            if (str != null) {
                StringBuilder sb = new StringBuilder("form-data; name=");
                C3008bz.m1331a(sb, str);
                if (str2 != null) {
                    sb.append("; filename=");
                    C3008bz.m1331a(sb, str2);
                }
                return m1340a(C3000bv.m1284a("Content-Disposition", sb.toString()), ceVar);
            }
            throw new NullPointerException("name == null");
        }
    }

    C3008bz(C3133eq eqVar, C3007by byVar, List list) {
        this.f1646i = eqVar;
        this.f1647j = byVar;
        this.f1648k = C3007by.m1329a(byVar + "; boundary=" + eqVar.mo38404a());
        this.f1649l = C3030cl.m1424a(list);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: com.uxcam.internals.eo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: com.uxcam.internals.en} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.uxcam.internals.en} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: com.uxcam.internals.eo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: com.uxcam.internals.en} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long m1330a(com.uxcam.internals.C3131eo r13, boolean r14) {
        /*
            r12 = this;
            if (r14 == 0) goto L_0x0009
            com.uxcam.internals.en r13 = new com.uxcam.internals.en
            r13.<init>()
            r0 = r13
            goto L_0x000a
        L_0x0009:
            r0 = 0
        L_0x000a:
            java.util.List r1 = r12.f1649l
            int r1 = r1.size()
            r2 = 0
            r3 = 0
            r4 = r3
            r3 = 0
        L_0x0015:
            if (r3 >= r1) goto L_0x00a8
            java.util.List r6 = r12.f1649l
            java.lang.Object r6 = r6.get(r3)
            com.uxcam.internals.bz$ab r6 = (com.uxcam.internals.C3008bz.C3010ab) r6
            com.uxcam.internals.bv r7 = r6.f1654a
            com.uxcam.internals.ce r6 = r6.f1655b
            byte[] r8 = f1645h
            r13.mo38365b((byte[]) r8)
            com.uxcam.internals.eq r8 = r12.f1646i
            r13.mo38369c(r8)
            byte[] r8 = f1644g
            r13.mo38365b((byte[]) r8)
            if (r7 == 0) goto L_0x005a
            java.lang.String[] r8 = r7.f1606a
            int r8 = r8.length
            int r8 = r8 / 2
            r9 = 0
        L_0x003a:
            if (r9 >= r8) goto L_0x005a
            java.lang.String r10 = r7.mo38112a((int) r9)
            com.uxcam.internals.eo r10 = r13.mo38364b((java.lang.String) r10)
            byte[] r11 = f1643f
            com.uxcam.internals.eo r10 = r10.mo38365b((byte[]) r11)
            java.lang.String r11 = r7.mo38114b(r9)
            com.uxcam.internals.eo r10 = r10.mo38364b((java.lang.String) r11)
            byte[] r11 = f1644g
            r10.mo38365b((byte[]) r11)
            int r9 = r9 + 1
            goto L_0x003a
        L_0x005a:
            com.uxcam.internals.by r7 = r6.mo38104a()
            if (r7 == 0) goto L_0x0073
            java.lang.String r8 = "Content-Type: "
            com.uxcam.internals.eo r8 = r13.mo38364b((java.lang.String) r8)
            java.lang.String r7 = r7.toString()
            com.uxcam.internals.eo r7 = r8.mo38364b((java.lang.String) r7)
            byte[] r8 = f1644g
            r7.mo38365b((byte[]) r8)
        L_0x0073:
            long r7 = r6.mo38106b()
            r9 = -1
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 == 0) goto L_0x008d
            java.lang.String r9 = "Content-Length: "
            com.uxcam.internals.eo r9 = r13.mo38364b((java.lang.String) r9)
            com.uxcam.internals.eo r9 = r9.mo38393j(r7)
            byte[] r10 = f1644g
            r9.mo38365b((byte[]) r10)
            goto L_0x0093
        L_0x008d:
            if (r14 == 0) goto L_0x0093
            r0.mo38398o()
            return r9
        L_0x0093:
            byte[] r9 = f1644g
            r13.mo38365b((byte[]) r9)
            if (r14 == 0) goto L_0x009c
            long r4 = r4 + r7
            goto L_0x009f
        L_0x009c:
            r6.mo38105a((com.uxcam.internals.C3131eo) r13)
        L_0x009f:
            byte[] r6 = f1644g
            r13.mo38365b((byte[]) r6)
            int r3 = r3 + 1
            goto L_0x0015
        L_0x00a8:
            byte[] r1 = f1645h
            r13.mo38365b((byte[]) r1)
            com.uxcam.internals.eq r1 = r12.f1646i
            r13.mo38369c(r1)
            byte[] r1 = f1645h
            r13.mo38365b((byte[]) r1)
            byte[] r1 = f1644g
            r13.mo38365b((byte[]) r1)
            if (r14 == 0) goto L_0x00c4
            long r13 = r0.f2158b
            long r4 = r4 + r13
            r0.mo38398o()
        L_0x00c4:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C3008bz.m1330a(com.uxcam.internals.eo, boolean):long");
    }

    /* renamed from: a */
    static StringBuilder m1331a(StringBuilder sb, String str) {
        String str2;
        sb.append(Typography.quote);
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == 10) {
                str2 = "%0A";
            } else if (charAt == 13) {
                str2 = "%0D";
            } else if (charAt != '\"') {
                sb.append(charAt);
            } else {
                str2 = "%22";
            }
            sb.append(str2);
        }
        sb.append(Typography.quote);
        return sb;
    }

    /* renamed from: a */
    public final C3007by mo38104a() {
        return this.f1648k;
    }

    /* renamed from: a */
    public final void mo38105a(C3131eo eoVar) {
        m1330a(eoVar, false);
    }

    /* renamed from: b */
    public final long mo38106b() {
        long j = this.f1650m;
        if (j != -1) {
            return j;
        }
        long a = m1330a((C3131eo) null, true);
        this.f1650m = a;
        return a;
    }
}
