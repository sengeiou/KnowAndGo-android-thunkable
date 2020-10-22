package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

final /* synthetic */ class zzcmc implements Callable {
    private final zzbbh zzdzi;
    private final zzbbh zzdzk;
    private final zzcxu zzgaq;
    private final zzclx zzgax;
    private final zzcxm zzgay;
    private final JSONObject zzgaz;

    zzcmc(zzclx zzclx, zzbbh zzbbh, zzbbh zzbbh2, zzcxu zzcxu, zzcxm zzcxm, JSONObject jSONObject) {
        this.zzgax = zzclx;
        this.zzdzi = zzbbh;
        this.zzdzk = zzbbh2;
        this.zzgaq = zzcxu;
        this.zzgay = zzcxm;
        this.zzgaz = jSONObject;
    }

    public final Object call() {
        return this.zzgax.zza(this.zzdzi, this.zzdzk, this.zzgaq, this.zzgay, this.zzgaz);
    }
}
