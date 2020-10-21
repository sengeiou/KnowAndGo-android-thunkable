package com.uxcam.internals;

/* renamed from: com.uxcam.internals.er */
public abstract class C3134er implements C3148fc {

    /* renamed from: a */
    private final C3148fc f2164a;

    public C3134er(C3148fc fcVar) {
        if (fcVar != null) {
            this.f2164a = fcVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    /* renamed from: a */
    public final long mo38196a(C3130en enVar, long j) {
        return this.f2164a.mo38196a(enVar, j);
    }

    /* renamed from: a */
    public final C3149fd mo38197a() {
        return this.f2164a.mo38197a();
    }

    public void close() {
        this.f2164a.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f2164a.toString() + ")";
    }
}
