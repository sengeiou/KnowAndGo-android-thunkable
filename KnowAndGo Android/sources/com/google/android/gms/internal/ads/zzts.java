package com.google.android.gms.internal.ads;

final class zzts implements Runnable {
    private final /* synthetic */ zzto zzbpu;
    private final /* synthetic */ int zzbpv;
    private final /* synthetic */ long zzbpw;

    zzts(zzto zzto, int i, long j) {
        this.zzbpu = zzto;
        this.zzbpv = i;
        this.zzbpw = j;
    }

    public final void run() {
        this.zzbpu.zzbpt.zzb(this.zzbpv, this.zzbpw);
    }
}
