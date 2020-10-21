package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONObject;

public final class zzbnb implements zzdti<JSONObject> {
    private final zzdtu<zzcxm> zzfgo;

    private zzbnb(zzdtu<zzcxm> zzdtu) {
        this.zzfgo = zzdtu;
    }

    public static zzbnb zzi(zzdtu<zzcxm> zzdtu) {
        return new zzbnb(zzdtu);
    }

    @Nullable
    public final /* synthetic */ Object get() {
        return zzbna.zza(this.zzfgo.get());
    }
}
