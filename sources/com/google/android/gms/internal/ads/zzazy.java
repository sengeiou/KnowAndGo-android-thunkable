package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import java.util.Map;

final /* synthetic */ class zzazy implements zzbac {
    private final String zzdbk;
    private final Map zzdbr;
    private final String zzddy;
    private final byte[] zzdyy;

    zzazy(String str, String str2, Map map, byte[] bArr) {
        this.zzddy = str;
        this.zzdbk = str2;
        this.zzdbr = map;
        this.zzdyy = bArr;
    }

    public final void zzb(JsonWriter jsonWriter) {
        zzazx.zza(this.zzddy, this.zzdbk, this.zzdbr, this.zzdyy, jsonWriter);
    }
}
