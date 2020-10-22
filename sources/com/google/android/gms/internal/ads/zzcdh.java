package com.google.android.gms.internal.ads;

public final class zzcdh implements zzdti<zzcjv<zzcdb>> {
    private final zzdtu<zzcoe<zzcdb, zzams, zzclb>> zzfgg;
    private final zzdtu<zzcxv> zzfhr;
    private final zzdtu<zzcoe<zzcdb, zzams, zzcla>> zzftd;

    public zzcdh(zzdtu<zzcoe<zzcdb, zzams, zzclb>> zzdtu, zzdtu<zzcoe<zzcdb, zzams, zzcla>> zzdtu2, zzdtu<zzcxv> zzdtu3) {
        this.zzfgg = zzdtu;
        this.zzftd = zzdtu2;
        this.zzfhr = zzdtu3;
    }

    public final /* synthetic */ Object get() {
        zzcjv zzcjv;
        zzdtu<zzcoe<zzcdb, zzams, zzclb>> zzdtu = this.zzfgg;
        zzdtu<zzcoe<zzcdb, zzams, zzcla>> zzdtu2 = this.zzftd;
        if (this.zzfhr.get().zzglj.contains("new_rewarded")) {
            zzcjv = zzdtu2.get();
        } else {
            zzcjv = zzdtu.get();
        }
        return (zzcjv) zzdto.zza(zzcjv, "Cannot return null from a non-@Nullable @Provides method");
    }
}
