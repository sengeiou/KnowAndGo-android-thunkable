package com.uxcam.internals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

/* renamed from: com.uxcam.internals.ek */
public abstract class C3122ek {

    /* renamed from: com.uxcam.internals.ek$aa */
    static final class C3123aa extends C3122ek {

        /* renamed from: a */
        private final X509TrustManager f2141a;

        /* renamed from: b */
        private final Method f2142b;

        C3123aa(X509TrustManager x509TrustManager, Method method) {
            this.f2142b = method;
            this.f2141a = x509TrustManager;
        }

        /* renamed from: a */
        public final X509Certificate mo38338a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f2142b.invoke(this.f2141a, new Object[]{x509Certificate});
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException unused2) {
            }
            return null;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C3123aa)) {
                return false;
            }
            C3123aa aaVar = (C3123aa) obj;
            return this.f2141a.equals(aaVar.f2141a) && this.f2142b.equals(aaVar.f2142b);
        }

        public final int hashCode() {
            return this.f2141a.hashCode() + (this.f2142b.hashCode() * 31);
        }
    }

    /* renamed from: com.uxcam.internals.ek$ab */
    static final class C3124ab extends C3122ek {

        /* renamed from: a */
        private final Map f2143a = new LinkedHashMap();

        public C3124ab(X509Certificate... x509CertificateArr) {
            for (X509Certificate x509Certificate : x509CertificateArr) {
                X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
                Set set = (Set) this.f2143a.get(subjectX500Principal);
                if (set == null) {
                    set = new LinkedHashSet(1);
                    this.f2143a.put(subjectX500Principal, set);
                }
                set.add(x509Certificate);
            }
        }

        /* renamed from: a */
        public final X509Certificate mo38338a(X509Certificate x509Certificate) {
            Set<X509Certificate> set = (Set) this.f2143a.get(x509Certificate.getIssuerX500Principal());
            if (set == null) {
                return null;
            }
            for (X509Certificate x509Certificate2 : set) {
                try {
                    x509Certificate.verify(x509Certificate2.getPublicKey());
                    return x509Certificate2;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return (obj instanceof C3124ab) && ((C3124ab) obj).f2143a.equals(this.f2143a);
        }

        public final int hashCode() {
            return this.f2143a.hashCode();
        }
    }

    /* renamed from: a */
    public static C3122ek m1724a(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});
            declaredMethod.setAccessible(true);
            return new C3123aa(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return new C3124ab(x509TrustManager.getAcceptedIssuers());
        }
    }

    /* renamed from: a */
    public abstract X509Certificate mo38338a(X509Certificate x509Certificate);
}
