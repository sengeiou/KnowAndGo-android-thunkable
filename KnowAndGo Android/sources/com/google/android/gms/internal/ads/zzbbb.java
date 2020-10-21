package com.google.android.gms.internal.ads;

import java.util.concurrent.Future;

final /* synthetic */ class zzbbb implements Runnable {
    private final Future zzbxi;
    private final zzbbh zzdzo;

    zzbbb(zzbbh zzbbh, Future future) {
        this.zzdzo = zzbbh;
        this.zzbxi = future;
    }

    public final void run() {
        zzbbh zzbbh = this.zzdzo;
        Future future = this.zzbxi;
        if (zzbbh.isCancelled()) {
            future.cancel(true);
        }
    }
}
