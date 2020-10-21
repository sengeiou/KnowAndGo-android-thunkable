package com.google.android.gms.internal.ads;

final /* synthetic */ class zzbeu implements Runnable {
    private final boolean zzecm;
    private final long zzega;
    private final zzbek zzegk;

    zzbeu(zzbek zzbek, boolean z, long j) {
        this.zzegk = zzbek;
        this.zzecm = z;
        this.zzega = j;
    }

    public final void run() {
        this.zzegk.zze(this.zzecm, this.zzega);
    }
}
