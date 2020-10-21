package com.uxcam.internals;

import java.util.concurrent.TimeUnit;

/* renamed from: com.uxcam.internals.bh */
public final class C2978bh {

    /* renamed from: a */
    public static final C2978bh f1411a;

    /* renamed from: b */
    public static final C2978bh f1412b;

    /* renamed from: c */
    public final boolean f1413c;

    /* renamed from: d */
    public final boolean f1414d;

    /* renamed from: e */
    public final int f1415e;

    /* renamed from: f */
    public final boolean f1416f;

    /* renamed from: g */
    public final boolean f1417g;

    /* renamed from: h */
    public final boolean f1418h;

    /* renamed from: i */
    public final int f1419i;

    /* renamed from: j */
    public final int f1420j;

    /* renamed from: k */
    public final boolean f1421k;

    /* renamed from: l */
    String f1422l;

    /* renamed from: m */
    private final int f1423m;

    /* renamed from: n */
    private final boolean f1424n;

    /* renamed from: com.uxcam.internals.bh$aa */
    public static final class C2979aa {

        /* renamed from: a */
        boolean f1425a;

        /* renamed from: b */
        boolean f1426b;

        /* renamed from: c */
        int f1427c = -1;

        /* renamed from: d */
        int f1428d = -1;

        /* renamed from: e */
        int f1429e = -1;

        /* renamed from: f */
        boolean f1430f;

        /* renamed from: g */
        boolean f1431g;

        /* renamed from: a */
        public final C2978bh mo38076a() {
            return new C2978bh(this);
        }
    }

    static {
        C2979aa aaVar = new C2979aa();
        aaVar.f1425a = true;
        f1411a = aaVar.mo38076a();
        C2979aa aaVar2 = new C2979aa();
        aaVar2.f1430f = true;
        long seconds = TimeUnit.SECONDS.toSeconds(2147483647L);
        aaVar2.f1428d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
        f1412b = aaVar2.mo38076a();
    }

    C2978bh(C2979aa aaVar) {
        this.f1413c = aaVar.f1425a;
        this.f1414d = aaVar.f1426b;
        this.f1415e = aaVar.f1427c;
        this.f1423m = -1;
        this.f1416f = false;
        this.f1417g = false;
        this.f1418h = false;
        this.f1419i = aaVar.f1428d;
        this.f1420j = aaVar.f1429e;
        this.f1421k = aaVar.f1430f;
        this.f1424n = aaVar.f1431g;
    }

    private C2978bh(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, String str) {
        this.f1413c = z;
        this.f1414d = z2;
        this.f1415e = i;
        this.f1423m = i2;
        this.f1416f = z3;
        this.f1417g = z4;
        this.f1418h = z5;
        this.f1419i = i3;
        this.f1420j = i4;
        this.f1421k = z6;
        this.f1424n = z7;
        this.f1422l = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0042  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.uxcam.internals.C2978bh m1244a(com.uxcam.internals.C3000bv r22) {
        /*
            r0 = r22
            java.lang.String[] r1 = r0.f1606a
            int r1 = r1.length
            int r1 = r1 / 2
            r6 = 0
            r7 = 1
            r8 = 0
            r10 = 0
            r11 = 0
            r12 = -1
            r13 = -1
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = -1
            r18 = -1
            r19 = 0
            r20 = 0
        L_0x001a:
            if (r6 >= r1) goto L_0x013a
            java.lang.String r9 = r0.mo38112a((int) r6)
            java.lang.String r2 = r0.mo38114b(r6)
            java.lang.String r4 = "Cache-Control"
            boolean r4 = r9.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x0032
            if (r8 == 0) goto L_0x0030
        L_0x002e:
            r7 = 0
            goto L_0x003b
        L_0x0030:
            r8 = r2
            goto L_0x003b
        L_0x0032:
            java.lang.String r4 = "Pragma"
            boolean r4 = r9.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x0133
            goto L_0x002e
        L_0x003b:
            r4 = 0
        L_0x003c:
            int r9 = r2.length()
            if (r4 >= r9) goto L_0x0133
            java.lang.String r9 = "=,;"
            int r9 = com.uxcam.internals.C3054dc.m1499a((java.lang.String) r2, (int) r4, (java.lang.String) r9)
            java.lang.String r4 = r2.substring(r4, r9)
            java.lang.String r4 = r4.trim()
            int r3 = r2.length()
            if (r9 == r3) goto L_0x009d
            char r3 = r2.charAt(r9)
            r5 = 44
            if (r3 == r5) goto L_0x009d
            char r3 = r2.charAt(r9)
            r5 = 59
            if (r3 != r5) goto L_0x0067
            goto L_0x009d
        L_0x0067:
            int r9 = r9 + 1
            int r3 = com.uxcam.internals.C3054dc.m1498a(r2, r9)
            int r5 = r2.length()
            if (r3 >= r5) goto L_0x008c
            char r5 = r2.charAt(r3)
            r9 = 34
            if (r5 != r9) goto L_0x008c
            int r3 = r3 + 1
            java.lang.String r5 = "\""
            int r5 = com.uxcam.internals.C3054dc.m1499a((java.lang.String) r2, (int) r3, (java.lang.String) r5)
            java.lang.String r3 = r2.substring(r3, r5)
            r21 = 1
            int r5 = r5 + 1
            goto L_0x00a3
        L_0x008c:
            r21 = 1
            java.lang.String r5 = ",;"
            int r5 = com.uxcam.internals.C3054dc.m1499a((java.lang.String) r2, (int) r3, (java.lang.String) r5)
            java.lang.String r3 = r2.substring(r3, r5)
            java.lang.String r3 = r3.trim()
            goto L_0x00a3
        L_0x009d:
            r21 = 1
            int r9 = r9 + 1
            r5 = r9
            r3 = 0
        L_0x00a3:
            java.lang.String r9 = "no-cache"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x00ae
            r4 = r5
            r10 = 1
            goto L_0x003c
        L_0x00ae:
            java.lang.String r9 = "no-store"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x00b9
            r4 = r5
            r11 = 1
            goto L_0x003c
        L_0x00b9:
            java.lang.String r9 = "max-age"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x00c9
            r9 = -1
            int r12 = com.uxcam.internals.C3054dc.m1504b(r3, r9)
        L_0x00c6:
            r4 = r5
            goto L_0x003c
        L_0x00c9:
            java.lang.String r9 = "s-maxage"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x00d7
            r9 = -1
            int r13 = com.uxcam.internals.C3054dc.m1504b(r3, r9)
            goto L_0x00c6
        L_0x00d7:
            java.lang.String r9 = "private"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x00e3
            r4 = r5
            r14 = 1
            goto L_0x003c
        L_0x00e3:
            java.lang.String r9 = "public"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x00ef
            r4 = r5
            r15 = 1
            goto L_0x003c
        L_0x00ef:
            java.lang.String r9 = "must-revalidate"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x00fc
            r4 = r5
            r16 = 1
            goto L_0x003c
        L_0x00fc:
            java.lang.String r9 = "max-stale"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x010c
            r4 = 2147483647(0x7fffffff, float:NaN)
            int r17 = com.uxcam.internals.C3054dc.m1504b(r3, r4)
            goto L_0x00c6
        L_0x010c:
            java.lang.String r9 = "min-fresh"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x011a
            r9 = -1
            int r18 = com.uxcam.internals.C3054dc.m1504b(r3, r9)
            goto L_0x00c6
        L_0x011a:
            r9 = -1
            java.lang.String r3 = "only-if-cached"
            boolean r3 = r3.equalsIgnoreCase(r4)
            if (r3 == 0) goto L_0x0128
            r4 = r5
            r19 = 1
            goto L_0x003c
        L_0x0128:
            java.lang.String r3 = "no-transform"
            boolean r3 = r3.equalsIgnoreCase(r4)
            if (r3 == 0) goto L_0x00c6
            r20 = 1
            goto L_0x00c6
        L_0x0133:
            r9 = -1
            r21 = 1
            int r6 = r6 + 1
            goto L_0x001a
        L_0x013a:
            if (r7 != 0) goto L_0x013f
            r21 = 0
            goto L_0x0141
        L_0x013f:
            r21 = r8
        L_0x0141:
            com.uxcam.internals.bh r0 = new com.uxcam.internals.bh
            r9 = r0
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C2978bh.m1244a(com.uxcam.internals.bv):com.uxcam.internals.bh");
    }

    public final String toString() {
        String str;
        String str2 = this.f1422l;
        if (str2 != null) {
            return str2;
        }
        StringBuilder sb = new StringBuilder();
        if (this.f1413c) {
            sb.append("no-cache, ");
        }
        if (this.f1414d) {
            sb.append("no-store, ");
        }
        if (this.f1415e != -1) {
            sb.append("max-age=");
            sb.append(this.f1415e);
            sb.append(", ");
        }
        if (this.f1423m != -1) {
            sb.append("s-maxage=");
            sb.append(this.f1423m);
            sb.append(", ");
        }
        if (this.f1416f) {
            sb.append("private, ");
        }
        if (this.f1417g) {
            sb.append("public, ");
        }
        if (this.f1418h) {
            sb.append("must-revalidate, ");
        }
        if (this.f1419i != -1) {
            sb.append("max-stale=");
            sb.append(this.f1419i);
            sb.append(", ");
        }
        if (this.f1420j != -1) {
            sb.append("min-fresh=");
            sb.append(this.f1420j);
            sb.append(", ");
        }
        if (this.f1421k) {
            sb.append("only-if-cached, ");
        }
        if (this.f1424n) {
            sb.append("no-transform, ");
        }
        if (sb.length() == 0) {
            str = "";
        } else {
            sb.delete(sb.length() - 2, sb.length());
            str = sb.toString();
        }
        this.f1422l = str;
        return str;
    }
}
