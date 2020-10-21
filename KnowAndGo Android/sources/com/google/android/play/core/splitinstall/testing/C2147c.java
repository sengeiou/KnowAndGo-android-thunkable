package com.google.android.play.core.splitinstall.testing;

import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.testing.c */
final /* synthetic */ class C2147c implements Runnable {

    /* renamed from: a */
    private final FakeSplitInstallManager f972a;

    /* renamed from: b */
    private final List f973b;

    /* renamed from: c */
    private final List f974c;

    C2147c(FakeSplitInstallManager fakeSplitInstallManager, List list, List list2) {
        this.f972a = fakeSplitInstallManager;
        this.f973b = list;
        this.f974c = list2;
    }

    public final void run() {
        this.f972a.mo33774a(this.f973b, this.f974c);
    }
}
