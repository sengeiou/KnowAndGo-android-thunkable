package com.google.android.gms.internal.ads;

import java.util.List;

final /* synthetic */ class zzcgi implements Runnable {
    private final zzcgb zzfvf;
    private final zzams zzfvj;
    private final zzaiq zzfvk;
    private final List zzfvl;

    zzcgi(zzcgb zzcgb, zzams zzams, zzaiq zzaiq, List list) {
        this.zzfvf = zzcgb;
        this.zzfvj = zzams;
        this.zzfvk = zzaiq;
        this.zzfvl = list;
    }

    public final void run() {
        this.zzfvf.zza(this.zzfvj, this.zzfvk, this.zzfvl);
    }
}
