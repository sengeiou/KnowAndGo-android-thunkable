package com.google.android.gms.internal.ads;

final /* synthetic */ class zzbdy implements Runnable {
    private final String zzdbk;
    private final String zzdsr;
    private final zzbdq zzefz;

    zzbdy(zzbdq zzbdq, String str, String str2) {
        this.zzefz = zzbdq;
        this.zzdbk = str;
        this.zzdsr = str2;
    }

    public final void run() {
        this.zzefz.zzo(this.zzdbk, this.zzdsr);
    }
}
