package com.google.android.gms.internal.ads;

import org.json.JSONObject;

final /* synthetic */ class zzbmz implements Runnable {
    private final JSONObject zzfga;
    private final zzbmy zzfgt;

    zzbmz(zzbmy zzbmy, JSONObject jSONObject) {
        this.zzfgt = zzbmy;
        this.zzfga = jSONObject;
    }

    public final void run() {
        this.zzfgt.zzh(this.zzfga);
    }
}
