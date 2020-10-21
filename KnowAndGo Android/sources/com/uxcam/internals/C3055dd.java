package com.uxcam.internals;

/* renamed from: com.uxcam.internals.dd */
public final class C3055dd {
    /* renamed from: a */
    public static boolean m1506a(String str) {
        return str.equals("POST") || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT");
    }

    /* renamed from: b */
    public static boolean m1507b(String str) {
        return m1506a(str) || str.equals("OPTIONS") || str.equals("DELETE") || str.equals("PROPFIND") || str.equals("MKCOL") || str.equals("LOCK");
    }
}
