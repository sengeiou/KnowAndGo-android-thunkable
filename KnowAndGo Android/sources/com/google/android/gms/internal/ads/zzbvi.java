package com.google.android.gms.internal.ads;

public final class zzbvi implements zzdti<zzbvh> {
    private final zzdtu<zzdae> zzerp;
    private final zzdtu<zzcxm> zzffg;

    private zzbvi(zzdtu<zzcxm> zzdtu, zzdtu<zzdae> zzdtu2) {
        this.zzffg = zzdtu;
        this.zzerp = zzdtu2;
    }

    public static zzbvi zzh(zzdtu<zzcxm> zzdtu, zzdtu<zzdae> zzdtu2) {
        return new zzbvi(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return new zzbvh(this.zzffg.get(), this.zzerp.get());
    }
}
