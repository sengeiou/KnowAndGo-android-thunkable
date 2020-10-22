package com.google.android.gms.internal.ads;

final /* synthetic */ class zzblb implements Runnable {
    private final Runnable zzead;
    private final zzbkz zzfei;

    zzblb(zzbkz zzbkz, Runnable runnable) {
        this.zzfei = zzbkz;
        this.zzead = runnable;
    }

    public final void run() {
        this.zzfei.zzf(this.zzead);
    }
}
