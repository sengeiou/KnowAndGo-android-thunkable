package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbqg implements zzdti<zzbuz<zzbvg>> {
    private final zzdtu<Executor> zzfgh;
    private final zzdtu<zzbvh> zzfhs;

    private zzbqg(zzdtu<zzbvh> zzdtu, zzdtu<Executor> zzdtu2) {
        this.zzfhs = zzdtu;
        this.zzfgh = zzdtu2;
    }

    public static zzbqg zzc(zzdtu<zzbvh> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzbqg(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.zzfhs.get(), this.zzfgh.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
