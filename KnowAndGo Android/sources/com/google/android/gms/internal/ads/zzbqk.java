package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbqk implements zzdti<zzbuz<zzbsr>> {
    private final zzdtu<Executor> zzfgh;
    private final zzdtu<zzbme> zzfhs;

    private zzbqk(zzdtu<zzbme> zzdtu, zzdtu<Executor> zzdtu2) {
        this.zzfhs = zzdtu;
        this.zzfgh = zzdtu2;
    }

    public static zzbqk zzg(zzdtu<zzbme> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzbqk(zzdtu, zzdtu2);
    }

    public static zzbuz<zzbsr> zza(zzbme zzbme, Executor executor) {
        return (zzbuz) zzdto.zza(new zzbuz(zzbme, executor), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzfhs.get(), this.zzfgh.get());
    }
}
