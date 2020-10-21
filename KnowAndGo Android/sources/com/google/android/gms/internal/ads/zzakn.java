package com.google.android.gms.internal.ads;

final /* synthetic */ class zzakn implements Runnable {
    private final zzajw zzdck;

    private zzakn(zzajw zzajw) {
        this.zzdck = zzajw;
    }

    static Runnable zzb(zzajw zzajw) {
        return new zzakn(zzajw);
    }

    public final void run() {
        this.zzdck.destroy();
    }
}
