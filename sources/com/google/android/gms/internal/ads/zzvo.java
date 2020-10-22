package com.google.android.gms.internal.ads;

final class zzvo implements Runnable {
    private final /* synthetic */ zzvn zzbwq;

    zzvo(zzvn zzvn) {
        this.zzbwq = zzvn;
    }

    public final void run() {
        this.zzbwq.disconnect();
    }
}
