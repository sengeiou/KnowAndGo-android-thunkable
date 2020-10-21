package com.google.android.gms.internal.ads;

final class zztv implements Runnable {
    private final /* synthetic */ zznc zzavr;
    private final /* synthetic */ zzto zzbpu;

    zztv(zzto zzto, zznc zznc) {
        this.zzbpu = zzto;
        this.zzavr = zznc;
    }

    public final void run() {
        this.zzavr.zzdk();
        this.zzbpu.zzbpt.zzf(this.zzavr);
    }
}
