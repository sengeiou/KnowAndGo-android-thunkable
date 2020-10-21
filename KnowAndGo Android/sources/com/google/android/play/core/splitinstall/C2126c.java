package com.google.android.play.core.splitinstall;

import android.content.Context;
import com.google.android.play.core.internal.C2042cl;
import com.google.android.play.core.internal.C2044cn;
import com.google.android.play.core.splitinstall.testing.C2155k;
import com.google.android.play.core.splitinstall.testing.FakeSplitInstallManager;
import java.io.File;

/* renamed from: com.google.android.play.core.splitinstall.c */
public final class C2126c implements C2136m {

    /* renamed from: a */
    private C2044cn<Context> f909a;

    /* renamed from: b */
    private C2044cn<C2120av> f910b = C2042cl.m743a(new C2121aw(this.f909a));

    /* renamed from: c */
    private C2044cn<C2144t> f911c;

    /* renamed from: d */
    private C2044cn<C2140p> f912d;

    /* renamed from: e */
    private C2044cn<C2122ax> f913e;

    /* renamed from: f */
    private C2044cn<C2158w> f914f;

    /* renamed from: g */
    private C2044cn<File> f915g;

    /* renamed from: h */
    private C2044cn<FakeSplitInstallManager> f916h;

    /* renamed from: i */
    private C2044cn<C2132i> f917i;

    /* renamed from: j */
    private C2044cn<SplitInstallManager> f918j;

    /* synthetic */ C2126c(C2160y yVar) {
        this.f909a = new C2161z(yVar);
        this.f911c = C2042cl.m743a(new C2100ab(yVar));
        this.f912d = C2042cl.m743a(C2141q.m1005a(this.f909a));
        this.f913e = C2042cl.m743a(new C2123ay(this.f909a));
        this.f914f = C2042cl.m743a(new C2159x(this.f910b, this.f911c, this.f912d, this.f913e));
        this.f915g = C2042cl.m743a(new C2099aa(this.f909a));
        this.f916h = C2042cl.m743a(new C2155k(this.f909a, this.f915g, this.f912d));
        this.f917i = C2042cl.m743a(new C2133j(this.f914f, this.f916h, this.f915g));
        this.f918j = C2042cl.m743a(new C2101ac(yVar, this.f917i));
    }

    /* renamed from: a */
    public final SplitInstallManager mo33757a() {
        return this.f918j.mo33266a();
    }

    /* renamed from: b */
    public final File mo33758b() {
        return this.f915g.mo33266a();
    }
}
