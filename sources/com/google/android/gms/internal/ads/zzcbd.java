package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

public final class zzcbd {
    private final Executor zzffi;
    private final zzcau zzfqx;

    public zzcbd(Executor executor, zzcau zzcau) {
        this.zzffi = executor;
        this.zzfqx = zzcau;
    }

    public final zzbbh<List<zzcbg>> zzg(JSONObject jSONObject, String str) {
        zzbbh<B> zzbbh;
        String optString;
        char c;
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return zzbar.zzm(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (!(optJSONObject == null || (optString = optJSONObject.optString("name")) == null)) {
                String optString2 = optJSONObject.optString("type");
                if ("string".equals(optString2)) {
                    c = 1;
                } else {
                    c = "image".equals(optString2) ? (char) 2 : 0;
                }
                switch (c) {
                    case 1:
                        zzbbh = zzbar.zzm(new zzcbg(optString, optJSONObject.optString("string_value")));
                        continue;
                    case 2:
                        zzbbh = zzbar.zza(this.zzfqx.zzc(optJSONObject, "image_value"), new zzcbf(optString), this.zzffi);
                        continue;
                }
            }
            zzbbh = zzbar.zzm(null);
            arrayList.add(zzbbh);
        }
        return zzbar.zza(zzbar.zze(arrayList), zzcbe.zzdrn, this.zzffi);
    }
}
