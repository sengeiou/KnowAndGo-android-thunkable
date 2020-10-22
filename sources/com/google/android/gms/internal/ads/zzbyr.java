package com.google.android.gms.internal.ads;

final /* synthetic */ class zzbyr implements Runnable {
    private final boolean zzecm;
    private final zzbyn zzfny;

    zzbyr(zzbyn zzbyn, boolean z) {
        this.zzfny = zzbyn;
        this.zzecm = z;
    }

    public final void run() {
        this.zzfny.zzay(this.zzecm);
    }
}
