package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

final /* synthetic */ class zzbom implements Runnable {
    private final AtomicReference zzfid;

    zzbom(AtomicReference atomicReference) {
        this.zzfid = atomicReference;
    }

    public final void run() {
        Runnable runnable = (Runnable) this.zzfid.getAndSet((Object) null);
        if (runnable != null) {
            runnable.run();
        }
    }
}
