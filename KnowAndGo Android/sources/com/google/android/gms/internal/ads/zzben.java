package com.google.android.gms.internal.ads;

final /* synthetic */ class zzben implements Runnable {
    private final String zzdbk;
    private final zzbek zzegk;

    zzben(zzbek zzbek, String str) {
        this.zzegk = zzbek;
        this.zzdbk = str;
    }

    public final void run() {
        this.zzegk.zzeu(this.zzdbk);
    }
}
