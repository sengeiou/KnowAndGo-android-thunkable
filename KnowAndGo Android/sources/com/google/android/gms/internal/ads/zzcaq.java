package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONObject;

public final class zzcaq {
    private final zzbbl zzfqw;
    private final zzcau zzfqx;
    private final zzcbd zzfqy;

    public zzcaq(zzbbl zzbbl, zzcau zzcau, zzcbd zzcbd) {
        this.zzfqw = zzbbl;
        this.zzfqx = zzcau;
        this.zzfqy = zzcbd;
    }

    public final zzbbh<zzbyt> zza(zzcxu zzcxu, zzcxm zzcxm, JSONObject jSONObject) {
        zzbbh zza;
        JSONObject jSONObject2 = jSONObject;
        zzcxu zzcxu2 = zzcxu;
        zzbbh zza2 = this.zzfqw.zza(new zzcar(this, zzcxu, zzcxm, jSONObject2));
        zzbbh<List<zzadw>> zzd = this.zzfqx.zzd(jSONObject2, "images");
        zzbbh<zzadw> zzc = this.zzfqx.zzc(jSONObject2, "secondary_image");
        zzbbh<zzadw> zzc2 = this.zzfqx.zzc(jSONObject2, "app_icon");
        zzbbh<zzadt> zze = this.zzfqx.zze(jSONObject2, "attribution");
        zzbbh<zzbgz> zzl = this.zzfqx.zzl(jSONObject2);
        zzcau zzcau = this.zzfqx;
        if (!jSONObject2.optBoolean("enable_omid")) {
            zza = zzbar.zzm(null);
        } else {
            JSONObject optJSONObject = jSONObject2.optJSONObject("omid_settings");
            if (optJSONObject == null) {
                zza = zzbar.zzm(null);
            } else {
                String optString = optJSONObject.optString("omid_html");
                if (TextUtils.isEmpty(optString)) {
                    zza = zzbar.zzm(null);
                } else {
                    zza = zzbar.zza(zzbar.zzm(null), new zzcay(zzcau, optString), zzbbm.zzeae);
                }
            }
        }
        zzbbh zzbbh = zza;
        zzbbh<List<zzcbg>> zzg = this.zzfqy.zzg(jSONObject2, "custom_assets");
        return zzbar.zza(zza2, zzd, zzc, zzc2, zze, zzl, zzbbh, zzg).zza(new zzcas(this, zza2, zzd, zzc2, zzc, zze, jSONObject, zzl, zzbbh, zzg), this.zzfqw);
    }
}
