package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

public final class zzcft implements zzdti<Set<zzbuz<zzbsr>>> {
    private final zzdtu<Executor> zzfgh;
    private final zzdtu<zzcfz> zzfuc;
    private final zzcfp zzfux;

    private zzcft(zzcfp zzcfp, zzdtu<zzcfz> zzdtu, zzdtu<Executor> zzdtu2) {
        this.zzfux = zzcfp;
        this.zzfuc = zzdtu;
        this.zzfgh = zzdtu2;
    }

    public static zzcft zzd(zzcfp zzcfp, zzdtu<zzcfz> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzcft(zzcfp, zzdtu, zzdtu2);
    }

    public static Set<zzbuz<zzbsr>> zza(zzcfp zzcfp, zzcfz zzcfz, Executor executor) {
        return (Set) zzdto.zza(zzcfp.zzc(zzcfz, executor), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzfux, this.zzfuc.get(), this.zzfgh.get());
    }
}
