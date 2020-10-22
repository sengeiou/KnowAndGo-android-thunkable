package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

@zzard
public final class zzapx {
    private final boolean zzdiq;
    private final boolean zzdir;
    private final boolean zzdis;
    private final boolean zzdit;
    private final boolean zzdiu;

    private zzapx(zzapz zzapz) {
        this.zzdiq = zzapz.zzdiq;
        this.zzdir = zzapz.zzdir;
        this.zzdis = zzapz.zzdis;
        this.zzdit = zzapz.zzdit;
        this.zzdiu = zzapz.zzdiu;
    }

    public final JSONObject toJson() {
        try {
            return new JSONObject().put("sms", this.zzdiq).put("tel", this.zzdir).put("calendar", this.zzdis).put("storePicture", this.zzdit).put("inlineVideo", this.zzdiu);
        } catch (JSONException e) {
            zzawz.zzc("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
