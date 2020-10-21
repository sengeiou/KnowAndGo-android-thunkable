package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzchd implements zzdti<zzbuz<zzbtk>> {
    private final zzdtu<Executor> zzfgh;
    private final zzdtu<zzcic> zzfgm;

    private zzchd(zzdtu<zzcic> zzdtu, zzdtu<Executor> zzdtu2) {
        this.zzfgm = zzdtu;
        this.zzfgh = zzdtu2;
    }

    public static zzchd zzab(zzdtu<zzcic> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzchd(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.zzfgm.get(), this.zzfgh.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
