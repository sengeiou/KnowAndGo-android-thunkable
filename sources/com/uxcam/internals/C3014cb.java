package com.uxcam.internals;

import java.io.IOException;

/* renamed from: com.uxcam.internals.cb */
public enum C3014cb {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");
    

    /* renamed from: e */
    private final String f1715e;

    private C3014cb(String str) {
        this.f1715e = str;
    }

    /* renamed from: a */
    public static C3014cb m1360a(String str) {
        if (str.equals(HTTP_1_0.f1715e)) {
            return HTTP_1_0;
        }
        if (str.equals(HTTP_1_1.f1715e)) {
            return HTTP_1_1;
        }
        if (str.equals(HTTP_2.f1715e)) {
            return HTTP_2;
        }
        if (str.equals(SPDY_3.f1715e)) {
            return SPDY_3;
        }
        throw new IOException("Unexpected protocol: ".concat(String.valueOf(str)));
    }

    public final String toString() {
        return this.f1715e;
    }
}
