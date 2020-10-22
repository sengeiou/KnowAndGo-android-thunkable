package com.uxcam.internals;

import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* renamed from: com.uxcam.internals.bu */
public final class C2999bu {

    /* renamed from: a */
    public final C2985bl f1602a;

    /* renamed from: b */
    public final List f1603b;

    /* renamed from: c */
    private final C3027ci f1604c;

    /* renamed from: d */
    private final List f1605d;

    private C2999bu(C3027ci ciVar, C2985bl blVar, List list, List list2) {
        this.f1604c = ciVar;
        this.f1602a = blVar;
        this.f1603b = list;
        this.f1605d = list2;
    }

    /* renamed from: a */
    public static C2999bu m1283a(SSLSession sSLSession) {
        Certificate[] certificateArr;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite != null) {
            C2985bl a = C2985bl.m1252a(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol != null) {
                C3027ci a2 = C3027ci.m1407a(protocol);
                try {
                    certificateArr = sSLSession.getPeerCertificates();
                } catch (SSLPeerUnverifiedException unused) {
                    certificateArr = null;
                }
                List a3 = certificateArr != null ? C3030cl.m1425a((Object[]) certificateArr) : Collections.emptyList();
                Certificate[] localCertificates = sSLSession.getLocalCertificates();
                return new C2999bu(a2, a, a3, localCertificates != null ? C3030cl.m1425a((Object[]) localCertificates) : Collections.emptyList());
            }
            throw new IllegalStateException("tlsVersion == null");
        }
        throw new IllegalStateException("cipherSuite == null");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C2999bu)) {
            return false;
        }
        C2999bu buVar = (C2999bu) obj;
        return C3030cl.m1433a((Object) this.f1602a, (Object) buVar.f1602a) && this.f1602a.equals(buVar.f1602a) && this.f1603b.equals(buVar.f1603b) && this.f1605d.equals(buVar.f1605d);
    }

    public final int hashCode() {
        return (((((((this.f1604c != null ? this.f1604c.hashCode() : 0) + 527) * 31) + this.f1602a.hashCode()) * 31) + this.f1603b.hashCode()) * 31) + this.f1605d.hashCode();
    }
}
