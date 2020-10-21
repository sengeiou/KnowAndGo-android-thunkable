package com.google.android.gms.internal.ads;

import org.json.JSONObject;

final /* synthetic */ class zzcii implements zzczc {
    static final zzczc zzfvz = new zzcii();

    private zzcii() {
    }

    public final Object apply(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        zzawz.zzds("Ad request signals:");
        zzawz.zzds(jSONObject.toString(2));
        return jSONObject;
    }
}
