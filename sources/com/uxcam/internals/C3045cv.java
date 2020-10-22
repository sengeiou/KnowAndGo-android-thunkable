package com.uxcam.internals;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: com.uxcam.internals.cv */
public final class C3045cv extends RuntimeException {

    /* renamed from: b */
    private static final Method f1860b;

    /* renamed from: a */
    public IOException f1861a;

    static {
        Method method;
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", new Class[]{Throwable.class});
        } catch (Exception unused) {
            method = null;
        }
        f1860b = method;
    }

    public C3045cv(IOException iOException) {
        super(iOException);
        this.f1861a = iOException;
    }

    /* renamed from: a */
    static void m1470a(IOException iOException, IOException iOException2) {
        if (f1860b != null) {
            try {
                f1860b.invoke(iOException, new Object[]{iOException2});
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }
}
