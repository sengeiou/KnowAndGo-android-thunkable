package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

public final class zzclx implements zzclw<zzbyn> {
    private final zzbbl zzfqw;
    private final zzbxo zzgav;
    private final zzcaq zzgaw;

    public zzclx(zzbxo zzbxo, zzbbl zzbbl, zzcaq zzcaq) {
        this.zzgav = zzbxo;
        this.zzfqw = zzbbl;
        this.zzgaw = zzcaq;
    }

    public final boolean zza(zzcxu zzcxu, zzcxm zzcxm) {
        return (zzcxm.zzgke == null || zzcxm.zzgke.zzfmo == null) ? false : true;
    }

    public final zzbbh<List<zzbbh<zzbyn>>> zzb(zzcxu zzcxu, zzcxm zzcxm) {
        zzbbh<zzccj> zzamr = this.zzgav.zzadc().zzamr();
        this.zzgav.zzadc().zza(zzamr);
        return zzbar.zza(zzbar.zza(zzamr, new zzcly(this, zzcxm), (Executor) this.zzfqw), new zzclz(this, zzcxu, zzcxm), (Executor) this.zzfqw);
    }

    private final zzbbh<zzbyn> zzb(zzcxu zzcxu, zzcxm zzcxm, JSONObject jSONObject) {
        zzbbh<zzccj> zzamr = this.zzgav.zzadc().zzamr();
        zzbbh<zzbyt> zza = this.zzgaw.zza(zzcxu, zzcxm, jSONObject);
        return zzbar.zza(zzamr, zza).zza(new zzcmc(this, zza, zzamr, zzcxu, zzcxm, jSONObject), this.zzfqw);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbyn zza(zzbbh zzbbh, zzbbh zzbbh2, zzcxu zzcxu, zzcxm zzcxm, JSONObject jSONObject) throws Exception {
        zzbyt zzbyt = (zzbyt) zzbbh.get();
        zzccj zzccj = (zzccj) zzbbh2.get();
        zzbyv zza = this.zzgav.zza(new zzbpr(zzcxu, zzcxm, (String) null), new zzbzf(zzbyt), new zzbyc(jSONObject, zzccj));
        zza.zzadk().zzaji();
        zza.zzadl().zzb(zzccj);
        zza.zzadm().zzk(zzbyt.zzahz());
        return zza.zzadj();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh zza(zzcxu zzcxu, zzcxm zzcxm, JSONArray jSONArray) throws Exception {
        if (jSONArray.length() == 0) {
            return zzbar.zzd(new zzcgm(3));
        }
        if (zzcxu.zzgkx.zzfjp.zzglg <= 1) {
            return zzbar.zza(zzb(zzcxu, zzcxm, jSONArray.getJSONObject(0)), zzcmb.zzdrn, (Executor) this.zzfqw);
        }
        int length = jSONArray.length();
        this.zzgav.zzadc().zzdq(Math.min(length, zzcxu.zzgkx.zzfjp.zzglg));
        ArrayList arrayList = new ArrayList(zzcxu.zzgkx.zzfjp.zzglg);
        for (int i = 0; i < zzcxu.zzgkx.zzfjp.zzglg; i++) {
            if (i < length) {
                arrayList.add(zzb(zzcxu, zzcxm, jSONArray.getJSONObject(i)));
            } else {
                arrayList.add(zzbar.zzd(new zzcgm(3)));
            }
        }
        return zzbar.zzm(arrayList);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh zza(zzcxm zzcxm, zzccj zzccj) throws Exception {
        JSONObject zza = zzazc.zza("isNonagon", (Object) true);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("response", zzcxm.zzgke.zzfmo);
        jSONObject.put("sdk_params", zza);
        return zzbar.zza(zzccj.zzc("google.afma.nativeAds.preProcessJson", jSONObject), zzcma.zzbqz, (Executor) this.zzfqw);
    }
}
