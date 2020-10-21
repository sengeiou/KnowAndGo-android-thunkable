package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
public final class zzamm {
    private final long zzdfc;
    public final List<zzaml> zzdfd;
    private final List<String> zzdfe;
    private final List<String> zzdff;
    private final List<String> zzdfg;
    private final List<String> zzdfh;
    private final List<String> zzdfi;
    private final boolean zzdfj;
    private final String zzdfk;
    private final long zzdfl;
    private final String zzdfm;
    private final int zzdfn;
    private final int zzdfo;
    private final long zzdfp;
    private final boolean zzdfq;
    private final boolean zzdfr;
    private final boolean zzdfs;
    private final boolean zzdft;
    private int zzdfu;
    private int zzdfv;
    private boolean zzdfw;

    public zzamm(JSONObject jSONObject) throws JSONException {
        if (zzawz.isLoggable(2)) {
            String valueOf = String.valueOf(jSONObject.toString(2));
            zzawz.zzds(valueOf.length() != 0 ? "Mediation Response JSON: ".concat(valueOf) : new String("Mediation Response JSON: "));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                zzaml zzaml = new zzaml(jSONArray.getJSONObject(i2));
                boolean z = true;
                if ("banner".equalsIgnoreCase(zzaml.zzdfb)) {
                    this.zzdfw = true;
                }
                arrayList.add(zzaml);
                if (i < 0) {
                    Iterator<String> it = zzaml.zzdei.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (z) {
                        i = i2;
                    }
                }
            } catch (JSONException unused) {
            }
        }
        this.zzdfu = i;
        this.zzdfv = jSONArray.length();
        this.zzdfd = Collections.unmodifiableList(arrayList);
        this.zzdfk = jSONObject.optString("qdata");
        this.zzdfo = jSONObject.optInt("fs_model_type", -1);
        long j = -1;
        this.zzdfp = jSONObject.optLong("timeout_ms", -1);
        JSONObject optJSONObject = jSONObject.optJSONObject("settings");
        if (optJSONObject != null) {
            this.zzdfc = optJSONObject.optLong("ad_network_timeout_millis", -1);
            zzk.zzly();
            this.zzdfe = zzamn.zza(optJSONObject, "click_urls");
            zzk.zzly();
            this.zzdff = zzamn.zza(optJSONObject, "imp_urls");
            zzk.zzly();
            this.zzdfg = zzamn.zza(optJSONObject, "downloaded_imp_urls");
            zzk.zzly();
            this.zzdfh = zzamn.zza(optJSONObject, "nofill_urls");
            zzk.zzly();
            this.zzdfi = zzamn.zza(optJSONObject, "remote_ping_urls");
            this.zzdfj = optJSONObject.optBoolean("render_in_browser", false);
            long optLong = optJSONObject.optLong("refresh", -1);
            this.zzdfl = optLong > 0 ? 1000 * optLong : j;
            zzato zza = zzato.zza(optJSONObject.optJSONArray("rewards"));
            if (zza == null) {
                this.zzdfm = null;
                this.zzdfn = 0;
            } else {
                this.zzdfm = zza.type;
                this.zzdfn = zza.zzdqm;
            }
            this.zzdfq = optJSONObject.optBoolean("use_displayed_impression", false);
            this.zzdfr = optJSONObject.optBoolean("allow_pub_rendered_attribution", false);
            this.zzdfs = optJSONObject.optBoolean("allow_pub_owned_ad_view", false);
            this.zzdft = optJSONObject.optBoolean("allow_custom_click_gesture", false);
            return;
        }
        this.zzdfc = -1;
        this.zzdfe = null;
        this.zzdff = null;
        this.zzdfg = null;
        this.zzdfh = null;
        this.zzdfi = null;
        this.zzdfl = -1;
        this.zzdfm = null;
        this.zzdfn = 0;
        this.zzdfq = false;
        this.zzdfj = false;
        this.zzdfr = false;
        this.zzdfs = false;
        this.zzdft = false;
    }
}
