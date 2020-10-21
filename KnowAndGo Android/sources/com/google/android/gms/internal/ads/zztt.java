package com.google.android.gms.internal.ads;

final class zztt implements Runnable {
    private final /* synthetic */ zzto zzbpu;
    private final /* synthetic */ int zzbpx;
    private final /* synthetic */ int zzbpy;
    private final /* synthetic */ int zzbpz;
    private final /* synthetic */ float zzbqa;

    zztt(zzto zzto, int i, int i2, int i3, float f) {
        this.zzbpu = zzto;
        this.zzbpx = i;
        this.zzbpy = i2;
        this.zzbpz = i3;
        this.zzbqa = f;
    }

    public final void run() {
        this.zzbpu.zzbpt.zza(this.zzbpx, this.zzbpy, this.zzbpz, this.zzbqa);
    }
}
