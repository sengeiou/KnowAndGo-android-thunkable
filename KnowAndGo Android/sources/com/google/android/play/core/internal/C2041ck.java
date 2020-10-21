package com.google.android.play.core.internal;

/* renamed from: com.google.android.play.core.internal.ck */
public final class C2041ck<T> implements C2044cn<T> {

    /* renamed from: a */
    private C2044cn<T> f777a;

    /* renamed from: a */
    public static <T> void m741a(C2044cn<T> cnVar, C2044cn<T> cnVar2) {
        C2020bq.m687a(cnVar2);
        C2041ck ckVar = (C2041ck) cnVar;
        if (ckVar.f777a == null) {
            ckVar.f777a = cnVar2;
            return;
        }
        throw new IllegalStateException();
    }

    /* renamed from: a */
    public final T mo33266a() {
        C2044cn<T> cnVar = this.f777a;
        if (cnVar != null) {
            return cnVar.mo33266a();
        }
        throw new IllegalStateException();
    }
}
