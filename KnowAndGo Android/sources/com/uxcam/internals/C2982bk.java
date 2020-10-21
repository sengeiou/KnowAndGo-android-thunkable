package com.uxcam.internals;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* renamed from: com.uxcam.internals.bk */
public final class C2982bk {

    /* renamed from: a */
    public static final C2982bk f1432a = new C2982bk(new LinkedHashSet(new C2983aa().f1435a), (C3119eh) null);

    /* renamed from: b */
    final Set f1433b;

    /* renamed from: c */
    final C3119eh f1434c;

    /* renamed from: com.uxcam.internals.bk$aa */
    public static final class C2983aa {

        /* renamed from: a */
        final List f1435a = new ArrayList();
    }

    /* renamed from: com.uxcam.internals.bk$ab */
    static final class C2984ab {

        /* renamed from: a */
        final String f1436a;

        /* renamed from: b */
        final String f1437b;

        /* renamed from: c */
        final String f1438c;

        /* renamed from: d */
        final C3133eq f1439d;

        public final boolean equals(Object obj) {
            if (!(obj instanceof C2984ab)) {
                return false;
            }
            C2984ab abVar = (C2984ab) obj;
            return this.f1436a.equals(abVar.f1436a) && this.f1438c.equals(abVar.f1438c) && this.f1439d.equals(abVar.f1439d);
        }

        public final int hashCode() {
            return ((((this.f1436a.hashCode() + 527) * 31) + this.f1438c.hashCode()) * 31) + this.f1439d.hashCode();
        }

        public final String toString() {
            return this.f1438c + this.f1439d.mo38408b();
        }
    }

    C2982bk(Set set, C3119eh ehVar) {
        this.f1433b = set;
        this.f1434c = ehVar;
    }

    /* renamed from: a */
    private static C3133eq m1249a(X509Certificate x509Certificate) {
        return C3133eq.m1829a(x509Certificate.getPublicKey().getEncoded()).mo38411d();
    }

    /* renamed from: a */
    public static String m1250a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + m1249a((X509Certificate) certificate).mo38408b();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    /* renamed from: a */
    public final void mo38078a(String str, List list) {
        boolean z;
        List emptyList = Collections.emptyList();
        for (C2984ab abVar : this.f1433b) {
            if (abVar.f1436a.startsWith("*.")) {
                z = str.regionMatches(false, str.indexOf(46) + 1, abVar.f1437b, 0, abVar.f1437b.length());
            } else {
                z = str.equals(abVar.f1437b);
            }
            if (z) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList();
                }
                emptyList.add(abVar);
            }
        }
        if (!emptyList.isEmpty()) {
            if (this.f1434c != null) {
                list = this.f1434c.mo38321a(list, str);
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i);
                int size2 = emptyList.size();
                C3133eq eqVar = null;
                C3133eq eqVar2 = null;
                for (int i2 = 0; i2 < size2; i2++) {
                    C2984ab abVar2 = (C2984ab) emptyList.get(i2);
                    if (abVar2.f1438c.equals("sha256/")) {
                        if (eqVar == null) {
                            eqVar = m1249a(x509Certificate);
                        }
                        if (abVar2.f1439d.equals(eqVar)) {
                            return;
                        }
                    } else if (abVar2.f1438c.equals("sha1/")) {
                        if (eqVar2 == null) {
                            eqVar2 = C3133eq.m1829a(x509Certificate.getPublicKey().getEncoded()).mo38409c();
                        }
                        if (abVar2.f1439d.equals(eqVar2)) {
                            return;
                        }
                    } else {
                        throw new AssertionError();
                    }
                }
            }
            StringBuilder sb = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
            int size3 = list.size();
            for (int i3 = 0; i3 < size3; i3++) {
                X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
                sb.append("\n    ");
                sb.append(m1250a((Certificate) x509Certificate2));
                sb.append(": ");
                sb.append(x509Certificate2.getSubjectDN().getName());
            }
            sb.append("\n  Pinned certificates for ");
            sb.append(str);
            sb.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            int size4 = emptyList.size();
            for (int i4 = 0; i4 < size4; i4++) {
                sb.append("\n    ");
                sb.append((C2984ab) emptyList.get(i4));
            }
            throw new SSLPeerUnverifiedException(sb.toString());
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2982bk)) {
            return false;
        }
        C2982bk bkVar = (C2982bk) obj;
        return C3030cl.m1433a((Object) this.f1434c, (Object) bkVar.f1434c) && this.f1433b.equals(bkVar.f1433b);
    }

    public final int hashCode() {
        return ((this.f1434c != null ? this.f1434c.hashCode() : 0) * 31) + this.f1433b.hashCode();
    }
}
