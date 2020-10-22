package com.google.android.play.core.assetpacks;

import java.util.concurrent.ThreadFactory;

/* renamed from: com.google.android.play.core.assetpacks.m */
final /* synthetic */ class C1955m implements ThreadFactory {

    /* renamed from: a */
    static final ThreadFactory f695a = new C1955m();

    private C1955m() {
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "UpdateListenerExecutor");
    }
}
