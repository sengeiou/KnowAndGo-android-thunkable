package com.google.android.gms.internal.ads;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

final class zzcwf implements zzcva<zzcuz<JSONObject>> {
    private final JSONObject zzgjd;

    zzcwf(Context context) {
        this.zzgjd = zzasj.zzu(context);
    }

    public final zzbbh<zzcuz<JSONObject>> zzalm() {
        return zzbar.zzm(new zzcwg(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(JSONObject jSONObject) {
        try {
            jSONObject.put("gms_sdk_env", this.zzgjd);
        } catch (JSONException unused) {
            zzawz.zzds("Failed putting version constants.");
        }
    }
}
