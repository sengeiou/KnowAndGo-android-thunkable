package com.google.android.gms.internal.ads;

public final class zzbqa implements zzdti<zzbuz<zzbrw>> {
    private final zzbpx zzfji;
    private final zzdtu<zzbqe> zzfjj;

    private zzbqa(zzbpx zzbpx, zzdtu<zzbqe> zzdtu) {
        this.zzfji = zzbpx;
        this.zzfjj = zzdtu;
    }

    public static zzbqa zzc(zzbpx zzbpx, zzdtu<zzbqe> zzdtu) {
        return new zzbqa(zzbpx, zzdtu);
    }

    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.zzfjj.get(), zzbbm.zzeaf), "Cannot return null from a non-@Nullable @Provides method");
    }
}
