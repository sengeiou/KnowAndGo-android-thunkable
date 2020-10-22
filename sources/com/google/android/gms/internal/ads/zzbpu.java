package com.google.android.gms.internal.ads;

public final class zzbpu implements zzdti<zzcxu> {
    private final zzbpr zzfjf;

    private zzbpu(zzbpr zzbpr) {
        this.zzfjf = zzbpr;
    }

    public static zzbpu zze(zzbpr zzbpr) {
        return new zzbpu(zzbpr);
    }

    public static zzcxu zzf(zzbpr zzbpr) {
        return (zzcxu) zzdto.zza(zzbpr.zzaga(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzf(this.zzfjf);
    }
}
