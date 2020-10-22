package com.uxcam.internals;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* renamed from: com.uxcam.internals.ed */
final class C3114ed extends C3117ef {

    /* renamed from: a */
    private final Method f2119a;

    /* renamed from: b */
    private final Method f2120b;

    /* renamed from: d */
    private final Method f2121d;

    /* renamed from: e */
    private final Class f2122e;

    /* renamed from: f */
    private final Class f2123f;

    /* renamed from: com.uxcam.internals.ed$aa */
    static class C3115aa implements InvocationHandler {

        /* renamed from: a */
        boolean f2124a;

        /* renamed from: b */
        String f2125b;

        /* renamed from: c */
        private final List f2126c;

        public C3115aa(List list) {
            this.f2126c = list;
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) {
            Object obj2;
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = C3030cl.f1781b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f2124a = true;
                return null;
            } else if (name.equals("protocols") && objArr.length == 0) {
                return this.f2126c;
            } else {
                if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                    List list = (List) objArr[0];
                    int size = list.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            obj2 = this.f2126c.get(0);
                            break;
                        } else if (this.f2126c.contains(list.get(i))) {
                            obj2 = list.get(i);
                            break;
                        } else {
                            i++;
                        }
                    }
                    String str = (String) obj2;
                    this.f2125b = str;
                    return str;
                } else if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                    return method.invoke(this, objArr);
                } else {
                    this.f2125b = (String) objArr[0];
                    return null;
                }
            }
        }
    }

    private C3114ed(Method method, Method method2, Method method3, Class cls, Class cls2) {
        this.f2119a = method;
        this.f2120b = method2;
        this.f2121d = method3;
        this.f2122e = cls;
        this.f2123f = cls2;
    }

    /* renamed from: a */
    public static C3117ef m1690a() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$Provider");
            Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ClientProvider");
            Class<?> cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ServerProvider");
            Method method = cls.getMethod("put", new Class[]{SSLSocket.class, cls2});
            return new C3114ed(method, cls.getMethod("get", new Class[]{SSLSocket.class}), cls.getMethod("remove", new Class[]{SSLSocket.class}), cls3, cls4);
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public final String mo38315a(SSLSocket sSLSocket) {
        try {
            C3115aa aaVar = (C3115aa) Proxy.getInvocationHandler(this.f2120b.invoke((Object) null, new Object[]{sSLSocket}));
            if (!aaVar.f2124a && aaVar.f2125b == null) {
                C3117ef.f2131c.mo38316a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            } else if (aaVar.f2124a) {
                return null;
            } else {
                return aaVar.f2125b;
            }
        } catch (IllegalAccessException | InvocationTargetException unused) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public final void mo38319a(SSLSocket sSLSocket, String str, List list) {
        List a = m1701a(list);
        try {
            Object newProxyInstance = Proxy.newProxyInstance(C3117ef.class.getClassLoader(), new Class[]{this.f2122e, this.f2123f}, new C3115aa(a));
            this.f2119a.invoke((Object) null, new Object[]{sSLSocket, newProxyInstance});
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: b */
    public final void mo38326b(SSLSocket sSLSocket) {
        try {
            this.f2121d.invoke((Object) null, new Object[]{sSLSocket});
        } catch (IllegalAccessException | InvocationTargetException unused) {
            throw new AssertionError();
        }
    }
}
