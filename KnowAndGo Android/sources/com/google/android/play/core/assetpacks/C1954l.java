package com.google.android.play.core.assetpacks;

import java.util.concurrent.ThreadFactory;

/* renamed from: com.google.android.play.core.assetpacks.l */
final /* synthetic */ class C1954l implements ThreadFactory {

    /* renamed from: a */
    static final ThreadFactory f694a = new C1954l();

    private C1954l() {
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "AssetPackBackgroundExecutor");
    }
}
