package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.ImagesContract;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

@zzard
public final class zzasd {
    private final int errorCode;
    private final String type;
    private String url;
    private final String zzdlx;
    private final String zzdoj;
    private final boolean zzdok;
    private final List<String> zzdox;
    private final String zzdoy;
    private final String zzdoz;
    private final boolean zzdpa;
    private final String zzdpb;
    private final boolean zzdpc;
    private final JSONObject zzdpd;

    public zzasd(JSONObject jSONObject) {
        List<String> list;
        this.url = jSONObject.optString(ImagesContract.URL);
        this.zzdoy = jSONObject.optString("base_uri");
        this.zzdoz = jSONObject.optString("post_parameters");
        String optString = jSONObject.optString("drt_include");
        int i = 1;
        this.zzdpa = optString != null && (optString.equals("1") || optString.equals("true"));
        this.zzdlx = jSONObject.optString("request_id");
        this.type = jSONObject.optString("type");
        String optString2 = jSONObject.optString("errors");
        if (optString2 == null) {
            list = null;
        } else {
            list = Arrays.asList(optString2.split(","));
        }
        this.zzdox = list;
        this.errorCode = jSONObject.optInt("valid", 0) == 1 ? -2 : i;
        this.zzdpb = jSONObject.optString("fetched_ad");
        this.zzdpc = jSONObject.optBoolean("render_test_ad_label");
        JSONObject optJSONObject = jSONObject.optJSONObject("preprocessor_flags");
        this.zzdpd = optJSONObject == null ? new JSONObject() : optJSONObject;
        this.zzdoj = jSONObject.optString("analytics_query_ad_event_id");
        this.zzdok = jSONObject.optBoolean("is_analytics_logging_enabled");
    }

    public final String zztu() {
        return this.zzdoy;
    }

    public final String zztv() {
        return this.zzdoz;
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean zztw() {
        return this.zzdpa;
    }

    public final JSONObject zztx() {
        return this.zzdpd;
    }
}
