package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

public final class zzcwi implements zzcuz<JSONObject> {
    private String zzgjf;
    private String zzgjg;

    public zzcwi(String str, String str2) {
        this.zzgjf = str;
        this.zzgjg = str2;
    }

    public final /* synthetic */ void zzt(Object obj) {
        try {
            JSONObject zzb = zzazc.zzb((JSONObject) obj, "pii");
            zzb.put("doritos", this.zzgjf);
            zzb.put("doritos_v2", this.zzgjg);
        } catch (JSONException unused) {
            zzawz.zzds("Failed putting doritos string.");
        }
    }
}
