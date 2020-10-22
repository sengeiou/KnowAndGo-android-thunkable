package com.google.android.gms.internal.ads;

final /* synthetic */ class zzcvq implements Runnable {
    private final zzbbh zzdzo;

    zzcvq(zzbbh zzbbh) {
        this.zzdzo = zzbbh;
    }

    public final void run() {
        this.zzdzo.cancel(true);
    }
}
