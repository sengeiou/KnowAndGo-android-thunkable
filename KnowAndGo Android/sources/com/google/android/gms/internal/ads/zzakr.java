package com.google.android.gms.internal.ads;

final /* synthetic */ class zzakr implements Runnable {
    private final zzajw zzdck;

    private zzakr(zzajw zzajw) {
        this.zzdck = zzajw;
    }

    static Runnable zzb(zzajw zzajw) {
        return new zzakr(zzajw);
    }

    public final void run() {
        this.zzdck.destroy();
    }
}
