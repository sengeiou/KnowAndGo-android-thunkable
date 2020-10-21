package com.google.android.gms.internal.ads;

final class zzaww implements Runnable {
    private final /* synthetic */ zzawv zzduv;

    zzaww(zzawv zzawv) {
        this.zzduv = zzawv;
    }

    public final void run() {
        Thread unused = this.zzduv.zzdut = Thread.currentThread();
        this.zzduv.zzto();
    }
}
