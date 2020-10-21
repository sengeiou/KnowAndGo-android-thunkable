package com.uxcam.internals;

import android.util.Log;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;

/* renamed from: com.uxcam.internals.eb */
final class C3110eb extends C3117ef {

    /* renamed from: a */
    private final Class f2106a;

    /* renamed from: b */
    private final C3116ee f2107b;

    /* renamed from: d */
    private final C3116ee f2108d;

    /* renamed from: e */
    private final C3116ee f2109e;

    /* renamed from: f */
    private final C3116ee f2110f;

    /* renamed from: g */
    private final C3112ab f2111g = C3112ab.m1684a();

    /* renamed from: com.uxcam.internals.eb$aa */
    static final class C3111aa extends C3119eh {

        /* renamed from: a */
        private final Object f2112a;

        /* renamed from: b */
        private final Method f2113b;

        C3111aa(Object obj, Method method) {
            this.f2112a = obj;
            this.f2113b = method;
        }

        /* renamed from: a */
        public final List mo38321a(List list, String str) {
            try {
                return (List) this.f2113b.invoke(this.f2112a, new Object[]{(X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str});
            } catch (InvocationTargetException e) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e.getMessage());
                sSLPeerUnverifiedException.initCause(e);
                throw sSLPeerUnverifiedException;
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }

        public final boolean equals(Object obj) {
            return obj instanceof C3111aa;
        }

        public final int hashCode() {
            return 0;
        }
    }

    /* renamed from: com.uxcam.internals.eb$ab */
    static final class C3112ab {

        /* renamed from: a */
        private final Method f2114a;

        /* renamed from: b */
        private final Method f2115b;

        /* renamed from: c */
        private final Method f2116c;

        private C3112ab(Method method, Method method2, Method method3) {
            this.f2114a = method;
            this.f2115b = method2;
            this.f2116c = method3;
        }

        /* renamed from: a */
        static C3112ab m1684a() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", new Class[0]);
                method = cls.getMethod(AbstractCircuitBreaker.PROPERTY_NAME, new Class[]{String.class});
                method2 = cls.getMethod("warnIfOpen", new Class[0]);
                method3 = method4;
            } catch (Exception unused) {
                method2 = null;
                method = null;
            }
            return new C3112ab(method3, method, method2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final Object mo38324a(String str) {
            if (this.f2114a != null) {
                try {
                    Object invoke = this.f2114a.invoke((Object) null, new Object[0]);
                    this.f2115b.invoke(invoke, new Object[]{str});
                    return invoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final boolean mo38325a(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                this.f2116c.invoke(obj, new Object[0]);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    private C3110eb(Class cls, C3116ee eeVar, C3116ee eeVar2, C3116ee eeVar3, C3116ee eeVar4) {
        this.f2106a = cls;
        this.f2107b = eeVar;
        this.f2108d = eeVar2;
        this.f2109e = eeVar3;
        this.f2110f = eeVar4;
    }

    /* renamed from: a */
    public static C3117ef m1674a() {
        Class<?> cls;
        C3116ee eeVar;
        C3116ee eeVar2;
        try {
            cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
        } catch (ClassNotFoundException unused) {
            try {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            } catch (ClassNotFoundException unused2) {
                return null;
            }
        }
        Class<?> cls2 = cls;
        C3116ee eeVar3 = new C3116ee((Class) null, "setUseSessionTickets", Boolean.TYPE);
        C3116ee eeVar4 = new C3116ee((Class) null, "setHostname", String.class);
        try {
            Class.forName("android.net.Network");
            eeVar2 = new C3116ee(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
            try {
                eeVar = new C3116ee((Class) null, "setAlpnProtocols", byte[].class);
            } catch (ClassNotFoundException unused3) {
                eeVar = null;
                return new C3110eb(cls2, eeVar3, eeVar4, eeVar2, eeVar);
            }
        } catch (ClassNotFoundException unused4) {
            eeVar2 = null;
            eeVar = null;
            return new C3110eb(cls2, eeVar3, eeVar4, eeVar2, eeVar);
        }
        return new C3110eb(cls2, eeVar3, eeVar4, eeVar2, eeVar);
    }

    /* renamed from: a */
    public final C3119eh mo38313a(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C3111aa(cls.getConstructor(new Class[]{X509TrustManager.class}).newInstance(new Object[]{x509TrustManager}), cls.getMethod("checkServerTrusted", new Class[]{X509Certificate[].class, String.class, String.class}));
        } catch (Exception unused) {
            return super.mo38313a(x509TrustManager);
        }
    }

    /* renamed from: a */
    public final Object mo38314a(String str) {
        return this.f2111g.mo38324a(str);
    }

    /* renamed from: a */
    public final String mo38315a(SSLSocket sSLSocket) {
        byte[] bArr;
        if (this.f2109e == null || !this.f2109e.mo38329a((Object) sSLSocket) || (bArr = (byte[]) this.f2109e.mo38330b(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, C3030cl.f1784e);
    }

    /* renamed from: a */
    public final void mo38316a(int i, String str, Throwable th) {
        int min;
        int i2 = 5;
        if (i != 5) {
            i2 = 3;
        }
        if (th != null) {
            str = str + 10 + Log.getStackTraceString(th);
        }
        int i3 = 0;
        int length = str.length();
        while (i3 < length) {
            int indexOf = str.indexOf(10, i3);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i3 + 4000);
                Log.println(i2, "OkHttp", str.substring(i3, min));
                if (min >= indexOf) {
                    break;
                }
                i3 = min;
            }
            i3 = min + 1;
        }
    }

    /* renamed from: a */
    public final void mo38317a(String str, Object obj) {
        if (!this.f2111g.mo38325a(obj)) {
            mo38316a(5, str, (Throwable) null);
        }
    }

    /* renamed from: a */
    public final void mo38318a(Socket socket, InetSocketAddress inetSocketAddress, int i) {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e) {
            if (C3030cl.m1432a(e)) {
                throw new IOException(e);
            }
            throw e;
        } catch (SecurityException e2) {
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e2);
            throw iOException;
        }
    }

    /* renamed from: a */
    public final void mo38319a(SSLSocket sSLSocket, String str, List list) {
        if (str != null) {
            this.f2107b.mo38328a(sSLSocket, Boolean.TRUE);
            this.f2108d.mo38328a(sSLSocket, str);
        }
        if (this.f2110f != null && this.f2110f.mo38329a((Object) sSLSocket)) {
            Object[] objArr = new Object[1];
            C3130en enVar = new C3130en();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                C3014cb cbVar = (C3014cb) list.get(i);
                if (cbVar != C3014cb.HTTP_1_0) {
                    enVar.mo38387h(cbVar.toString().length());
                    enVar.mo38364b(cbVar.toString());
                }
            }
            objArr[0] = enVar.mo38397n();
            this.f2110f.mo38330b(sSLSocket, objArr);
        }
    }

    /* renamed from: b */
    public final boolean mo38320b(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            Object invoke = cls.getMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[]{String.class}).invoke(invoke, new Object[]{str})).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.mo38320b(str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused2) {
            throw new AssertionError();
        }
    }
}
