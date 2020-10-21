package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C1982af;

/* renamed from: com.google.android.play.core.assetpacks.cs */
final class C1914cs {

    /* renamed from: a */
    private static final C1982af f552a = new C1982af("ExtractorTaskFinder");

    /* renamed from: b */
    private final C1911cp f553b;

    /* renamed from: c */
    private final C1870bb f554c;

    /* renamed from: d */
    private final C1879bk f555d;

    C1914cs(C1911cp cpVar, C1870bb bbVar, C1879bk bkVar) {
        this.f553b = cpVar;
        this.f554c = bbVar;
        this.f555d = bkVar;
    }

    /* renamed from: a */
    private final boolean m442a(C1908cm cmVar, C1909cn cnVar) {
        C1870bb bbVar = this.f554c;
        C1907cl clVar = cmVar.f532c;
        String str = clVar.f525a;
        return bbVar.mo33394e(str, cmVar.f531b, clVar.f526b, cnVar.f533a).exists();
    }

    /* renamed from: a */
    private static boolean m443a(C1909cn cnVar) {
        int i = cnVar.f538f;
        return i == 1 || i == 2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: com.google.android.play.core.assetpacks.dh} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: com.google.android.play.core.assetpacks.dh} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: com.google.android.play.core.assetpacks.de} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: com.google.android.play.core.assetpacks.de} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: com.google.android.play.core.assetpacks.du} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: com.google.android.play.core.assetpacks.du} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: com.google.android.play.core.assetpacks.bs} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v20, resolved type: com.google.android.play.core.assetpacks.bs} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v22, resolved type: com.google.android.play.core.assetpacks.dn} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v23, resolved type: com.google.android.play.core.assetpacks.dn} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v2, resolved type: com.google.android.play.core.assetpacks.bs} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v51, resolved type: com.google.android.play.core.assetpacks.bs} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v15, resolved type: com.google.android.play.core.assetpacks.dn} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v6, resolved type: com.google.android.play.core.assetpacks.du} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v7, resolved type: com.google.android.play.core.assetpacks.de} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v16, resolved type: com.google.android.play.core.assetpacks.dh} */
    /* JADX WARNING: type inference failed for: r0v11, types: [com.google.android.play.core.assetpacks.cr] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x040e, code lost:
        if (r0 != null) goto L_0x0410;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        f552a.mo33550a("Found final move task for session %s with pack %s.", java.lang.Integer.valueOf(r4.f530a), r4.f532c.f525a);
        r11 = r4.f530a;
        r8 = r4.f532c;
        r10 = new com.google.android.play.core.assetpacks.C1930dh(r11, r8.f525a, r4.f531b, r8.f526b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0218, code lost:
        r0 = f552a;
        r4 = new java.lang.Object[r8];
        r4[r7] = java.lang.Integer.valueOf(r6.f530a);
        r4[1] = r6.f532c.f525a;
        r4[2] = r10.f533a;
        r0.mo33550a("Found extraction task for patch for session %s, pack %s, slice %s.", r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        r11 = r1.f554c;
        r4 = r6.f532c;
        r0 = new java.io.FileInputStream(r11.mo33394e(r4.f525a, r6.f531b, r4.f526b, r10.f533a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        r9 = r6.f530a;
        r11 = r6.f532c;
        r0 = new com.google.android.play.core.assetpacks.C1887bs(r9, r11.f525a, r6.f531b, r11.f526b, r10.f533a, 0, 0, 1, r11.f528d, r11.f527c, r0);
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.annotation.Nullable
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.play.core.assetpacks.C1913cr mo33456a() {
        /*
            r34 = this;
            r1 = r34
            com.google.android.play.core.assetpacks.cp r0 = r1.f553b     // Catch:{ all -> 0x041d }
            r0.mo33441a()     // Catch:{ all -> 0x041d }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x041d }
            r2.<init>()     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.cp r0 = r1.f553b     // Catch:{ all -> 0x041d }
            java.util.Map r0 = r0.mo33451c()     // Catch:{ all -> 0x041d }
            java.util.Collection r0 = r0.values()     // Catch:{ all -> 0x041d }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x041d }
        L_0x001a:
            boolean r3 = r0.hasNext()     // Catch:{ all -> 0x041d }
            if (r3 == 0) goto L_0x0034
            java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.cm r3 = (com.google.android.play.core.assetpacks.C1908cm) r3     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.cl r4 = r3.f532c     // Catch:{ all -> 0x041d }
            int r4 = r4.f527c     // Catch:{ all -> 0x041d }
            boolean r4 = com.google.android.play.core.assetpacks.C1924db.m476c(r4)     // Catch:{ all -> 0x041d }
            if (r4 == 0) goto L_0x001a
            r2.add(r3)     // Catch:{ all -> 0x041d }
            goto L_0x001a
        L_0x0034:
            boolean r0 = r2.isEmpty()     // Catch:{ all -> 0x041d }
            if (r0 != 0) goto L_0x0416
            java.util.Iterator r0 = r2.iterator()     // Catch:{ all -> 0x041d }
        L_0x003e:
            boolean r4 = r0.hasNext()     // Catch:{ all -> 0x041d }
            r5 = 2
            r6 = 1
            r7 = 0
            if (r4 == 0) goto L_0x00ac
            java.lang.Object r4 = r0.next()     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.cm r4 = (com.google.android.play.core.assetpacks.C1908cm) r4     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.bb r8 = r1.f554c     // Catch:{ IOException -> 0x008d }
            com.google.android.play.core.assetpacks.cl r9 = r4.f532c     // Catch:{ IOException -> 0x008d }
            java.lang.String r10 = r9.f525a     // Catch:{ IOException -> 0x008d }
            int r11 = r4.f531b     // Catch:{ IOException -> 0x008d }
            long r12 = r9.f526b     // Catch:{ IOException -> 0x008d }
            int r8 = r8.mo33388d(r10, r11, r12)     // Catch:{ IOException -> 0x008d }
            com.google.android.play.core.assetpacks.cl r9 = r4.f532c     // Catch:{ IOException -> 0x008d }
            java.util.List<com.google.android.play.core.assetpacks.cn> r9 = r9.f529e     // Catch:{ IOException -> 0x008d }
            int r9 = r9.size()     // Catch:{ IOException -> 0x008d }
            if (r8 != r9) goto L_0x003e
            com.google.android.play.core.internal.af r0 = f552a     // Catch:{ all -> 0x041d }
            java.lang.Object[] r8 = new java.lang.Object[r5]     // Catch:{ all -> 0x041d }
            int r9 = r4.f530a     // Catch:{ all -> 0x041d }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x041d }
            r8[r7] = r9     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.cl r9 = r4.f532c     // Catch:{ all -> 0x041d }
            java.lang.String r9 = r9.f525a     // Catch:{ all -> 0x041d }
            r8[r6] = r9     // Catch:{ all -> 0x041d }
            java.lang.String r9 = "Found final move task for session %s with pack %s."
            r0.mo33550a(r9, r8)     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.dh r0 = new com.google.android.play.core.assetpacks.dh     // Catch:{ all -> 0x041d }
            int r11 = r4.f530a     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.cl r8 = r4.f532c     // Catch:{ all -> 0x041d }
            java.lang.String r12 = r8.f525a     // Catch:{ all -> 0x041d }
            int r13 = r4.f531b     // Catch:{ all -> 0x041d }
            long r14 = r8.f526b     // Catch:{ all -> 0x041d }
            r10 = r0
            r10.<init>(r11, r12, r13, r14)     // Catch:{ all -> 0x041d }
            goto L_0x00ad
        L_0x008d:
            r0 = move-exception
            com.google.android.play.core.assetpacks.bv r2 = new com.google.android.play.core.assetpacks.bv     // Catch:{ all -> 0x041d }
            java.lang.Object[] r3 = new java.lang.Object[r5]     // Catch:{ all -> 0x041d }
            int r5 = r4.f530a     // Catch:{ all -> 0x041d }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x041d }
            r3[r7] = r5     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.cl r5 = r4.f532c     // Catch:{ all -> 0x041d }
            java.lang.String r5 = r5.f525a     // Catch:{ all -> 0x041d }
            r3[r6] = r5     // Catch:{ all -> 0x041d }
            java.lang.String r5 = "Failed to check number of completed merges for session %s, pack %s"
            java.lang.String r3 = java.lang.String.format(r5, r3)     // Catch:{ all -> 0x041d }
            int r4 = r4.f530a     // Catch:{ all -> 0x041d }
            r2.<init>(r3, r0, r4)     // Catch:{ all -> 0x041d }
            throw r2     // Catch:{ all -> 0x041d }
        L_0x00ac:
            r0 = 0
        L_0x00ad:
            if (r0 != 0) goto L_0x0410
            java.util.Iterator r0 = r2.iterator()     // Catch:{ all -> 0x041d }
        L_0x00b3:
            boolean r4 = r0.hasNext()     // Catch:{ all -> 0x041d }
            r8 = 3
            if (r4 == 0) goto L_0x0137
            java.lang.Object r4 = r0.next()     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.cm r4 = (com.google.android.play.core.assetpacks.C1908cm) r4     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.cl r9 = r4.f532c     // Catch:{ all -> 0x041d }
            int r9 = r9.f527c     // Catch:{ all -> 0x041d }
            boolean r9 = com.google.android.play.core.assetpacks.C1924db.m476c(r9)     // Catch:{ all -> 0x041d }
            if (r9 == 0) goto L_0x00b3
            com.google.android.play.core.assetpacks.cl r9 = r4.f532c     // Catch:{ all -> 0x041d }
            java.util.List<com.google.android.play.core.assetpacks.cn> r9 = r9.f529e     // Catch:{ all -> 0x041d }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x041d }
        L_0x00d2:
            boolean r10 = r9.hasNext()     // Catch:{ all -> 0x041d }
            if (r10 == 0) goto L_0x00b3
            java.lang.Object r10 = r9.next()     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.cn r10 = (com.google.android.play.core.assetpacks.C1909cn) r10     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.bb r11 = r1.f554c     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.cl r12 = r4.f532c     // Catch:{ all -> 0x041d }
            java.lang.String r13 = r12.f525a     // Catch:{ all -> 0x041d }
            int r14 = r4.f531b     // Catch:{ all -> 0x041d }
            long r5 = r12.f526b     // Catch:{ all -> 0x041d }
            java.lang.String r15 = r10.f533a     // Catch:{ all -> 0x041d }
            r12 = r13
            r13 = r14
            r16 = r15
            r14 = r5
            java.io.File r5 = r11.mo33382b(r12, r13, r14, r16)     // Catch:{ all -> 0x041d }
            boolean r5 = r5.exists()     // Catch:{ all -> 0x041d }
            if (r5 == 0) goto L_0x0134
            com.google.android.play.core.internal.af r0 = f552a     // Catch:{ all -> 0x041d }
            java.lang.Object[] r5 = new java.lang.Object[r8]     // Catch:{ all -> 0x041d }
            int r6 = r4.f530a     // Catch:{ all -> 0x041d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x041d }
            r5[r7] = r6     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.cl r6 = r4.f532c     // Catch:{ all -> 0x041d }
            java.lang.String r6 = r6.f525a     // Catch:{ all -> 0x041d }
            r9 = 1
            r5[r9] = r6     // Catch:{ all -> 0x041d }
            java.lang.String r6 = r10.f533a     // Catch:{ all -> 0x041d }
            r9 = 2
            r5[r9] = r6     // Catch:{ all -> 0x041d }
            java.lang.String r6 = "Found merge task for session %s with pack %s and slice %s."
            r0.mo33550a(r6, r5)     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.de r0 = new com.google.android.play.core.assetpacks.de     // Catch:{ all -> 0x041d }
            int r5 = r4.f530a     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.cl r6 = r4.f532c     // Catch:{ all -> 0x041d }
            java.lang.String r9 = r6.f525a     // Catch:{ all -> 0x041d }
            int r4 = r4.f531b     // Catch:{ all -> 0x041d }
            long r11 = r6.f526b     // Catch:{ all -> 0x041d }
            java.lang.String r6 = r10.f533a     // Catch:{ all -> 0x041d }
            r19 = r0
            r20 = r5
            r21 = r9
            r22 = r4
            r23 = r11
            r25 = r6
            r19.<init>(r20, r21, r22, r23, r25)     // Catch:{ all -> 0x041d }
            goto L_0x0138
        L_0x0134:
            r5 = 2
            r6 = 1
            goto L_0x00d2
        L_0x0137:
            r0 = 0
        L_0x0138:
            if (r0 != 0) goto L_0x0410
            java.util.Iterator r0 = r2.iterator()     // Catch:{ all -> 0x041d }
        L_0x013e:
            boolean r4 = r0.hasNext()     // Catch:{ all -> 0x041d }
            if (r4 == 0) goto L_0x01d8
            java.lang.Object r4 = r0.next()     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.cm r4 = (com.google.android.play.core.assetpacks.C1908cm) r4     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.cl r5 = r4.f532c     // Catch:{ all -> 0x041d }
            int r5 = r5.f527c     // Catch:{ all -> 0x041d }
            boolean r5 = com.google.android.play.core.assetpacks.C1924db.m476c(r5)     // Catch:{ all -> 0x041d }
            if (r5 == 0) goto L_0x013e
            com.google.android.play.core.assetpacks.cl r5 = r4.f532c     // Catch:{ all -> 0x041d }
            java.util.List<com.google.android.play.core.assetpacks.cn> r5 = r5.f529e     // Catch:{ all -> 0x041d }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x041d }
        L_0x015c:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x041d }
            if (r6 == 0) goto L_0x013e
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.cn r6 = (com.google.android.play.core.assetpacks.C1909cn) r6     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.dr r16 = new com.google.android.play.core.assetpacks.dr     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.bb r10 = r1.f554c     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.cl r9 = r4.f532c     // Catch:{ all -> 0x041d }
            java.lang.String r11 = r9.f525a     // Catch:{ all -> 0x041d }
            int r12 = r4.f531b     // Catch:{ all -> 0x041d }
            long r13 = r9.f526b     // Catch:{ all -> 0x041d }
            java.lang.String r15 = r6.f533a     // Catch:{ all -> 0x041d }
            r9 = r16
            r9.<init>(r10, r11, r12, r13, r15)     // Catch:{ all -> 0x041d }
            boolean r9 = r16.mo33500d()     // Catch:{ all -> 0x041d }
            if (r9 == 0) goto L_0x015c
            com.google.android.play.core.assetpacks.bb r10 = r1.f554c     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.cl r9 = r4.f532c     // Catch:{ all -> 0x041d }
            java.lang.String r11 = r9.f525a     // Catch:{ all -> 0x041d }
            int r12 = r4.f531b     // Catch:{ all -> 0x041d }
            long r13 = r9.f526b     // Catch:{ all -> 0x041d }
            java.lang.String r15 = r6.f533a     // Catch:{ all -> 0x041d }
            java.io.File r9 = r10.mo33375a((java.lang.String) r11, (int) r12, (long) r13, (java.lang.String) r15)     // Catch:{ all -> 0x041d }
            boolean r9 = r9.exists()     // Catch:{ all -> 0x041d }
            if (r9 == 0) goto L_0x015c
            com.google.android.play.core.internal.af r0 = f552a     // Catch:{ all -> 0x041d }
            java.lang.Object[] r5 = new java.lang.Object[r8]     // Catch:{ all -> 0x041d }
            int r9 = r4.f530a     // Catch:{ all -> 0x041d }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x041d }
            r5[r7] = r9     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.cl r9 = r4.f532c     // Catch:{ all -> 0x041d }
            java.lang.String r9 = r9.f525a     // Catch:{ all -> 0x041d }
            r10 = 1
            r5[r10] = r9     // Catch:{ all -> 0x041d }
            java.lang.String r9 = r6.f533a     // Catch:{ all -> 0x041d }
            r10 = 2
            r5[r10] = r9     // Catch:{ all -> 0x041d }
            java.lang.String r9 = "Found verify task for session %s with pack %s and slice %s."
            r0.mo33550a(r9, r5)     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.du r0 = new com.google.android.play.core.assetpacks.du     // Catch:{ all -> 0x041d }
            int r5 = r4.f530a     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.cl r9 = r4.f532c     // Catch:{ all -> 0x041d }
            java.lang.String r10 = r9.f525a     // Catch:{ all -> 0x041d }
            int r4 = r4.f531b     // Catch:{ all -> 0x041d }
            long r11 = r9.f526b     // Catch:{ all -> 0x041d }
            java.lang.String r9 = r6.f533a     // Catch:{ all -> 0x041d }
            java.lang.String r13 = r6.f534b     // Catch:{ all -> 0x041d }
            long r14 = r6.f535c     // Catch:{ all -> 0x041d }
            r19 = r0
            r20 = r5
            r21 = r10
            r22 = r4
            r23 = r11
            r25 = r9
            r26 = r13
            r19.<init>(r20, r21, r22, r23, r25, r26)     // Catch:{ all -> 0x041d }
            goto L_0x01d9
        L_0x01d8:
            r0 = 0
        L_0x01d9:
            if (r0 != 0) goto L_0x0410
            java.util.Iterator r4 = r2.iterator()     // Catch:{ all -> 0x041d }
        L_0x01df:
            boolean r0 = r4.hasNext()     // Catch:{ all -> 0x041d }
            r5 = 4
            if (r0 == 0) goto L_0x035a
            java.lang.Object r0 = r4.next()     // Catch:{ all -> 0x041d }
            r6 = r0
            com.google.android.play.core.assetpacks.cm r6 = (com.google.android.play.core.assetpacks.C1908cm) r6     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.cl r0 = r6.f532c     // Catch:{ all -> 0x041d }
            int r0 = r0.f527c     // Catch:{ all -> 0x041d }
            boolean r0 = com.google.android.play.core.assetpacks.C1924db.m476c(r0)     // Catch:{ all -> 0x041d }
            if (r0 == 0) goto L_0x01df
            com.google.android.play.core.assetpacks.cl r0 = r6.f532c     // Catch:{ all -> 0x041d }
            java.util.List<com.google.android.play.core.assetpacks.cn> r0 = r0.f529e     // Catch:{ all -> 0x041d }
            java.util.Iterator r9 = r0.iterator()     // Catch:{ all -> 0x041d }
        L_0x01ff:
            boolean r0 = r9.hasNext()     // Catch:{ all -> 0x041d }
            if (r0 == 0) goto L_0x01df
            java.lang.Object r0 = r9.next()     // Catch:{ all -> 0x041d }
            r10 = r0
            com.google.android.play.core.assetpacks.cn r10 = (com.google.android.play.core.assetpacks.C1909cn) r10     // Catch:{ all -> 0x041d }
            boolean r0 = m443a(r10)     // Catch:{ all -> 0x041d }
            if (r0 == 0) goto L_0x02a3
            boolean r0 = r1.m442a(r6, r10)     // Catch:{ all -> 0x041d }
            if (r0 == 0) goto L_0x01ff
            com.google.android.play.core.internal.af r0 = f552a     // Catch:{ all -> 0x041d }
            java.lang.Object[] r4 = new java.lang.Object[r8]     // Catch:{ all -> 0x041d }
            int r9 = r6.f530a     // Catch:{ all -> 0x041d }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x041d }
            r4[r7] = r9     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.cl r9 = r6.f532c     // Catch:{ all -> 0x041d }
            java.lang.String r9 = r9.f525a     // Catch:{ all -> 0x041d }
            r11 = 1
            r4[r11] = r9     // Catch:{ all -> 0x041d }
            java.lang.String r9 = r10.f533a     // Catch:{ all -> 0x041d }
            r11 = 2
            r4[r11] = r9     // Catch:{ all -> 0x041d }
            java.lang.String r9 = "Found extraction task for patch for session %s, pack %s, slice %s."
            r0.mo33550a(r9, r4)     // Catch:{ all -> 0x041d }
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x027c }
            com.google.android.play.core.assetpacks.bb r11 = r1.f554c     // Catch:{ FileNotFoundException -> 0x027c }
            com.google.android.play.core.assetpacks.cl r4 = r6.f532c     // Catch:{ FileNotFoundException -> 0x027c }
            java.lang.String r12 = r4.f525a     // Catch:{ FileNotFoundException -> 0x027c }
            int r13 = r6.f531b     // Catch:{ FileNotFoundException -> 0x027c }
            long r14 = r4.f526b     // Catch:{ FileNotFoundException -> 0x027c }
            java.lang.String r4 = r10.f533a     // Catch:{ FileNotFoundException -> 0x027c }
            r16 = r4
            java.io.File r4 = r11.mo33394e(r12, r13, r14, r16)     // Catch:{ FileNotFoundException -> 0x027c }
            r0.<init>(r4)     // Catch:{ FileNotFoundException -> 0x027c }
            com.google.android.play.core.assetpacks.bs r4 = new com.google.android.play.core.assetpacks.bs     // Catch:{ all -> 0x041d }
            int r9 = r6.f530a     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.cl r11 = r6.f532c     // Catch:{ all -> 0x041d }
            java.lang.String r12 = r11.f525a     // Catch:{ all -> 0x041d }
            int r6 = r6.f531b     // Catch:{ all -> 0x041d }
            long r13 = r11.f526b     // Catch:{ all -> 0x041d }
            java.lang.String r10 = r10.f533a     // Catch:{ all -> 0x041d }
            long r7 = r11.f528d     // Catch:{ all -> 0x041d }
            r26 = 0
            r27 = 0
            r28 = 1
            int r11 = r11.f527c     // Catch:{ all -> 0x041d }
            r19 = r4
            r20 = r9
            r21 = r12
            r22 = r6
            r23 = r13
            r25 = r10
            r29 = r7
            r31 = r11
            r32 = r0
            r19.<init>(r20, r21, r22, r23, r25, r26, r27, r28, r29, r31, r32)     // Catch:{ all -> 0x041d }
            r0 = r4
            goto L_0x035b
        L_0x027c:
            r0 = move-exception
            com.google.android.play.core.assetpacks.bv r2 = new com.google.android.play.core.assetpacks.bv     // Catch:{ all -> 0x041d }
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x041d }
            int r4 = r6.f530a     // Catch:{ all -> 0x041d }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x041d }
            r5 = 0
            r3[r5] = r4     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.cl r4 = r6.f532c     // Catch:{ all -> 0x041d }
            java.lang.String r4 = r4.f525a     // Catch:{ all -> 0x041d }
            r5 = 1
            r3[r5] = r4     // Catch:{ all -> 0x041d }
            java.lang.String r4 = r10.f533a     // Catch:{ all -> 0x041d }
            r5 = 2
            r3[r5] = r4     // Catch:{ all -> 0x041d }
            java.lang.String r4 = "Error finding patch, session %s packName %s sliceId %s"
            java.lang.String r3 = java.lang.String.format(r4, r3)     // Catch:{ all -> 0x041d }
            int r4 = r6.f530a     // Catch:{ all -> 0x041d }
            r2.<init>(r3, r0, r4)     // Catch:{ all -> 0x041d }
            throw r2     // Catch:{ all -> 0x041d }
        L_0x02a3:
            com.google.android.play.core.assetpacks.dr r0 = new com.google.android.play.core.assetpacks.dr     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.bb r7 = r1.f554c     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.cl r8 = r6.f532c     // Catch:{ all -> 0x041d }
            java.lang.String r11 = r8.f525a     // Catch:{ all -> 0x041d }
            int r12 = r6.f531b     // Catch:{ all -> 0x041d }
            long r13 = r8.f526b     // Catch:{ all -> 0x041d }
            java.lang.String r8 = r10.f533a     // Catch:{ all -> 0x041d }
            r19 = r0
            r20 = r7
            r21 = r11
            r22 = r12
            r23 = r13
            r25 = r8
            r19.<init>(r20, r21, r22, r23, r25)     // Catch:{ all -> 0x041d }
            int r7 = r0.mo33499c()     // Catch:{ IOException -> 0x02c5 }
            goto L_0x02d5
        L_0x02c5:
            r0 = move-exception
            r7 = r0
            com.google.android.play.core.internal.af r0 = f552a     // Catch:{ all -> 0x041d }
            r8 = 1
            java.lang.Object[] r11 = new java.lang.Object[r8]     // Catch:{ all -> 0x041d }
            r8 = 0
            r11[r8] = r7     // Catch:{ all -> 0x041d }
            java.lang.String r7 = "Slice checkpoint corrupt, restarting extraction. %s"
            r0.mo33552b(r7, r11)     // Catch:{ all -> 0x041d }
            r7 = 0
        L_0x02d5:
            r0 = -1
            if (r7 == r0) goto L_0x0356
            java.util.List<com.google.android.play.core.assetpacks.ck> r0 = r10.f536d     // Catch:{ all -> 0x041d }
            java.lang.Object r0 = r0.get(r7)     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.ck r0 = (com.google.android.play.core.assetpacks.C1906ck) r0     // Catch:{ all -> 0x041d }
            boolean r0 = r0.f524a     // Catch:{ all -> 0x041d }
            if (r0 == 0) goto L_0x0356
            com.google.android.play.core.internal.af r0 = f552a     // Catch:{ all -> 0x041d }
            r4 = 5
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x041d }
            int r8 = r10.f537e     // Catch:{ all -> 0x041d }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x041d }
            r9 = 0
            r4[r9] = r8     // Catch:{ all -> 0x041d }
            int r8 = r6.f530a     // Catch:{ all -> 0x041d }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x041d }
            r9 = 1
            r4[r9] = r8     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.cl r8 = r6.f532c     // Catch:{ all -> 0x041d }
            java.lang.String r8 = r8.f525a     // Catch:{ all -> 0x041d }
            r9 = 2
            r4[r9] = r8     // Catch:{ all -> 0x041d }
            java.lang.String r8 = r10.f533a     // Catch:{ all -> 0x041d }
            r9 = 3
            r4[r9] = r8     // Catch:{ all -> 0x041d }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x041d }
            r4[r5] = r8     // Catch:{ all -> 0x041d }
            java.lang.String r8 = "Found extraction task using compression format %s for session %s, pack %s, slice %s, chunk %s."
            r0.mo33550a(r8, r4)     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.bk r0 = r1.f555d     // Catch:{ all -> 0x041d }
            int r4 = r6.f530a     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.cl r8 = r6.f532c     // Catch:{ all -> 0x041d }
            java.lang.String r8 = r8.f525a     // Catch:{ all -> 0x041d }
            java.lang.String r9 = r10.f533a     // Catch:{ all -> 0x041d }
            java.io.InputStream r32 = r0.mo33418a(r4, r8, r9, r7)     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.bs r0 = new com.google.android.play.core.assetpacks.bs     // Catch:{ all -> 0x041d }
            int r4 = r6.f530a     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.cl r8 = r6.f532c     // Catch:{ all -> 0x041d }
            java.lang.String r9 = r8.f525a     // Catch:{ all -> 0x041d }
            int r11 = r6.f531b     // Catch:{ all -> 0x041d }
            long r12 = r8.f526b     // Catch:{ all -> 0x041d }
            java.lang.String r8 = r10.f533a     // Catch:{ all -> 0x041d }
            int r14 = r10.f537e     // Catch:{ all -> 0x041d }
            java.util.List<com.google.android.play.core.assetpacks.ck> r10 = r10.f536d     // Catch:{ all -> 0x041d }
            int r28 = r10.size()     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.cl r6 = r6.f532c     // Catch:{ all -> 0x041d }
            r33 = r4
            long r3 = r6.f528d     // Catch:{ all -> 0x041d }
            int r6 = r6.f527c     // Catch:{ all -> 0x041d }
            r19 = r0
            r20 = r33
            r21 = r9
            r22 = r11
            r23 = r12
            r25 = r8
            r26 = r14
            r27 = r7
            r29 = r3
            r31 = r6
            r19.<init>(r20, r21, r22, r23, r25, r26, r27, r28, r29, r31, r32)     // Catch:{ all -> 0x041d }
            goto L_0x035b
        L_0x0356:
            r7 = 0
            r8 = 3
            goto L_0x01ff
        L_0x035a:
            r0 = 0
        L_0x035b:
            if (r0 != 0) goto L_0x0410
            java.util.Iterator r0 = r2.iterator()     // Catch:{ all -> 0x041d }
        L_0x0361:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x041d }
            if (r2 == 0) goto L_0x040d
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.cm r2 = (com.google.android.play.core.assetpacks.C1908cm) r2     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.cl r3 = r2.f532c     // Catch:{ all -> 0x041d }
            int r3 = r3.f527c     // Catch:{ all -> 0x041d }
            boolean r3 = com.google.android.play.core.assetpacks.C1924db.m476c(r3)     // Catch:{ all -> 0x041d }
            if (r3 == 0) goto L_0x0361
            com.google.android.play.core.assetpacks.cl r3 = r2.f532c     // Catch:{ all -> 0x041d }
            java.util.List<com.google.android.play.core.assetpacks.cn> r3 = r3.f529e     // Catch:{ all -> 0x041d }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x041d }
        L_0x037f:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x041d }
            if (r4 == 0) goto L_0x0361
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.cn r4 = (com.google.android.play.core.assetpacks.C1909cn) r4     // Catch:{ all -> 0x041d }
            boolean r6 = m443a(r4)     // Catch:{ all -> 0x041d }
            if (r6 == 0) goto L_0x037f
            java.util.List<com.google.android.play.core.assetpacks.ck> r6 = r4.f536d     // Catch:{ all -> 0x041d }
            r7 = 0
            java.lang.Object r6 = r6.get(r7)     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.ck r6 = (com.google.android.play.core.assetpacks.C1906ck) r6     // Catch:{ all -> 0x041d }
            boolean r6 = r6.f524a     // Catch:{ all -> 0x041d }
            if (r6 == 0) goto L_0x037f
            boolean r6 = r1.m442a(r2, r4)     // Catch:{ all -> 0x041d }
            if (r6 != 0) goto L_0x037f
            com.google.android.play.core.internal.af r0 = f552a     // Catch:{ all -> 0x041d }
            java.lang.Object[] r3 = new java.lang.Object[r5]     // Catch:{ all -> 0x041d }
            int r5 = r4.f538f     // Catch:{ all -> 0x041d }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x041d }
            r6 = 0
            r3[r6] = r5     // Catch:{ all -> 0x041d }
            int r5 = r2.f530a     // Catch:{ all -> 0x041d }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x041d }
            r6 = 1
            r3[r6] = r5     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.cl r5 = r2.f532c     // Catch:{ all -> 0x041d }
            java.lang.String r5 = r5.f525a     // Catch:{ all -> 0x041d }
            r7 = 2
            r3[r7] = r5     // Catch:{ all -> 0x041d }
            java.lang.String r5 = r4.f533a     // Catch:{ all -> 0x041d }
            r8 = 3
            r3[r8] = r5     // Catch:{ all -> 0x041d }
            java.lang.String r5 = "Found patch slice task using patch format %s for session %s, pack %s, slice %s."
            r0.mo33550a(r5, r3)     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.bk r0 = r1.f555d     // Catch:{ all -> 0x041d }
            int r3 = r2.f530a     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.cl r5 = r2.f532c     // Catch:{ all -> 0x041d }
            java.lang.String r5 = r5.f525a     // Catch:{ all -> 0x041d }
            java.lang.String r6 = r4.f533a     // Catch:{ all -> 0x041d }
            r9 = 0
            java.io.InputStream r23 = r0.mo33418a(r3, r5, r6, r9)     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.dn r0 = new com.google.android.play.core.assetpacks.dn     // Catch:{ all -> 0x041d }
            int r11 = r2.f530a     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.cl r3 = r2.f532c     // Catch:{ all -> 0x041d }
            java.lang.String r12 = r3.f525a     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.bb r3 = r1.f554c     // Catch:{ all -> 0x041d }
            int r13 = r3.mo33392e(r12)     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.bb r3 = r1.f554c     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.cl r5 = r2.f532c     // Catch:{ all -> 0x041d }
            java.lang.String r5 = r5.f525a     // Catch:{ all -> 0x041d }
            long r14 = r3.mo33396f(r5)     // Catch:{ all -> 0x041d }
            int r3 = r2.f531b     // Catch:{ all -> 0x041d }
            com.google.android.play.core.assetpacks.cl r2 = r2.f532c     // Catch:{ all -> 0x041d }
            long r5 = r2.f526b     // Catch:{ all -> 0x041d }
            int r2 = r4.f538f     // Catch:{ all -> 0x041d }
            java.lang.String r7 = r4.f533a     // Catch:{ all -> 0x041d }
            long r8 = r4.f535c     // Catch:{ all -> 0x041d }
            r10 = r0
            r16 = r3
            r17 = r5
            r19 = r2
            r20 = r7
            r21 = r8
            r10.<init>(r11, r12, r13, r14, r16, r17, r19, r20, r21, r23)     // Catch:{ all -> 0x041d }
            goto L_0x040e
        L_0x040d:
            r0 = 0
        L_0x040e:
            if (r0 == 0) goto L_0x0416
        L_0x0410:
            com.google.android.play.core.assetpacks.cp r2 = r1.f553b
            r2.mo33446b()
            return r0
        L_0x0416:
            com.google.android.play.core.assetpacks.cp r0 = r1.f553b
            r0.mo33446b()
            r2 = 0
            return r2
        L_0x041d:
            r0 = move-exception
            com.google.android.play.core.assetpacks.cp r2 = r1.f553b
            r2.mo33446b()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.assetpacks.C1914cs.mo33456a():com.google.android.play.core.assetpacks.cr");
    }
}
