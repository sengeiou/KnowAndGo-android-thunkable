package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.zzk;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcwt implements zzcuz<JSONObject> {
    private Bundle zzgjm;

    public zzcwt(Bundle bundle) {
        this.zzgjm = bundle;
    }

    public final /* synthetic */ void zzt(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (this.zzgjm != null) {
            try {
                zzazc.zzb(zzazc.zzb(jSONObject, "device"), "play_store").put("parental_controls", zzk.zzlg().zzd(this.zzgjm));
            } catch (JSONException unused) {
                zzawz.zzds("Failed putting parental controls bundle.");
            }
        }
    }
}
