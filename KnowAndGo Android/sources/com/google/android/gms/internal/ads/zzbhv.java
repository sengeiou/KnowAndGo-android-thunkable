package com.google.android.gms.internal.ads;

final /* synthetic */ class zzbhv implements Runnable {
    private final String zzdbk;
    private final zzbht zzemg;

    zzbhv(zzbht zzbht, String str) {
        this.zzemg = zzbht;
        this.zzdbk = str;
    }

    public final void run() {
        this.zzemg.zzff(this.zzdbk);
    }
}
