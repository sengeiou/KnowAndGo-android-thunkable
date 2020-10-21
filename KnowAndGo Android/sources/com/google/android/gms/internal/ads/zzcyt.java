package com.google.android.gms.internal.ads;

public final class zzcyt implements zzdti<zzawu> {
    private final zzcyo zzglu;
    private final zzdtu<zzcym> zzglv;

    private zzcyt(zzcyo zzcyo, zzdtu<zzcym> zzdtu) {
        this.zzglu = zzcyo;
        this.zzglv = zzdtu;
    }

    public static zzcyt zzd(zzcyo zzcyo, zzdtu<zzcym> zzdtu) {
        return new zzcyt(zzcyo, zzdtu);
    }

    public final /* synthetic */ Object get() {
        return (zzawu) zzdto.zza(this.zzglv.get().zzdsw, "Cannot return null from a non-@Nullable @Provides method");
    }
}
