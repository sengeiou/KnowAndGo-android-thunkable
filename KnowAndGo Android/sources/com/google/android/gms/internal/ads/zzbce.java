package com.google.android.gms.internal.ads;

final /* synthetic */ class zzbce implements Runnable {
    private final int zzdwj;
    private final zzbcd zzebl;

    zzbce(zzbcd zzbcd, int i) {
        this.zzebl = zzbcd;
        this.zzdwj = i;
    }

    public final void run() {
        this.zzebl.zzcx(this.zzdwj);
    }
}
