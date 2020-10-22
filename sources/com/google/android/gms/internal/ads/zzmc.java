package com.google.android.gms.internal.ads;

final class zzmc implements Runnable {
    private final /* synthetic */ String zzael;
    private final /* synthetic */ zzma zzavk;
    private final /* synthetic */ long zzavl;
    private final /* synthetic */ long zzavm;

    zzmc(zzma zzma, String str, long j, long j2) {
        this.zzavk = zzma;
        this.zzael = str;
        this.zzavl = j;
        this.zzavm = j2;
    }

    public final void run() {
        this.zzavk.zzavi.zzb(this.zzael, this.zzavl, this.zzavm);
    }
}
