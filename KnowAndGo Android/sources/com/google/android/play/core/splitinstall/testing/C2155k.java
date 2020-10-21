package com.google.android.play.core.splitinstall.testing;

import android.content.Context;
import com.google.android.play.core.internal.C2044cn;
import com.google.android.play.core.splitinstall.C2140p;
import com.google.android.play.core.splitinstall.C2161z;
import java.io.File;

/* renamed from: com.google.android.play.core.splitinstall.testing.k */
public final class C2155k implements C2044cn<FakeSplitInstallManager> {

    /* renamed from: a */
    private final C2044cn<Context> f995a;

    /* renamed from: b */
    private final C2044cn<File> f996b;

    /* renamed from: c */
    private final C2044cn<C2140p> f997c;

    public C2155k(C2044cn<Context> cnVar, C2044cn<File> cnVar2, C2044cn<C2140p> cnVar3) {
        this.f995a = cnVar;
        this.f996b = cnVar2;
        this.f997c = cnVar3;
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo33266a() {
        return new FakeSplitInstallManager(((C2161z) this.f995a).mo33266a(), this.f996b.mo33266a(), this.f997c.mo33266a());
    }
}
