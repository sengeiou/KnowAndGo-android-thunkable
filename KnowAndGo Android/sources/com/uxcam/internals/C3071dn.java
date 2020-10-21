package com.uxcam.internals;

import okhttp3.internal.http2.Header;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* renamed from: com.uxcam.internals.dn */
public final class C3071dn {

    /* renamed from: a */
    public static final C3133eq f1937a = C3133eq.m1828a(ParameterizedMessage.ERROR_MSG_SEPARATOR);

    /* renamed from: b */
    public static final C3133eq f1938b = C3133eq.m1828a(Header.RESPONSE_STATUS_UTF8);

    /* renamed from: c */
    public static final C3133eq f1939c = C3133eq.m1828a(Header.TARGET_METHOD_UTF8);

    /* renamed from: d */
    public static final C3133eq f1940d = C3133eq.m1828a(Header.TARGET_PATH_UTF8);

    /* renamed from: e */
    public static final C3133eq f1941e = C3133eq.m1828a(Header.TARGET_SCHEME_UTF8);

    /* renamed from: f */
    public static final C3133eq f1942f = C3133eq.m1828a(Header.TARGET_AUTHORITY_UTF8);

    /* renamed from: g */
    public final C3133eq f1943g;

    /* renamed from: h */
    public final C3133eq f1944h;

    /* renamed from: i */
    final int f1945i;

    public C3071dn(C3133eq eqVar, C3133eq eqVar2) {
        this.f1943g = eqVar;
        this.f1944h = eqVar2;
        this.f1945i = eqVar.mo38415g() + 32 + eqVar2.mo38415g();
    }

    public C3071dn(C3133eq eqVar, String str) {
        this(eqVar, C3133eq.m1828a(str));
    }

    public C3071dn(String str, String str2) {
        this(C3133eq.m1828a(str), C3133eq.m1828a(str2));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C3071dn) {
            C3071dn dnVar = (C3071dn) obj;
            return this.f1943g.equals(dnVar.f1943g) && this.f1944h.equals(dnVar.f1944h);
        }
    }

    public final int hashCode() {
        return ((this.f1943g.hashCode() + 527) * 31) + this.f1944h.hashCode();
    }

    public final String toString() {
        return C3030cl.m1422a("%s: %s", this.f1943g.mo38404a(), this.f1944h.mo38404a());
    }
}
