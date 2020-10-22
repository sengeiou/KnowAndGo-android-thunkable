package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import org.json.JSONObject;

public final class zzbyj implements zzdti<zzty> {
    private final zzdtu<zzbai> zzfgp;
    private final zzdtu<String> zzfgq;

    public zzbyj(zzdtu<zzbai> zzdtu, zzdtu<String> zzdtu2) {
        this.zzfgp = zzdtu;
        this.zzfgq = zzdtu2;
    }

    public final /* synthetic */ Object get() {
        zzk.zzlg();
        return (zzty) zzdto.zza(new zzty(zzaxi.zzwb(), this.zzfgp.get(), this.zzfgq.get(), new JSONObject(), false, true), "Cannot return null from a non-@Nullable @Provides method");
    }
}
