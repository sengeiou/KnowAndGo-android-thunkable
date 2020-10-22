package com.google.android.gms.internal.ads;

final class zzmg implements Runnable {
    private final /* synthetic */ zzma zzavk;
    private final /* synthetic */ int zzavs;

    zzmg(zzma zzma, int i) {
        this.zzavk = zzma;
        this.zzavs = i;
    }

    public final void run() {
        this.zzavk.zzavi.zzag(this.zzavs);
    }
}
