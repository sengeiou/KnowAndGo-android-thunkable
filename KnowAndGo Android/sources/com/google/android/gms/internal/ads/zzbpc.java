package com.google.android.gms.internal.ads;

import android.content.Context;
import org.json.JSONException;

public class zzbpc {
    protected zzcxu zzffa;
    protected zzcxm zzfig;
    protected zzbry zzfiq;
    protected zzbso zzfir;
    protected String zzfis;

    public final zzbry zzafy() {
        return this.zzfiq;
    }

    public void zzafl() {
        this.zzfir.onAdLoaded();
    }

    public final String getMediationAdapterClassName() {
        return this.zzfis;
    }

    public final String zzpj() {
        String zzb = "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(this.zzfis) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(this.zzfis) ? zzb(this.zzfig) : null;
        return zzb == null ? this.zzfis : zzb;
    }

    public void destroy() {
        this.zzfiq.zzbr((Context) null);
    }

    private static String zzb(zzcxm zzcxm) {
        try {
            return zzcxm.zzgkh.getString("class_name");
        } catch (JSONException unused) {
            return null;
        }
    }
}
