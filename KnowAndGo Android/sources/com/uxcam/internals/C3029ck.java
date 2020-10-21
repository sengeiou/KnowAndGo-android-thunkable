package com.uxcam.internals;

/* renamed from: com.uxcam.internals.ck */
public abstract class C3029ck implements Runnable {

    /* renamed from: b */
    protected final String f1779b;

    public C3029ck(String str, Object... objArr) {
        this.f1779b = C3030cl.m1422a(str, objArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo38164b();

    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f1779b);
        try {
            mo38164b();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
