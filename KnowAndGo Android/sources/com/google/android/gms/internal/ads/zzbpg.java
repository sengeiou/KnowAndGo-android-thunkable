package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzbpg<AdT> implements zzdti<zzbpf<AdT>> {
    private final zzdtu<Map<String, zzcjv<AdT>>> zzfiu;

    private zzbpg(zzdtu<Map<String, zzcjv<AdT>>> zzdtu) {
        this.zzfiu = zzdtu;
    }

    public static <AdT> zzbpg<AdT> zzj(zzdtu<Map<String, zzcjv<AdT>>> zzdtu) {
        return new zzbpg<>(zzdtu);
    }

    public final /* synthetic */ Object get() {
        return new zzbpf(this.zzfiu.get());
    }
}
