package com.google.android.gms.internal.ads;

final /* synthetic */ class zzbcs implements Runnable {
    private final zzbcq zzecl;
    private final boolean zzecm;

    zzbcs(zzbcq zzbcq, boolean z) {
        this.zzecl = zzbcq;
        this.zzecm = z;
    }

    public final void run() {
        this.zzecl.zzan(this.zzecm);
    }
}
