package com.google.android.play.core.internal;

/* renamed from: com.google.android.play.core.internal.cl */
public final class C2042cl<T> implements C2044cn, C2040cj {

    /* renamed from: a */
    private static final Object f778a = new Object();

    /* renamed from: b */
    private volatile C2044cn<T> f779b;

    /* renamed from: c */
    private volatile Object f780c = f778a;

    private C2042cl(C2044cn<T> cnVar) {
        this.f779b = cnVar;
    }

    /* renamed from: a */
    public static <P extends C2044cn<T>, T> C2044cn<T> m743a(P p) {
        C2020bq.m687a(p);
        return p instanceof C2042cl ? p : new C2042cl(p);
    }

    /* renamed from: b */
    public static <P extends C2044cn<T>, T> C2040cj<T> m744b(P p) {
        if (p instanceof C2040cj) {
            return (C2040cj) p;
        }
        C2020bq.m687a(p);
        return new C2042cl(p);
    }

    /* renamed from: a */
    public final T mo33266a() {
        T t = this.f780c;
        if (t == f778a) {
            synchronized (this) {
                t = this.f780c;
                if (t == f778a) {
                    t = this.f779b.mo33266a();
                    T t2 = this.f780c;
                    if (t2 != f778a && !(t2 instanceof C2043cm)) {
                        if (t2 != t) {
                            String valueOf = String.valueOf(t2);
                            String valueOf2 = String.valueOf(t);
                            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 118 + String.valueOf(valueOf2).length());
                            sb.append("Scoped provider was invoked recursively returning different results: ");
                            sb.append(valueOf);
                            sb.append(" & ");
                            sb.append(valueOf2);
                            sb.append(". This is likely due to a circular dependency.");
                            throw new IllegalStateException(sb.toString());
                        }
                    }
                    this.f780c = t;
                    this.f779b = null;
                }
            }
        }
        return t;
    }
}
