package com.google.android.gms.internal.ads;

import org.json.JSONObject;

final /* synthetic */ class zzchr implements zzbal {
    private final zzchq zzfxb;
    private final zzxt zzfxc;

    zzchr(zzchq zzchq, zzxt zzxt) {
        this.zzfxb = zzchq;
        this.zzfxc = zzxt;
    }

    public final zzbbh zzf(Object obj) {
        zzxt zzxt = this.zzfxc;
        String str = (String) obj;
        String str2 = zzxt.zzcgj;
        String str3 = zzxt.zzcgk;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("headers", new JSONObject());
        jSONObject3.put(TtmlNode.TAG_BODY, str2);
        jSONObject2.put("base_url", "");
        jSONObject2.put("signals", new JSONObject(str3));
        jSONObject.put("request", jSONObject2);
        jSONObject.put("response", jSONObject3);
        jSONObject.put("flags", new JSONObject());
        return zzbar.zzm(jSONObject);
    }
}
