package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzb;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzccj {
    private final zzbhf zzbrt;
    private final zzbai zzdld;
    private final zzdh zzeko;
    private final Executor zzffv;
    private final zza zzfrm;
    /* access modifiers changed from: private */
    public final zzccq zzfsh = new zzccq((zzccm) null);
    private final zzahu zzfsi;
    private zzbbh<zzbgz> zzfsj;
    private final Context zzlj;

    public zzccj(Context context, Executor executor, zzdh zzdh, zzbai zzbai, zza zza, zzbhf zzbhf) {
        this.zzlj = context;
        this.zzffv = executor;
        this.zzeko = zzdh;
        this.zzdld = zzbai;
        this.zzfrm = zza;
        this.zzbrt = zzbhf;
        this.zzfsi = new zzahu();
    }

    public final synchronized void zzajj() {
        this.zzfsj = zzbar.zza(zzbhf.zza(this.zzlj, this.zzdld, (String) zzyt.zzpe().zzd(zzacu.zzcsa), this.zzeko, this.zzfrm), new zzcck(this), this.zzffv);
        zzbao.zza(this.zzfsj, "NativeJavascriptExecutor.initializeEngine");
    }

    public final synchronized void destroy() {
        if (this.zzfsj != null) {
            zzbar.zza(this.zzfsj, new zzccm(this), this.zzffv);
            this.zzfsj = null;
        }
    }

    public final synchronized zzbbh<JSONObject> zzc(String str, JSONObject jSONObject) {
        if (this.zzfsj == null) {
            return zzbar.zzm(null);
        }
        return zzbar.zza(this.zzfsj, new zzccl(this, str, jSONObject), this.zzffv);
    }

    public final synchronized void zza(String str, zzaho<Object> zzaho) {
        if (this.zzfsj != null) {
            zzbar.zza(this.zzfsj, new zzccn(this, str, zzaho), this.zzffv);
        }
    }

    public final synchronized void zzb(String str, zzaho<Object> zzaho) {
        if (this.zzfsj != null) {
            zzbar.zza(this.zzfsj, new zzcco(this, str, zzaho), this.zzffv);
        }
    }

    public final synchronized void zza(String str, Map<String, ?> map) {
        if (this.zzfsj != null) {
            zzbar.zza(this.zzfsj, new zzccp(this, str, map), this.zzffv);
        }
    }

    public final <T> void zza(WeakReference<T> weakReference, String str, zzaho<T> zzaho) {
        zza(str, (zzaho<Object>) new zzcct(this, weakReference, str, zzaho, (zzccm) null));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh zza(String str, JSONObject jSONObject, zzbgz zzbgz) throws Exception {
        return this.zzfsi.zza(zzbgz, str, jSONObject);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbgz zzl(zzbgz zzbgz) {
        zzbgz.zza("/result", (zzaho<? super zzbgz>) this.zzfsi);
        zzbgz.zzaai().zza((zzxr) null, this.zzfsh, this.zzfsh, this.zzfsh, this.zzfsh, false, (zzahp) null, new zzb(this.zzlj, (zzavb) null, (zzark) null), (zzaqc) null, (zzavb) null);
        return zzbgz;
    }
}
