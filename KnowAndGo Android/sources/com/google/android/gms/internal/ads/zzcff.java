package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcff implements zzdti<zzbuz<zzbsr>> {
    private final zzdtu<Executor> zzfgh;
    private final zzdtu<zzcfb> zzfgm;

    private zzcff(zzdtu<zzcfb> zzdtu, zzdtu<Executor> zzdtu2) {
        this.zzfgm = zzdtu;
        this.zzfgh = zzdtu2;
    }

    public static zzcff zzv(zzdtu<zzcfb> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzcff(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.zzfgm.get(), this.zzfgh.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
