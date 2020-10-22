package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

final class zzamf implements zzahw {
    private final zzbbr zzddv;
    private final /* synthetic */ zzamd zzdec;

    public zzamf(zzamd zzamd, zzbbr zzbbr) {
        this.zzdec = zzamd;
        this.zzddv = zzbbr;
    }

    public final void zzc(JSONObject jSONObject) {
        try {
            this.zzddv.set(this.zzdec.zzddo.zzd(jSONObject));
        } catch (IllegalStateException unused) {
        } catch (JSONException e) {
            this.zzddv.set(e);
        }
    }

    public final void onFailure(@Nullable String str) {
        if (str == null) {
            try {
                this.zzddv.setException(new zzali());
            } catch (IllegalStateException unused) {
            }
        } else {
            this.zzddv.setException(new zzali(str));
        }
    }
}
