package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbqi implements zzdti<zzbuz<zzbrl>> {
    private final zzdtu<Executor> zzfgh;
    private final zzdtu<zzbme> zzfhs;

    private zzbqi(zzdtu<zzbme> zzdtu, zzdtu<Executor> zzdtu2) {
        this.zzfhs = zzdtu;
        this.zzfgh = zzdtu2;
    }

    public static zzbqi zze(zzdtu<zzbme> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzbqi(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.zzfhs.get(), this.zzfgh.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
