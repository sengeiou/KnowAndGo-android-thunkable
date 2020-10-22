package com.google.android.gms.internal.ads;

import java.util.concurrent.TimeoutException;

final /* synthetic */ class zzbax implements Runnable {
    private final zzbbr zzbxh;

    zzbax(zzbbr zzbbr) {
        this.zzbxh = zzbbr;
    }

    public final void run() {
        this.zzbxh.setException(new TimeoutException());
    }
}
