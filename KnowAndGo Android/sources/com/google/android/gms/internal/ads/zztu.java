package com.google.android.gms.internal.ads;

import android.view.Surface;

final class zztu implements Runnable {
    private final /* synthetic */ Surface zzafp;
    private final /* synthetic */ zzto zzbpu;

    zztu(zzto zzto, Surface surface) {
        this.zzbpu = zzto;
        this.zzafp = surface;
    }

    public final void run() {
        this.zzbpu.zzbpt.zzb(this.zzafp);
    }
}
