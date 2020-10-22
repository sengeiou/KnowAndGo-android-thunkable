package com.google.android.gms.internal.ads;

public final class zzcgs implements zzdti<zzcgn> {
    private final zzdtu<zzbbl> zzfgh;
    private final zzdtu<zzbbl> zzfvw;
    private final zzdtu<zzchv> zzfvx;
    private final zzdtu<zzcig> zzfvy;

    private zzcgs(zzdtu<zzbbl> zzdtu, zzdtu<zzbbl> zzdtu2, zzdtu<zzchv> zzdtu3, zzdtu<zzcig> zzdtu4) {
        this.zzfvw = zzdtu;
        this.zzfgh = zzdtu2;
        this.zzfvx = zzdtu3;
        this.zzfvy = zzdtu4;
    }

    public static zzcgs zzc(zzdtu<zzbbl> zzdtu, zzdtu<zzbbl> zzdtu2, zzdtu<zzchv> zzdtu3, zzdtu<zzcig> zzdtu4) {
        return new zzcgs(zzdtu, zzdtu2, zzdtu3, zzdtu4);
    }

    public final /* synthetic */ Object get() {
        return new zzcgn(this.zzfvw.get(), this.zzfgh.get(), this.zzfvx.get(), zzdth.zzap(this.zzfvy));
    }
}
