package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import android.util.JsonWriter;
import java.io.IOException;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcxq implements zzazf {
    @Nullable
    public final String zzdkn = this.zzgks.optString("ad_base_url", (String) null);
    @Nullable
    public final String zzdkp = this.zzgks.optString("ad_html", (String) null);
    public final JSONObject zzfmo = this.zzgks.optJSONObject("ad_json");
    private final JSONObject zzgks;

    zzcxq(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        this.zzgks = zzazc.zzc(jsonReader);
    }

    public final void zza(JsonWriter jsonWriter) throws IOException {
        zzazc.zza(jsonWriter, this.zzgks);
    }
}
