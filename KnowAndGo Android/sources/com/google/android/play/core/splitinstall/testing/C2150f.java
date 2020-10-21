package com.google.android.play.core.splitinstall.testing;

import com.google.android.play.core.splitinstall.SplitInstallSessionState;

/* renamed from: com.google.android.play.core.splitinstall.testing.f */
final /* synthetic */ class C2150f implements Runnable {

    /* renamed from: a */
    private final FakeSplitInstallManager f977a;

    /* renamed from: b */
    private final SplitInstallSessionState f978b;

    C2150f(FakeSplitInstallManager fakeSplitInstallManager, SplitInstallSessionState splitInstallSessionState) {
        this.f977a = fakeSplitInstallManager;
        this.f978b = splitInstallSessionState;
    }

    public final void run() {
        this.f977a.mo33773a(this.f978b);
    }
}
