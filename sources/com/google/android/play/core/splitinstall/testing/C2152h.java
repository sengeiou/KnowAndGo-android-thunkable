package com.google.android.play.core.splitinstall.testing;

import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.testing.h */
final /* synthetic */ class C2152h implements Runnable {

    /* renamed from: a */
    private final FakeSplitInstallManager f984a;

    /* renamed from: b */
    private final List f985b;

    /* renamed from: c */
    private final List f986c;

    /* renamed from: d */
    private final List f987d;

    /* renamed from: e */
    private final long f988e;

    C2152h(FakeSplitInstallManager fakeSplitInstallManager, List list, List list2, List list3, long j) {
        this.f984a = fakeSplitInstallManager;
        this.f985b = list;
        this.f986c = list2;
        this.f987d = list3;
        this.f988e = j;
    }

    public final void run() {
        this.f984a.mo33775a(this.f985b, this.f986c, this.f987d, this.f988e);
    }
}
