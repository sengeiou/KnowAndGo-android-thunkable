package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C2042cl;
import com.google.android.play.core.internal.C2044cn;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.dk */
public final class C1933dk implements C2044cn<C1932dj> {

    /* renamed from: a */
    private final C2044cn<C1870bb> f617a;

    /* renamed from: b */
    private final C2044cn<C1966w> f618b;

    /* renamed from: c */
    private final C2044cn<C1911cp> f619c;

    /* renamed from: d */
    private final C2044cn<Executor> f620d;

    /* renamed from: e */
    private final C2044cn<C1894bz> f621e;

    public C1933dk(C2044cn<C1870bb> cnVar, C2044cn<C1966w> cnVar2, C2044cn<C1911cp> cnVar3, C2044cn<Executor> cnVar4, C2044cn<C1894bz> cnVar5) {
        this.f617a = cnVar;
        this.f618b = cnVar2;
        this.f619c = cnVar3;
        this.f620d = cnVar4;
        this.f621e = cnVar5;
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo33266a() {
        C1870bb a = this.f617a.mo33266a();
        return new C1932dj(a, C2042cl.m744b(this.f618b), this.f619c.mo33266a(), C2042cl.m744b(this.f620d), this.f621e.mo33266a());
    }
}
