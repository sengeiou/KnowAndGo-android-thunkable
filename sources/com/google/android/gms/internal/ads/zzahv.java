package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;
import org.json.JSONObject;

final class zzahv implements zzahw {
    private final /* synthetic */ zzbbr zzdar;

    zzahv(zzahu zzahu, zzbbr zzbbr) {
        this.zzdar = zzbbr;
    }

    public final void zzc(JSONObject jSONObject) {
        this.zzdar.set(jSONObject);
    }

    public final void onFailure(@Nullable String str) {
        this.zzdar.setException(new zzali(str));
    }
}
