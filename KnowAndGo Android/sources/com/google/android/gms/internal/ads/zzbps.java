package com.google.android.gms.internal.ads;

public final class zzbps implements zzdti<zzcxm> {
    private final zzbpr zzfjf;

    private zzbps(zzbpr zzbpr) {
        this.zzfjf = zzbpr;
    }

    public static zzbps zza(zzbpr zzbpr) {
        return new zzbps(zzbpr);
    }

    public static zzcxm zzb(zzbpr zzbpr) {
        return (zzcxm) zzdto.zza(zzbpr.zzagb(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzb(this.zzfjf);
    }
}
