package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcej implements zzdti<zzbuz<zzbsr>> {
    private final zzdtu<Executor> zzfgh;
    private final zzdtu<zzcep> zzfgm;

    private zzcej(zzdtu<zzcep> zzdtu, zzdtu<Executor> zzdtu2) {
        this.zzfgm = zzdtu;
        this.zzfgh = zzdtu2;
    }

    public static zzcej zzo(zzdtu<zzcep> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzcej(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.zzfgm.get(), this.zzfgh.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
