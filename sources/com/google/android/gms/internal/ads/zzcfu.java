package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

public final class zzcfu implements zzdti<Set<zzbuz<zzbtk>>> {
    private final zzdtu<Executor> zzfgh;
    private final zzdtu<zzcfz> zzfuc;
    private final zzcfp zzfux;

    private zzcfu(zzcfp zzcfp, zzdtu<zzcfz> zzdtu, zzdtu<Executor> zzdtu2) {
        this.zzfux = zzcfp;
        this.zzfuc = zzdtu;
        this.zzfgh = zzdtu2;
    }

    public static zzcfu zze(zzcfp zzcfp, zzdtu<zzcfz> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzcfu(zzcfp, zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzdto.zza(zzcfp.zzi(this.zzfuc.get(), this.zzfgh.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
