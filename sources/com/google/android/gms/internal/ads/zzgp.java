package com.google.android.gms.internal.ads;

final class zzgp implements Runnable {
    private final /* synthetic */ zzgn zzadd;
    private final /* synthetic */ zzhv zzade;

    zzgp(zzgn zzgn, zzhv zzhv) {
        this.zzadd = zzgn;
        this.zzade = zzhv;
    }

    public final void run() {
        this.zzadd.zzacy.zza(this.zzade);
    }
}
