package com.google.android.gms.internal.ads;

public final class zzbmf implements zzdti<zzbme> {
    private final zzdtu<zzdae> zzerp;
    private final zzdtu<zzcxu> zzfff;
    private final zzdtu<zzcxm> zzffg;

    private zzbmf(zzdtu<zzcxu> zzdtu, zzdtu<zzcxm> zzdtu2, zzdtu<zzdae> zzdtu3) {
        this.zzfff = zzdtu;
        this.zzffg = zzdtu2;
        this.zzerp = zzdtu3;
    }

    public static zzbmf zza(zzdtu<zzcxu> zzdtu, zzdtu<zzcxm> zzdtu2, zzdtu<zzdae> zzdtu3) {
        return new zzbmf(zzdtu, zzdtu2, zzdtu3);
    }

    public final /* synthetic */ Object get() {
        return new zzbme(this.zzfff.get(), this.zzffg.get(), this.zzerp.get());
    }
}
