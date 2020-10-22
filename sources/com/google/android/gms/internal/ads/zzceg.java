package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzceg implements zzdti<zzbuz<zzxr>> {
    private final zzdtu<Executor> zzfgh;
    private final zzdtu<zzcep> zzfgm;

    private zzceg(zzdtu<zzcep> zzdtu, zzdtu<Executor> zzdtu2) {
        this.zzfgm = zzdtu;
        this.zzfgh = zzdtu2;
    }

    public static zzceg zzl(zzdtu<zzcep> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzceg(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.zzfgm.get(), this.zzfgh.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
