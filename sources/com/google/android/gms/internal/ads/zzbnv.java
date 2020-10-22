package com.google.android.gms.internal.ads;

public final class zzbnv implements zzdti<zzbuz<zzbsr>> {
    private final zzbnk zzfhp;
    private final zzdtu<zzbot> zzfhs;

    public zzbnv(zzbnk zzbnk, zzdtu<zzbot> zzdtu) {
        this.zzfhp = zzbnk;
        this.zzfhs = zzdtu;
    }

    public static zzbuz<zzbsr> zza(zzbnk zzbnk, zzbot zzbot) {
        return (zzbuz) zzdto.zza(new zzbuz(zzbot, zzbbm.zzeaf), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzfhp, this.zzfhs.get());
    }
}
