package com.google.android.gms.internal.ads;

public final class zzcoy implements zzdti<zzcow> {
    private final zzcow zzgdc;

    private zzcoy(zzcow zzcow) {
        this.zzgdc = zzcow;
    }

    public static zzcoy zzd(zzcow zzcow) {
        return new zzcoy(zzcow);
    }

    public final /* synthetic */ Object get() {
        zzcow zzcow = this.zzgdc;
        if (zzcow != null) {
            return (zzcow) zzdto.zza(zzcow, "Cannot return null from a non-@Nullable @Provides method");
        }
        throw null;
    }
}
