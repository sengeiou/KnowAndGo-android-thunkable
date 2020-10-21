package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcxg implements zzcuz<JSONObject> {
    private final Map<String, Object> zzgjs;

    public zzcxg(Map<String, Object> map) {
        this.zzgjs = map;
    }

    public final /* synthetic */ void zzt(Object obj) {
        try {
            ((JSONObject) obj).put("video_decoders", zzk.zzlg().zzi((Map<String, ?>) this.zzgjs));
        } catch (JSONException e) {
            String valueOf = String.valueOf(e.getMessage());
            zzawz.zzds(valueOf.length() != 0 ? "Could not encode video decoder properties: ".concat(valueOf) : new String("Could not encode video decoder properties: "));
        }
    }
}
