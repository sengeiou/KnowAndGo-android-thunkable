package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;

final /* synthetic */ class zzcvd implements Callable {
    private final Object zzdeb;
    private final List zzghy;

    zzcvd(List list, Object obj) {
        this.zzghy = list;
        this.zzdeb = obj;
    }

    public final Object call() {
        return zzcvb.zza(this.zzghy, this.zzdeb);
    }
}
