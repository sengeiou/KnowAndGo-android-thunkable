package com.google.android.gms.internal.ads;

public final class zzbqc implements zzdti<zzbuz<zzbtk>> {
    private final zzbpx zzfji;
    private final zzdtu<zzbqe> zzfjj;

    private zzbqc(zzbpx zzbpx, zzdtu<zzbqe> zzdtu) {
        this.zzfji = zzbpx;
        this.zzfjj = zzdtu;
    }

    public static zzbqc zze(zzbpx zzbpx, zzdtu<zzbqe> zzdtu) {
        return new zzbqc(zzbpx, zzdtu);
    }

    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.zzfjj.get(), zzbbm.zzeaf), "Cannot return null from a non-@Nullable @Provides method");
    }
}
