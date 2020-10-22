package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

public final class zzbyy extends zzbyx {
    private final boolean zzdfr;
    private final boolean zzdfs;
    private final boolean zzdoh;
    private final JSONObject zzfov;

    public zzbyy(zzcxm zzcxm, JSONObject jSONObject) {
        super(zzcxm);
        this.zzfov = zzazc.zza(jSONObject, "tracking_urls_and_actions", "active_view");
        this.zzdfs = zzazc.zza(false, jSONObject, "allow_pub_owned_ad_view");
        this.zzdfr = zzazc.zza(false, jSONObject, "attribution", "allow_pub_rendering");
        this.zzdoh = zzazc.zza(false, jSONObject, "enable_omid");
    }

    public final JSONObject zzaie() {
        if (this.zzfov != null) {
            return this.zzfov;
        }
        try {
            return new JSONObject(this.zzfou.zzdnr);
        } catch (JSONException unused) {
            return null;
        }
    }

    public final boolean zzaif() {
        return this.zzdfs;
    }

    public final boolean zzaih() {
        return this.zzdoh;
    }

    public final boolean zzaig() {
        return this.zzdfr;
    }
}
