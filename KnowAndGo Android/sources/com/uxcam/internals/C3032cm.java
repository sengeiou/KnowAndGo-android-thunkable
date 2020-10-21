package com.uxcam.internals;

import com.polidea.multiplatformbleadapter.utils.Constants;
import com.uxcam.internals.C3000bv;
import com.uxcam.internals.C3022cf;

/* renamed from: com.uxcam.internals.cm */
public final class C3032cm implements C3005bx {

    /* renamed from: a */
    final C3040cq f1798a;

    public C3032cm(C3040cq cqVar) {
        this.f1798a = cqVar;
    }

    /* renamed from: a */
    private static C3000bv m1439a(C3000bv bvVar, C3000bv bvVar2) {
        C3000bv.C3001aa aaVar = new C3000bv.C3001aa();
        int length = bvVar.f1606a.length / 2;
        for (int i = 0; i < length; i++) {
            String a = bvVar.mo38112a(i);
            String b = bvVar.mo38114b(i);
            if ((!Constants.BluetoothLogLevel.WARNING.equalsIgnoreCase(a) || !b.startsWith("1")) && (!m1441a(a) || bvVar2.mo38113a(a) == null)) {
                C3028cj.f1778a.mo38151a(aaVar, a, b);
            }
        }
        int length2 = bvVar2.f1606a.length / 2;
        for (int i2 = 0; i2 < length2; i2++) {
            String a2 = bvVar2.mo38112a(i2);
            if (!"Content-Length".equalsIgnoreCase(a2) && m1441a(a2)) {
                C3028cj.f1778a.mo38151a(aaVar, a2, bvVar2.mo38114b(i2));
            }
        }
        return aaVar.mo38120a();
    }

    /* renamed from: a */
    private static C3022cf m1440a(C3022cf cfVar) {
        if (cfVar == null || cfVar.f1746g == null) {
            return cfVar;
        }
        C3022cf.C3023aa b = cfVar.mo38177b();
        b.f1759g = null;
        return b.mo38185a();
    }

    /* renamed from: a */
    private static boolean m1441a(String str) {
        return !"Connection".equalsIgnoreCase(str) && !"Keep-Alive".equalsIgnoreCase(str) && !"Proxy-Authenticate".equalsIgnoreCase(str) && !"Proxy-Authorization".equalsIgnoreCase(str) && !"TE".equalsIgnoreCase(str) && !"Trailers".equalsIgnoreCase(str) && !"Transfer-Encoding".equalsIgnoreCase(str) && !"Upgrade".equalsIgnoreCase(str);
    }

    /* JADX WARNING: type inference failed for: r3v1, types: [com.uxcam.internals.cf, com.uxcam.internals.cd] */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r3v14 */
    /* JADX WARNING: type inference failed for: r3v15 */
    /* JADX WARNING: type inference failed for: r3v20 */
    /* JADX WARNING: type inference failed for: r3v26 */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00df, code lost:
        if (r2 > 0) goto L_0x011f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x020f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x021d A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x024b  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0258  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.uxcam.internals.C3022cf mo38068a(com.uxcam.internals.C3005bx.C3006aa r18) {
        /*
            r17 = this;
            r1 = r17
            com.uxcam.internals.cq r0 = r1.f1798a
            r2 = 0
            if (r0 == 0) goto L_0x000f
            com.uxcam.internals.cq r0 = r1.f1798a
            com.uxcam.internals.cf r0 = r0.mo38203a()
            r3 = r0
            goto L_0x0010
        L_0x000f:
            r3 = r2
        L_0x0010:
            long r4 = java.lang.System.currentTimeMillis()
            com.uxcam.internals.co$aa r0 = new com.uxcam.internals.co$aa
            com.uxcam.internals.cd r6 = r18.mo38137a()
            r0.<init>(r4, r6, r3)
            com.uxcam.internals.cf r4 = r0.f1808c
            if (r4 != 0) goto L_0x002d
            com.uxcam.internals.co r4 = new com.uxcam.internals.co
            com.uxcam.internals.cd r5 = r0.f1807b
            r4.<init>(r5, r2)
        L_0x0028:
            r16 = r3
            r3 = r2
            goto L_0x01f6
        L_0x002d:
            com.uxcam.internals.cd r4 = r0.f1807b
            com.uxcam.internals.bw r4 = r4.f1723a
            boolean r4 = r4.mo38122b()
            if (r4 == 0) goto L_0x0045
            com.uxcam.internals.cf r4 = r0.f1808c
            com.uxcam.internals.bu r4 = r4.f1744e
            if (r4 != 0) goto L_0x0045
            com.uxcam.internals.co r4 = new com.uxcam.internals.co
            com.uxcam.internals.cd r5 = r0.f1807b
            r4.<init>(r5, r2)
            goto L_0x0028
        L_0x0045:
            com.uxcam.internals.cf r4 = r0.f1808c
            com.uxcam.internals.cd r5 = r0.f1807b
            boolean r4 = com.uxcam.internals.C3035co.m1446a(r4, r5)
            if (r4 != 0) goto L_0x0057
            com.uxcam.internals.co r4 = new com.uxcam.internals.co
            com.uxcam.internals.cd r5 = r0.f1807b
            r4.<init>(r5, r2)
            goto L_0x0028
        L_0x0057:
            com.uxcam.internals.cd r4 = r0.f1807b
            com.uxcam.internals.bh r4 = r4.mo38167b()
            boolean r5 = r4.f1413c
            if (r5 != 0) goto L_0x01ec
            com.uxcam.internals.cd r5 = r0.f1807b
            java.lang.String r6 = "If-Modified-Since"
            java.lang.String r6 = r5.mo38166a(r6)
            if (r6 != 0) goto L_0x0076
            java.lang.String r6 = "If-None-Match"
            java.lang.String r5 = r5.mo38166a(r6)
            if (r5 == 0) goto L_0x0074
            goto L_0x0076
        L_0x0074:
            r5 = 0
            goto L_0x0077
        L_0x0076:
            r5 = 1
        L_0x0077:
            if (r5 == 0) goto L_0x007b
            goto L_0x01ec
        L_0x007b:
            java.util.Date r5 = r0.f1809d
            r9 = 0
            if (r5 == 0) goto L_0x008f
            long r5 = r0.f1815j
            java.util.Date r11 = r0.f1809d
            long r11 = r11.getTime()
            long r5 = r5 - r11
            long r5 = java.lang.Math.max(r9, r5)
            goto L_0x0090
        L_0x008f:
            r5 = r9
        L_0x0090:
            int r11 = r0.f1817l
            r12 = -1
            if (r11 == r12) goto L_0x00a2
            java.util.concurrent.TimeUnit r11 = java.util.concurrent.TimeUnit.SECONDS
            int r13 = r0.f1817l
            long r13 = (long) r13
            long r13 = r11.toMillis(r13)
            long r5 = java.lang.Math.max(r5, r13)
        L_0x00a2:
            long r13 = r0.f1815j
            long r7 = r0.f1814i
            long r13 = r13 - r7
            long r7 = r0.f1806a
            r16 = r3
            long r2 = r0.f1815j
            long r7 = r7 - r2
            long r5 = r5 + r13
            long r5 = r5 + r7
            com.uxcam.internals.cf r2 = r0.f1808c
            com.uxcam.internals.bh r2 = r2.mo38179c()
            int r3 = r2.f1415e
            if (r3 == r12) goto L_0x00c4
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.SECONDS
            int r2 = r2.f1415e
            long r7 = (long) r2
            long r2 = r3.toMillis(r7)
            goto L_0x011f
        L_0x00c4:
            java.util.Date r2 = r0.f1813h
            if (r2 == 0) goto L_0x00e2
            java.util.Date r2 = r0.f1809d
            if (r2 == 0) goto L_0x00d3
            java.util.Date r2 = r0.f1809d
            long r2 = r2.getTime()
            goto L_0x00d5
        L_0x00d3:
            long r2 = r0.f1815j
        L_0x00d5:
            java.util.Date r7 = r0.f1813h
            long r7 = r7.getTime()
            long r2 = r7 - r2
            int r7 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r7 <= 0) goto L_0x011e
            goto L_0x011f
        L_0x00e2:
            java.util.Date r2 = r0.f1811f
            if (r2 == 0) goto L_0x011e
            com.uxcam.internals.cf r2 = r0.f1808c
            com.uxcam.internals.cd r2 = r2.f1740a
            com.uxcam.internals.bw r2 = r2.f1723a
            java.util.List r3 = r2.f1612d
            if (r3 != 0) goto L_0x00f2
            r2 = 0
            goto L_0x0100
        L_0x00f2:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.util.List r2 = r2.f1612d
            com.uxcam.internals.C3002bw.m1304b(r3, r2)
            java.lang.String r2 = r3.toString()
        L_0x0100:
            if (r2 != 0) goto L_0x011e
            java.util.Date r2 = r0.f1809d
            if (r2 == 0) goto L_0x010d
            java.util.Date r2 = r0.f1809d
            long r2 = r2.getTime()
            goto L_0x010f
        L_0x010d:
            long r2 = r0.f1814i
        L_0x010f:
            java.util.Date r7 = r0.f1811f
            long r7 = r7.getTime()
            long r2 = r2 - r7
            int r7 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r7 <= 0) goto L_0x011e
            r7 = 10
            long r2 = r2 / r7
            goto L_0x011f
        L_0x011e:
            r2 = r9
        L_0x011f:
            int r7 = r4.f1415e
            if (r7 == r12) goto L_0x0130
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.SECONDS
            int r8 = r4.f1415e
            long r13 = (long) r8
            long r7 = r7.toMillis(r13)
            long r2 = java.lang.Math.min(r2, r7)
        L_0x0130:
            int r7 = r4.f1420j
            if (r7 == r12) goto L_0x013e
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.SECONDS
            int r8 = r4.f1420j
            long r13 = (long) r8
            long r7 = r7.toMillis(r13)
            goto L_0x013f
        L_0x013e:
            r7 = r9
        L_0x013f:
            com.uxcam.internals.cf r11 = r0.f1808c
            com.uxcam.internals.bh r11 = r11.mo38179c()
            boolean r13 = r11.f1418h
            if (r13 != 0) goto L_0x0156
            int r13 = r4.f1419i
            if (r13 == r12) goto L_0x0156
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.SECONDS
            int r4 = r4.f1419i
            long r13 = (long) r4
            long r9 = r9.toMillis(r13)
        L_0x0156:
            boolean r4 = r11.f1413c
            if (r4 != 0) goto L_0x019f
            long r7 = r7 + r5
            long r9 = r9 + r2
            int r4 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r4 >= 0) goto L_0x019f
            com.uxcam.internals.cf r4 = r0.f1808c
            com.uxcam.internals.cf$aa r4 = r4.mo38177b()
            int r2 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x0171
            java.lang.String r2 = "Warning"
            java.lang.String r3 = "110 HttpURLConnection \"Response is stale\""
            r4.mo38184a((java.lang.String) r2, (java.lang.String) r3)
        L_0x0171:
            r2 = 86400000(0x5265c00, double:4.2687272E-316)
            int r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x0192
            com.uxcam.internals.cf r2 = r0.f1808c
            com.uxcam.internals.bh r2 = r2.mo38179c()
            int r2 = r2.f1415e
            if (r2 != r12) goto L_0x0188
            java.util.Date r2 = r0.f1813h
            if (r2 != 0) goto L_0x0188
            r15 = 1
            goto L_0x0189
        L_0x0188:
            r15 = 0
        L_0x0189:
            if (r15 == 0) goto L_0x0192
            java.lang.String r2 = "Warning"
            java.lang.String r3 = "113 HttpURLConnection \"Heuristic expiration\""
            r4.mo38184a((java.lang.String) r2, (java.lang.String) r3)
        L_0x0192:
            com.uxcam.internals.co r2 = new com.uxcam.internals.co
            com.uxcam.internals.cf r3 = r4.mo38185a()
            r4 = 0
            r2.<init>(r4, r3)
            r3 = r4
            r4 = r2
            goto L_0x01f6
        L_0x019f:
            java.lang.String r2 = r0.f1816k
            if (r2 == 0) goto L_0x01a8
            java.lang.String r2 = "If-None-Match"
            java.lang.String r3 = r0.f1816k
            goto L_0x01b9
        L_0x01a8:
            java.util.Date r2 = r0.f1811f
            if (r2 == 0) goto L_0x01b1
            java.lang.String r2 = "If-Modified-Since"
            java.lang.String r3 = r0.f1812g
            goto L_0x01b9
        L_0x01b1:
            java.util.Date r2 = r0.f1809d
            if (r2 == 0) goto L_0x01e3
            java.lang.String r2 = "If-Modified-Since"
            java.lang.String r3 = r0.f1810e
        L_0x01b9:
            com.uxcam.internals.cd r4 = r0.f1807b
            com.uxcam.internals.bv r4 = r4.f1725c
            com.uxcam.internals.bv$aa r4 = r4.mo38111a()
            com.uxcam.internals.cj r5 = com.uxcam.internals.C3028cj.f1778a
            r5.mo38151a((com.uxcam.internals.C3000bv.C3001aa) r4, (java.lang.String) r2, (java.lang.String) r3)
            com.uxcam.internals.cd r2 = r0.f1807b
            com.uxcam.internals.cd$aa r2 = r2.mo38165a()
            com.uxcam.internals.bv r3 = r4.mo38120a()
            com.uxcam.internals.bv$aa r3 = r3.mo38111a()
            r2.f1731c = r3
            com.uxcam.internals.cd r2 = r2.mo38173a()
            com.uxcam.internals.co r4 = new com.uxcam.internals.co
            com.uxcam.internals.cf r3 = r0.f1808c
            r4.<init>(r2, r3)
            r3 = 0
            goto L_0x01f6
        L_0x01e3:
            com.uxcam.internals.co r4 = new com.uxcam.internals.co
            com.uxcam.internals.cd r2 = r0.f1807b
            r3 = 0
            r4.<init>(r2, r3)
            goto L_0x01f6
        L_0x01ec:
            r16 = r3
            r3 = r2
            com.uxcam.internals.co r4 = new com.uxcam.internals.co
            com.uxcam.internals.cd r2 = r0.f1807b
            r4.<init>(r2, r3)
        L_0x01f6:
            com.uxcam.internals.cd r2 = r4.f1804a
            if (r2 == 0) goto L_0x0209
            com.uxcam.internals.cd r0 = r0.f1807b
            com.uxcam.internals.bh r0 = r0.mo38167b()
            boolean r0 = r0.f1421k
            if (r0 == 0) goto L_0x0209
            com.uxcam.internals.co r4 = new com.uxcam.internals.co
            r4.<init>(r3, r3)
        L_0x0209:
            com.uxcam.internals.cd r0 = r4.f1804a
            com.uxcam.internals.cf r2 = r4.f1805b
            if (r16 == 0) goto L_0x0219
            if (r2 != 0) goto L_0x0219
            r4 = r16
            com.uxcam.internals.cg r5 = r4.f1746g
            com.uxcam.internals.C3030cl.m1428a((java.io.Closeable) r5)
            goto L_0x021b
        L_0x0219:
            r4 = r16
        L_0x021b:
            if (r0 != 0) goto L_0x0249
            if (r2 != 0) goto L_0x0249
            com.uxcam.internals.cf$aa r0 = new com.uxcam.internals.cf$aa
            r0.<init>()
            com.uxcam.internals.cd r2 = r18.mo38137a()
            r0.f1753a = r2
            com.uxcam.internals.cb r2 = com.uxcam.internals.C3014cb.HTTP_1_1
            r0.f1754b = r2
            r2 = 504(0x1f8, float:7.06E-43)
            r0.f1755c = r2
            java.lang.String r2 = "Unsatisfiable Request (only-if-cached)"
            r0.f1756d = r2
            com.uxcam.internals.cg r2 = com.uxcam.internals.C3030cl.f1782c
            r0.f1759g = r2
            r2 = -1
            r0.f1763k = r2
            long r2 = java.lang.System.currentTimeMillis()
            r0.f1764l = r2
        L_0x0244:
            com.uxcam.internals.cf r0 = r0.mo38185a()
            return r0
        L_0x0249:
            if (r0 != 0) goto L_0x0258
            com.uxcam.internals.cf$aa r0 = r2.mo38177b()
            com.uxcam.internals.cf r2 = m1440a((com.uxcam.internals.C3022cf) r2)
            com.uxcam.internals.cf$aa r0 = r0.mo38186b(r2)
            goto L_0x0244
        L_0x0258:
            r5 = r18
            com.uxcam.internals.cf r0 = r5.mo38138a(r0)     // Catch:{ all -> 0x032e }
            if (r0 != 0) goto L_0x0267
            if (r4 == 0) goto L_0x0267
            com.uxcam.internals.cg r4 = r4.f1746g
            com.uxcam.internals.C3030cl.m1428a((java.io.Closeable) r4)
        L_0x0267:
            if (r2 == 0) goto L_0x02a6
            int r4 = r0.f1742c
            r5 = 304(0x130, float:4.26E-43)
            if (r4 != r5) goto L_0x02a1
            com.uxcam.internals.cf$aa r3 = r2.mo38177b()
            com.uxcam.internals.bv r4 = r2.f1745f
            com.uxcam.internals.bv r5 = r0.f1745f
            com.uxcam.internals.bv r4 = m1439a(r4, r5)
            com.uxcam.internals.cf$aa r3 = r3.mo38182a((com.uxcam.internals.C3000bv) r4)
            long r4 = r0.f1750k
            r3.f1763k = r4
            long r4 = r0.f1751l
            r3.f1764l = r4
            com.uxcam.internals.cf r2 = m1440a((com.uxcam.internals.C3022cf) r2)
            com.uxcam.internals.cf$aa r2 = r3.mo38186b(r2)
            com.uxcam.internals.cf r3 = m1440a((com.uxcam.internals.C3022cf) r0)
            com.uxcam.internals.cf$aa r2 = r2.mo38183a((com.uxcam.internals.C3022cf) r3)
            com.uxcam.internals.cf r2 = r2.mo38185a()
            com.uxcam.internals.cg r0 = r0.f1746g
            r0.close()
            return r2
        L_0x02a1:
            com.uxcam.internals.cg r4 = r2.f1746g
            com.uxcam.internals.C3030cl.m1428a((java.io.Closeable) r4)
        L_0x02a6:
            com.uxcam.internals.cf$aa r4 = r0.mo38177b()
            com.uxcam.internals.cf r2 = m1440a((com.uxcam.internals.C3022cf) r2)
            com.uxcam.internals.cf$aa r2 = r4.mo38186b(r2)
            com.uxcam.internals.cf r4 = m1440a((com.uxcam.internals.C3022cf) r0)
            com.uxcam.internals.cf$aa r2 = r2.mo38183a((com.uxcam.internals.C3022cf) r4)
            com.uxcam.internals.cf r2 = r2.mo38185a()
            boolean r4 = com.uxcam.internals.C3054dc.m1505b(r2)
            if (r4 == 0) goto L_0x032d
            com.uxcam.internals.cd r0 = r0.f1740a
            com.uxcam.internals.cq r4 = r1.f1798a
            if (r4 != 0) goto L_0x02cb
            goto L_0x02fe
        L_0x02cb:
            boolean r5 = com.uxcam.internals.C3035co.m1446a(r2, r0)
            if (r5 != 0) goto L_0x02f9
            java.lang.String r0 = r0.f1724b
            java.lang.String r4 = "POST"
            boolean r4 = r0.equals(r4)
            if (r4 != 0) goto L_0x02fe
            java.lang.String r4 = "PATCH"
            boolean r4 = r0.equals(r4)
            if (r4 != 0) goto L_0x02fe
            java.lang.String r4 = "PUT"
            boolean r4 = r0.equals(r4)
            if (r4 != 0) goto L_0x02fe
            java.lang.String r4 = "DELETE"
            boolean r4 = r0.equals(r4)
            if (r4 != 0) goto L_0x02fe
            java.lang.String r4 = "MOVE"
            r0.equals(r4)
            goto L_0x02fe
        L_0x02f9:
            com.uxcam.internals.cn r0 = r4.mo38204b()
            r3 = r0
        L_0x02fe:
            if (r3 != 0) goto L_0x0301
            goto L_0x032d
        L_0x0301:
            com.uxcam.internals.fb r0 = r3.mo38199a()
            if (r0 != 0) goto L_0x0308
            goto L_0x032d
        L_0x0308:
            com.uxcam.internals.cg r4 = r2.f1746g
            com.uxcam.internals.ep r4 = r4.mo38189c()
            com.uxcam.internals.eo r0 = com.uxcam.internals.C3138ev.m1862a((com.uxcam.internals.C3147fb) r0)
            com.uxcam.internals.cm$1 r5 = new com.uxcam.internals.cm$1
            r5.<init>(r4, r3, r0)
            com.uxcam.internals.cf$aa r0 = r2.mo38177b()
            com.uxcam.internals.df r3 = new com.uxcam.internals.df
            com.uxcam.internals.bv r2 = r2.f1745f
            com.uxcam.internals.ep r4 = com.uxcam.internals.C3138ev.m1863a((com.uxcam.internals.C3148fc) r5)
            r3.<init>(r2, r4)
            r0.f1759g = r3
            com.uxcam.internals.cf r0 = r0.mo38185a()
            r2 = r0
        L_0x032d:
            return r2
        L_0x032e:
            r0 = move-exception
            r2 = r0
            if (r4 == 0) goto L_0x0337
            com.uxcam.internals.cg r0 = r4.f1746g
            com.uxcam.internals.C3030cl.m1428a((java.io.Closeable) r0)
        L_0x0337:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C3032cm.mo38068a(com.uxcam.internals.bx$aa):com.uxcam.internals.cf");
    }
}
