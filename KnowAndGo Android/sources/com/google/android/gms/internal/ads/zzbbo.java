package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

final class zzbbo implements Executor {
    zzbbo() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}