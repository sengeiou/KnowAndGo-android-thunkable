package com.google.android.gms.internal.ads;

public final class zzbwg implements zzdti<zzbuz<zzbsr>> {
    private final zzdtu<zzbxa> zzfhs;
    private final zzbvz zzflo;

    private zzbwg(zzbvz zzbvz, zzdtu<zzbxa> zzdtu) {
        this.zzflo = zzbvz;
        this.zzfhs = zzdtu;
    }

    public static zzbwg zzb(zzbvz zzbvz, zzdtu<zzbxa> zzdtu) {
        return new zzbwg(zzbvz, zzdtu);
    }

    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.zzfhs.get(), zzbbm.zzeaf), "Cannot return null from a non-@Nullable @Provides method");
    }
}
