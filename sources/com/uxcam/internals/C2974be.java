package com.uxcam.internals;

import com.facebook.common.util.UriUtil;
import com.uxcam.internals.C3002bw;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: com.uxcam.internals.be */
public final class C2974be {

    /* renamed from: a */
    public final C3002bw f1397a;

    /* renamed from: b */
    public final C2995bs f1398b;

    /* renamed from: c */
    public final SocketFactory f1399c;

    /* renamed from: d */
    final C2975bf f1400d;

    /* renamed from: e */
    public final List f1401e;

    /* renamed from: f */
    public final List f1402f;

    /* renamed from: g */
    public final ProxySelector f1403g;

    /* renamed from: h */
    public final Proxy f1404h;

    /* renamed from: i */
    public final SSLSocketFactory f1405i;

    /* renamed from: j */
    public final HostnameVerifier f1406j;

    /* renamed from: k */
    public final C2982bk f1407k;

    public C2974be(String str, int i, C2995bs bsVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, C2982bk bkVar, C2975bf bfVar, Proxy proxy, List list, List list2, ProxySelector proxySelector) {
        String str2;
        C3002bw.C3003aa aaVar = new C3002bw.C3003aa();
        String str3 = sSLSocketFactory != null ? UriUtil.HTTPS_SCHEME : UriUtil.HTTP_SCHEME;
        if (str3.equalsIgnoreCase(UriUtil.HTTP_SCHEME)) {
            str2 = UriUtil.HTTP_SCHEME;
        } else if (str3.equalsIgnoreCase(UriUtil.HTTPS_SCHEME)) {
            str2 = UriUtil.HTTPS_SCHEME;
        } else {
            throw new IllegalArgumentException("unexpected scheme: ".concat(String.valueOf(str3)));
        }
        aaVar.f1618a = str2;
        if (str != null) {
            String a = C3002bw.C3003aa.m1314a(str, 0, str.length());
            if (a != null) {
                aaVar.f1621d = a;
                if (i <= 0 || i > 65535) {
                    throw new IllegalArgumentException("unexpected port: ".concat(String.valueOf(i)));
                }
                aaVar.f1622e = i;
                this.f1397a = aaVar.mo38135b();
                if (bsVar != null) {
                    this.f1398b = bsVar;
                    if (socketFactory != null) {
                        this.f1399c = socketFactory;
                        if (bfVar != null) {
                            this.f1400d = bfVar;
                            if (list != null) {
                                this.f1401e = C3030cl.m1424a(list);
                                if (list2 != null) {
                                    this.f1402f = C3030cl.m1424a(list2);
                                    if (proxySelector != null) {
                                        this.f1403g = proxySelector;
                                        this.f1404h = proxy;
                                        this.f1405i = sSLSocketFactory;
                                        this.f1406j = hostnameVerifier;
                                        this.f1407k = bkVar;
                                        return;
                                    }
                                    throw new NullPointerException("proxySelector == null");
                                }
                                throw new NullPointerException("connectionSpecs == null");
                            }
                            throw new NullPointerException("protocols == null");
                        }
                        throw new NullPointerException("proxyAuthenticator == null");
                    }
                    throw new NullPointerException("socketFactory == null");
                }
                throw new NullPointerException("dns == null");
            }
            throw new IllegalArgumentException("unexpected host: ".concat(String.valueOf(str)));
        }
        throw new NullPointerException("host == null");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C2974be) {
            C2974be beVar = (C2974be) obj;
            return this.f1397a.equals(beVar.f1397a) && this.f1398b.equals(beVar.f1398b) && this.f1400d.equals(beVar.f1400d) && this.f1401e.equals(beVar.f1401e) && this.f1402f.equals(beVar.f1402f) && this.f1403g.equals(beVar.f1403g) && C3030cl.m1433a((Object) this.f1404h, (Object) beVar.f1404h) && C3030cl.m1433a((Object) this.f1405i, (Object) beVar.f1405i) && C3030cl.m1433a((Object) this.f1406j, (Object) beVar.f1406j) && C3030cl.m1433a((Object) this.f1407k, (Object) beVar.f1407k);
        }
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((((((((((this.f1397a.hashCode() + 527) * 31) + this.f1398b.hashCode()) * 31) + this.f1400d.hashCode()) * 31) + this.f1401e.hashCode()) * 31) + this.f1402f.hashCode()) * 31) + this.f1403g.hashCode()) * 31) + (this.f1404h != null ? this.f1404h.hashCode() : 0)) * 31) + (this.f1405i != null ? this.f1405i.hashCode() : 0)) * 31) + (this.f1406j != null ? this.f1406j.hashCode() : 0)) * 31;
        if (this.f1407k != null) {
            i = this.f1407k.hashCode();
        }
        return hashCode + i;
    }
}
