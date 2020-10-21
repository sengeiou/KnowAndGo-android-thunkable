package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import org.json.JSONObject;

public final class zzbmt implements zzdti<zzty> {
    private final zzdtu<JSONObject> zzewt;
    private final zzdtu<zzcxm> zzfgo;
    private final zzdtu<zzbai> zzfgp;
    private final zzdtu<String> zzfgq;

    private zzbmt(zzdtu<zzcxm> zzdtu, zzdtu<zzbai> zzdtu2, zzdtu<JSONObject> zzdtu3, zzdtu<String> zzdtu4) {
        this.zzfgo = zzdtu;
        this.zzfgp = zzdtu2;
        this.zzewt = zzdtu3;
        this.zzfgq = zzdtu4;
    }

    public static zzbmt zza(zzdtu<zzcxm> zzdtu, zzdtu<zzbai> zzdtu2, zzdtu<JSONObject> zzdtu3, zzdtu<String> zzdtu4) {
        return new zzbmt(zzdtu, zzdtu2, zzdtu3, zzdtu4);
    }

    public final /* synthetic */ Object get() {
        this.zzfgo.get();
        String str = this.zzfgq.get();
        boolean equals = "native".equals(str);
        zzk.zzlg();
        return (zzty) zzdto.zza(new zzty(zzaxi.zzwb(), this.zzfgp.get(), str, this.zzewt.get(), false, equals), "Cannot return null from a non-@Nullable @Provides method");
    }
}
