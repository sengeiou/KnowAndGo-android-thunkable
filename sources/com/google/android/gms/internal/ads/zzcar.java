package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Callable;
import org.json.JSONObject;

final /* synthetic */ class zzcar implements Callable {
    private final zzcxm zzfhm;
    private final zzcaq zzfqz;
    private final zzcxu zzfra;
    private final JSONObject zzfrb;

    zzcar(zzcaq zzcaq, zzcxu zzcxu, zzcxm zzcxm, JSONObject jSONObject) {
        this.zzfqz = zzcaq;
        this.zzfra = zzcxu;
        this.zzfhm = zzcxm;
        this.zzfrb = jSONObject;
    }

    public final Object call() {
        zzcxu zzcxu = this.zzfra;
        zzcxm zzcxm = this.zzfhm;
        JSONObject jSONObject = this.zzfrb;
        zzbyt zzbyt = new zzbyt();
        zzbyt.zzdn(jSONObject.optInt("template_id", -1));
        zzbyt.zzfl(jSONObject.optString("custom_template_id"));
        zzcxv zzcxv = zzcxu.zzgkx.zzfjp;
        if (zzcxv.zzglc.contains(Integer.toString(zzbyt.zzahv()))) {
            if (zzbyt.zzahv() == 3) {
                if (zzbyt.getCustomTemplateId() == null) {
                    throw new zzcmw("No custom template id for custom template ad response.", 0);
                } else if (!zzcxv.zzgld.contains(zzbyt.getCustomTemplateId())) {
                    throw new zzcmw("Unexpected custom template id in the response.", 0);
                }
            }
            zzbyt.setStarRating(jSONObject.optDouble("rating", -1.0d));
            String optString = jSONObject.optString("headline", (String) null);
            if (zzcxm.zzdpc) {
                zzk.zzlg();
                String zzwe = zzaxi.zzwe();
                StringBuilder sb = new StringBuilder(String.valueOf(zzwe).length() + 3 + String.valueOf(optString).length());
                sb.append(zzwe);
                sb.append(" : ");
                sb.append(optString);
                optString = sb.toString();
            }
            zzbyt.zzp("headline", optString);
            zzbyt.zzp(TtmlNode.TAG_BODY, jSONObject.optString(TtmlNode.TAG_BODY, (String) null));
            zzbyt.zzp("call_to_action", jSONObject.optString("call_to_action", (String) null));
            zzbyt.zzp("store", jSONObject.optString("store", (String) null));
            zzbyt.zzp("price", jSONObject.optString("price", (String) null));
            zzbyt.zzp("advertiser", jSONObject.optString("advertiser", (String) null));
            return zzbyt;
        }
        int zzahv = zzbyt.zzahv();
        StringBuilder sb2 = new StringBuilder(32);
        sb2.append("Invalid template ID: ");
        sb2.append(zzahv);
        throw new zzcmw(sb2.toString(), 0);
    }
}
