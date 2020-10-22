package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.amplitude.api.Constants;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcvn implements zzcuz<JSONObject> {
    private final AdvertisingIdClient.Info zzgip;
    private final String zzgiq;
    private final Context zzlj;

    public zzcvn(AdvertisingIdClient.Info info, Context context, String str) {
        this.zzlj = context;
        this.zzgip = info;
        this.zzgiq = str;
    }

    public final /* synthetic */ void zzt(Object obj) {
        try {
            JSONObject zzb = zzazc.zzb((JSONObject) obj, "pii");
            String str = null;
            boolean z = false;
            if (this.zzgip != null) {
                str = this.zzgip.getId();
                z = this.zzgip.isLimitAdTrackingEnabled();
            }
            if (!TextUtils.isEmpty(str)) {
                zzb.put("rdid", str);
                zzb.put("is_lat", z);
                zzb.put("idtype", Constants.AMP_TRACKING_OPTION_ADID);
                return;
            }
            zzb.put("pdid", this.zzgiq);
            zzb.put("pdidtype", "ssaid");
        } catch (JSONException e) {
            zzawz.zza("Failed putting Ad ID.", e);
        }
    }
}
