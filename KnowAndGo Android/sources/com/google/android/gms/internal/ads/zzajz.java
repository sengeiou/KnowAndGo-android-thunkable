package com.google.android.gms.internal.ads;

final /* synthetic */ class zzajz implements Runnable {
    private final String zzdbk;
    private final zzajy zzdbt;

    zzajz(zzajy zzajy, String str) {
        this.zzdbt = zzajy;
        this.zzdbk = str;
    }

    public final void run() {
        this.zzdbt.zzct(this.zzdbk);
    }
}
