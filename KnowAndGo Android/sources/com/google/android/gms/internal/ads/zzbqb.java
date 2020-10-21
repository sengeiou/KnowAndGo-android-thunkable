package com.google.android.gms.internal.ads;

public final class zzbqb implements zzdti<zzbuz<zzbsr>> {
    private final zzbpx zzfji;
    private final zzdtu<zzbqe> zzfjj;

    private zzbqb(zzbpx zzbpx, zzdtu<zzbqe> zzdtu) {
        this.zzfji = zzbpx;
        this.zzfjj = zzdtu;
    }

    public static zzbqb zzd(zzbpx zzbpx, zzdtu<zzbqe> zzdtu) {
        return new zzbqb(zzbpx, zzdtu);
    }

    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.zzfjj.get(), zzbbm.zzeaf), "Cannot return null from a non-@Nullable @Provides method");
    }
}
