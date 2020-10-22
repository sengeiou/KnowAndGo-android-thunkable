package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.common.C1971a;
import com.google.android.play.core.internal.C2040cj;
import com.google.android.play.core.internal.C2042cl;
import com.google.android.play.core.internal.C2044cn;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.ax */
public final class C1865ax implements C2044cn<C1864aw> {

    /* renamed from: a */
    private final C2044cn<Context> f379a;

    /* renamed from: b */
    private final C2044cn<C1911cp> f380b;

    /* renamed from: c */
    private final C2044cn<C1891bw> f381c;

    /* renamed from: d */
    private final C2044cn<C1966w> f382d;

    /* renamed from: e */
    private final C2044cn<C1894bz> f383e;

    /* renamed from: f */
    private final C2044cn<C1882bn> f384f;

    /* renamed from: g */
    private final C2044cn<C1971a> f385g;

    /* renamed from: h */
    private final C2044cn<Executor> f386h;

    /* renamed from: i */
    private final C2044cn<Executor> f387i;

    public C1865ax(C2044cn<Context> cnVar, C2044cn<C1911cp> cnVar2, C2044cn<C1891bw> cnVar3, C2044cn<C1966w> cnVar4, C2044cn<C1894bz> cnVar5, C2044cn<C1882bn> cnVar6, C2044cn<C1971a> cnVar7, C2044cn<Executor> cnVar8, C2044cn<Executor> cnVar9) {
        this.f379a = cnVar;
        this.f380b = cnVar2;
        this.f381c = cnVar3;
        this.f382d = cnVar4;
        this.f383e = cnVar5;
        this.f384f = cnVar6;
        this.f385g = cnVar7;
        this.f386h = cnVar8;
        this.f387i = cnVar9;
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo33266a() {
        Context b = ((C1962s) this.f379a).mo33266a();
        C1911cp a = this.f380b.mo33266a();
        C1891bw a2 = this.f381c.mo33266a();
        C2040cj<C1966w> b2 = C2042cl.m744b(this.f382d);
        C1894bz a3 = this.f383e.mo33266a();
        C1882bn a4 = this.f384f.mo33266a();
        return new C1864aw(b, a, a2, b2, a3, a4, this.f385g.mo33266a(), C2042cl.m744b(this.f386h), C2042cl.m744b(this.f387i));
    }
}
