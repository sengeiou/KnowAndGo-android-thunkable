package com.google.android.gms.internal.ads;

import org.json.JSONObject;

final /* synthetic */ class zzccl implements zzbal {
    private final String zzdbk;
    private final zzccj zzfsk;
    private final JSONObject zzfsl;

    zzccl(zzccj zzccj, String str, JSONObject jSONObject) {
        this.zzfsk = zzccj;
        this.zzdbk = str;
        this.zzfsl = jSONObject;
    }

    public final zzbbh zzf(Object obj) {
        return this.zzfsk.zza(this.zzdbk, this.zzfsl, (zzbgz) obj);
    }
}
