package com.google.android.gms.internal.ads;

import org.json.JSONObject;

final /* synthetic */ class zzcik implements zzczc {
    static final zzczc zzfvz = new zzcik();

    private zzcik() {
    }

    public final Object apply(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject.optInt("error_code") == 6) {
            return zzalo.zzddj.zzd(jSONObject.getJSONObject("response"));
        }
        throw new zzcif(jSONObject.getString("error_reason"), jSONObject.optInt("error_code", 0));
    }
}
