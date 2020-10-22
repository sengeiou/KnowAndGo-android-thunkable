package com.google.android.gms.internal.ads;

import android.location.Location;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcwp implements zzcuz<JSONObject> {
    private final Location zzmw;

    public zzcwp(Location location) {
        this.zzmw = location;
    }

    public final /* synthetic */ void zzt(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        try {
            if (this.zzmw != null) {
                JSONObject jSONObject2 = new JSONObject();
                Float valueOf = Float.valueOf(this.zzmw.getAccuracy() * 1000.0f);
                Long valueOf2 = Long.valueOf(this.zzmw.getTime() * 1000);
                Long valueOf3 = Long.valueOf((long) (this.zzmw.getLatitude() * 1.0E7d));
                Long valueOf4 = Long.valueOf((long) (this.zzmw.getLongitude() * 1.0E7d));
                jSONObject2.put("radius", valueOf);
                jSONObject2.put("lat", valueOf3);
                jSONObject2.put("long", valueOf4);
                jSONObject2.put("time", valueOf2);
                jSONObject.put("uule", jSONObject2);
            }
        } catch (JSONException e) {
            zzawz.zza("Failed adding location to the request JSON.", e);
        }
    }
}
