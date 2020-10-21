package com.google.android.gms.internal.ads;

import java.util.Map;

final /* synthetic */ class zzajv implements Runnable {
    private final zzaju zzdbp;
    private final zzaho zzdbq;
    private final Map zzdbr;

    zzajv(zzaju zzaju, zzaho zzaho, Map map) {
        this.zzdbp = zzaju;
        this.zzdbq = zzaho;
        this.zzdbr = map;
    }

    public final void run() {
        this.zzdbp.zza(this.zzdbq, this.zzdbr);
    }
}
