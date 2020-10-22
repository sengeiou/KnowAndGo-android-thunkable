package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
public final class zzawl {
    private String zzdmk;
    private final long zzdth;
    private final List<String> zzdti = new ArrayList();
    private final List<String> zzdtj = new ArrayList();
    private final Map<String, zzamm> zzdtk = new HashMap();
    private String zzdtl;
    private JSONObject zzdtm;
    private boolean zzdtn;

    public zzawl(String str, long j) {
        JSONObject optJSONObject;
        this.zzdtn = false;
        this.zzdmk = str;
        this.zzdth = j;
        if (!TextUtils.isEmpty(str)) {
            try {
                this.zzdtm = new JSONObject(str);
                if (this.zzdtm.optInt("status", -1) != 1) {
                    this.zzdtn = false;
                    zzawz.zzep("App settings could not be fetched successfully.");
                    return;
                }
                this.zzdtn = true;
                this.zzdtl = this.zzdtm.optString("app_id");
                JSONArray optJSONArray = this.zzdtm.optJSONArray("ad_unit_id_settings");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject = optJSONArray.getJSONObject(i);
                        String optString = jSONObject.optString("format");
                        String optString2 = jSONObject.optString("ad_unit_id");
                        if (!TextUtils.isEmpty(optString)) {
                            if (!TextUtils.isEmpty(optString2)) {
                                if ("interstitial".equalsIgnoreCase(optString)) {
                                    this.zzdtj.add(optString2);
                                } else if ("rewarded".equalsIgnoreCase(optString) && (optJSONObject = jSONObject.optJSONObject("mediation_config")) != null) {
                                    this.zzdtk.put(optString2, new zzamm(optJSONObject));
                                }
                            }
                        }
                    }
                }
                JSONArray optJSONArray2 = this.zzdtm.optJSONArray("persistable_banner_ad_unit_ids");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        this.zzdti.add(optJSONArray2.optString(i2));
                    }
                }
            } catch (JSONException e) {
                zzawz.zzd("Exception occurred while processing app setting json", e);
                zzk.zzlk().zza(e, "AppSettings.parseAppSettingsJson");
            }
        }
    }

    public final long zzuq() {
        return this.zzdth;
    }

    public final boolean zzur() {
        return this.zzdtn;
    }

    public final String zzus() {
        return this.zzdmk;
    }

    public final String zzut() {
        return this.zzdtl;
    }

    public final Map<String, zzamm> zzuu() {
        return this.zzdtk;
    }

    public final JSONObject zzuv() {
        return this.zzdtm;
    }
}
