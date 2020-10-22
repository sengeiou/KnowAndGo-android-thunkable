package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class zzbzt {
    private final zzbzb zzfno;
    private final zzccj zzfpz;
    private final zzcdn zzfqh;
    private final zzbmy zzfqi;
    private final Context zzlj;

    public zzbzt(Context context, zzcdn zzcdn, zzccj zzccj, zzbmy zzbmy, zzbzb zzbzb) {
        this.zzlj = context;
        this.zzfqh = zzcdn;
        this.zzfpz = zzccj;
        this.zzfqi = zzbmy;
        this.zzfno = zzbzb;
    }

    public final View zzajb() throws zzbhj {
        zzbgz zzc = this.zzfqh.zzc(zzyd.zzg(this.zzlj));
        zzc.getView().setVisibility(8);
        zzc.zza("/sendMessageToSdk", (zzaho<? super zzbgz>) new zzbzu(this));
        zzc.zza("/adMuted", (zzaho<? super zzbgz>) new zzbzv(this));
        this.zzfpz.zza(new WeakReference(zzc), "/loadHtml", new zzbzw(this));
        this.zzfpz.zza(new WeakReference(zzc), "/showOverlay", new zzbzx(this));
        this.zzfpz.zza(new WeakReference(zzc), "/hideOverlay", new zzbzy(this));
        return zzc.getView();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzbgz zzbgz, Map map) {
        zzbgz.getView().setVisibility(8);
        this.zzfqi.zzax(false);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzbgz zzbgz, Map map) {
        zzbgz.getView().setVisibility(0);
        this.zzfqi.zzax(true);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Map map, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("messageType", "htmlLoaded");
        hashMap.put("id", (String) map.get("id"));
        this.zzfpz.zza("sendMessageToNativeJs", (Map<String, ?>) hashMap);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzbgz zzbgz, Map map) {
        this.zzfno.zzahl();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzbgz zzbgz, Map map) {
        this.zzfpz.zza("sendMessageToNativeJs", (Map<String, ?>) map);
    }
}
