package com.google.android.gms.internal.ads;

final /* synthetic */ class zzbon implements Runnable {
    private final Runnable zzead;
    private final zzbol zzfie;

    zzbon(zzbol zzbol, Runnable runnable) {
        this.zzfie = zzbol;
        this.zzead = runnable;
    }

    public final void run() {
        this.zzfie.zzg(this.zzead);
    }
}
