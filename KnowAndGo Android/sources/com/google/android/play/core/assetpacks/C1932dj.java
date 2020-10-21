package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C2040cj;
import java.io.File;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.dj */
final class C1932dj {

    /* renamed from: a */
    private final C1870bb f612a;

    /* renamed from: b */
    private final C2040cj<C1966w> f613b;

    /* renamed from: c */
    private final C1911cp f614c;

    /* renamed from: d */
    private final C2040cj<Executor> f615d;

    /* renamed from: e */
    private final C1894bz f616e;

    C1932dj(C1870bb bbVar, C2040cj<C1966w> cjVar, C1911cp cpVar, C2040cj<Executor> cjVar2, C1894bz bzVar) {
        this.f612a = bbVar;
        this.f613b = cjVar;
        this.f614c = cpVar;
        this.f615d = cjVar2;
        this.f616e = bzVar;
    }

    /* renamed from: a */
    public final void mo33477a(C1930dh dhVar) {
        File c = this.f612a.mo33384c(dhVar.f551k, dhVar.f609a, dhVar.f610b);
        File e = this.f612a.mo33393e(dhVar.f551k, dhVar.f609a, dhVar.f610b);
        if (!c.exists() || !e.exists()) {
            throw new C1890bv(String.format("Cannot find pack files to move for pack %s.", new Object[]{dhVar.f551k}), dhVar.f550j);
        }
        File a = this.f612a.mo33374a(dhVar.f551k, dhVar.f609a, dhVar.f610b);
        a.mkdirs();
        if (c.renameTo(a)) {
            new File(this.f612a.mo33374a(dhVar.f551k, dhVar.f609a, dhVar.f610b), "merge.tmp").delete();
            File b = this.f612a.mo33381b(dhVar.f551k, dhVar.f609a, dhVar.f610b);
            b.mkdirs();
            if (e.renameTo(b)) {
                C1870bb bbVar = this.f612a;
                bbVar.getClass();
                this.f615d.mo33606a().execute(C1931di.m486a(bbVar));
                this.f614c.mo33443a(dhVar.f551k, dhVar.f609a, dhVar.f610b);
                this.f616e.mo33436a(dhVar.f551k);
                this.f613b.mo33606a().mo33358a(dhVar.f550j, dhVar.f551k);
                return;
            }
            throw new C1890bv("Cannot move metadata files to final location.", dhVar.f550j);
        }
        throw new C1890bv("Cannot move merged pack files to final location.", dhVar.f550j);
    }
}
