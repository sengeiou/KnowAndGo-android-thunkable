package com.google.android.gms.internal.ads;

import java.util.concurrent.Future;

final /* synthetic */ class zzbay implements Runnable {
    private final Future zzdzr;

    zzbay(Future future) {
        this.zzdzr = future;
    }

    public final void run() {
        Future future = this.zzdzr;
        if (!future.isDone()) {
            future.cancel(true);
        }
    }
}
