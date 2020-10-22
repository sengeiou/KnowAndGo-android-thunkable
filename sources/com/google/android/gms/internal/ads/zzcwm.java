package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcwm implements zzcuz<JSONObject> {
    private List<String> zzdly;

    public zzcwm(List<String> list) {
        this.zzdly = list;
    }

    public final /* synthetic */ void zzt(Object obj) {
        try {
            ((JSONObject) obj).put("eid", TextUtils.join(",", this.zzdly));
        } catch (JSONException unused) {
            zzawz.zzds("Failed putting experiment ids.");
        }
    }
}
