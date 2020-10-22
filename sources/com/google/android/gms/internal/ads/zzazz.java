package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import java.util.Map;

final /* synthetic */ class zzazz implements zzbac {
    private final int zzdyz;
    private final Map zzdza;

    zzazz(int i, Map map) {
        this.zzdyz = i;
        this.zzdza = map;
    }

    public final void zzb(JsonWriter jsonWriter) {
        zzazx.zza(this.zzdyz, this.zzdza, jsonWriter);
    }
}
