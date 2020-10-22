package com.google.android.gms.internal.ads;

public final class zzcyp implements zzdti<zzaxb> {
    private final zzcyo zzglu;
    private final zzdtu<zzcym> zzglv;

    private zzcyp(zzcyo zzcyo, zzdtu<zzcym> zzdtu) {
        this.zzglu = zzcyo;
        this.zzglv = zzdtu;
    }

    public static zzcyp zza(zzcyo zzcyo, zzdtu<zzcym> zzdtu) {
        return new zzcyp(zzcyo, zzdtu);
    }

    public final /* synthetic */ Object get() {
        return (zzaxb) zzdto.zza(this.zzglv.get().zzduk, "Cannot return null from a non-@Nullable @Provides method");
    }
}
