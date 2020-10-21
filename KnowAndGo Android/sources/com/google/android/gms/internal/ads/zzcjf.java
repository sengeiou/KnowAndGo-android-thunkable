package com.google.android.gms.internal.ads;

public final class zzcjf implements zzdti<zzcjc> {
    private final zzdtu<zzcja> zzety;
    private final zzdtu<zzbbl> zzfyg;

    private zzcjf(zzdtu<zzcja> zzdtu, zzdtu<zzbbl> zzdtu2) {
        this.zzety = zzdtu;
        this.zzfyg = zzdtu2;
    }

    public static zzcjf zzah(zzdtu<zzcja> zzdtu, zzdtu<zzbbl> zzdtu2) {
        return new zzcjf(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return new zzcjc(this.zzety.get(), this.zzfyg.get());
    }
}
