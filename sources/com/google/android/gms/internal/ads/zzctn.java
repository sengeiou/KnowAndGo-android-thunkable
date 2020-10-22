package com.google.android.gms.internal.ads;

public final class zzctn implements zzdti<zzctl> {
    private final zzdtu<zzcxk> zzfey;
    private final zzdtu<zzbbl> zzfgh;

    private zzctn(zzdtu<zzbbl> zzdtu, zzdtu<zzcxk> zzdtu2) {
        this.zzfgh = zzdtu;
        this.zzfey = zzdtu2;
    }

    public static zzctn zzao(zzdtu<zzbbl> zzdtu, zzdtu<zzcxk> zzdtu2) {
        return new zzctn(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return new zzctl(this.zzfgh.get(), this.zzfey.get());
    }
}
