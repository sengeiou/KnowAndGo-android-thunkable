package com.google.android.play.core.splitinstall;

import com.google.android.play.core.internal.C2042cl;
import com.google.android.play.core.internal.C2044cn;
import com.google.android.play.core.splitinstall.testing.FakeSplitInstallManager;
import java.io.File;

/* renamed from: com.google.android.play.core.splitinstall.j */
public final class C2133j implements C2044cn<C2132i> {

    /* renamed from: a */
    private final C2044cn<C2158w> f924a;

    /* renamed from: b */
    private final C2044cn<FakeSplitInstallManager> f925b;

    /* renamed from: c */
    private final C2044cn<File> f926c;

    public C2133j(C2044cn<C2158w> cnVar, C2044cn<FakeSplitInstallManager> cnVar2, C2044cn<File> cnVar3) {
        this.f924a = cnVar;
        this.f925b = cnVar2;
        this.f926c = cnVar3;
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo33266a() {
        return new C2132i(C2042cl.m744b(this.f924a), C2042cl.m744b(this.f925b), C2042cl.m744b(this.f926c));
    }
}
