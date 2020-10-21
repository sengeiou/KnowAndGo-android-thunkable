package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

public final class zzcfr implements zzdti<Set<zzbuz<zzbro>>> {
    private final zzdtu<Executor> zzfgh;
    private final zzdtu<zzcfz> zzfuc;
    private final zzcfp zzfux;

    private zzcfr(zzcfp zzcfp, zzdtu<zzcfz> zzdtu, zzdtu<Executor> zzdtu2) {
        this.zzfux = zzcfp;
        this.zzfuc = zzdtu;
        this.zzfgh = zzdtu2;
    }

    public static zzcfr zzb(zzcfp zzcfp, zzdtu<zzcfz> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzcfr(zzcfp, zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzdto.zza(zzcfp.zzd(this.zzfuc.get(), this.zzfgh.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
