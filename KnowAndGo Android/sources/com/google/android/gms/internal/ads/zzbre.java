package com.google.android.gms.internal.ads;

public final class zzbre implements zzdti<zzcxv> {
    private final zzbqy zzfjw;

    private zzbre(zzbqy zzbqy) {
        this.zzfjw = zzbqy;
    }

    public static zzbre zzh(zzbqy zzbqy) {
        return new zzbre(zzbqy);
    }

    public static zzcxv zzi(zzbqy zzbqy) {
        return (zzcxv) zzdto.zza(zzbqy.zzage(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzi(this.zzfjw);
    }
}
