package com.uxcam.internals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* renamed from: com.uxcam.internals.bo */
public final class C2989bo {

    /* renamed from: a */
    public static final C2989bo f1563a;

    /* renamed from: b */
    public static final C2989bo f1564b = new C2990aa(f1563a).mo38093a(C3027ci.TLS_1_0).mo38092a().mo38096b();

    /* renamed from: c */
    public static final C2989bo f1565c = new C2990aa(false).mo38096b();

    /* renamed from: h */
    private static final C2985bl[] f1566h = {C2985bl.f1489aW, C2985bl.f1520ba, C2985bl.f1490aX, C2985bl.f1521bb, C2985bl.f1527bh, C2985bl.f1526bg, C2985bl.f1516ax, C2985bl.f1474aH, C2985bl.f1517ay, C2985bl.f1475aI, C2985bl.f1498af, C2985bl.f1499ag, C2985bl.f1443D, C2985bl.f1447H, C2985bl.f1534h};

    /* renamed from: d */
    final boolean f1567d;

    /* renamed from: e */
    public final boolean f1568e;

    /* renamed from: f */
    final String[] f1569f;

    /* renamed from: g */
    final String[] f1570g;

    /* renamed from: com.uxcam.internals.bo$aa */
    public static final class C2990aa {

        /* renamed from: a */
        boolean f1571a;

        /* renamed from: b */
        String[] f1572b;

        /* renamed from: c */
        String[] f1573c;

        /* renamed from: d */
        boolean f1574d;

        public C2990aa(C2989bo boVar) {
            this.f1571a = boVar.f1567d;
            this.f1572b = boVar.f1569f;
            this.f1573c = boVar.f1570g;
            this.f1574d = boVar.f1568e;
        }

        C2990aa(boolean z) {
            this.f1571a = z;
        }

        /* renamed from: a */
        public final C2990aa mo38092a() {
            if (this.f1571a) {
                this.f1574d = true;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        /* renamed from: a */
        public final C2990aa mo38093a(C3027ci... ciVarArr) {
            if (this.f1571a) {
                String[] strArr = new String[ciVarArr.length];
                for (int i = 0; i < ciVarArr.length; i++) {
                    strArr[i] = ciVarArr[i].f1777f;
                }
                return mo38095b(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        /* renamed from: a */
        public final C2990aa mo38094a(String... strArr) {
            if (!this.f1571a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            } else if (strArr.length != 0) {
                this.f1572b = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
        }

        /* renamed from: b */
        public final C2990aa mo38095b(String... strArr) {
            if (!this.f1571a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            } else if (strArr.length != 0) {
                this.f1573c = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
        }

        /* renamed from: b */
        public final C2989bo mo38096b() {
            return new C2989bo(this);
        }
    }

    static {
        C2990aa aaVar = new C2990aa(true);
        C2985bl[] blVarArr = f1566h;
        if (aaVar.f1571a) {
            String[] strArr = new String[blVarArr.length];
            for (int i = 0; i < blVarArr.length; i++) {
                strArr[i] = blVarArr[i].f1553bi;
            }
            f1563a = aaVar.mo38094a(strArr).mo38093a(C3027ci.TLS_1_3, C3027ci.TLS_1_2, C3027ci.TLS_1_1, C3027ci.TLS_1_0).mo38092a().mo38096b();
            return;
        }
        throw new IllegalStateException("no cipher suites for cleartext connections");
    }

    C2989bo(C2990aa aaVar) {
        this.f1567d = aaVar.f1571a;
        this.f1569f = aaVar.f1572b;
        this.f1570g = aaVar.f1573c;
        this.f1568e = aaVar.f1574d;
    }

    /* renamed from: a */
    private List m1255a() {
        if (this.f1570g == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.f1570g.length);
        for (String a : this.f1570g) {
            arrayList.add(C3027ci.m1407a(a));
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: a */
    private static boolean m1256a(String[] strArr, String[] strArr2) {
        if (!(strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0)) {
            for (String a : strArr) {
                if (C3030cl.m1419a((Object[]) strArr2, (Object) a) != -1) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public final boolean mo38088a(SSLSocket sSLSocket) {
        if (!this.f1567d) {
            return false;
        }
        if (this.f1570g == null || m1256a(this.f1570g, sSLSocket.getEnabledProtocols())) {
            return this.f1569f == null || m1256a(this.f1569f, sSLSocket.getEnabledCipherSuites());
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C2989bo)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        C2989bo boVar = (C2989bo) obj;
        if (this.f1567d != boVar.f1567d) {
            return false;
        }
        return !this.f1567d || (Arrays.equals(this.f1569f, boVar.f1569f) && Arrays.equals(this.f1570g, boVar.f1570g) && this.f1568e == boVar.f1568e);
    }

    public final int hashCode() {
        if (this.f1567d) {
            return ((((Arrays.hashCode(this.f1569f) + 527) * 31) + Arrays.hashCode(this.f1570g)) * 31) + (this.f1568e ^ true ? 1 : 0);
        }
        return 17;
    }

    public final String toString() {
        String str;
        List list;
        if (!this.f1567d) {
            return "ConnectionSpec()";
        }
        if (this.f1569f != null) {
            if (this.f1569f == null) {
                list = null;
            } else {
                ArrayList arrayList = new ArrayList(this.f1569f.length);
                for (String a : this.f1569f) {
                    arrayList.add(C2985bl.m1252a(a));
                }
                list = Collections.unmodifiableList(arrayList);
            }
            str = list.toString();
        } else {
            str = "[all enabled]";
        }
        return "ConnectionSpec(cipherSuites=" + str + ", tlsVersions=" + (this.f1570g != null ? m1255a().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.f1568e + ")";
    }
}
