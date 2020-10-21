package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzbal;
import com.google.android.gms.internal.ads.zzbar;
import com.google.android.gms.internal.ads.zzbbh;
import org.json.JSONObject;

final /* synthetic */ class zze implements zzbal {
    static final zzbal zzbqz = new zze();

    private zze() {
    }

    public final zzbbh zzf(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject.optBoolean("isSuccessful", false)) {
            zzk.zzlk().zzvc().zzdv(jSONObject.getString("appSettingsJson"));
        }
        return zzbar.zzm(null);
    }
}
