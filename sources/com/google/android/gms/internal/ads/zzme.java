package com.google.android.gms.internal.ads;

final class zzme implements Runnable {
    private final /* synthetic */ zzma zzavk;
    private final /* synthetic */ int zzavo;
    private final /* synthetic */ long zzavp;
    private final /* synthetic */ long zzavq;

    zzme(zzma zzma, int i, long j, long j2) {
        this.zzavk = zzma;
        this.zzavo = i;
        this.zzavp = j;
        this.zzavq = j2;
    }

    public final void run() {
        this.zzavk.zzavi.zzc(this.zzavo, this.zzavp, this.zzavq);
    }
}
