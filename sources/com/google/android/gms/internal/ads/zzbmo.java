package com.google.android.gms.internal.ads;

import org.json.JSONObject;

final /* synthetic */ class zzbmo implements Runnable {
    private final zzbgz zzemf;
    private final JSONObject zzfga;

    zzbmo(zzbgz zzbgz, JSONObject jSONObject) {
        this.zzemf = zzbgz;
        this.zzfga = jSONObject;
    }

    public final void run() {
        this.zzemf.zzb("AFMA_updateActiveView", this.zzfga);
    }
}
