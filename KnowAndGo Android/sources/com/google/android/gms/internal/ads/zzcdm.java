package com.google.android.gms.internal.ads;

public final class zzcdm implements zzdti<zzcjv<zzcdb>> {
    private final zzdtu<zzbbl> zzfhi;
    private final zzdtu<zzczt> zzfhv;
    private final zzdtu<zzcnd> zzfhz;
    private final zzdtu<zzcoc> zzfia;

    public zzcdm(zzdtu<zzczt> zzdtu, zzdtu<zzbbl> zzdtu2, zzdtu<zzcnd> zzdtu3, zzdtu<zzcoc> zzdtu4) {
        this.zzfhv = zzdtu;
        this.zzfhi = zzdtu2;
        this.zzfhz = zzdtu3;
        this.zzfia = zzdtu4;
    }

    public final /* synthetic */ Object get() {
        return (zzcjv) zzdto.zza(new zzcoe(this.zzfhv.get(), this.zzfhi.get(), this.zzfia.get(), this.zzfhz.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
