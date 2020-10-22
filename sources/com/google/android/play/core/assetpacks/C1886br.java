package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.common.C1971a;
import com.google.android.play.core.common.C1973c;
import com.google.android.play.core.internal.C2041ck;
import com.google.android.play.core.internal.C2042cl;
import com.google.android.play.core.internal.C2044cn;
import com.google.android.play.core.splitinstall.C2140p;
import com.google.android.play.core.splitinstall.C2141q;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.br */
public final class C1886br implements C1841a {

    /* renamed from: a */
    private final C1957n f432a;

    /* renamed from: b */
    private C2044cn<Context> f433b;

    /* renamed from: c */
    private C2044cn<C1934dl> f434c = C2042cl.m743a(new C1935dm(this.f433b));

    /* renamed from: d */
    private C2044cn<C1870bb> f435d = C2042cl.m743a(new C1871bc(this.f433b, this.f434c));

    /* renamed from: e */
    private C2044cn<C1894bz> f436e = C2042cl.m743a(C1896ca.f505a);

    /* renamed from: f */
    private C2044cn<C1859ar> f437f = C2042cl.m743a(new C1860as(this.f433b, this.f436e));

    /* renamed from: g */
    private C2044cn<String> f438g = C2042cl.m743a(new C1963t(this.f433b));

    /* renamed from: h */
    private C2044cn<C1966w> f439h = new C2041ck();

    /* renamed from: i */
    private C2044cn<Executor> f440i = C2042cl.m743a(C1958o.f699a);

    /* renamed from: j */
    private C2044cn<C1911cp> f441j = C2042cl.m743a(new C1912cq(this.f435d, this.f439h, this.f436e, this.f440i));

    /* renamed from: k */
    private C2044cn<C1864aw> f442k = new C2041ck();

    /* renamed from: l */
    private C2044cn<C1888bt> f443l = C2042cl.m743a(new C1889bu(this.f435d, this.f439h, this.f442k, this.f436e));

    /* renamed from: m */
    private C2044cn<C1944dv> f444m = C2042cl.m743a(new C1945dw(this.f435d));

    /* renamed from: n */
    private C2044cn<C1928df> f445n = C2042cl.m743a(new C1929dg(this.f435d));

    /* renamed from: o */
    private C2044cn<C1932dj> f446o = C2042cl.m743a(new C1933dk(this.f435d, this.f439h, this.f441j, this.f440i, this.f436e));

    /* renamed from: p */
    private C2044cn<C1971a> f447p = C2042cl.m743a(C1973c.m571b());

    /* renamed from: q */
    private C2044cn<C1937do> f448q = C2042cl.m743a(new C1938dp(this.f435d, this.f439h, this.f447p));

    /* renamed from: r */
    private C2044cn<C1879bk> f449r = C2042cl.m743a(new C1880bl(this.f439h));

    /* renamed from: s */
    private C2044cn<C1914cs> f450s = C2042cl.m743a(new C1915ct(this.f441j, this.f435d, this.f449r));

    /* renamed from: t */
    private C2044cn<C1891bw> f451t = C2042cl.m743a(new C1892bx(this.f441j, this.f439h, this.f443l, this.f444m, this.f445n, this.f446o, this.f448q, this.f450s));

    /* renamed from: u */
    private C2044cn<C1882bn> f452u = C2042cl.m743a(C1883bo.f430a);

    /* renamed from: v */
    private C2044cn<Executor> f453v = C2042cl.m743a(C1964u.f707a);

    /* renamed from: w */
    private C2044cn<C1921cz> f454w;

    /* renamed from: x */
    private C2044cn<C2140p> f455x;

    /* renamed from: y */
    private C2044cn<C1952j> f456y;

    /* renamed from: z */
    private C2044cn<AssetPackManager> f457z;

    /* synthetic */ C1886br(C1957n nVar) {
        this.f432a = nVar;
        this.f433b = new C1962s(nVar);
        C2041ck.m741a(this.f442k, C2042cl.m743a(new C1865ax(this.f433b, this.f441j, this.f451t, this.f439h, this.f436e, this.f452u, this.f447p, this.f440i, this.f453v)));
        this.f454w = C2042cl.m743a(new C1923da(this.f438g, this.f442k, this.f436e, this.f433b, this.f434c, this.f440i));
        C2041ck.m741a(this.f439h, C2042cl.m743a(new C1961r(this.f433b, this.f437f, this.f454w)));
        this.f455x = C2042cl.m743a(C2141q.m1005a(this.f433b));
        this.f456y = C2042cl.m743a(new C1953k(this.f435d, this.f439h, this.f442k, this.f455x, this.f441j, this.f436e, this.f452u, this.f440i));
        this.f457z = C2042cl.m743a(new C1960q(this.f456y, this.f433b));
    }

    /* renamed from: a */
    public final AssetPackManager mo33338a() {
        return this.f457z.mo33266a();
    }

    /* renamed from: a */
    public final void mo33339a(AssetPackExtractionService assetPackExtractionService) {
        assetPackExtractionService.f294a = C1962s.m546a(this.f432a);
        assetPackExtractionService.f295b = this.f456y.mo33266a();
        assetPackExtractionService.f296c = this.f435d.mo33266a();
    }
}
