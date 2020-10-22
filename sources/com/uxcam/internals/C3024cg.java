package com.uxcam.internals;

import java.io.Closeable;
import java.nio.charset.Charset;

/* renamed from: com.uxcam.internals.cg */
public abstract class C3024cg implements Closeable {
    /* renamed from: a */
    private static C3024cg m1397a(final C3007by byVar, final long j, final C3132ep epVar) {
        if (epVar != null) {
            return new C3024cg() {
                /* renamed from: a */
                public final C3007by mo38187a() {
                    return byVar;
                }

                /* renamed from: b */
                public final long mo38188b() {
                    return j;
                }

                /* renamed from: c */
                public final C3132ep mo38189c() {
                    return epVar;
                }
            };
        }
        throw new NullPointerException("source == null");
    }

    /* renamed from: a */
    public static C3024cg m1398a(C3007by byVar, String str) {
        C3130en enVar;
        Charset charset = C3030cl.f1784e;
        if (byVar != null) {
            charset = byVar.f1635b != null ? Charset.forName(byVar.f1635b) : null;
            if (charset == null) {
                charset = C3030cl.f1784e;
                byVar = C3007by.m1329a(byVar + "; charset=utf-8");
            }
        }
        C3130en enVar2 = new C3130en();
        int length = str.length();
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (length < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + length + " < 0");
        } else if (length > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + length + " > " + str.length());
        } else if (charset != null) {
            if (charset.equals(C3151fe.f2202a)) {
                enVar = enVar2.mo38356a(str, 0, length);
            } else {
                byte[] bytes = str.substring(0, length).getBytes(charset);
                enVar = enVar2.mo38366b(bytes, 0, bytes.length);
            }
            return m1397a(byVar, enVar.f2158b, enVar);
        } else {
            throw new IllegalArgumentException("charset == null");
        }
    }

    /* renamed from: a */
    public static C3024cg m1399a(byte[] bArr) {
        return m1397a((C3007by) null, (long) bArr.length, new C3130en().mo38365b(bArr));
    }

    /* renamed from: a */
    public abstract C3007by mo38187a();

    /* renamed from: b */
    public abstract long mo38188b();

    /* renamed from: c */
    public abstract C3132ep mo38189c();

    public void close() {
        C3030cl.m1428a((Closeable) mo38189c());
    }

    /* renamed from: d */
    public final String mo38191d() {
        Charset charset;
        C3132ep c = mo38189c();
        try {
            C3007by a = mo38187a();
            if (a != null) {
                charset = C3030cl.f1784e;
                if (a.f1635b != null) {
                    charset = Charset.forName(a.f1635b);
                }
            } else {
                charset = C3030cl.f1784e;
            }
            return c.mo38359a(C3030cl.m1423a(c, charset));
        } finally {
            C3030cl.m1428a((Closeable) c);
        }
    }
}
