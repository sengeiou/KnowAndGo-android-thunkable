package com.google.android.gms.internal.ads;

final class zzhe implements Runnable {
    private final /* synthetic */ int zzafl;
    private final /* synthetic */ int zzafm;
    private final /* synthetic */ float zzafn;
    private final /* synthetic */ zzhd zzafo;

    zzhe(zzhd zzhd, int i, int i2, float f) {
        this.zzafo = zzhd;
        this.zzafl = i;
        this.zzafm = i2;
        this.zzafn = f;
    }

    public final void run() {
        this.zzafo.zzaev.zza(this.zzafl, this.zzafm, this.zzafn);
    }
}
