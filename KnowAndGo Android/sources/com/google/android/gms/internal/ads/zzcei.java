package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcei implements zzdti<zzbuz<zzbrw>> {
    private final zzdtu<Executor> zzfgh;
    private final zzdtu<zzcep> zzfgm;

    private zzcei(zzdtu<zzcep> zzdtu, zzdtu<Executor> zzdtu2) {
        this.zzfgm = zzdtu;
        this.zzfgh = zzdtu2;
    }

    public static zzcei zzn(zzdtu<zzcep> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzcei(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.zzfgm.get(), this.zzfgh.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
