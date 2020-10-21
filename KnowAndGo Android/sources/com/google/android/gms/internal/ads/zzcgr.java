package com.google.android.gms.internal.ads;

final /* synthetic */ class zzcgr implements Runnable {
    private final zzbbh zzdzo;

    zzcgr(zzbbh zzbbh) {
        this.zzdzo = zzbbh;
    }

    public final void run() {
        this.zzdzo.cancel(true);
    }
}
