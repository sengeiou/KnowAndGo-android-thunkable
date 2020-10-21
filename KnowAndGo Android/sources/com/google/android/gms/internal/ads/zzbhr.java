package com.google.android.gms.internal.ads;

import java.util.Map;

final /* synthetic */ class zzbhr implements Runnable {
    private final Map zzdza;
    private final zzbhq zzemc;

    zzbhr(zzbhq zzbhq, Map map) {
        this.zzemc = zzbhq;
        this.zzdza = map;
    }

    public final void run() {
        this.zzemc.zzj(this.zzdza);
    }
}
