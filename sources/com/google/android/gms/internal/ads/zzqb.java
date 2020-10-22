package com.google.android.gms.internal.ads;

final class zzqb implements Runnable {
    private final /* synthetic */ zzpz zzbis;

    zzqb(zzpz zzpz) {
        this.zzbis = zzpz;
    }

    public final void run() {
        if (!this.zzbis.zzacf) {
            this.zzbis.zzbik.zza(this.zzbis);
        }
    }
}
