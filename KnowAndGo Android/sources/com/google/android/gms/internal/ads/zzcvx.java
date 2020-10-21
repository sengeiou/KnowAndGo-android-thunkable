package com.google.android.gms.internal.ads;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcvx implements zzcuz<JSONObject> {
    private final JSONObject zzgix;

    public zzcvx(JSONObject jSONObject) {
        this.zzgix = jSONObject;
    }

    public final /* synthetic */ void zzt(Object obj) {
        try {
            JSONObject zzb = zzazc.zzb((JSONObject) obj, "content_info");
            JSONObject jSONObject = this.zzgix;
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                zzb.put(next, jSONObject.get(next));
            }
        } catch (JSONException unused) {
            zzawz.zzds("Failed putting app indexing json.");
        }
    }
}
