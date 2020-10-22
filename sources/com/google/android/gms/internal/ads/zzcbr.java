package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

final /* synthetic */ class zzcbr implements zzue {
    private final zzbgz zzemf;

    zzcbr(zzbgz zzbgz) {
        this.zzemf = zzbgz;
    }

    public final void zza(zzud zzud) {
        zzbgz zzbgz = this.zzemf;
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", zzud.zzbtk ? "1" : "0");
        zzbgz.zza("onAdVisibilityChanged", (Map<String, ?>) hashMap);
    }
}
