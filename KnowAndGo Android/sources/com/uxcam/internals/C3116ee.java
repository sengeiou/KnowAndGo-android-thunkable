package com.uxcam.internals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: com.uxcam.internals.ee */
final class C3116ee {

    /* renamed from: a */
    private final Class f2127a;

    /* renamed from: b */
    private final String f2128b;

    /* renamed from: c */
    private final Class[] f2129c;

    public C3116ee(Class cls, String str, Class... clsArr) {
        this.f2127a = cls;
        this.f2128b = str;
        this.f2129c = clsArr;
    }

    /* renamed from: a */
    private Method m1694a(Class cls) {
        if (this.f2128b == null) {
            return null;
        }
        Method a = m1695a(cls, this.f2128b, this.f2129c);
        if (a == null || this.f2127a == null || this.f2127a.isAssignableFrom(a.getReturnType())) {
            return a;
        }
        return null;
    }

    /* renamed from: a */
    private static Method m1695a(Class cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) != 0) {
                    return method;
                }
            } catch (NoSuchMethodException unused) {
                return method;
            }
        } catch (NoSuchMethodException unused2) {
        }
        return null;
    }

    /* renamed from: c */
    private Object m1696c(Object obj, Object... objArr) {
        Method a = m1694a((Class) obj.getClass());
        if (a == null) {
            return null;
        }
        try {
            return a.invoke(obj, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    /* renamed from: d */
    private Object m1697d(Object obj, Object... objArr) {
        Method a = m1694a((Class) obj.getClass());
        if (a != null) {
            try {
                return a.invoke(obj, objArr);
            } catch (IllegalAccessException e) {
                AssertionError assertionError = new AssertionError("Unexpectedly could not call: ".concat(String.valueOf(a)));
                assertionError.initCause(e);
                throw assertionError;
            }
        } else {
            throw new AssertionError("Method " + this.f2128b + " not supported for object " + obj);
        }
    }

    /* renamed from: a */
    public final Object mo38328a(Object obj, Object... objArr) {
        try {
            return m1696c(obj, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    /* renamed from: a */
    public final boolean mo38329a(Object obj) {
        return m1694a((Class) obj.getClass()) != null;
    }

    /* renamed from: b */
    public final Object mo38330b(Object obj, Object... objArr) {
        try {
            return m1697d(obj, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }
}
