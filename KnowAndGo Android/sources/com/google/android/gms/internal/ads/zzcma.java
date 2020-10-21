package com.google.android.gms.internal.ads;

import org.json.JSONObject;

final /* synthetic */ class zzcma implements zzbal {
    static final zzbal zzbqz = new zzcma();

    private zzcma() {
    }

    public final zzbbh zzf(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject.optBoolean("success")) {
            return zzbar.zzm(jSONObject.getJSONObject("json").getJSONArray("ads"));
        }
        throw new zzali("process json failed");
    }
}
