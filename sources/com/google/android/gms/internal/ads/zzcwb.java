package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

public final class zzcwb implements zzcuz<JSONObject> {
    private JSONObject zzgja;

    public zzcwb(JSONObject jSONObject) {
        this.zzgja = jSONObject;
    }

    public final /* synthetic */ void zzt(Object obj) {
        try {
            ((JSONObject) obj).put("cache_state", this.zzgja);
        } catch (JSONException unused) {
            zzawz.zzds("Unable to get cache_state");
        }
    }
}
