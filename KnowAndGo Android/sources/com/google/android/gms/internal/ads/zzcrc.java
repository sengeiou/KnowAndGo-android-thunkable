package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.util.JsonReader;
import com.google.android.gms.ads.internal.zzk;
import java.io.IOException;
import org.json.JSONException;

public final class zzcrc {
    public final String zzgfw;
    public String zzgfx;

    public zzcrc(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        String str = "";
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName = nextName == null ? "" : nextName;
            char c = 65535;
            if (nextName.hashCode() == -995427962 && nextName.equals("params")) {
                c = 0;
            }
            if (c != 0) {
                jsonReader.skipValue();
            } else {
                str = jsonReader.nextString();
            }
        }
        this.zzgfw = str;
        jsonReader.endObject();
    }

    /* access modifiers changed from: package-private */
    public final zzcrc zzn(Bundle bundle) {
        try {
            this.zzgfx = zzk.zzlg().zzd(bundle).toString();
        } catch (JSONException unused) {
            this.zzgfx = "{}";
        }
        return this;
    }
}
