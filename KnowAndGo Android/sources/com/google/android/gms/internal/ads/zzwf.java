package com.google.android.gms.internal.ads;

import java.util.concurrent.Future;

final /* synthetic */ class zzwf implements Runnable {
    private final zzbbr zzbxh;
    private final Future zzbxi;

    zzwf(zzbbr zzbbr, Future future) {
        this.zzbxh = zzbbr;
        this.zzbxi = future;
    }

    public final void run() {
        zzbbr zzbbr = this.zzbxh;
        Future future = this.zzbxi;
        if (zzbbr.isCancelled()) {
            future.cancel(true);
        }
    }
}
