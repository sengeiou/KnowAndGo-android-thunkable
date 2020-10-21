package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.internal.C2042cl;
import com.google.android.play.core.internal.C2044cn;
import java.io.File;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.da */
public final class C1923da implements C2044cn<C1921cz> {

    /* renamed from: a */
    private final C2044cn<String> f585a;

    /* renamed from: b */
    private final C2044cn<C1864aw> f586b;

    /* renamed from: c */
    private final C2044cn<C1894bz> f587c;

    /* renamed from: d */
    private final C2044cn<Context> f588d;

    /* renamed from: e */
    private final C2044cn<C1934dl> f589e;

    /* renamed from: f */
    private final C2044cn<Executor> f590f;

    public C1923da(C2044cn<String> cnVar, C2044cn<C1864aw> cnVar2, C2044cn<C1894bz> cnVar3, C2044cn<Context> cnVar4, C2044cn<C1934dl> cnVar5, C2044cn<Executor> cnVar6) {
        this.f585a = cnVar;
        this.f586b = cnVar2;
        this.f587c = cnVar3;
        this.f588d = cnVar4;
        this.f589e = cnVar5;
        this.f590f = cnVar6;
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo33266a() {
        String a = this.f585a.mo33266a();
        C1864aw a2 = this.f586b.mo33266a();
        C1894bz a3 = this.f587c.mo33266a();
        Context b = ((C1962s) this.f588d).mo33266a();
        C1934dl a4 = this.f589e.mo33266a();
        return new C1921cz(a != null ? new File(b.getExternalFilesDir((String) null), a) : b.getExternalFilesDir((String) null), a2, a3, b, a4, C2042cl.m744b(this.f590f));
    }
}
