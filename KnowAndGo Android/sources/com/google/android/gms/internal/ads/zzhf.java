package com.google.android.gms.internal.ads;

import android.view.Surface;

final class zzhf implements Runnable {
    private final /* synthetic */ zzhd zzafo;
    private final /* synthetic */ Surface zzafp;

    zzhf(zzhd zzhd, Surface surface) {
        this.zzafo = zzhd;
        this.zzafp = surface;
    }

    public final void run() {
        this.zzafo.zzaev.zza(this.zzafp);
    }
}
