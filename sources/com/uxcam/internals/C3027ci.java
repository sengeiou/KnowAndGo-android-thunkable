package com.uxcam.internals;

/* renamed from: com.uxcam.internals.ci */
public enum C3027ci {
    TLS_1_3("TLSv1.3"),
    TLS_1_2("TLSv1.2"),
    TLS_1_1("TLSv1.1"),
    TLS_1_0("TLSv1"),
    SSL_3_0("SSLv3");
    

    /* renamed from: f */
    final String f1777f;

    private C3027ci(String str) {
        this.f1777f = str;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0064  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.uxcam.internals.C3027ci m1407a(java.lang.String r2) {
        /*
            int r0 = r2.hashCode()
            r1 = 79201641(0x4b88569, float:4.338071E-36)
            if (r0 == r1) goto L_0x003a
            r1 = 79923350(0x4c38896, float:4.5969714E-36)
            if (r0 == r1) goto L_0x0030
            switch(r0) {
                case -503070503: goto L_0x0026;
                case -503070502: goto L_0x001c;
                case -503070501: goto L_0x0012;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x0044
        L_0x0012:
            java.lang.String r0 = "TLSv1.3"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0044
            r0 = 0
            goto L_0x0045
        L_0x001c:
            java.lang.String r0 = "TLSv1.2"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0044
            r0 = 1
            goto L_0x0045
        L_0x0026:
            java.lang.String r0 = "TLSv1.1"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0044
            r0 = 2
            goto L_0x0045
        L_0x0030:
            java.lang.String r0 = "TLSv1"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0044
            r0 = 3
            goto L_0x0045
        L_0x003a:
            java.lang.String r0 = "SSLv3"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0044
            r0 = 4
            goto L_0x0045
        L_0x0044:
            r0 = -1
        L_0x0045:
            switch(r0) {
                case 0: goto L_0x0064;
                case 1: goto L_0x0061;
                case 2: goto L_0x005e;
                case 3: goto L_0x005b;
                case 4: goto L_0x0058;
                default: goto L_0x0048;
            }
        L_0x0048:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r1 = "Unexpected TLS version: "
            java.lang.String r2 = r1.concat(r2)
            r0.<init>(r2)
            throw r0
        L_0x0058:
            com.uxcam.internals.ci r2 = SSL_3_0
            return r2
        L_0x005b:
            com.uxcam.internals.ci r2 = TLS_1_0
            return r2
        L_0x005e:
            com.uxcam.internals.ci r2 = TLS_1_1
            return r2
        L_0x0061:
            com.uxcam.internals.ci r2 = TLS_1_2
            return r2
        L_0x0064:
            com.uxcam.internals.ci r2 = TLS_1_3
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C3027ci.m1407a(java.lang.String):com.uxcam.internals.ci");
    }
}
