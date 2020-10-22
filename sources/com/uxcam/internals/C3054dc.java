package com.uxcam.internals;

import java.util.regex.Pattern;

/* renamed from: com.uxcam.internals.dc */
public final class C3054dc {

    /* renamed from: a */
    private static final Pattern f1888a = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");

    /* renamed from: a */
    public static int m1498a(String str, int i) {
        while (i < str.length() && ((r0 = str.charAt(i)) == ' ' || r0 == 9)) {
            i++;
        }
        return i;
    }

    /* renamed from: a */
    public static int m1499a(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    /* renamed from: a */
    public static long m1500a(C3000bv bvVar) {
        return m1502a(bvVar.mo38113a("Content-Length"));
    }

    /* renamed from: a */
    public static long m1501a(C3022cf cfVar) {
        return m1500a(cfVar.f1745f);
    }

    /* renamed from: a */
    private static long m1502a(String str) {
        if (str == null) {
            return -1;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    /* renamed from: a */
    public static void m1503a(C2992bq bqVar, C3002bw bwVar, C3000bv bvVar) {
        if (bqVar != C2992bq.f1588a && C2991bp.m1266a(bwVar, bvVar).isEmpty()) {
        }
    }

    /* renamed from: b */
    public static int m1504b(String str, int i) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    /* renamed from: b */
    public static boolean m1505b(C3022cf cfVar) {
        if (cfVar.f1740a.f1724b.equals("HEAD")) {
            return false;
        }
        int i = cfVar.f1742c;
        return (((i >= 100 && i < 200) || i == 204 || i == 304) && m1500a(cfVar.f1745f) == -1 && !"chunked".equalsIgnoreCase(cfVar.mo38178b("Transfer-Encoding"))) ? false : true;
    }
}
