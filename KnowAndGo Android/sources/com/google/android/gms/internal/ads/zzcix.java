package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcix implements zzdti<zzbuz<zzbro>> {
    private final zzdtu<Executor> zzfgh;
    private final zzdtu<zzcjg> zzfgm;

    private zzcix(zzdtu<zzcjg> zzdtu, zzdtu<Executor> zzdtu2) {
        this.zzfgm = zzdtu;
        this.zzfgh = zzdtu2;
    }

    public static zzcix zzae(zzdtu<zzcjg> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzcix(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.zzfgm.get(), this.zzfgh.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
