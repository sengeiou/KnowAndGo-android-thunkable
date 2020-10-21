package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

public final class zzceo implements zzdti<Set<zzbuz<zzczz>>> {
    private final zzdtu<Executor> zzfgh;
    private final zzdtu<zzcex> zzfgm;

    private zzceo(zzdtu<Executor> zzdtu, zzdtu<zzcex> zzdtu2) {
        this.zzfgh = zzdtu;
        this.zzfgm = zzdtu2;
    }

    public static zzceo zzq(zzdtu<Executor> zzdtu, zzdtu<zzcex> zzdtu2) {
        return new zzceo(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        Set set;
        Executor executor = this.zzfgh.get();
        zzcex zzcex = this.zzfgm.get();
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcul)).booleanValue()) {
            set = Collections.singleton(new zzbuz(zzcex, executor));
        } else {
            set = Collections.emptySet();
        }
        return (Set) zzdto.zza(set, "Cannot return null from a non-@Nullable @Provides method");
    }
}
