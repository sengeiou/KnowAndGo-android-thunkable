package com.google.android.gms.internal.ads;

import java.util.List;
import org.json.JSONObject;

final /* synthetic */ class zzcax implements zzbam {
    private final JSONObject zzfga;
    private final zzcau zzfrp;

    zzcax(zzcau zzcau, JSONObject jSONObject) {
        this.zzfrp = zzcau;
        this.zzfga = jSONObject;
    }

    public final Object apply(Object obj) {
        return this.zzfrp.zza(this.zzfga, (List) obj);
    }
}
