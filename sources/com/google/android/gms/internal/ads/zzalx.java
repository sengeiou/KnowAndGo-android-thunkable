package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

final class zzalx implements zzahw {
    private final /* synthetic */ zzalu zzddt;
    private final zzakw zzddu;
    private final zzbbr zzddv;

    public zzalx(zzalu zzalu, zzakw zzakw, zzbbr zzbbr) {
        this.zzddt = zzalu;
        this.zzddu = zzakw;
        this.zzddv = zzbbr;
    }

    public final void zzc(JSONObject jSONObject) {
        try {
            this.zzddv.set(this.zzddt.zzddo.zzd(jSONObject));
        } catch (IllegalStateException unused) {
        } catch (JSONException e) {
            this.zzddv.set(e);
        } finally {
            this.zzddu.release();
        }
    }

    public final void onFailure(@Nullable String str) {
        if (str == null) {
            try {
                this.zzddv.setException(new zzali());
            } catch (IllegalStateException unused) {
                this.zzddu.release();
                return;
            } catch (Throwable th) {
                this.zzddu.release();
                throw th;
            }
        } else {
            this.zzddv.setException(new zzali(str));
        }
        this.zzddu.release();
    }
}
