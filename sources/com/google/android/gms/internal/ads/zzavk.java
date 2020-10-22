package com.google.android.gms.internal.ads;

final /* synthetic */ class zzavk implements Runnable {
    private final zzavg zzdsp;
    private final zzavw zzdsq;
    private final String zzdsr;

    zzavk(zzavg zzavg, zzavw zzavw, String str) {
        this.zzdsp = zzavg;
        this.zzdsq = zzavw;
        this.zzdsr = str;
    }

    public final void run() {
        this.zzdsp.zza(this.zzdsq, this.zzdsr);
    }
}
