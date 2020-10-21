package com.google.android.gms.internal.ads;

public final class zzbpt implements zzdti<String> {
    private final zzbpr zzfjf;

    private zzbpt(zzbpr zzbpr) {
        this.zzfjf = zzbpr;
    }

    public static zzbpt zzc(zzbpr zzbpr) {
        return new zzbpt(zzbpr);
    }

    public static String zzd(zzbpr zzbpr) {
        return (String) zzdto.zza(zzbpr.zzagc(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzd(this.zzfjf);
    }
}
