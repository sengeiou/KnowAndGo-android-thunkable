package com.google.android.gms.internal.ads;

public final class zzcys implements zzdti<zzdh> {
    private final zzcyo zzglu;
    private final zzdtu<zzcym> zzglv;

    private zzcys(zzcyo zzcyo, zzdtu<zzcym> zzdtu) {
        this.zzglu = zzcyo;
        this.zzglv = zzdtu;
    }

    public static zzcys zzc(zzcyo zzcyo, zzdtu<zzcym> zzdtu) {
        return new zzcys(zzcyo, zzdtu);
    }

    public final /* synthetic */ Object get() {
        return (zzdh) zzdto.zza(this.zzglv.get().zzglt, "Cannot return null from a non-@Nullable @Provides method");
    }
}
