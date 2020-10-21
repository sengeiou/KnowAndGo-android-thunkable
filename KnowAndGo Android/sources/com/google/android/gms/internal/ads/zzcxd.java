package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

final /* synthetic */ class zzcxd implements zzcuz {
    static final zzcuz zzgjq = new zzcxd();

    private zzcxd() {
    }

    public final void zzt(Object obj) {
        try {
            ((JSONObject) obj).getJSONObject("sdk_env").put("container_version", 12451009);
        } catch (JSONException unused) {
        }
    }
}
