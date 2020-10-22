package com.google.android.gms.internal.ads;

public final class zzctb implements zzdti<zzcsz> {
    private final zzdtu<zzbbl> zzfgh;
    private final zzdtu<zzcxv> zzfhr;

    private zzctb(zzdtu<zzbbl> zzdtu, zzdtu<zzcxv> zzdtu2) {
        this.zzfgh = zzdtu;
        this.zzfhr = zzdtu2;
    }

    public static zzctb zzan(zzdtu<zzbbl> zzdtu, zzdtu<zzcxv> zzdtu2) {
        return new zzctb(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return new zzcsz(this.zzfgh.get(), this.zzfhr.get());
    }
}
