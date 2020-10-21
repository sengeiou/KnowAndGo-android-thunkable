package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbwn implements zzdti<zzbuz<zzbto>> {
    private final zzdtu<Executor> zzfgh;
    private final zzbvz zzflo;

    private zzbwn(zzbvz zzbvz, zzdtu<Executor> zzdtu) {
        this.zzflo = zzbvz;
        this.zzfgh = zzdtu;
    }

    public static zzbwn zzd(zzbvz zzbvz, zzdtu<Executor> zzdtu) {
        return new zzbwn(zzbvz, zzdtu);
    }

    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(new zzbwb(this.zzflo), this.zzfgh.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
