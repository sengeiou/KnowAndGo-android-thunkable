package com.uxcam.internals;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;

/* renamed from: com.uxcam.internals.ej */
public final class C3121ej implements HostnameVerifier {

    /* renamed from: a */
    public static final C3121ej f2140a = new C3121ej();

    private C3121ej() {
    }

    /* renamed from: a */
    public static List m1721a(X509Certificate x509Certificate) {
        List a = m1722a(x509Certificate, 7);
        List a2 = m1722a(x509Certificate, 2);
        ArrayList arrayList = new ArrayList(a.size() + a2.size());
        arrayList.addAll(a);
        arrayList.addAll(a2);
        return arrayList;
    }

    /* renamed from: a */
    private static List m1722a(X509Certificate x509Certificate, int i) {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List next : subjectAlternativeNames) {
                if (!(next == null || next.size() < 2 || (num = (Integer) next.get(0)) == null || num.intValue() != i || (str = (String) next.get(1)) == null)) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.emptyList();
        }
    }

    /* renamed from: a */
    private static boolean m1723a(String str, String str2) {
        if (str != null && str.length() != 0 && !str.startsWith(".") && !str.endsWith("..") && str2 != null && str2.length() != 0 && !str2.startsWith(".") && !str2.endsWith("..")) {
            if (!str.endsWith(".")) {
                str = str + '.';
            }
            if (!str2.endsWith(".")) {
                str2 = str2 + '.';
            }
            String lowerCase = str2.toLowerCase(Locale.US);
            if (!lowerCase.contains("*")) {
                return str.equals(lowerCase);
            }
            if (!lowerCase.startsWith("*.") || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || "*.".equals(lowerCase)) {
                return false;
            }
            String substring = lowerCase.substring(1);
            if (!str.endsWith(substring)) {
                return false;
            }
            int length = str.length() - substring.length();
            return length <= 0 || str.lastIndexOf(46, length - 1) == -1;
        }
        return false;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean verify(java.lang.String r11, javax.net.ssl.SSLSession r12) {
        /*
            r10 = this;
            r0 = 0
            java.security.cert.Certificate[] r12 = r12.getPeerCertificates()     // Catch:{ SSLException -> 0x0187 }
            r12 = r12[r0]     // Catch:{ SSLException -> 0x0187 }
            java.security.cert.X509Certificate r12 = (java.security.cert.X509Certificate) r12     // Catch:{ SSLException -> 0x0187 }
            boolean r1 = com.uxcam.internals.C3030cl.m1437b(r11)     // Catch:{ SSLException -> 0x0187 }
            r2 = 1
            if (r1 == 0) goto L_0x002d
            r1 = 7
            java.util.List r12 = m1722a((java.security.cert.X509Certificate) r12, (int) r1)     // Catch:{ SSLException -> 0x0187 }
            int r1 = r12.size()     // Catch:{ SSLException -> 0x0187 }
            r3 = 0
        L_0x001a:
            if (r3 >= r1) goto L_0x002c
            java.lang.Object r4 = r12.get(r3)     // Catch:{ SSLException -> 0x0187 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ SSLException -> 0x0187 }
            boolean r4 = r11.equalsIgnoreCase(r4)     // Catch:{ SSLException -> 0x0187 }
            if (r4 == 0) goto L_0x0029
            return r2
        L_0x0029:
            int r3 = r3 + 1
            goto L_0x001a
        L_0x002c:
            return r0
        L_0x002d:
            java.util.Locale r1 = java.util.Locale.US     // Catch:{ SSLException -> 0x0187 }
            java.lang.String r11 = r11.toLowerCase(r1)     // Catch:{ SSLException -> 0x0187 }
            r1 = 2
            java.util.List r1 = m1722a((java.security.cert.X509Certificate) r12, (int) r1)     // Catch:{ SSLException -> 0x0187 }
            int r3 = r1.size()     // Catch:{ SSLException -> 0x0187 }
            r4 = 0
            r5 = 0
        L_0x003e:
            if (r4 >= r3) goto L_0x0051
            java.lang.Object r5 = r1.get(r4)     // Catch:{ SSLException -> 0x0187 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ SSLException -> 0x0187 }
            boolean r5 = m1723a((java.lang.String) r11, (java.lang.String) r5)     // Catch:{ SSLException -> 0x0187 }
            if (r5 == 0) goto L_0x004d
            return r2
        L_0x004d:
            int r4 = r4 + 1
            r5 = 1
            goto L_0x003e
        L_0x0051:
            if (r5 != 0) goto L_0x0187
            javax.security.auth.x500.X500Principal r12 = r12.getSubjectX500Principal()     // Catch:{ SSLException -> 0x0187 }
            com.uxcam.internals.ei r1 = new com.uxcam.internals.ei     // Catch:{ SSLException -> 0x0187 }
            r1.<init>(r12)     // Catch:{ SSLException -> 0x0187 }
            java.lang.String r12 = "cn"
            r1.f2135c = r0     // Catch:{ SSLException -> 0x0187 }
            r1.f2136d = r0     // Catch:{ SSLException -> 0x0187 }
            r1.f2137e = r0     // Catch:{ SSLException -> 0x0187 }
            r1.f2138f = r0     // Catch:{ SSLException -> 0x0187 }
            java.lang.String r3 = r1.f2133a     // Catch:{ SSLException -> 0x0187 }
            char[] r3 = r3.toCharArray()     // Catch:{ SSLException -> 0x0187 }
            r1.f2139g = r3     // Catch:{ SSLException -> 0x0187 }
            java.lang.String r3 = r1.mo38333a()     // Catch:{ SSLException -> 0x0187 }
            r4 = 0
            if (r3 != 0) goto L_0x0077
            goto L_0x0128
        L_0x0077:
            java.lang.String r5 = ""
            int r6 = r1.f2135c     // Catch:{ SSLException -> 0x0187 }
            int r7 = r1.f2134b     // Catch:{ SSLException -> 0x0187 }
            if (r6 != r7) goto L_0x0081
            goto L_0x0128
        L_0x0081:
            char[] r6 = r1.f2139g     // Catch:{ SSLException -> 0x0187 }
            int r7 = r1.f2135c     // Catch:{ SSLException -> 0x0187 }
            char r6 = r6[r7]     // Catch:{ SSLException -> 0x0187 }
            switch(r6) {
                case 34: goto L_0x0096;
                case 35: goto L_0x0090;
                case 43: goto L_0x011a;
                case 44: goto L_0x011a;
                case 59: goto L_0x011a;
                default: goto L_0x008a;
            }     // Catch:{ SSLException -> 0x0187 }
        L_0x008a:
            java.lang.String r5 = r1.mo38335c()     // Catch:{ SSLException -> 0x0187 }
            goto L_0x011a
        L_0x0090:
            java.lang.String r5 = r1.mo38334b()     // Catch:{ SSLException -> 0x0187 }
            goto L_0x011a
        L_0x0096:
            int r5 = r1.f2135c     // Catch:{ SSLException -> 0x0187 }
            int r5 = r5 + r2
            r1.f2135c = r5     // Catch:{ SSLException -> 0x0187 }
            int r5 = r1.f2135c     // Catch:{ SSLException -> 0x0187 }
            r1.f2136d = r5     // Catch:{ SSLException -> 0x0187 }
            int r5 = r1.f2136d     // Catch:{ SSLException -> 0x0187 }
            r1.f2137e = r5     // Catch:{ SSLException -> 0x0187 }
        L_0x00a3:
            int r5 = r1.f2135c     // Catch:{ SSLException -> 0x0187 }
            int r6 = r1.f2134b     // Catch:{ SSLException -> 0x0187 }
            if (r5 == r6) goto L_0x0104
            char[] r5 = r1.f2139g     // Catch:{ SSLException -> 0x0187 }
            int r6 = r1.f2135c     // Catch:{ SSLException -> 0x0187 }
            char r5 = r5[r6]     // Catch:{ SSLException -> 0x0187 }
            r6 = 34
            if (r5 != r6) goto L_0x00d8
        L_0x00b3:
            int r5 = r1.f2135c     // Catch:{ SSLException -> 0x0187 }
            int r5 = r5 + r2
            r1.f2135c = r5     // Catch:{ SSLException -> 0x0187 }
            int r5 = r1.f2135c     // Catch:{ SSLException -> 0x0187 }
            int r6 = r1.f2134b     // Catch:{ SSLException -> 0x0187 }
            if (r5 >= r6) goto L_0x00c9
            char[] r5 = r1.f2139g     // Catch:{ SSLException -> 0x0187 }
            int r6 = r1.f2135c     // Catch:{ SSLException -> 0x0187 }
            char r5 = r5[r6]     // Catch:{ SSLException -> 0x0187 }
            r6 = 32
            if (r5 != r6) goto L_0x00c9
            goto L_0x00b3
        L_0x00c9:
            java.lang.String r5 = new java.lang.String     // Catch:{ SSLException -> 0x0187 }
            char[] r6 = r1.f2139g     // Catch:{ SSLException -> 0x0187 }
            int r7 = r1.f2136d     // Catch:{ SSLException -> 0x0187 }
            int r8 = r1.f2137e     // Catch:{ SSLException -> 0x0187 }
            int r9 = r1.f2136d     // Catch:{ SSLException -> 0x0187 }
            int r8 = r8 - r9
            r5.<init>(r6, r7, r8)     // Catch:{ SSLException -> 0x0187 }
            goto L_0x011a
        L_0x00d8:
            char[] r5 = r1.f2139g     // Catch:{ SSLException -> 0x0187 }
            int r6 = r1.f2135c     // Catch:{ SSLException -> 0x0187 }
            char r5 = r5[r6]     // Catch:{ SSLException -> 0x0187 }
            r6 = 92
            if (r5 != r6) goto L_0x00ed
            char[] r5 = r1.f2139g     // Catch:{ SSLException -> 0x0187 }
            int r6 = r1.f2137e     // Catch:{ SSLException -> 0x0187 }
            char r7 = r1.mo38336d()     // Catch:{ SSLException -> 0x0187 }
            r5[r6] = r7     // Catch:{ SSLException -> 0x0187 }
            goto L_0x00f9
        L_0x00ed:
            char[] r5 = r1.f2139g     // Catch:{ SSLException -> 0x0187 }
            int r6 = r1.f2137e     // Catch:{ SSLException -> 0x0187 }
            char[] r7 = r1.f2139g     // Catch:{ SSLException -> 0x0187 }
            int r8 = r1.f2135c     // Catch:{ SSLException -> 0x0187 }
            char r7 = r7[r8]     // Catch:{ SSLException -> 0x0187 }
            r5[r6] = r7     // Catch:{ SSLException -> 0x0187 }
        L_0x00f9:
            int r5 = r1.f2135c     // Catch:{ SSLException -> 0x0187 }
            int r5 = r5 + r2
            r1.f2135c = r5     // Catch:{ SSLException -> 0x0187 }
            int r5 = r1.f2137e     // Catch:{ SSLException -> 0x0187 }
            int r5 = r5 + r2
            r1.f2137e = r5     // Catch:{ SSLException -> 0x0187 }
            goto L_0x00a3
        L_0x0104:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException     // Catch:{ SSLException -> 0x0187 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ SSLException -> 0x0187 }
            java.lang.String r2 = "Unexpected end of DN: "
            r12.<init>(r2)     // Catch:{ SSLException -> 0x0187 }
            java.lang.String r1 = r1.f2133a     // Catch:{ SSLException -> 0x0187 }
            r12.append(r1)     // Catch:{ SSLException -> 0x0187 }
            java.lang.String r12 = r12.toString()     // Catch:{ SSLException -> 0x0187 }
            r11.<init>(r12)     // Catch:{ SSLException -> 0x0187 }
            throw r11     // Catch:{ SSLException -> 0x0187 }
        L_0x011a:
            boolean r3 = r12.equalsIgnoreCase(r3)     // Catch:{ SSLException -> 0x0187 }
            if (r3 == 0) goto L_0x0122
            r4 = r5
            goto L_0x0128
        L_0x0122:
            int r3 = r1.f2135c     // Catch:{ SSLException -> 0x0187 }
            int r5 = r1.f2134b     // Catch:{ SSLException -> 0x0187 }
            if (r3 < r5) goto L_0x012f
        L_0x0128:
            if (r4 == 0) goto L_0x0187
            boolean r11 = m1723a((java.lang.String) r11, (java.lang.String) r4)     // Catch:{ SSLException -> 0x0187 }
            return r11
        L_0x012f:
            char[] r3 = r1.f2139g     // Catch:{ SSLException -> 0x0187 }
            int r5 = r1.f2135c     // Catch:{ SSLException -> 0x0187 }
            char r3 = r3[r5]     // Catch:{ SSLException -> 0x0187 }
            r5 = 44
            if (r3 == r5) goto L_0x0164
            char[] r3 = r1.f2139g     // Catch:{ SSLException -> 0x0187 }
            int r5 = r1.f2135c     // Catch:{ SSLException -> 0x0187 }
            char r3 = r3[r5]     // Catch:{ SSLException -> 0x0187 }
            r5 = 59
            if (r3 == r5) goto L_0x0164
            char[] r3 = r1.f2139g     // Catch:{ SSLException -> 0x0187 }
            int r5 = r1.f2135c     // Catch:{ SSLException -> 0x0187 }
            char r3 = r3[r5]     // Catch:{ SSLException -> 0x0187 }
            r5 = 43
            if (r3 != r5) goto L_0x014e
            goto L_0x0164
        L_0x014e:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException     // Catch:{ SSLException -> 0x0187 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ SSLException -> 0x0187 }
            java.lang.String r2 = "Malformed DN: "
            r12.<init>(r2)     // Catch:{ SSLException -> 0x0187 }
            java.lang.String r1 = r1.f2133a     // Catch:{ SSLException -> 0x0187 }
            r12.append(r1)     // Catch:{ SSLException -> 0x0187 }
            java.lang.String r12 = r12.toString()     // Catch:{ SSLException -> 0x0187 }
            r11.<init>(r12)     // Catch:{ SSLException -> 0x0187 }
            throw r11     // Catch:{ SSLException -> 0x0187 }
        L_0x0164:
            int r3 = r1.f2135c     // Catch:{ SSLException -> 0x0187 }
            int r3 = r3 + r2
            r1.f2135c = r3     // Catch:{ SSLException -> 0x0187 }
            java.lang.String r3 = r1.mo38333a()     // Catch:{ SSLException -> 0x0187 }
            if (r3 == 0) goto L_0x0171
            goto L_0x0077
        L_0x0171:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException     // Catch:{ SSLException -> 0x0187 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ SSLException -> 0x0187 }
            java.lang.String r2 = "Malformed DN: "
            r12.<init>(r2)     // Catch:{ SSLException -> 0x0187 }
            java.lang.String r1 = r1.f2133a     // Catch:{ SSLException -> 0x0187 }
            r12.append(r1)     // Catch:{ SSLException -> 0x0187 }
            java.lang.String r12 = r12.toString()     // Catch:{ SSLException -> 0x0187 }
            r11.<init>(r12)     // Catch:{ SSLException -> 0x0187 }
            throw r11     // Catch:{ SSLException -> 0x0187 }
        L_0x0187:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C3121ej.verify(java.lang.String, javax.net.ssl.SSLSession):boolean");
    }
}
