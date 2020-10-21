package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

final class zzacl extends zzacj<Integer> {
    zzacl(int i, String str, Integer num) {
        super(i, str, num, (zzack) null);
    }

    public final /* synthetic */ Object zza(Bundle bundle) {
        String valueOf = String.valueOf(getKey());
        if (!bundle.containsKey(valueOf.length() != 0 ? "com.google.android.gms.ads.flag.".concat(valueOf) : new String("com.google.android.gms.ads.flag."))) {
            return (Integer) zzqm();
        }
        String valueOf2 = String.valueOf(getKey());
        return Integer.valueOf(bundle.getInt(valueOf2.length() != 0 ? "com.google.android.gms.ads.flag.".concat(valueOf2) : new String("com.google.android.gms.ads.flag.")));
    }

    public final /* synthetic */ void zza(SharedPreferences.Editor editor, Object obj) {
        editor.putInt(getKey(), ((Integer) obj).intValue());
    }

    public final /* synthetic */ Object zza(JSONObject jSONObject) {
        return Integer.valueOf(jSONObject.optInt(getKey(), ((Integer) zzqm()).intValue()));
    }

    public final /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
        return Integer.valueOf(sharedPreferences.getInt(getKey(), ((Integer) zzqm()).intValue()));
    }
}
