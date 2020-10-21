package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;

public final class zzbwh implements zzdti<zzbuz<zzo>> {
    private final zzdtu<zzbxa> zzfhs;
    private final zzbvz zzflo;

    private zzbwh(zzbvz zzbvz, zzdtu<zzbxa> zzdtu) {
        this.zzflo = zzbvz;
        this.zzfhs = zzdtu;
    }

    public static zzbwh zzc(zzbvz zzbvz, zzdtu<zzbxa> zzdtu) {
        return new zzbwh(zzbvz, zzdtu);
    }

    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.zzfhs.get(), zzbbm.zzeaf), "Cannot return null from a non-@Nullable @Provides method");
    }
}
