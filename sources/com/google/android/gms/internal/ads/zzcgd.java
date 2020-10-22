package com.google.android.gms.internal.ads;

final /* synthetic */ class zzcgd implements Runnable {
    private final String zzdbk;
    private final zzcgb zzfvf;

    zzcgd(zzcgb zzcgb, String str) {
        this.zzfvf = zzcgb;
        this.zzdbk = str;
    }

    public final void run() {
        this.zzfvf.zzfq(this.zzdbk);
    }
}
