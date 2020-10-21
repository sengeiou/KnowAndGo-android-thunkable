package com.google.android.gms.internal.ads;

final class zzqc implements Runnable {
    private final /* synthetic */ zzpz zzbis;
    private final /* synthetic */ zzqf zzbit;

    zzqc(zzpz zzpz, zzqf zzqf) {
        this.zzbis = zzpz;
        this.zzbit = zzqf;
    }

    public final void run() {
        this.zzbit.release();
        int size = this.zzbis.zzaif.size();
        for (int i = 0; i < size; i++) {
            ((zzqt) this.zzbis.zzaif.valueAt(i)).disable();
        }
    }
}
