package com.google.android.gms.internal.ads;

final /* synthetic */ class zzbyp implements Runnable {
    private final zzbzb zzfnz;

    private zzbyp(zzbzb zzbzb) {
        this.zzfnz = zzbzb;
    }

    static Runnable zza(zzbzb zzbzb) {
        return new zzbyp(zzbzb);
    }

    public final void run() {
        this.zzfnz.zzahm();
    }
}
