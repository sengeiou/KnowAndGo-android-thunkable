package com.uxcam.internals;

import com.facebook.react.uimanager.ViewProps;
import com.uxcam.internals.C3078dr;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* renamed from: com.uxcam.internals.ct */
public final class C3043ct extends C3078dr.C3087ab implements C2986bm {

    /* renamed from: a */
    public final C3026ch f1846a;

    /* renamed from: b */
    public Socket f1847b;

    /* renamed from: c */
    public C2999bu f1848c;

    /* renamed from: d */
    public volatile C3078dr f1849d;

    /* renamed from: e */
    public int f1850e;

    /* renamed from: f */
    public C3132ep f1851f;

    /* renamed from: g */
    public C3131eo f1852g;

    /* renamed from: h */
    public int f1853h;

    /* renamed from: i */
    public final List f1854i = new ArrayList();

    /* renamed from: j */
    public boolean f1855j;

    /* renamed from: k */
    public long f1856k = Long.MAX_VALUE;

    /* renamed from: m */
    private Socket f1857m;

    /* renamed from: n */
    private C3014cb f1858n;

    public C3043ct(C3026ch chVar) {
        this.f1846a = chVar;
    }

    /* renamed from: a */
    private void m1459a(int i, int i2) {
        Proxy proxy = this.f1846a.f1769b;
        this.f1857m = (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.HTTP) ? this.f1846a.f1768a.f1399c.createSocket() : new Socket(proxy);
        this.f1857m.setSoTimeout(i2);
        try {
            C3117ef.m1702b().mo38318a(this.f1857m, this.f1846a.f1770c, i);
            this.f1851f = C3138ev.m1863a(C3138ev.m1868b(this.f1857m));
            this.f1852g = C3138ev.m1862a(C3138ev.m1864a(this.f1857m));
        } catch (ConnectException e) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f1846a.f1770c);
            connectException.initCause(e);
            throw connectException;
        }
    }

    /* renamed from: a */
    private void m1460a(C3042cs csVar) {
        if (this.f1846a.f1768a.f1405i != null) {
            m1461b(csVar);
        } else {
            this.f1858n = C3014cb.HTTP_1_1;
            this.f1847b = this.f1857m;
        }
        if (this.f1858n == C3014cb.HTTP_2) {
            this.f1847b.setSoTimeout(0);
            C3078dr.C3086aa a = new C3078dr.C3086aa().mo38266a(this.f1847b, this.f1846a.f1768a.f1397a.f1610b, this.f1851f, this.f1852g);
            a.f2037e = this;
            C3078dr a2 = a.mo38267a();
            a2.mo38261b();
            this.f1853h = a2.mo38252a();
            this.f1849d = a2;
            return;
        }
        this.f1853h = 1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00e8 A[Catch:{ all -> 0x00de }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ee A[Catch:{ all -> 0x00de }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00f1  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1461b(com.uxcam.internals.C3042cs r8) {
        /*
            r7 = this;
            com.uxcam.internals.ch r0 = r7.f1846a
            com.uxcam.internals.be r0 = r0.f1768a
            javax.net.ssl.SSLSocketFactory r1 = r0.f1405i
            r2 = 0
            java.net.Socket r3 = r7.f1857m     // Catch:{ AssertionError -> 0x00e1 }
            com.uxcam.internals.bw r4 = r0.f1397a     // Catch:{ AssertionError -> 0x00e1 }
            java.lang.String r4 = r4.f1610b     // Catch:{ AssertionError -> 0x00e1 }
            com.uxcam.internals.bw r5 = r0.f1397a     // Catch:{ AssertionError -> 0x00e1 }
            int r5 = r5.f1611c     // Catch:{ AssertionError -> 0x00e1 }
            r6 = 1
            java.net.Socket r1 = r1.createSocket(r3, r4, r5, r6)     // Catch:{ AssertionError -> 0x00e1 }
            javax.net.ssl.SSLSocket r1 = (javax.net.ssl.SSLSocket) r1     // Catch:{ AssertionError -> 0x00e1 }
            com.uxcam.internals.bo r8 = r8.mo38205a(r1)     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            boolean r3 = r8.f1568e     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            if (r3 == 0) goto L_0x002d
            com.uxcam.internals.ef r3 = com.uxcam.internals.C3117ef.m1702b()     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            com.uxcam.internals.bw r4 = r0.f1397a     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            java.lang.String r4 = r4.f1610b     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            java.util.List r5 = r0.f1401e     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            r3.mo38319a((javax.net.ssl.SSLSocket) r1, (java.lang.String) r4, (java.util.List) r5)     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
        L_0x002d:
            r1.startHandshake()     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            javax.net.ssl.SSLSession r3 = r1.getSession()     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            com.uxcam.internals.bu r3 = com.uxcam.internals.C2999bu.m1283a(r3)     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            javax.net.ssl.HostnameVerifier r4 = r0.f1406j     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            com.uxcam.internals.bw r5 = r0.f1397a     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            java.lang.String r5 = r5.f1610b     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            javax.net.ssl.SSLSession r6 = r1.getSession()     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            boolean r4 = r4.verify(r5, r6)     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            if (r4 == 0) goto L_0x0090
            com.uxcam.internals.bk r4 = r0.f1407k     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            com.uxcam.internals.bw r0 = r0.f1397a     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            java.lang.String r0 = r0.f1610b     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            java.util.List r5 = r3.f1603b     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            r4.mo38078a(r0, r5)     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            boolean r8 = r8.f1568e     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            if (r8 == 0) goto L_0x005f
            com.uxcam.internals.ef r8 = com.uxcam.internals.C3117ef.m1702b()     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            java.lang.String r2 = r8.mo38315a((javax.net.ssl.SSLSocket) r1)     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
        L_0x005f:
            r7.f1847b = r1     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            java.net.Socket r8 = r7.f1847b     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            com.uxcam.internals.fc r8 = com.uxcam.internals.C3138ev.m1868b(r8)     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            com.uxcam.internals.ep r8 = com.uxcam.internals.C3138ev.m1863a((com.uxcam.internals.C3148fc) r8)     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            r7.f1851f = r8     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            java.net.Socket r8 = r7.f1847b     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            com.uxcam.internals.fb r8 = com.uxcam.internals.C3138ev.m1864a((java.net.Socket) r8)     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            com.uxcam.internals.eo r8 = com.uxcam.internals.C3138ev.m1862a((com.uxcam.internals.C3147fb) r8)     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            r7.f1852g = r8     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            r7.f1848c = r3     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            if (r2 == 0) goto L_0x0082
            com.uxcam.internals.cb r8 = com.uxcam.internals.C3014cb.m1360a(r2)     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            goto L_0x0084
        L_0x0082:
            com.uxcam.internals.cb r8 = com.uxcam.internals.C3014cb.HTTP_1_1     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
        L_0x0084:
            r7.f1858n = r8     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            if (r1 == 0) goto L_0x008f
            com.uxcam.internals.ef r8 = com.uxcam.internals.C3117ef.m1702b()
            r8.mo38326b((javax.net.ssl.SSLSocket) r1)
        L_0x008f:
            return
        L_0x0090:
            java.util.List r8 = r3.f1603b     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            r2 = 0
            java.lang.Object r8 = r8.get(r2)     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            java.security.cert.X509Certificate r8 = (java.security.cert.X509Certificate) r8     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            javax.net.ssl.SSLPeerUnverifiedException r2 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            java.lang.String r4 = "Hostname "
            r3.<init>(r4)     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            com.uxcam.internals.bw r0 = r0.f1397a     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            java.lang.String r0 = r0.f1610b     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            r3.append(r0)     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            java.lang.String r0 = " not verified:\n    certificate: "
            r3.append(r0)     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            java.lang.String r0 = com.uxcam.internals.C2982bk.m1250a((java.security.cert.Certificate) r8)     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            r3.append(r0)     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            java.lang.String r0 = "\n    DN: "
            r3.append(r0)     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            java.security.Principal r0 = r8.getSubjectDN()     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            java.lang.String r0 = r0.getName()     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            r3.append(r0)     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            java.lang.String r0 = "\n    subjectAltNames: "
            r3.append(r0)     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            java.util.List r8 = com.uxcam.internals.C3121ej.m1721a(r8)     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            r3.append(r8)     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            java.lang.String r8 = r3.toString()     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            r2.<init>(r8)     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
            throw r2     // Catch:{ AssertionError -> 0x00db, all -> 0x00d9 }
        L_0x00d9:
            r8 = move-exception
            goto L_0x00ef
        L_0x00db:
            r8 = move-exception
            r2 = r1
            goto L_0x00e2
        L_0x00de:
            r8 = move-exception
            r1 = r2
            goto L_0x00ef
        L_0x00e1:
            r8 = move-exception
        L_0x00e2:
            boolean r0 = com.uxcam.internals.C3030cl.m1432a((java.lang.AssertionError) r8)     // Catch:{ all -> 0x00de }
            if (r0 == 0) goto L_0x00ee
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00de }
            r0.<init>(r8)     // Catch:{ all -> 0x00de }
            throw r0     // Catch:{ all -> 0x00de }
        L_0x00ee:
            throw r8     // Catch:{ all -> 0x00de }
        L_0x00ef:
            if (r1 == 0) goto L_0x00f8
            com.uxcam.internals.ef r0 = com.uxcam.internals.C3117ef.m1702b()
            r0.mo38326b((javax.net.ssl.SSLSocket) r1)
        L_0x00f8:
            com.uxcam.internals.C3030cl.m1429a((java.net.Socket) r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C3043ct.m1461b(com.uxcam.internals.cs):void");
    }

    /* renamed from: a */
    public final C3026ch mo38085a() {
        return this.f1846a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01cc A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo38206a(int r17, int r18, int r19, java.util.List r20, boolean r21) {
        /*
            r16 = this;
            r1 = r16
            r0 = r20
            com.uxcam.internals.cb r2 = r1.f1858n
            if (r2 != 0) goto L_0x01ce
            com.uxcam.internals.cs r2 = new com.uxcam.internals.cs
            r2.<init>(r0)
            com.uxcam.internals.ch r3 = r1.f1846a
            com.uxcam.internals.be r3 = r3.f1768a
            javax.net.ssl.SSLSocketFactory r3 = r3.f1405i
            if (r3 != 0) goto L_0x005b
            com.uxcam.internals.bo r3 = com.uxcam.internals.C2989bo.f1565c
            boolean r0 = r0.contains(r3)
            if (r0 == 0) goto L_0x004e
            com.uxcam.internals.ch r0 = r1.f1846a
            com.uxcam.internals.be r0 = r0.f1768a
            com.uxcam.internals.bw r0 = r0.f1397a
            java.lang.String r0 = r0.f1610b
            com.uxcam.internals.ef r3 = com.uxcam.internals.C3117ef.m1702b()
            boolean r3 = r3.mo38320b((java.lang.String) r0)
            if (r3 == 0) goto L_0x0030
            goto L_0x005b
        L_0x0030:
            com.uxcam.internals.cv r2 = new com.uxcam.internals.cv
            java.net.UnknownServiceException r3 = new java.net.UnknownServiceException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "CLEARTEXT communication to "
            r4.<init>(r5)
            r4.append(r0)
            java.lang.String r0 = " not permitted by network security policy"
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r3.<init>(r0)
            r2.<init>(r3)
            throw r2
        L_0x004e:
            com.uxcam.internals.cv r0 = new com.uxcam.internals.cv
            java.net.UnknownServiceException r2 = new java.net.UnknownServiceException
            java.lang.String r3 = "CLEARTEXT communication not enabled for client"
            r2.<init>(r3)
            r0.<init>(r2)
            throw r0
        L_0x005b:
            r3 = 0
            r4 = r3
        L_0x005d:
            com.uxcam.internals.cb r0 = r1.f1858n
            if (r0 != 0) goto L_0x01cd
            r5 = 0
            r6 = 1
            com.uxcam.internals.ch r0 = r1.f1846a     // Catch:{ IOException -> 0x0174 }
            com.uxcam.internals.be r7 = r0.f1768a     // Catch:{ IOException -> 0x0174 }
            javax.net.ssl.SSLSocketFactory r7 = r7.f1405i     // Catch:{ IOException -> 0x0174 }
            if (r7 == 0) goto L_0x0077
            java.net.Proxy r0 = r0.f1769b     // Catch:{ IOException -> 0x0174 }
            java.net.Proxy$Type r0 = r0.type()     // Catch:{ IOException -> 0x0174 }
            java.net.Proxy$Type r7 = java.net.Proxy.Type.HTTP     // Catch:{ IOException -> 0x0174 }
            if (r0 != r7) goto L_0x0077
            r0 = 1
            goto L_0x0078
        L_0x0077:
            r0 = 0
        L_0x0078:
            if (r0 == 0) goto L_0x016a
            com.uxcam.internals.cd$aa r0 = new com.uxcam.internals.cd$aa     // Catch:{ IOException -> 0x0174 }
            r0.<init>()     // Catch:{ IOException -> 0x0174 }
            com.uxcam.internals.ch r7 = r1.f1846a     // Catch:{ IOException -> 0x0174 }
            com.uxcam.internals.be r7 = r7.f1768a     // Catch:{ IOException -> 0x0174 }
            com.uxcam.internals.bw r7 = r7.f1397a     // Catch:{ IOException -> 0x0174 }
            com.uxcam.internals.cd$aa r0 = r0.mo38169a((com.uxcam.internals.C3002bw) r7)     // Catch:{ IOException -> 0x0174 }
            java.lang.String r7 = "Host"
            com.uxcam.internals.ch r8 = r1.f1846a     // Catch:{ IOException -> 0x0174 }
            com.uxcam.internals.be r8 = r8.f1768a     // Catch:{ IOException -> 0x0174 }
            com.uxcam.internals.bw r8 = r8.f1397a     // Catch:{ IOException -> 0x0174 }
            java.lang.String r8 = com.uxcam.internals.C3030cl.m1420a((com.uxcam.internals.C3002bw) r8, (boolean) r6)     // Catch:{ IOException -> 0x0174 }
            com.uxcam.internals.cd$aa r0 = r0.mo38172a((java.lang.String) r7, (java.lang.String) r8)     // Catch:{ IOException -> 0x0174 }
            java.lang.String r7 = "Proxy-Connection"
            java.lang.String r8 = "Keep-Alive"
            com.uxcam.internals.cd$aa r0 = r0.mo38172a((java.lang.String) r7, (java.lang.String) r8)     // Catch:{ IOException -> 0x0174 }
            java.lang.String r7 = "User-Agent"
            java.lang.String r8 = "okhttp/3.5.0"
            com.uxcam.internals.cd$aa r0 = r0.mo38172a((java.lang.String) r7, (java.lang.String) r8)     // Catch:{ IOException -> 0x0174 }
            com.uxcam.internals.cd r0 = r0.mo38173a()     // Catch:{ IOException -> 0x0174 }
            com.uxcam.internals.bw r7 = r0.f1723a     // Catch:{ IOException -> 0x0174 }
            r16.m1459a(r17, r18)     // Catch:{ IOException -> 0x0174 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0174 }
            java.lang.String r9 = "CONNECT "
            r8.<init>(r9)     // Catch:{ IOException -> 0x0174 }
            java.lang.String r7 = com.uxcam.internals.C3030cl.m1420a((com.uxcam.internals.C3002bw) r7, (boolean) r6)     // Catch:{ IOException -> 0x0174 }
            r8.append(r7)     // Catch:{ IOException -> 0x0174 }
            java.lang.String r7 = " HTTP/1.1"
            r8.append(r7)     // Catch:{ IOException -> 0x0174 }
            java.lang.String r7 = r8.toString()     // Catch:{ IOException -> 0x0174 }
            com.uxcam.internals.dk r8 = new com.uxcam.internals.dk     // Catch:{ IOException -> 0x0174 }
            com.uxcam.internals.ep r9 = r1.f1851f     // Catch:{ IOException -> 0x0174 }
            com.uxcam.internals.eo r10 = r1.f1852g     // Catch:{ IOException -> 0x0174 }
            r8.<init>(r3, r3, r9, r10)     // Catch:{ IOException -> 0x0174 }
            com.uxcam.internals.ep r9 = r1.f1851f     // Catch:{ IOException -> 0x0174 }
            com.uxcam.internals.fd r9 = r9.mo38197a()     // Catch:{ IOException -> 0x0174 }
            r10 = r18
            long r11 = (long) r10
            java.util.concurrent.TimeUnit r13 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ IOException -> 0x0168 }
            r9.mo38421a(r11, r13)     // Catch:{ IOException -> 0x0168 }
            com.uxcam.internals.eo r9 = r1.f1852g     // Catch:{ IOException -> 0x0168 }
            com.uxcam.internals.fd r9 = r9.mo38241a()     // Catch:{ IOException -> 0x0168 }
            r11 = r19
            long r12 = (long) r11
            java.util.concurrent.TimeUnit r14 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ IOException -> 0x0172 }
            r9.mo38421a(r12, r14)     // Catch:{ IOException -> 0x0172 }
            com.uxcam.internals.bv r9 = r0.f1725c     // Catch:{ IOException -> 0x0172 }
            r8.mo38237a((com.uxcam.internals.C3000bv) r9, (java.lang.String) r7)     // Catch:{ IOException -> 0x0172 }
            r8.mo38230a()     // Catch:{ IOException -> 0x0172 }
            com.uxcam.internals.cf$aa r7 = r8.mo38238c()     // Catch:{ IOException -> 0x0172 }
            r7.f1753a = r0     // Catch:{ IOException -> 0x0172 }
            com.uxcam.internals.cf r0 = r7.mo38185a()     // Catch:{ IOException -> 0x0172 }
            long r12 = com.uxcam.internals.C3054dc.m1501a((com.uxcam.internals.C3022cf) r0)     // Catch:{ IOException -> 0x0172 }
            r14 = -1
            int r7 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r7 != 0) goto L_0x010c
            r12 = 0
        L_0x010c:
            com.uxcam.internals.fc r7 = r8.mo38236a((long) r12)     // Catch:{ IOException -> 0x0172 }
            r8 = 2147483647(0x7fffffff, float:NaN)
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ IOException -> 0x0172 }
            com.uxcam.internals.C3030cl.m1430a((com.uxcam.internals.C3148fc) r7, (int) r8, (java.util.concurrent.TimeUnit) r9)     // Catch:{ IOException -> 0x0172 }
            r7.close()     // Catch:{ IOException -> 0x0172 }
            int r7 = r0.f1742c     // Catch:{ IOException -> 0x0172 }
            r8 = 200(0xc8, float:2.8E-43)
            if (r7 == r8) goto L_0x0143
            r8 = 407(0x197, float:5.7E-43)
            if (r7 == r8) goto L_0x013b
            java.io.IOException r7 = new java.io.IOException     // Catch:{ IOException -> 0x0172 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0172 }
            java.lang.String r9 = "Unexpected response code for CONNECT: "
            r8.<init>(r9)     // Catch:{ IOException -> 0x0172 }
            int r0 = r0.f1742c     // Catch:{ IOException -> 0x0172 }
            r8.append(r0)     // Catch:{ IOException -> 0x0172 }
            java.lang.String r0 = r8.toString()     // Catch:{ IOException -> 0x0172 }
            r7.<init>(r0)     // Catch:{ IOException -> 0x0172 }
            throw r7     // Catch:{ IOException -> 0x0172 }
        L_0x013b:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0172 }
            java.lang.String r7 = "Failed to authenticate with proxy"
            r0.<init>(r7)     // Catch:{ IOException -> 0x0172 }
            throw r0     // Catch:{ IOException -> 0x0172 }
        L_0x0143:
            com.uxcam.internals.ep r0 = r1.f1851f     // Catch:{ IOException -> 0x0172 }
            com.uxcam.internals.en r0 = r0.mo38362b()     // Catch:{ IOException -> 0x0172 }
            boolean r0 = r0.mo38371c()     // Catch:{ IOException -> 0x0172 }
            if (r0 == 0) goto L_0x0160
            com.uxcam.internals.eo r0 = r1.f1852g     // Catch:{ IOException -> 0x0172 }
            com.uxcam.internals.en r0 = r0.mo38362b()     // Catch:{ IOException -> 0x0172 }
            boolean r0 = r0.mo38371c()     // Catch:{ IOException -> 0x0172 }
            if (r0 == 0) goto L_0x0160
        L_0x015b:
            r1.m1460a((com.uxcam.internals.C3042cs) r2)     // Catch:{ IOException -> 0x0172 }
            goto L_0x005d
        L_0x0160:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0172 }
            java.lang.String r7 = "TLS tunnel buffered too many bytes!"
            r0.<init>(r7)     // Catch:{ IOException -> 0x0172 }
            throw r0     // Catch:{ IOException -> 0x0172 }
        L_0x0168:
            r0 = move-exception
            goto L_0x0177
        L_0x016a:
            r10 = r18
            r11 = r19
            r16.m1459a(r17, r18)     // Catch:{ IOException -> 0x0172 }
            goto L_0x015b
        L_0x0172:
            r0 = move-exception
            goto L_0x0179
        L_0x0174:
            r0 = move-exception
            r10 = r18
        L_0x0177:
            r11 = r19
        L_0x0179:
            java.net.Socket r7 = r1.f1847b
            com.uxcam.internals.C3030cl.m1429a((java.net.Socket) r7)
            java.net.Socket r7 = r1.f1857m
            com.uxcam.internals.C3030cl.m1429a((java.net.Socket) r7)
            r1.f1847b = r3
            r1.f1857m = r3
            r1.f1851f = r3
            r1.f1852g = r3
            r1.f1848c = r3
            r1.f1858n = r3
            if (r4 != 0) goto L_0x0198
            com.uxcam.internals.cv r4 = new com.uxcam.internals.cv
            r4.<init>(r0)
        L_0x0196:
            r7 = r4
            goto L_0x01a0
        L_0x0198:
            java.io.IOException r7 = r4.f1861a
            com.uxcam.internals.C3045cv.m1470a(r0, r7)
            r4.f1861a = r0
            goto L_0x0196
        L_0x01a0:
            if (r21 == 0) goto L_0x01cc
            r2.f1843b = r6
            boolean r8 = r2.f1842a
            if (r8 == 0) goto L_0x01c7
            boolean r8 = r0 instanceof java.net.ProtocolException
            if (r8 != 0) goto L_0x01c7
            boolean r8 = r0 instanceof java.io.InterruptedIOException
            if (r8 != 0) goto L_0x01c7
            boolean r8 = r0 instanceof javax.net.ssl.SSLHandshakeException
            if (r8 == 0) goto L_0x01bc
            java.lang.Throwable r9 = r0.getCause()
            boolean r9 = r9 instanceof java.security.cert.CertificateException
            if (r9 != 0) goto L_0x01c7
        L_0x01bc:
            boolean r9 = r0 instanceof javax.net.ssl.SSLPeerUnverifiedException
            if (r9 != 0) goto L_0x01c7
            if (r8 != 0) goto L_0x01c6
            boolean r0 = r0 instanceof javax.net.ssl.SSLProtocolException
            if (r0 == 0) goto L_0x01c7
        L_0x01c6:
            r5 = 1
        L_0x01c7:
            if (r5 == 0) goto L_0x01cc
            r4 = r7
            goto L_0x005d
        L_0x01cc:
            throw r7
        L_0x01cd:
            return
        L_0x01ce:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "already connected"
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C3043ct.mo38206a(int, int, int, java.util.List, boolean):void");
    }

    /* renamed from: a */
    public final void mo38207a(C3078dr drVar) {
        this.f1853h = drVar.mo38252a();
    }

    /* renamed from: a */
    public final void mo38208a(C3096dt dtVar) {
        dtVar.mo38279a(C3070dm.REFUSED_STREAM);
    }

    /* renamed from: a */
    public final boolean mo38209a(boolean z) {
        int soTimeout;
        if (this.f1847b.isClosed() || this.f1847b.isInputShutdown() || this.f1847b.isOutputShutdown()) {
            return false;
        }
        if (this.f1849d != null) {
            return !this.f1849d.mo38264c();
        }
        if (z) {
            try {
                soTimeout = this.f1847b.getSoTimeout();
                this.f1847b.setSoTimeout(1);
                if (this.f1851f.mo38371c()) {
                    this.f1847b.setSoTimeout(soTimeout);
                    return false;
                }
                this.f1847b.setSoTimeout(soTimeout);
                return true;
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            } catch (Throwable th) {
                this.f1847b.setSoTimeout(soTimeout);
                throw th;
            }
        }
        return true;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Connection{");
        sb.append(this.f1846a.f1768a.f1397a.f1610b);
        sb.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        sb.append(this.f1846a.f1768a.f1397a.f1611c);
        sb.append(", proxy=");
        sb.append(this.f1846a.f1769b);
        sb.append(" hostAddress=");
        sb.append(this.f1846a.f1770c);
        sb.append(" cipherSuite=");
        sb.append(this.f1848c != null ? this.f1848c.f1602a : ViewProps.NONE);
        sb.append(" protocol=");
        sb.append(this.f1858n);
        sb.append('}');
        return sb.toString();
    }
}
