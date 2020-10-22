package com.google.android.gms.internal.ads;

public final class zzblg implements zzdti<zzbah> {
    private final zzdtu<String> zzfem;

    private zzblg(zzdtu<String> zzdtu) {
        this.zzfem = zzdtu;
    }

    public static zzblg zza(zzdtu<String> zzdtu) {
        return new zzblg(zzdtu);
    }

    public final /* synthetic */ Object get() {
        return (zzbah) zzdto.zza(new zzbah(this.zzfem.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
