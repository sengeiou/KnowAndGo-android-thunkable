package com.uxcam.internals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/* renamed from: com.uxcam.internals.bp */
public final class C2991bp {

    /* renamed from: c */
    private static final Pattern f1575c = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: d */
    private static final Pattern f1576d = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: e */
    private static final Pattern f1577e = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: f */
    private static final Pattern f1578f = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a */
    public final String f1579a;

    /* renamed from: b */
    public final String f1580b;

    /* renamed from: g */
    private final long f1581g;

    /* renamed from: h */
    private final String f1582h;

    /* renamed from: i */
    private final String f1583i;

    /* renamed from: j */
    private final boolean f1584j;

    /* renamed from: k */
    private final boolean f1585k;

    /* renamed from: l */
    private final boolean f1586l;

    /* renamed from: m */
    private final boolean f1587m;

    private C2991bp(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f1579a = str;
        this.f1580b = str2;
        this.f1581g = j;
        this.f1582h = str3;
        this.f1583i = str4;
        this.f1584j = z;
        this.f1585k = z2;
        this.f1587m = z3;
        this.f1586l = z4;
    }

    /* renamed from: a */
    private static int m1263a(String str, int i, int i2, boolean z) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (((charAt < ' ' && charAt != 9) || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: a */
    private static long m1264a(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e) {
            if (str.matches("-?\\d+")) {
                return str.startsWith("-") ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
            throw e;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:147:0x02ac, code lost:
        if (com.uxcam.internals.C3030cl.m1437b(r0) == false) goto L_0x02b0;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x027e  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0285  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02c2  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x02c5  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.uxcam.internals.C2991bp m1265a(long r32, com.uxcam.internals.C3002bw r34, java.lang.String r35) {
        /*
            r2 = r34
            r3 = r35
            int r4 = r35.length()
            r5 = 59
            r6 = 0
            int r7 = com.uxcam.internals.C3030cl.m1417a((java.lang.String) r3, (int) r6, (int) r4, (char) r5)
            r8 = 61
            int r9 = com.uxcam.internals.C3030cl.m1417a((java.lang.String) r3, (int) r6, (int) r7, (char) r8)
            r10 = 0
            if (r9 != r7) goto L_0x0019
            return r10
        L_0x0019:
            java.lang.String r12 = com.uxcam.internals.C3030cl.m1438c(r3, r6, r9)
            boolean r11 = r12.isEmpty()
            if (r11 == 0) goto L_0x0024
            return r10
        L_0x0024:
            r11 = 1
            int r9 = r9 + r11
            java.lang.String r13 = com.uxcam.internals.C3030cl.m1438c(r3, r9, r7)
            int r7 = r7 + r11
            r16 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
            r9 = r10
            r22 = r9
            r20 = r16
            r18 = -1
            r23 = 0
            r24 = 0
            r25 = 1
            r26 = 0
        L_0x003f:
            if (r7 >= r4) goto L_0x024b
            int r10 = com.uxcam.internals.C3030cl.m1417a((java.lang.String) r3, (int) r7, (int) r4, (char) r5)
            int r14 = com.uxcam.internals.C3030cl.m1417a((java.lang.String) r3, (int) r7, (int) r10, (char) r8)
            java.lang.String r7 = com.uxcam.internals.C3030cl.m1438c(r3, r7, r14)
            if (r14 >= r10) goto L_0x0056
            int r14 = r14 + 1
            java.lang.String r14 = com.uxcam.internals.C3030cl.m1438c(r3, r14, r10)
            goto L_0x0058
        L_0x0056:
            java.lang.String r14 = ""
        L_0x0058:
            java.lang.String r15 = "expires"
            boolean r15 = r7.equalsIgnoreCase(r15)
            if (r15 == 0) goto L_0x01d4
            int r7 = r14.length()     // Catch:{ IllegalArgumentException -> 0x01ce }
            int r15 = m1263a(r14, r6, r7, r6)     // Catch:{ IllegalArgumentException -> 0x01ce }
            java.util.regex.Pattern r8 = f1578f     // Catch:{ IllegalArgumentException -> 0x01ce }
            java.util.regex.Matcher r8 = r8.matcher(r14)     // Catch:{ IllegalArgumentException -> 0x01ce }
            r5 = -1
            r6 = -1
            r27 = -1
            r28 = -1
            r29 = -1
            r30 = -1
        L_0x0078:
            if (r15 >= r7) goto L_0x0132
            int r11 = r15 + 1
            r3 = 1
            int r11 = m1263a(r14, r11, r7, r3)     // Catch:{ IllegalArgumentException -> 0x01ce }
            r8.region(r15, r11)     // Catch:{ IllegalArgumentException -> 0x01ce }
            r3 = -1
            if (r5 != r3) goto L_0x00b7
            java.util.regex.Pattern r3 = f1578f     // Catch:{ IllegalArgumentException -> 0x01ce }
            java.util.regex.Matcher r3 = r8.usePattern(r3)     // Catch:{ IllegalArgumentException -> 0x01ce }
            boolean r3 = r3.matches()     // Catch:{ IllegalArgumentException -> 0x01ce }
            if (r3 == 0) goto L_0x00b7
            r3 = 1
            java.lang.String r5 = r8.group(r3)     // Catch:{ IllegalArgumentException -> 0x01ce }
            int r3 = java.lang.Integer.parseInt(r5)     // Catch:{ IllegalArgumentException -> 0x01ce }
            r5 = 2
            java.lang.String r5 = r8.group(r5)     // Catch:{ IllegalArgumentException -> 0x01ce }
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ IllegalArgumentException -> 0x01ce }
            r15 = 3
            java.lang.String r15 = r8.group(r15)     // Catch:{ IllegalArgumentException -> 0x01ce }
            int r15 = java.lang.Integer.parseInt(r15)     // Catch:{ IllegalArgumentException -> 0x01ce }
            r31 = r4
            r29 = r5
            r30 = r15
            r5 = r3
            goto L_0x0125
        L_0x00b7:
            r3 = r28
            r15 = -1
            if (r3 != r15) goto L_0x00d6
            java.util.regex.Pattern r15 = f1577e     // Catch:{ IllegalArgumentException -> 0x01ce }
            java.util.regex.Matcher r15 = r8.usePattern(r15)     // Catch:{ IllegalArgumentException -> 0x01ce }
            boolean r15 = r15.matches()     // Catch:{ IllegalArgumentException -> 0x01ce }
            if (r15 == 0) goto L_0x00d6
            r15 = 1
            java.lang.String r3 = r8.group(r15)     // Catch:{ IllegalArgumentException -> 0x01ce }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ IllegalArgumentException -> 0x01ce }
            r28 = r3
            r31 = r4
            goto L_0x0125
        L_0x00d6:
            r31 = r4
            r15 = r27
            r4 = -1
            if (r15 != r4) goto L_0x0106
            java.util.regex.Pattern r4 = f1576d     // Catch:{ IllegalArgumentException -> 0x01d0 }
            java.util.regex.Matcher r4 = r8.usePattern(r4)     // Catch:{ IllegalArgumentException -> 0x01d0 }
            boolean r4 = r4.matches()     // Catch:{ IllegalArgumentException -> 0x01d0 }
            if (r4 == 0) goto L_0x0105
            r4 = 1
            java.lang.String r15 = r8.group(r4)     // Catch:{ IllegalArgumentException -> 0x01d0 }
            java.util.Locale r4 = java.util.Locale.US     // Catch:{ IllegalArgumentException -> 0x01d0 }
            java.lang.String r4 = r15.toLowerCase(r4)     // Catch:{ IllegalArgumentException -> 0x01d0 }
            java.util.regex.Pattern r15 = f1576d     // Catch:{ IllegalArgumentException -> 0x01d0 }
            java.lang.String r15 = r15.pattern()     // Catch:{ IllegalArgumentException -> 0x01d0 }
            int r4 = r15.indexOf(r4)     // Catch:{ IllegalArgumentException -> 0x01d0 }
            int r4 = r4 / 4
            r28 = r3
            r27 = r4
            goto L_0x0125
        L_0x0105:
            r4 = -1
        L_0x0106:
            if (r6 != r4) goto L_0x0121
            java.util.regex.Pattern r4 = f1575c     // Catch:{ IllegalArgumentException -> 0x01d0 }
            java.util.regex.Matcher r4 = r8.usePattern(r4)     // Catch:{ IllegalArgumentException -> 0x01d0 }
            boolean r4 = r4.matches()     // Catch:{ IllegalArgumentException -> 0x01d0 }
            if (r4 == 0) goto L_0x0121
            r4 = 1
            java.lang.String r6 = r8.group(r4)     // Catch:{ IllegalArgumentException -> 0x01d0 }
            int r4 = java.lang.Integer.parseInt(r6)     // Catch:{ IllegalArgumentException -> 0x01d0 }
            r28 = r3
            r6 = r4
            goto L_0x0123
        L_0x0121:
            r28 = r3
        L_0x0123:
            r27 = r15
        L_0x0125:
            int r11 = r11 + 1
            r3 = 0
            int r15 = m1263a(r14, r11, r7, r3)     // Catch:{ IllegalArgumentException -> 0x01d0 }
            r4 = r31
            r3 = r35
            goto L_0x0078
        L_0x0132:
            r31 = r4
            r15 = r27
            r3 = r28
            r4 = 70
            if (r6 < r4) goto L_0x0142
            r4 = 99
            if (r6 > r4) goto L_0x0142
            int r6 = r6 + 1900
        L_0x0142:
            if (r6 < 0) goto L_0x014a
            r4 = 69
            if (r6 > r4) goto L_0x014a
            int r6 = r6 + 2000
        L_0x014a:
            r4 = 1601(0x641, float:2.243E-42)
            if (r6 < r4) goto L_0x01c6
            r4 = -1
            if (r15 == r4) goto L_0x01be
            if (r3 <= 0) goto L_0x01b6
            r4 = 31
            if (r3 > r4) goto L_0x01b6
            if (r5 < 0) goto L_0x01ae
            r4 = 23
            if (r5 > r4) goto L_0x01ae
            r4 = r29
            if (r4 < 0) goto L_0x01a6
            r8 = 59
            if (r4 > r8) goto L_0x01a8
            r7 = r30
            if (r7 < 0) goto L_0x01a0
            if (r7 > r8) goto L_0x01a0
            java.util.GregorianCalendar r11 = new java.util.GregorianCalendar     // Catch:{ IllegalArgumentException -> 0x023c }
            java.util.TimeZone r14 = com.uxcam.internals.C3030cl.f1785f     // Catch:{ IllegalArgumentException -> 0x023c }
            r11.<init>(r14)     // Catch:{ IllegalArgumentException -> 0x023c }
            r14 = 0
            r11.setLenient(r14)     // Catch:{ IllegalArgumentException -> 0x023c }
            r14 = 1
            r11.set(r14, r6)     // Catch:{ IllegalArgumentException -> 0x023c }
            int r6 = r15 + -1
            r14 = 2
            r11.set(r14, r6)     // Catch:{ IllegalArgumentException -> 0x023c }
            r6 = 5
            r11.set(r6, r3)     // Catch:{ IllegalArgumentException -> 0x023c }
            r3 = 11
            r11.set(r3, r5)     // Catch:{ IllegalArgumentException -> 0x023c }
            r3 = 12
            r11.set(r3, r4)     // Catch:{ IllegalArgumentException -> 0x023c }
            r3 = 13
            r11.set(r3, r7)     // Catch:{ IllegalArgumentException -> 0x023c }
            r3 = 14
            r4 = 0
            r11.set(r3, r4)     // Catch:{ IllegalArgumentException -> 0x023c }
            long r3 = r11.getTimeInMillis()     // Catch:{ IllegalArgumentException -> 0x023c }
            r20 = r3
            goto L_0x01e6
        L_0x01a0:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x023c }
            r3.<init>()     // Catch:{ IllegalArgumentException -> 0x023c }
            throw r3     // Catch:{ IllegalArgumentException -> 0x023c }
        L_0x01a6:
            r8 = 59
        L_0x01a8:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x023c }
            r3.<init>()     // Catch:{ IllegalArgumentException -> 0x023c }
            throw r3     // Catch:{ IllegalArgumentException -> 0x023c }
        L_0x01ae:
            r8 = 59
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x023c }
            r3.<init>()     // Catch:{ IllegalArgumentException -> 0x023c }
            throw r3     // Catch:{ IllegalArgumentException -> 0x023c }
        L_0x01b6:
            r8 = 59
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x023c }
            r3.<init>()     // Catch:{ IllegalArgumentException -> 0x023c }
            throw r3     // Catch:{ IllegalArgumentException -> 0x023c }
        L_0x01be:
            r8 = 59
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x023c }
            r3.<init>()     // Catch:{ IllegalArgumentException -> 0x023c }
            throw r3     // Catch:{ IllegalArgumentException -> 0x023c }
        L_0x01c6:
            r8 = 59
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x023c }
            r3.<init>()     // Catch:{ IllegalArgumentException -> 0x023c }
            throw r3     // Catch:{ IllegalArgumentException -> 0x023c }
        L_0x01ce:
            r31 = r4
        L_0x01d0:
            r8 = 59
            goto L_0x023c
        L_0x01d4:
            r31 = r4
            r8 = 59
            java.lang.String r3 = "max-age"
            boolean r3 = r7.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x01e9
            long r3 = m1264a(r14)     // Catch:{  }
            r18 = r3
        L_0x01e6:
            r26 = 1
            goto L_0x023c
        L_0x01e9:
            java.lang.String r3 = "domain"
            boolean r3 = r7.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x021c
            java.lang.String r3 = "."
            boolean r3 = r14.endsWith(r3)     // Catch:{ IllegalArgumentException -> 0x023c }
            if (r3 != 0) goto L_0x0216
            java.lang.String r3 = "."
            boolean r3 = r14.startsWith(r3)     // Catch:{ IllegalArgumentException -> 0x023c }
            if (r3 == 0) goto L_0x0206
            r3 = 1
            java.lang.String r14 = r14.substring(r3)     // Catch:{ IllegalArgumentException -> 0x023c }
        L_0x0206:
            java.lang.String r3 = com.uxcam.internals.C3030cl.m1421a((java.lang.String) r14)     // Catch:{ IllegalArgumentException -> 0x023c }
            if (r3 == 0) goto L_0x0210
            r9 = r3
            r25 = 0
            goto L_0x023c
        L_0x0210:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x023c }
            r3.<init>()     // Catch:{ IllegalArgumentException -> 0x023c }
            throw r3     // Catch:{ IllegalArgumentException -> 0x023c }
        L_0x0216:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x023c }
            r3.<init>()     // Catch:{ IllegalArgumentException -> 0x023c }
            throw r3     // Catch:{ IllegalArgumentException -> 0x023c }
        L_0x021c:
            java.lang.String r3 = "path"
            boolean r3 = r7.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0227
            r22 = r14
            goto L_0x023c
        L_0x0227:
            java.lang.String r3 = "secure"
            boolean r3 = r7.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0232
            r23 = 1
            goto L_0x023c
        L_0x0232:
            java.lang.String r3 = "httponly"
            boolean r3 = r7.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x023c
            r24 = 1
        L_0x023c:
            int r7 = r10 + 1
            r4 = r31
            r3 = r35
            r5 = 59
            r6 = 0
            r8 = 61
            r10 = 0
            r11 = 1
            goto L_0x003f
        L_0x024b:
            r3 = -9223372036854775808
            int r5 = (r18 > r3 ? 1 : (r18 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x0253
        L_0x0251:
            r14 = r3
            goto L_0x027c
        L_0x0253:
            r3 = -1
            int r3 = (r18 > r3 ? 1 : (r18 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x027a
            r3 = 9223372036854775(0x20c49ba5e353f7, double:4.663754807431093E-308)
            int r3 = (r18 > r3 ? 1 : (r18 == r3 ? 0 : -1))
            if (r3 > 0) goto L_0x0267
            r3 = 1000(0x3e8, double:4.94E-321)
            long r18 = r18 * r3
            goto L_0x026c
        L_0x0267:
            r18 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x026c:
            r3 = 0
            long r3 = r32 + r18
            int r0 = (r3 > r32 ? 1 : (r3 == r32 ? 0 : -1))
            if (r0 < 0) goto L_0x0277
            int r0 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
            if (r0 <= 0) goto L_0x0251
        L_0x0277:
            r14 = r16
            goto L_0x027c
        L_0x027a:
            r14 = r20
        L_0x027c:
            if (r9 != 0) goto L_0x0285
            java.lang.String r0 = r2.f1610b
            r16 = r0
        L_0x0282:
            r10 = r22
            goto L_0x02b7
        L_0x0285:
            java.lang.String r0 = r2.f1610b
            boolean r1 = r0.equals(r9)
            if (r1 == 0) goto L_0x028f
            r3 = 1
            goto L_0x02b0
        L_0x028f:
            boolean r1 = r0.endsWith(r9)
            if (r1 == 0) goto L_0x02af
            int r1 = r0.length()
            int r3 = r9.length()
            int r1 = r1 - r3
            r3 = 1
            int r1 = r1 - r3
            char r1 = r0.charAt(r1)
            r4 = 46
            if (r1 != r4) goto L_0x02af
            boolean r0 = com.uxcam.internals.C3030cl.m1437b(r0)
            if (r0 != 0) goto L_0x02af
            goto L_0x02b0
        L_0x02af:
            r3 = 0
        L_0x02b0:
            if (r3 != 0) goto L_0x02b4
            r0 = 0
            return r0
        L_0x02b4:
            r16 = r9
            goto L_0x0282
        L_0x02b7:
            if (r10 == 0) goto L_0x02c5
            java.lang.String r0 = "/"
            boolean r0 = r10.startsWith(r0)
            if (r0 != 0) goto L_0x02c2
            goto L_0x02c5
        L_0x02c2:
            r17 = r10
            goto L_0x02db
        L_0x02c5:
            java.lang.String r0 = r34.mo38126e()
            r1 = 47
            int r1 = r0.lastIndexOf(r1)
            if (r1 == 0) goto L_0x02d7
            r2 = 0
            java.lang.String r0 = r0.substring(r2, r1)
            goto L_0x02d9
        L_0x02d7:
            java.lang.String r0 = "/"
        L_0x02d9:
            r17 = r0
        L_0x02db:
            com.uxcam.internals.bp r0 = new com.uxcam.internals.bp
            r11 = r0
            r18 = r23
            r19 = r24
            r20 = r25
            r21 = r26
            r11.<init>(r12, r13, r14, r16, r17, r18, r19, r20, r21)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C2991bp.m1265a(long, com.uxcam.internals.bw, java.lang.String):com.uxcam.internals.bp");
    }

    /* renamed from: a */
    public static List m1266a(C3002bw bwVar, C3000bv bvVar) {
        int length = bvVar.f1606a.length / 2;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        for (int i = 0; i < length; i++) {
            if ("Set-Cookie".equalsIgnoreCase(bvVar.mo38112a(i))) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList(2);
                }
                arrayList2.add(bvVar.mo38114b(i));
            }
        }
        List unmodifiableList = arrayList2 != null ? Collections.unmodifiableList(arrayList2) : Collections.emptyList();
        int size = unmodifiableList.size();
        for (int i2 = 0; i2 < size; i2++) {
            C2991bp a = m1265a(System.currentTimeMillis(), bwVar, (String) unmodifiableList.get(i2));
            if (a != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(a);
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C2991bp)) {
            return false;
        }
        C2991bp bpVar = (C2991bp) obj;
        return bpVar.f1579a.equals(this.f1579a) && bpVar.f1580b.equals(this.f1580b) && bpVar.f1582h.equals(this.f1582h) && bpVar.f1583i.equals(this.f1583i) && bpVar.f1581g == this.f1581g && bpVar.f1584j == this.f1584j && bpVar.f1585k == this.f1585k && bpVar.f1586l == this.f1586l && bpVar.f1587m == this.f1587m;
    }

    public final int hashCode() {
        return ((((((((((((((((this.f1579a.hashCode() + 527) * 31) + this.f1580b.hashCode()) * 31) + this.f1582h.hashCode()) * 31) + this.f1583i.hashCode()) * 31) + ((int) (this.f1581g ^ (this.f1581g >>> 32)))) * 31) + (this.f1584j ^ true ? 1 : 0)) * 31) + (this.f1585k ^ true ? 1 : 0)) * 31) + (this.f1586l ^ true ? 1 : 0)) * 31) + (this.f1587m ^ true ? 1 : 0);
    }

    public final String toString() {
        String a;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1579a);
        sb.append('=');
        sb.append(this.f1580b);
        if (this.f1586l) {
            if (this.f1581g == Long.MIN_VALUE) {
                a = "; max-age=0";
            } else {
                sb.append("; expires=");
                a = C3052db.m1496a(new Date(this.f1581g));
            }
            sb.append(a);
        }
        if (!this.f1587m) {
            sb.append("; domain=");
            sb.append(this.f1582h);
        }
        sb.append("; path=");
        sb.append(this.f1583i);
        if (this.f1584j) {
            sb.append("; secure");
        }
        if (this.f1585k) {
            sb.append("; httponly");
        }
        return sb.toString();
    }
}
