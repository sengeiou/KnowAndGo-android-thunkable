package com.google.android.gms.internal.ads;

final class zzgo implements Runnable {
    private final /* synthetic */ zzhu zzadc;
    private final /* synthetic */ zzgn zzadd;

    zzgo(zzgn zzgn, zzhu zzhu) {
        this.zzadd = zzgn;
        this.zzadc = zzhu;
    }

    public final void run() {
        this.zzadd.zzacy.zza(this.zzadc);
    }
}
