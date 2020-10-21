package com.google.android.gms.internal.ads;

final class zzhg implements Runnable {
    private final /* synthetic */ zzhd zzafo;
    private final /* synthetic */ int zzafq;
    private final /* synthetic */ long zzafr;

    zzhg(zzhd zzhd, int i, long j) {
        this.zzafo = zzhd;
        this.zzafq = i;
        this.zzafr = j;
    }

    public final void run() {
        this.zzafo.zzaev.zzb(this.zzafq, this.zzafr);
    }
}
