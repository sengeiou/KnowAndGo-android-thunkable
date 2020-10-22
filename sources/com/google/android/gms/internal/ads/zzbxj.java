package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzbxj implements zzdti<zzbxi> {
    private final zzdtu<zzbzc> zzfhh;
    private final zzdtu<Map<String, zzcjv<zzbph>>> zzfiu;
    private final zzdtu<zzbpe<zzbnf>> zzfmb;
    private final zzdtu<Map<String, zzcjv<zzbyn>>> zzfmc;
    private final zzdtu<Map<String, zzclw<zzbyn>>> zzfmd;

    public zzbxj(zzdtu<Map<String, zzcjv<zzbph>>> zzdtu, zzdtu<Map<String, zzcjv<zzbyn>>> zzdtu2, zzdtu<Map<String, zzclw<zzbyn>>> zzdtu3, zzdtu<zzbpe<zzbnf>> zzdtu4, zzdtu<zzbzc> zzdtu5) {
        this.zzfiu = zzdtu;
        this.zzfmc = zzdtu2;
        this.zzfmd = zzdtu3;
        this.zzfmb = zzdtu4;
        this.zzfhh = zzdtu5;
    }

    public final /* synthetic */ Object get() {
        return new zzbxi(this.zzfiu.get(), this.zzfmc.get(), this.zzfmd.get(), this.zzfmb, this.zzfhh.get());
    }
}
