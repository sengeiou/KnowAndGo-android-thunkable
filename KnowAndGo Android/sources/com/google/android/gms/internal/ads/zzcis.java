package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

final class zzcis implements zzalm<zzcir> {
    zzcis() {
    }

    public final /* synthetic */ JSONObject zzj(Object obj) throws JSONException {
        zzcir zzcir = (zzcir) obj;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject2.put("base_url", zzcir.zzfxu.zztu());
        jSONObject2.put("signals", zzcir.zzfxt);
        jSONObject3.put(TtmlNode.TAG_BODY, zzcir.zzfxs.zzdnh);
        jSONObject3.put("headers", zzk.zzlg().zzi((Map<String, ?>) zzcir.zzfxs.zzab));
        jSONObject3.put("response_code", zzcir.zzfxs.zzfya);
        jSONObject3.put("latency", zzcir.zzfxs.zzfyb);
        jSONObject.put("request", jSONObject2);
        jSONObject.put("response", jSONObject3);
        jSONObject.put("flags", zzcir.zzfxu.zztx());
        return jSONObject;
    }
}
