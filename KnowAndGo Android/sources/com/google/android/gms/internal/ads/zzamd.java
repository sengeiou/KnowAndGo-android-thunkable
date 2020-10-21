package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import org.json.JSONObject;

@zzard
public final class zzamd<I, O> implements zzbal<I, O> {
    /* access modifiers changed from: private */
    public final zzall<O> zzddo;
    private final zzalm<I> zzddp;
    private final String zzddq;
    private final zzbbh<zzalf> zzddz;

    zzamd(zzbbh<zzalf> zzbbh, String str, zzalm<I> zzalm, zzall<O> zzall) {
        this.zzddz = zzbbh;
        this.zzddq = str;
        this.zzddp = zzalm;
        this.zzddo = zzall;
    }

    public final zzbbh<O> zzf(I i) throws Exception {
        return zzbar.zza(this.zzddz, new zzame(this, i), zzbbm.zzeaf);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh zza(Object obj, zzalf zzalf) throws Exception {
        zzbbr zzbbr = new zzbbr();
        zzk.zzlg();
        String zzwb = zzaxi.zzwb();
        zzagz.zzdae.zza(zzwb, (zzahw) new zzamf(this, zzbbr));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", zzwb);
        jSONObject.put("args", this.zzddp.zzj(obj));
        zzalf.zzb(this.zzddq, jSONObject);
        return zzbbr;
    }
}
