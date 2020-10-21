package com.google.android.gms.internal.ads;

public final class zzbpz implements zzdti<zzbuz<zzbrl>> {
    private final zzbpx zzfji;
    private final zzdtu<zzbqe> zzfjj;

    private zzbpz(zzbpx zzbpx, zzdtu<zzbqe> zzdtu) {
        this.zzfji = zzbpx;
        this.zzfjj = zzdtu;
    }

    public static zzbpz zzb(zzbpx zzbpx, zzdtu<zzbqe> zzdtu) {
        return new zzbpz(zzbpx, zzdtu);
    }

    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.zzfjj.get(), zzbbm.zzeaf), "Cannot return null from a non-@Nullable @Provides method");
    }
}
