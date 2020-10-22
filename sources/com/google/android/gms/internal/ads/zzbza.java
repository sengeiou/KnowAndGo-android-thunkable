package com.google.android.gms.internal.ads;

import org.json.JSONObject;

public final class zzbza implements zzdti<zzbyy> {
    private final zzdtu<JSONObject> zzewq;
    private final zzdtu<zzcxm> zzfgo;

    public zzbza(zzdtu<zzcxm> zzdtu, zzdtu<JSONObject> zzdtu2) {
        this.zzfgo = zzdtu;
        this.zzewq = zzdtu2;
    }

    public final /* synthetic */ Object get() {
        return new zzbyy(this.zzfgo.get(), this.zzewq.get());
    }
}
