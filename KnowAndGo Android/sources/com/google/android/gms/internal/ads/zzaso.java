package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import org.json.JSONObject;

@zzard
public final class zzaso implements zzasb {
    private zzalj<JSONObject, JSONObject> zzdqj;
    private zzalj<JSONObject, JSONObject> zzdql;

    public zzaso(Context context) {
        this.zzdql = zzk.zzlt().zza(context, zzbai.zzxc()).zza("google.afma.request.getAdDictionary", zzalo.zzddi, zzalo.zzddi);
        this.zzdqj = zzk.zzlt().zza(context, zzbai.zzxc()).zza("google.afma.sdkConstants.getSdkConstants", zzalo.zzddi, zzalo.zzddi);
    }

    public final zzalj<JSONObject, JSONObject> zztt() {
        return this.zzdqj;
    }
}
