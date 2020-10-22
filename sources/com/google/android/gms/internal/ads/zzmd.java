package com.google.android.gms.internal.ads;

final class zzmd implements Runnable {
    private final /* synthetic */ zzma zzavk;
    private final /* synthetic */ zzlh zzavn;

    zzmd(zzma zzma, zzlh zzlh) {
        this.zzavk = zzma;
        this.zzavn = zzlh;
    }

    public final void run() {
        this.zzavk.zzavi.zzb(this.zzavn);
    }
}
