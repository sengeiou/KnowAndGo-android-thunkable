package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzciz implements zzdti<zzbuz<zzczz>> {
    private final zzdtu<Executor> zzfgh;
    private final zzdtu<zzcjk> zzfgm;

    private zzciz(zzdtu<zzcjk> zzdtu, zzdtu<Executor> zzdtu2) {
        this.zzfgm = zzdtu;
        this.zzfgh = zzdtu2;
    }

    public static zzciz zzag(zzdtu<zzcjk> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzciz(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.zzfgm.get(), this.zzfgh.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
