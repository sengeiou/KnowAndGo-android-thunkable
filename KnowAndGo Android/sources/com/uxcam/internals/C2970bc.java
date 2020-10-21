package com.uxcam.internals;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.uxcam.internals.bc */
public final class C2970bc {

    /* renamed from: a */
    static volatile C2972aa[] f1392a = f1393b;

    /* renamed from: b */
    private static final C2972aa[] f1393b = new C2972aa[0];

    /* renamed from: c */
    private static final List f1394c = new ArrayList();

    /* renamed from: d */
    private static final C2972aa f1395d = new C2972aa() {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final void mo38069a(String str, String str2) {
            throw new AssertionError("Missing override for log method.");
        }

        /* renamed from: a */
        public final void mo38070a(String str, Object... objArr) {
            for (C2972aa a : C2970bc.f1392a) {
                a.mo38070a(str, objArr);
            }
        }
    };

    /* renamed from: com.uxcam.internals.bc$aa */
    public static abstract class C2972aa {

        /* renamed from: a */
        final ThreadLocal f1396a = new ThreadLocal();

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo38069a(String str, String str2);

        /* renamed from: a */
        public void mo38070a(String str, Object... objArr) {
            String str2 = (String) this.f1396a.get();
            if (str2 != null) {
                this.f1396a.remove();
            }
            if (str != null && str.length() == 0) {
                str = null;
            }
            if (str != null) {
                if (objArr.length > 0) {
                    str = String.format(str, objArr);
                }
                mo38069a(str2, str);
            }
        }
    }

    /* renamed from: a */
    public static C2972aa m1233a(String str) {
        for (C2972aa aaVar : f1392a) {
            aaVar.f1396a.set(str);
        }
        return f1395d;
    }

    /* renamed from: a */
    public static void m1234a() {
    }

    /* renamed from: a */
    public static void m1235a(C2972aa aaVar) {
        if (aaVar != f1395d) {
            synchronized (f1394c) {
                f1394c.add(aaVar);
                List list = f1394c;
                f1392a = (C2972aa[]) list.toArray(new C2972aa[list.size()]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot plant Timber into itself.");
    }

    /* renamed from: a */
    public static void m1236a(String str, Object... objArr) {
        f1395d.mo38070a(str, objArr);
    }

    /* renamed from: b */
    public static void m1237b() {
    }

    /* renamed from: c */
    public static void m1238c() {
    }
}
