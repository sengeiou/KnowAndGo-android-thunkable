package com.google.android.gms.internal.ads;

import org.json.JSONObject;

public final class zzclv implements zzcjz<zzams, zzcla> {
    private final zzclc zzfvd;

    public zzclv(zzclc zzclc) {
        this.zzfvd = zzclc;
    }

    public final zzcjy<zzams, zzcla> zzd(String str, JSONObject jSONObject) throws Throwable {
        zzams zze = this.zzfvd.zze(str, jSONObject);
        if (zze == null) {
            return null;
        }
        return new zzcjy<>(zze, new zzcla(), str);
    }
}
