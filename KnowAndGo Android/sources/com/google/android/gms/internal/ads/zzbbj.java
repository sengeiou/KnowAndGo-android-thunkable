package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

final /* synthetic */ class zzbbj implements Runnable {
    private final Executor zzeac;
    private final Runnable zzead;

    zzbbj(Executor executor, Runnable runnable) {
        this.zzeac = executor;
        this.zzead = runnable;
    }

    public final void run() {
        this.zzeac.execute(this.zzead);
    }
}
