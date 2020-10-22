package com.google.android.gms.internal.ads;

public final class zzbqx implements zzdti<zzbtb> {
    private final zzdtu<zzbtb> zzfjt;

    private zzbqx(zzdtu<zzbtb> zzdtu) {
        this.zzfjt = zzdtu;
    }

    public static zzbqx zzl(zzdtu<zzbtb> zzdtu) {
        return new zzbqx(zzdtu);
    }

    public final /* synthetic */ Object get() {
        return (zzbtb) zzdto.zza(this.zzfjt.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
