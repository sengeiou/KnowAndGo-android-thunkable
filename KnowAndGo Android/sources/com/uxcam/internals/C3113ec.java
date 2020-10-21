package com.uxcam.internals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* renamed from: com.uxcam.internals.ec */
final class C3113ec extends C3117ef {

    /* renamed from: a */
    final Method f2117a;

    /* renamed from: b */
    final Method f2118b;

    private C3113ec(Method method, Method method2) {
        this.f2117a = method;
        this.f2118b = method2;
    }

    /* renamed from: a */
    public static C3113ec m1687a() {
        try {
            return new C3113ec(SSLParameters.class.getMethod("setApplicationProtocols", new Class[]{String[].class}), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public final String mo38315a(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f2118b.invoke(sSLSocket, new Object[0]);
            if (str == null || str.equals("")) {
                return null;
            }
            return str;
        } catch (IllegalAccessException | InvocationTargetException unused) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public final void mo38319a(SSLSocket sSLSocket, String str, List list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List a = m1701a(list);
            this.f2117a.invoke(sSLParameters, new Object[]{a.toArray(new String[a.size()])});
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            throw new AssertionError();
        }
    }
}
