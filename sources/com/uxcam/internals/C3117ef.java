package com.uxcam.internals;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.uxcam.internals.ef */
public class C3117ef {

    /* renamed from: a */
    private static final Logger f2130a = Logger.getLogger(C3011ca.class.getName());

    /* renamed from: c */
    static final C3117ef f2131c;

    static {
        C3117ef a = C3110eb.m1674a();
        if (a == null && (a = C3113ec.m1687a()) == null && (a = C3114ed.m1690a()) == null) {
            a = new C3117ef();
        }
        f2131c = a;
    }

    /* renamed from: a */
    public static List m1701a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            C3014cb cbVar = (C3014cb) list.get(i);
            if (cbVar != C3014cb.HTTP_1_0) {
                arrayList.add(cbVar.toString());
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public static C3117ef m1702b() {
        return f2131c;
    }

    /* renamed from: a */
    public C3119eh mo38313a(X509TrustManager x509TrustManager) {
        return new C3118eg(C3122ek.m1724a(x509TrustManager));
    }

    /* renamed from: a */
    public Object mo38314a(String str) {
        if (f2130a.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    /* renamed from: a */
    public String mo38315a(SSLSocket sSLSocket) {
        return null;
    }

    /* renamed from: a */
    public void mo38316a(int i, String str, Throwable th) {
        f2130a.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    /* renamed from: a */
    public void mo38317a(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        mo38316a(5, str, (Throwable) obj);
    }

    /* renamed from: a */
    public void mo38318a(Socket socket, InetSocketAddress inetSocketAddress, int i) {
        socket.connect(inetSocketAddress, i);
    }

    /* renamed from: a */
    public void mo38319a(SSLSocket sSLSocket, String str, List list) {
    }

    /* renamed from: b */
    public void mo38326b(SSLSocket sSLSocket) {
    }

    /* renamed from: b */
    public boolean mo38320b(String str) {
        return true;
    }
}
