package com.google.android.gms.internal.ads;

final /* synthetic */ class zzbla implements Runnable {
    private final Runnable zzead;
    private final zzbkz zzfei;

    zzbla(zzbkz zzbkz, Runnable runnable) {
        this.zzfei = zzbkz;
        this.zzead = runnable;
    }

    public final void run() {
        zzbbm.zzeae.execute(new zzblb(this.zzfei, this.zzead));
    }
}
