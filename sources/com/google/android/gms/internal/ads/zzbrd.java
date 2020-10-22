package com.google.android.gms.internal.ads;

public final class zzbrd implements zzdti<String> {
    private final zzdtu<zzbqe> zzerf;
    private final zzbqy zzfjw;

    private zzbrd(zzbqy zzbqy, zzdtu<zzbqe> zzdtu) {
        this.zzfjw = zzbqy;
        this.zzerf = zzdtu;
    }

    public static zzbrd zzb(zzbqy zzbqy, zzdtu<zzbqe> zzdtu) {
        return new zzbrd(zzbqy, zzdtu);
    }

    public final /* synthetic */ Object get() {
        return (String) zzdto.zza(this.zzerf.get().zzum(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
