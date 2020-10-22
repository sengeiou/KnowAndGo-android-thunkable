package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

final /* synthetic */ class zzbxq implements Callable {
    private final zzdtu zzfmg;

    zzbxq(zzdtu zzdtu) {
        this.zzfmg = zzdtu;
    }

    public final Object call() {
        zzccj zzccj = (zzccj) this.zzfmg.get();
        zzccj.zzajj();
        return zzccj;
    }
}
