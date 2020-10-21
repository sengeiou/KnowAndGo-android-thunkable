package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzb;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzcbi {
    private final Executor zzffv;
    private final zzcxv zzfjp;
    private final zzcdn zzfqh;
    private final Context zzlj;

    public zzcbi(Context context, zzcxv zzcxv, Executor executor, zzcdn zzcdn) {
        this.zzlj = context;
        this.zzfjp = zzcxv;
        this.zzffv = executor;
        this.zzfqh = zzcdn;
    }

    public final zzbbh<zzbgz> zzm(JSONObject jSONObject) {
        return zzbar.zza(zzbar.zza(zzbar.zzm(null), new zzcbl(this), this.zzffv), new zzcbj(this, jSONObject), this.zzffv);
    }

    public final zzbbh<zzbgz> zzq(String str, String str2) {
        return zzbar.zza(zzbar.zzm(null), new zzcbk(this, str, str2), this.zzffv);
    }

    private final void zzj(zzbgz zzbgz) {
        zzbgz.zza("/video", (zzaho<? super zzbgz>) zzagz.zzdab);
        zzbgz.zza("/videoMeta", (zzaho<? super zzbgz>) zzagz.zzdac);
        zzbgz.zza("/precache", (zzaho<? super zzbgz>) new zzbgc());
        zzbgz.zza("/delayPageLoaded", (zzaho<? super zzbgz>) zzagz.zzdaf);
        zzbgz.zza("/instrument", (zzaho<? super zzbgz>) zzagz.zzdad);
        zzbgz.zza("/log", (zzaho<? super zzbgz>) zzagz.zzczw);
        zzbgz.zza("/videoClicked", (zzaho<? super zzbgz>) zzagz.zzczx);
        zzbgz.zzaai().zzau(true);
        if (this.zzfjp.zzdne != null) {
            zzbgz.zza("/open", (zzaho<? super zzbgz>) new zzahs((zzb) null, (zzapr) null));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh zzs(Object obj) throws Exception {
        zzbgz zzc = this.zzfqh.zzc(zzyd.zzg(this.zzlj));
        zzbbq zzn = zzbbq.zzn(zzc);
        zzj(zzc);
        zzc.zzaai().zza((zzbik) new zzcbm(zzn));
        zzc.loadUrl((String) zzyt.zzpe().zzd(zzacu.zzcsd));
        return zzn;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh zza(String str, String str2, Object obj) throws Exception {
        zzbgz zzc = this.zzfqh.zzc(zzyd.zzg(this.zzlj));
        zzbbq zzn = zzbbq.zzn(zzc);
        zzj(zzc);
        if (this.zzfjp.zzdne != null) {
            zzc.zza(zzbin.zzabw());
        } else {
            zzc.zza(zzbin.zzabv());
        }
        zzc.zzaai().zza((zzbij) new zzcbn(this, zzc, zzn));
        zzc.zzb(str, str2, (String) null);
        return zzn;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzbgz zzbgz, zzbbq zzbbq, boolean z) {
        if (!(this.zzfjp.zzgla == null || zzbgz.zzyb() == null)) {
            zzbgz.zzyb().zzb(this.zzfjp.zzgla);
        }
        zzbbq.zzxe();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh zza(JSONObject jSONObject, zzbgz zzbgz) throws Exception {
        zzbbq zzn = zzbbq.zzn(zzbgz);
        if (this.zzfjp.zzdne != null) {
            zzbgz.zza(zzbin.zzabw());
        } else {
            zzbgz.zza(zzbin.zzabv());
        }
        zzbgz.zzaai().zza((zzbij) new zzcbo(this, zzbgz, zzn));
        zzbgz.zzb("google.afma.nativeAds.renderVideo", jSONObject);
        return zzn;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzbgz zzbgz, zzbbq zzbbq, boolean z) {
        if (!(this.zzfjp.zzgla == null || zzbgz.zzyb() == null)) {
            zzbgz.zzyb().zzb(this.zzfjp.zzgla);
        }
        zzbbq.zzxe();
    }
}
