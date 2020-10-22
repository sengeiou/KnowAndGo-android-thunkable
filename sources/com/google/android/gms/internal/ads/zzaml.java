package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
@zzard
public final class zzaml {
    private final String zzdeg;
    private final String zzdeh;
    public final List<String> zzdei;
    private final String zzdej;
    private final String zzdek;
    private final List<String> zzdel;
    private final List<String> zzdem;
    private final List<String> zzden;
    private final List<String> zzdeo;
    private final List<String> zzdep;
    public final String zzdeq;
    private final List<String> zzder;
    private final List<String> zzdes;
    private final List<String> zzdet;
    private final String zzdeu;
    private final String zzdev;
    @Nullable
    private final String zzdew;
    @Nullable
    private final String zzdex;
    private final String zzdey;
    @Nullable
    private final List<String> zzdez;
    private final String zzdfa;
    @Nullable
    public final String zzdfb;
    private final long zzdfc;

    public zzaml(JSONObject jSONObject) throws JSONException {
        List<String> list;
        this.zzdeh = jSONObject.optString("id");
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        this.zzdei = Collections.unmodifiableList(arrayList);
        this.zzdej = jSONObject.optString("allocation_id", (String) null);
        zzk.zzly();
        this.zzdel = zzamn.zza(jSONObject, "clickurl");
        zzk.zzly();
        this.zzdem = zzamn.zza(jSONObject, "imp_urls");
        zzk.zzly();
        this.zzden = zzamn.zza(jSONObject, "downloaded_imp_urls");
        zzk.zzly();
        this.zzdep = zzamn.zza(jSONObject, "fill_urls");
        zzk.zzly();
        this.zzder = zzamn.zza(jSONObject, "video_start_urls");
        zzk.zzly();
        this.zzdet = zzamn.zza(jSONObject, "video_complete_urls");
        zzk.zzly();
        this.zzdes = zzamn.zza(jSONObject, "video_reward_urls");
        this.zzdeu = jSONObject.optString("transaction_id");
        this.zzdev = jSONObject.optString("valid_from_timestamp");
        JSONObject optJSONObject = jSONObject.optJSONObject("ad");
        if (optJSONObject != null) {
            zzk.zzly();
            list = zzamn.zza(optJSONObject, "manual_impression_urls");
        } else {
            list = null;
        }
        this.zzdeo = list;
        this.zzdeg = optJSONObject != null ? optJSONObject.toString() : null;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        this.zzdeq = optJSONObject2 != null ? optJSONObject2.toString() : null;
        this.zzdek = optJSONObject2 != null ? optJSONObject2.optString("class_name") : null;
        this.zzdew = jSONObject.optString("html_template", (String) null);
        this.zzdex = jSONObject.optString("ad_base_url", (String) null);
        JSONObject optJSONObject3 = jSONObject.optJSONObject("assets");
        this.zzdey = optJSONObject3 != null ? optJSONObject3.toString() : null;
        zzk.zzly();
        this.zzdez = zzamn.zza(jSONObject, "template_ids");
        JSONObject optJSONObject4 = jSONObject.optJSONObject("ad_loader_options");
        this.zzdfa = optJSONObject4 != null ? optJSONObject4.toString() : null;
        this.zzdfb = jSONObject.optString("response_type", (String) null);
        this.zzdfc = jSONObject.optLong("ad_network_timeout_millis", -1);
    }
}
