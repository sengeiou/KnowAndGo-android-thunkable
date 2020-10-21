package com.uxcam.internals;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: com.uxcam.internals.dh */
public final class C3059dh implements C3005bx {

    /* renamed from: a */
    public Object f1898a;

    /* renamed from: b */
    public volatile boolean f1899b;

    /* renamed from: c */
    private final C3011ca f1900c;

    /* renamed from: d */
    private final boolean f1901d;

    /* renamed from: e */
    private C3047cx f1902e;

    public C3059dh(C3011ca caVar, boolean z) {
        this.f1900c = caVar;
        this.f1901d = z;
    }

    /* renamed from: a */
    private C2974be m1516a(C3002bw bwVar) {
        C2982bk bkVar;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        C3002bw bwVar2 = bwVar;
        if (bwVar.mo38122b()) {
            SSLSocketFactory sSLSocketFactory2 = this.f1900c.f1671n;
            hostnameVerifier = this.f1900c.f1673p;
            sSLSocketFactory = sSLSocketFactory2;
            bkVar = this.f1900c.f1674q;
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            bkVar = null;
        }
        return new C2974be(bwVar2.f1610b, bwVar2.f1611c, this.f1900c.f1678u, this.f1900c.f1670m, sSLSocketFactory, hostnameVerifier, bkVar, this.f1900c.f1675r, this.f1900c.f1661d, this.f1900c.f1662e, this.f1900c.f1663f, this.f1900c.f1666i);
    }

    /* renamed from: a */
    private static boolean m1517a(C3022cf cfVar, C3002bw bwVar) {
        C3002bw bwVar2 = cfVar.f1740a.f1723a;
        return bwVar2.f1610b.equals(bwVar.f1610b) && bwVar2.f1611c == bwVar.f1611c && bwVar2.f1609a.equals(bwVar.f1609a);
    }

    /* renamed from: a */
    private static boolean m1518a(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z : (!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException);
    }

    /* renamed from: a */
    private boolean m1519a(IOException iOException, boolean z, C3017cd cdVar) {
        this.f1902e.mo38221a(iOException);
        if (!this.f1900c.f1681x) {
            return false;
        }
        return (!z || !(cdVar.f1726d instanceof C3061dj)) && m1518a(iOException, z) && this.f1902e.mo38226d();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009e, code lost:
        if (r7.equals("HEAD") == false) goto L_0x0125;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.uxcam.internals.C3022cf mo38068a(com.uxcam.internals.C3005bx.C3006aa r11) {
        /*
            r10 = this;
            com.uxcam.internals.cd r0 = r11.mo38137a()
            com.uxcam.internals.cx r1 = new com.uxcam.internals.cx
            com.uxcam.internals.ca r2 = r10.f1900c
            com.uxcam.internals.bn r2 = r2.f1677t
            com.uxcam.internals.bw r3 = r0.f1723a
            com.uxcam.internals.be r3 = r10.m1516a((com.uxcam.internals.C3002bw) r3)
            java.lang.Object r4 = r10.f1898a
            r1.<init>(r2, r3, r4)
            r10.f1902e = r1
            r1 = 0
            r2 = 0
            r3 = r2
            r4 = 0
        L_0x001b:
            boolean r5 = r10.f1899b
            r6 = 1
            if (r5 != 0) goto L_0x01dd
            r5 = r11
            com.uxcam.internals.de r5 = (com.uxcam.internals.C3056de) r5     // Catch:{ cv -> 0x01c4, IOException -> 0x01b4 }
            com.uxcam.internals.cx r7 = r10.f1902e     // Catch:{ cv -> 0x01c4, IOException -> 0x01b4 }
            com.uxcam.internals.cf r5 = r5.mo38234a(r0, r7, r2, r2)     // Catch:{ cv -> 0x01c4, IOException -> 0x01b4 }
            if (r3 == 0) goto L_0x004d
            com.uxcam.internals.cf$aa r0 = r5.mo38177b()
            com.uxcam.internals.cf$aa r3 = r3.mo38177b()
            r3.f1759g = r2
            com.uxcam.internals.cf r3 = r3.mo38185a()
            com.uxcam.internals.cg r5 = r3.f1746g
            if (r5 != 0) goto L_0x0045
            r0.f1762j = r3
            com.uxcam.internals.cf r0 = r0.mo38185a()
            r3 = r0
            goto L_0x004e
        L_0x0045:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "priorResponse.body != null"
            r11.<init>(r0)
            throw r11
        L_0x004d:
            r3 = r5
        L_0x004e:
            if (r3 == 0) goto L_0x01ac
            com.uxcam.internals.cx r0 = r10.f1902e
            com.uxcam.internals.ct r0 = r0.mo38224b()
            if (r0 == 0) goto L_0x005d
            com.uxcam.internals.ch r0 = r0.mo38085a()
            goto L_0x005e
        L_0x005d:
            r0 = r2
        L_0x005e:
            int r5 = r3.f1742c
            com.uxcam.internals.cd r7 = r3.f1740a
            java.lang.String r7 = r7.f1724b
            switch(r5) {
                case 300: goto L_0x00a0;
                case 301: goto L_0x00a0;
                case 302: goto L_0x00a0;
                case 303: goto L_0x00a0;
                case 307: goto L_0x0090;
                case 308: goto L_0x0090;
                case 401: goto L_0x0125;
                case 407: goto L_0x0075;
                case 408: goto L_0x0069;
                default: goto L_0x0067;
            }
        L_0x0067:
            goto L_0x0125
        L_0x0069:
            com.uxcam.internals.cd r0 = r3.f1740a
            com.uxcam.internals.ce r0 = r0.f1726d
            boolean r0 = r0 instanceof com.uxcam.internals.C3061dj
            if (r0 != 0) goto L_0x0125
            com.uxcam.internals.cd r0 = r3.f1740a
            goto L_0x0126
        L_0x0075:
            if (r0 == 0) goto L_0x007a
            java.net.Proxy r0 = r0.f1769b
            goto L_0x007e
        L_0x007a:
            com.uxcam.internals.ca r0 = r10.f1900c
            java.net.Proxy r0 = r0.f1661d
        L_0x007e:
            java.net.Proxy$Type r0 = r0.type()
            java.net.Proxy$Type r5 = java.net.Proxy.Type.HTTP
            if (r0 != r5) goto L_0x0088
            goto L_0x0125
        L_0x0088:
            java.net.ProtocolException r11 = new java.net.ProtocolException
            java.lang.String r0 = "Received HTTP_PROXY_AUTH (407) code while not using proxy"
            r11.<init>(r0)
            throw r11
        L_0x0090:
            java.lang.String r0 = "GET"
            boolean r0 = r7.equals(r0)
            if (r0 != 0) goto L_0x00a0
            java.lang.String r0 = "HEAD"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0125
        L_0x00a0:
            com.uxcam.internals.ca r0 = r10.f1900c
            boolean r0 = r0.f1680w
            if (r0 == 0) goto L_0x0125
            java.lang.String r0 = "Location"
            java.lang.String r0 = r3.mo38175a(r0)
            if (r0 == 0) goto L_0x0125
            com.uxcam.internals.cd r5 = r3.f1740a
            com.uxcam.internals.bw r5 = r5.f1723a
            com.uxcam.internals.bw$aa r0 = r5.mo38123c(r0)
            if (r0 == 0) goto L_0x00bd
            com.uxcam.internals.bw r0 = r0.mo38135b()
            goto L_0x00be
        L_0x00bd:
            r0 = r2
        L_0x00be:
            if (r0 == 0) goto L_0x0125
            java.lang.String r5 = r0.f1609a
            com.uxcam.internals.cd r8 = r3.f1740a
            com.uxcam.internals.bw r8 = r8.f1723a
            java.lang.String r8 = r8.f1609a
            boolean r5 = r5.equals(r8)
            if (r5 != 0) goto L_0x00d4
            com.uxcam.internals.ca r5 = r10.f1900c
            boolean r5 = r5.f1679v
            if (r5 == 0) goto L_0x0125
        L_0x00d4:
            com.uxcam.internals.cd r5 = r3.f1740a
            com.uxcam.internals.cd$aa r5 = r5.mo38165a()
            boolean r8 = com.uxcam.internals.C3055dd.m1507b(r7)
            if (r8 == 0) goto L_0x0111
            java.lang.String r8 = "PROPFIND"
            boolean r8 = r7.equals(r8)
            java.lang.String r9 = "PROPFIND"
            boolean r9 = r7.equals(r9)
            r6 = r6 ^ r9
            if (r6 == 0) goto L_0x00f5
            java.lang.String r6 = "GET"
            r5.mo38171a((java.lang.String) r6, (com.uxcam.internals.C3019ce) r2)
            goto L_0x0100
        L_0x00f5:
            if (r8 == 0) goto L_0x00fc
            com.uxcam.internals.cd r6 = r3.f1740a
            com.uxcam.internals.ce r6 = r6.f1726d
            goto L_0x00fd
        L_0x00fc:
            r6 = r2
        L_0x00fd:
            r5.mo38171a((java.lang.String) r7, (com.uxcam.internals.C3019ce) r6)
        L_0x0100:
            if (r8 != 0) goto L_0x0111
            java.lang.String r6 = "Transfer-Encoding"
            r5.mo38174b(r6)
            java.lang.String r6 = "Content-Length"
            r5.mo38174b(r6)
            java.lang.String r6 = "Content-Type"
            r5.mo38174b(r6)
        L_0x0111:
            boolean r6 = m1517a((com.uxcam.internals.C3022cf) r3, (com.uxcam.internals.C3002bw) r0)
            if (r6 != 0) goto L_0x011c
            java.lang.String r6 = "Authorization"
            r5.mo38174b(r6)
        L_0x011c:
            com.uxcam.internals.cd$aa r0 = r5.mo38169a((com.uxcam.internals.C3002bw) r0)
            com.uxcam.internals.cd r0 = r0.mo38173a()
            goto L_0x0126
        L_0x0125:
            r0 = r2
        L_0x0126:
            if (r0 != 0) goto L_0x0132
            boolean r11 = r10.f1901d
            if (r11 != 0) goto L_0x0131
            com.uxcam.internals.cx r11 = r10.f1902e
            r11.mo38225c()
        L_0x0131:
            return r3
        L_0x0132:
            com.uxcam.internals.cg r5 = r3.f1746g
            com.uxcam.internals.C3030cl.m1428a((java.io.Closeable) r5)
            int r4 = r4 + 1
            r5 = 20
            if (r4 > r5) goto L_0x0197
            com.uxcam.internals.ce r5 = r0.f1726d
            boolean r5 = r5 instanceof com.uxcam.internals.C3061dj
            if (r5 != 0) goto L_0x0188
            com.uxcam.internals.bw r5 = r0.f1723a
            boolean r5 = m1517a((com.uxcam.internals.C3022cf) r3, (com.uxcam.internals.C3002bw) r5)
            if (r5 != 0) goto L_0x0165
            com.uxcam.internals.cx r5 = r10.f1902e
            r5.mo38225c()
            com.uxcam.internals.cx r5 = new com.uxcam.internals.cx
            com.uxcam.internals.ca r6 = r10.f1900c
            com.uxcam.internals.bn r6 = r6.f1677t
            com.uxcam.internals.bw r7 = r0.f1723a
            com.uxcam.internals.be r7 = r10.m1516a((com.uxcam.internals.C3002bw) r7)
            java.lang.Object r8 = r10.f1898a
            r5.<init>(r6, r7, r8)
            r10.f1902e = r5
            goto L_0x001b
        L_0x0165:
            com.uxcam.internals.cx r5 = r10.f1902e
            com.uxcam.internals.da r5 = r5.mo38218a()
            if (r5 != 0) goto L_0x016f
            goto L_0x001b
        L_0x016f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Closing the body of "
            r0.<init>(r1)
            r0.append(r3)
            java.lang.String r1 = " didn't close its backing stream. Bad interceptor?"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r11.<init>(r0)
            throw r11
        L_0x0188:
            com.uxcam.internals.cx r11 = r10.f1902e
            r11.mo38225c()
            java.net.HttpRetryException r11 = new java.net.HttpRetryException
            int r0 = r3.f1742c
            java.lang.String r1 = "Cannot retry streamed HTTP body"
            r11.<init>(r1, r0)
            throw r11
        L_0x0197:
            com.uxcam.internals.cx r11 = r10.f1902e
            r11.mo38225c()
            java.net.ProtocolException r11 = new java.net.ProtocolException
            java.lang.String r0 = java.lang.String.valueOf(r4)
            java.lang.String r1 = "Too many follow-up requests: "
            java.lang.String r0 = r1.concat(r0)
            r11.<init>(r0)
            throw r11
        L_0x01ac:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            r11.<init>()
            throw r11
        L_0x01b2:
            r11 = move-exception
            goto L_0x01d2
        L_0x01b4:
            r5 = move-exception
            boolean r7 = r5 instanceof com.uxcam.internals.C3069dl     // Catch:{ all -> 0x01b2 }
            if (r7 != 0) goto L_0x01ba
            goto L_0x01bb
        L_0x01ba:
            r6 = 0
        L_0x01bb:
            boolean r6 = r10.m1519a(r5, r6, r0)     // Catch:{ all -> 0x01b2 }
            if (r6 == 0) goto L_0x01c3
            goto L_0x001b
        L_0x01c3:
            throw r5     // Catch:{ all -> 0x01b2 }
        L_0x01c4:
            r5 = move-exception
            java.io.IOException r6 = r5.f1861a     // Catch:{ all -> 0x01b2 }
            boolean r6 = r10.m1519a(r6, r1, r0)     // Catch:{ all -> 0x01b2 }
            if (r6 == 0) goto L_0x01cf
            goto L_0x001b
        L_0x01cf:
            java.io.IOException r11 = r5.f1861a     // Catch:{ all -> 0x01b2 }
            throw r11     // Catch:{ all -> 0x01b2 }
        L_0x01d2:
            com.uxcam.internals.cx r0 = r10.f1902e
            r0.mo38221a((java.io.IOException) r2)
            com.uxcam.internals.cx r0 = r10.f1902e
            r0.mo38225c()
            throw r11
        L_0x01dd:
            com.uxcam.internals.cx r11 = r10.f1902e
            r11.mo38223a(r1, r6, r1)
            java.io.IOException r11 = new java.io.IOException
            java.lang.String r0 = "Canceled"
            r11.<init>(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C3059dh.mo38068a(com.uxcam.internals.bx$aa):com.uxcam.internals.cf");
    }
}
