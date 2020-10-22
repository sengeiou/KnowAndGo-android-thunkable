package com.uxcam.internals;

import com.polidea.rxandroidble.ClientComponent;
import com.uxcam.internals.C2989bo;
import com.uxcam.internals.C3000bv;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* renamed from: com.uxcam.internals.ca */
public class C3011ca implements Cloneable {

    /* renamed from: a */
    static final List f1656a = C3030cl.m1425a((Object[]) new C3014cb[]{C3014cb.HTTP_2, C3014cb.HTTP_1_1});

    /* renamed from: b */
    static final List f1657b = C3030cl.m1425a((Object[]) new C2989bo[]{C2989bo.f1563a, C2989bo.f1564b, C2989bo.f1565c});

    /* renamed from: A */
    public final int f1658A;

    /* renamed from: B */
    final int f1659B;

    /* renamed from: c */
    final C2994br f1660c;

    /* renamed from: d */
    public final Proxy f1661d;

    /* renamed from: e */
    public final List f1662e;

    /* renamed from: f */
    public final List f1663f;

    /* renamed from: g */
    final List f1664g;

    /* renamed from: h */
    final List f1665h;

    /* renamed from: i */
    public final ProxySelector f1666i;

    /* renamed from: j */
    public final C2992bq f1667j;

    /* renamed from: k */
    final C2977bg f1668k;

    /* renamed from: l */
    final C3040cq f1669l;

    /* renamed from: m */
    public final SocketFactory f1670m;

    /* renamed from: n */
    public final SSLSocketFactory f1671n;

    /* renamed from: o */
    final C3119eh f1672o;

    /* renamed from: p */
    public final HostnameVerifier f1673p;

    /* renamed from: q */
    public final C2982bk f1674q;

    /* renamed from: r */
    public final C2975bf f1675r;

    /* renamed from: s */
    final C2975bf f1676s;

    /* renamed from: t */
    public final C2987bn f1677t;

    /* renamed from: u */
    public final C2995bs f1678u;

    /* renamed from: v */
    public final boolean f1679v;

    /* renamed from: w */
    public final boolean f1680w;

    /* renamed from: x */
    public final boolean f1681x;

    /* renamed from: y */
    public final int f1682y;

    /* renamed from: z */
    public final int f1683z;

    /* renamed from: com.uxcam.internals.ca$aa */
    public static final class C3013aa {

        /* renamed from: a */
        C2994br f1684a = new C2994br();

        /* renamed from: b */
        Proxy f1685b;

        /* renamed from: c */
        List f1686c = C3011ca.f1656a;

        /* renamed from: d */
        List f1687d = C3011ca.f1657b;

        /* renamed from: e */
        final List f1688e = new ArrayList();

        /* renamed from: f */
        final List f1689f = new ArrayList();

        /* renamed from: g */
        ProxySelector f1690g = ProxySelector.getDefault();

        /* renamed from: h */
        C2992bq f1691h = C2992bq.f1588a;

        /* renamed from: i */
        C2977bg f1692i;

        /* renamed from: j */
        C3040cq f1693j;

        /* renamed from: k */
        SocketFactory f1694k = SocketFactory.getDefault();

        /* renamed from: l */
        SSLSocketFactory f1695l;

        /* renamed from: m */
        C3119eh f1696m;

        /* renamed from: n */
        HostnameVerifier f1697n = C3121ej.f2140a;

        /* renamed from: o */
        C2982bk f1698o = C2982bk.f1432a;

        /* renamed from: p */
        C2975bf f1699p = C2975bf.f1408a;

        /* renamed from: q */
        C2975bf f1700q = C2975bf.f1408a;

        /* renamed from: r */
        C2987bn f1701r = new C2987bn();

        /* renamed from: s */
        C2995bs f1702s = C2995bs.f1596a;

        /* renamed from: t */
        boolean f1703t = true;

        /* renamed from: u */
        boolean f1704u = true;

        /* renamed from: v */
        boolean f1705v = true;

        /* renamed from: w */
        int f1706w = 10000;

        /* renamed from: x */
        int f1707x = 10000;

        /* renamed from: y */
        int f1708y = 10000;

        /* renamed from: z */
        int f1709z = 0;

        /* renamed from: a */
        private static int m1353a(String str, TimeUnit timeUnit) {
            if (timeUnit != null) {
                long millis = timeUnit.toMillis(30000);
                if (millis > 2147483647L) {
                    throw new IllegalArgumentException(str + " too large.");
                } else if (millis != 0) {
                    return (int) millis;
                } else {
                    throw new IllegalArgumentException(str + " too small.");
                }
            } else {
                throw new NullPointerException("unit == null");
            }
        }

        /* renamed from: a */
        public final C3013aa mo38154a() {
            this.f1692i = null;
            this.f1693j = null;
            return this;
        }

        /* renamed from: a */
        public final C3013aa mo38155a(C3005bx bxVar) {
            this.f1688e.add(bxVar);
            return this;
        }

        /* renamed from: a */
        public final C3013aa mo38156a(TimeUnit timeUnit) {
            this.f1706w = m1353a(ClientComponent.NamedSchedulers.TIMEOUT, timeUnit);
            return this;
        }

        /* renamed from: b */
        public final C3013aa mo38157b(TimeUnit timeUnit) {
            this.f1707x = m1353a(ClientComponent.NamedSchedulers.TIMEOUT, timeUnit);
            return this;
        }

        /* renamed from: b */
        public final C3011ca mo38158b() {
            return new C3011ca(this);
        }

        /* renamed from: c */
        public final C3013aa mo38159c(TimeUnit timeUnit) {
            this.f1708y = m1353a(ClientComponent.NamedSchedulers.TIMEOUT, timeUnit);
            return this;
        }
    }

    static {
        C3028cj.f1778a = new C3028cj() {
            /* renamed from: a */
            public final C3043ct mo38147a(C2987bn bnVar, C2974be beVar, C3047cx cxVar) {
                if (C2987bn.f1555g || Thread.holdsLock(bnVar)) {
                    for (C3043ct ctVar : bnVar.f1558d) {
                        if (ctVar.f1854i.size() < ctVar.f1853h && beVar.equals(ctVar.f1846a.f1768a) && !ctVar.f1855j) {
                            cxVar.mo38220a(ctVar);
                            return ctVar;
                        }
                    }
                    return null;
                }
                throw new AssertionError();
            }

            /* renamed from: a */
            public final C3044cu mo38148a(C2987bn bnVar) {
                return bnVar.f1559e;
            }

            /* renamed from: a */
            public final void mo38149a(C2989bo boVar, SSLSocket sSLSocket, boolean z) {
                String[] enabledCipherSuites = boVar.f1569f != null ? (String[]) C3030cl.m1434a(String.class, (Object[]) boVar.f1569f, (Object[]) sSLSocket.getEnabledCipherSuites()) : sSLSocket.getEnabledCipherSuites();
                String[] enabledProtocols = boVar.f1570g != null ? (String[]) C3030cl.m1434a(String.class, (Object[]) boVar.f1570g, (Object[]) sSLSocket.getEnabledProtocols()) : sSLSocket.getEnabledProtocols();
                if (z && C3030cl.m1419a((Object[]) sSLSocket.getSupportedCipherSuites(), (Object) "TLS_FALLBACK_SCSV") != -1) {
                    enabledCipherSuites = C3030cl.m1435a(enabledCipherSuites, "TLS_FALLBACK_SCSV");
                }
                C2989bo b = new C2989bo.C2990aa(boVar).mo38094a(enabledCipherSuites).mo38095b(enabledProtocols).mo38096b();
                if (b.f1570g != null) {
                    sSLSocket.setEnabledProtocols(b.f1570g);
                }
                if (b.f1569f != null) {
                    sSLSocket.setEnabledCipherSuites(b.f1569f);
                }
            }

            /* renamed from: a */
            public final void mo38150a(C3000bv.C3001aa aaVar, String str) {
                int indexOf = str.indexOf(ParameterizedMessage.ERROR_MSG_SEPARATOR, 1);
                if (indexOf != -1) {
                    aaVar.mo38119a(str.substring(0, indexOf), str.substring(indexOf + 1));
                } else if (str.startsWith(ParameterizedMessage.ERROR_MSG_SEPARATOR)) {
                    aaVar.mo38119a("", str.substring(1));
                } else {
                    aaVar.mo38119a("", str);
                }
            }

            /* renamed from: a */
            public final void mo38151a(C3000bv.C3001aa aaVar, String str, String str2) {
                aaVar.mo38119a(str, str2);
            }

            /* renamed from: a */
            public final boolean mo38152a(C2987bn bnVar, C3043ct ctVar) {
                if (!C2987bn.f1555g && !Thread.holdsLock(bnVar)) {
                    throw new AssertionError();
                } else if (ctVar.f1855j || bnVar.f1556b == 0) {
                    bnVar.f1558d.remove(ctVar);
                    return true;
                } else {
                    bnVar.notifyAll();
                    return false;
                }
            }

            /* renamed from: b */
            public final void mo38153b(C2987bn bnVar, C3043ct ctVar) {
                if (C2987bn.f1555g || Thread.holdsLock(bnVar)) {
                    if (!bnVar.f1560f) {
                        bnVar.f1560f = true;
                        C2987bn.f1554a.execute(bnVar.f1557c);
                    }
                    bnVar.f1558d.add(ctVar);
                    return;
                }
                throw new AssertionError();
            }
        };
    }

    public C3011ca() {
        this(new C3013aa());
    }

    C3011ca(C3013aa aaVar) {
        boolean z;
        C3119eh ehVar;
        this.f1660c = aaVar.f1684a;
        this.f1661d = aaVar.f1685b;
        this.f1662e = aaVar.f1686c;
        this.f1663f = aaVar.f1687d;
        this.f1664g = C3030cl.m1424a(aaVar.f1688e);
        this.f1665h = C3030cl.m1424a(aaVar.f1689f);
        this.f1666i = aaVar.f1690g;
        this.f1667j = aaVar.f1691h;
        this.f1668k = aaVar.f1692i;
        this.f1669l = aaVar.f1693j;
        this.f1670m = aaVar.f1694k;
        Iterator it = this.f1663f.iterator();
        loop0:
        while (true) {
            z = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                C2989bo boVar = (C2989bo) it.next();
                if (z || boVar.f1567d) {
                    z = true;
                }
            }
        }
        if (aaVar.f1695l != null || !z) {
            this.f1671n = aaVar.f1695l;
            ehVar = aaVar.f1696m;
        } else {
            X509TrustManager a = m1344a();
            this.f1671n = m1343a(a);
            ehVar = C3117ef.m1702b().mo38313a(a);
        }
        this.f1672o = ehVar;
        this.f1673p = aaVar.f1697n;
        C2982bk bkVar = aaVar.f1698o;
        C3119eh ehVar2 = this.f1672o;
        this.f1674q = !C3030cl.m1433a((Object) bkVar.f1434c, (Object) ehVar2) ? new C2982bk(bkVar.f1433b, ehVar2) : bkVar;
        this.f1675r = aaVar.f1699p;
        this.f1676s = aaVar.f1700q;
        this.f1677t = aaVar.f1701r;
        this.f1678u = aaVar.f1702s;
        this.f1679v = aaVar.f1703t;
        this.f1680w = aaVar.f1704u;
        this.f1681x = aaVar.f1705v;
        this.f1682y = aaVar.f1706w;
        this.f1683z = aaVar.f1707x;
        this.f1658A = aaVar.f1708y;
        this.f1659B = aaVar.f1709z;
    }

    /* renamed from: a */
    private static SSLSocketFactory m1343a(X509TrustManager x509TrustManager) {
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init((KeyManager[]) null, new TrustManager[]{x509TrustManager}, (SecureRandom) null);
            return instance.getSocketFactory();
        } catch (GeneralSecurityException unused) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    private static X509TrustManager m1344a() {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init((KeyStore) null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException unused) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public final C2980bi mo38146a(C3017cd cdVar) {
        return new C3015cc(this, cdVar, false);
    }
}
