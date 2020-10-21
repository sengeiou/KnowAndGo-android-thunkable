package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbqj implements zzdti<zzbuz<zzbrw>> {
    private final zzdtu<Executor> zzfgh;
    private final zzdtu<zzbme> zzfhs;

    private zzbqj(zzdtu<zzbme> zzdtu, zzdtu<Executor> zzdtu2) {
        this.zzfhs = zzdtu;
        this.zzfgh = zzdtu2;
    }

    public static zzbqj zzf(zzdtu<zzbme> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzbqj(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.zzfhs.get(), this.zzfgh.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
