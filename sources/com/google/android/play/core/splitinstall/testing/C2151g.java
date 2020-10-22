package com.google.android.play.core.splitinstall.testing;

import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.testing.g */
final /* synthetic */ class C2151g implements Runnable {

    /* renamed from: a */
    private final FakeSplitInstallManager f979a;

    /* renamed from: b */
    private final long f980b;

    /* renamed from: c */
    private final List f981c;

    /* renamed from: d */
    private final List f982d;

    /* renamed from: e */
    private final List f983e;

    C2151g(FakeSplitInstallManager fakeSplitInstallManager, long j, List list, List list2, List list3) {
        this.f979a = fakeSplitInstallManager;
        this.f980b = j;
        this.f981c = list;
        this.f982d = list2;
        this.f983e = list3;
    }

    public final void run() {
        this.f979a.mo33772a(this.f980b, this.f981c, this.f982d, this.f983e);
    }
}
