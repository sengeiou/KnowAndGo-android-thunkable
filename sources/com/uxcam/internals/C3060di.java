package com.uxcam.internals;

import java.net.ProtocolException;

/* renamed from: com.uxcam.internals.di */
public final class C3060di {

    /* renamed from: a */
    public final C3014cb f1903a;

    /* renamed from: b */
    public final int f1904b;

    /* renamed from: c */
    public final String f1905c;

    private C3060di(C3014cb cbVar, int i, String str) {
        this.f1903a = cbVar;
        this.f1904b = i;
        this.f1905c = str;
    }

    /* renamed from: a */
    public static C3060di m1521a(String str) {
        C3014cb cbVar;
        int i = 9;
        if (str.startsWith("HTTP/1.")) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: ".concat(String.valueOf(str)));
            }
            int charAt = str.charAt(7) - '0';
            if (charAt == 0) {
                cbVar = C3014cb.HTTP_1_0;
            } else if (charAt == 1) {
                cbVar = C3014cb.HTTP_1_1;
            } else {
                throw new ProtocolException("Unexpected status line: ".concat(String.valueOf(str)));
            }
        } else if (str.startsWith("ICY ")) {
            cbVar = C3014cb.HTTP_1_0;
            i = 4;
        } else {
            throw new ProtocolException("Unexpected status line: ".concat(String.valueOf(str)));
        }
        int i2 = i + 3;
        if (str.length() >= i2) {
            try {
                int parseInt = Integer.parseInt(str.substring(i, i2));
                String str2 = "";
                if (str.length() > i2) {
                    if (str.charAt(i2) == ' ') {
                        str2 = str.substring(i + 4);
                    } else {
                        throw new ProtocolException("Unexpected status line: ".concat(String.valueOf(str)));
                    }
                }
                return new C3060di(cbVar, parseInt, str2);
            } catch (NumberFormatException unused) {
                throw new ProtocolException("Unexpected status line: ".concat(String.valueOf(str)));
            }
        } else {
            throw new ProtocolException("Unexpected status line: ".concat(String.valueOf(str)));
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1903a == C3014cb.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.f1904b);
        if (this.f1905c != null) {
            sb.append(' ');
            sb.append(this.f1905c);
        }
        return sb.toString();
    }
}
