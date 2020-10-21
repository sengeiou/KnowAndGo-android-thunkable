package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C2040cj;
import com.google.android.play.core.internal.C2042cl;
import com.google.android.play.core.internal.C2044cn;
import com.google.android.play.core.splitinstall.C2140p;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.k */
public final class C1953k implements C2044cn<C1952j> {

    /* renamed from: a */
    private final C2044cn<C1870bb> f686a;

    /* renamed from: b */
    private final C2044cn<C1966w> f687b;

    /* renamed from: c */
    private final C2044cn<C1864aw> f688c;

    /* renamed from: d */
    private final C2044cn<C2140p> f689d;

    /* renamed from: e */
    private final C2044cn<C1911cp> f690e;

    /* renamed from: f */
    private final C2044cn<C1894bz> f691f;

    /* renamed from: g */
    private final C2044cn<C1882bn> f692g;

    /* renamed from: h */
    private final C2044cn<Executor> f693h;

    public C1953k(C2044cn<C1870bb> cnVar, C2044cn<C1966w> cnVar2, C2044cn<C1864aw> cnVar3, C2044cn<C2140p> cnVar4, C2044cn<C1911cp> cnVar5, C2044cn<C1894bz> cnVar6, C2044cn<C1882bn> cnVar7, C2044cn<Executor> cnVar8) {
        this.f686a = cnVar;
        this.f687b = cnVar2;
        this.f688c = cnVar3;
        this.f689d = cnVar4;
        this.f690e = cnVar5;
        this.f691f = cnVar6;
        this.f692g = cnVar7;
        this.f693h = cnVar8;
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo33266a() {
        C1870bb a = this.f686a.mo33266a();
        C2040cj<C1966w> b = C2042cl.m744b(this.f687b);
        C1864aw a2 = this.f688c.mo33266a();
        return new C1952j(a, b, a2, this.f689d.mo33266a(), this.f690e.mo33266a(), this.f691f.mo33266a(), this.f692g.mo33266a(), C2042cl.m744b(this.f693h));
    }
}
