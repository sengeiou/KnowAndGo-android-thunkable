package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C2042cl;
import com.google.android.play.core.internal.C2044cn;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.cq */
public final class C1912cq implements C2044cn<C1911cp> {

    /* renamed from: a */
    private final C2044cn<C1870bb> f546a;

    /* renamed from: b */
    private final C2044cn<C1966w> f547b;

    /* renamed from: c */
    private final C2044cn<C1894bz> f548c;

    /* renamed from: d */
    private final C2044cn<Executor> f549d;

    public C1912cq(C2044cn<C1870bb> cnVar, C2044cn<C1966w> cnVar2, C2044cn<C1894bz> cnVar3, C2044cn<Executor> cnVar4) {
        this.f546a = cnVar;
        this.f547b = cnVar2;
        this.f548c = cnVar3;
        this.f549d = cnVar4;
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo33266a() {
        C1870bb a = this.f546a.mo33266a();
        return new C1911cp(a, C2042cl.m744b(this.f547b), this.f548c.mo33266a(), C2042cl.m744b(this.f549d));
    }
}
