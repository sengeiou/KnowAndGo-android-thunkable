package com.google.android.gms.internal.ads;

final class zztp implements Runnable {
    private final /* synthetic */ zznc zzavj;
    private final /* synthetic */ zzto zzbpu;

    zztp(zzto zzto, zznc zznc) {
        this.zzbpu = zzto;
        this.zzavj = zznc;
    }

    public final void run() {
        this.zzbpu.zzbpt.zze(this.zzavj);
    }
}
