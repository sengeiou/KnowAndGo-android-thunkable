package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbwl implements zzdti<zzbuz<zzbrl>> {
    private final zzdtu<Executor> zzfgh;
    private final zzdtu<zzbxg> zzfhs;
    private final zzbvz zzflo;

    private zzbwl(zzbvz zzbvz, zzdtu<zzbxg> zzdtu, zzdtu<Executor> zzdtu2) {
        this.zzflo = zzbvz;
        this.zzfhs = zzdtu;
        this.zzfgh = zzdtu2;
    }

    public static zzbwl zzb(zzbvz zzbvz, zzdtu<zzbxg> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzbwl(zzbvz, zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.zzfhs.get(), this.zzfgh.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
