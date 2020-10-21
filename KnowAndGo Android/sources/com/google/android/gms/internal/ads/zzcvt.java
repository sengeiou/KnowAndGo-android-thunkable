package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

public final class zzcvt implements zzcuz<JSONObject> {
    private final String zzgiu;

    public zzcvt(String str) {
        this.zzgiu = str;
    }

    public final /* synthetic */ void zzt(Object obj) {
        try {
            ((JSONObject) obj).put("ms", this.zzgiu);
        } catch (JSONException e) {
            zzawz.zza("Failed putting Ad ID.", e);
        }
    }
}
