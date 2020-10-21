package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbmr implements zzdti<zzbmg> {
    private final zzdtu<Executor> zzfgh;
    private final zzdtu<zzty> zzfgk;
    private final zzdtu<zzaly> zzfgl;

    private zzbmr(zzdtu<zzty> zzdtu, zzdtu<zzaly> zzdtu2, zzdtu<Executor> zzdtu3) {
        this.zzfgk = zzdtu;
        this.zzfgl = zzdtu2;
        this.zzfgh = zzdtu3;
    }

    public static zzbmr zzb(zzdtu<zzty> zzdtu, zzdtu<zzaly> zzdtu2, zzdtu<Executor> zzdtu3) {
        return new zzbmr(zzdtu, zzdtu2, zzdtu3);
    }

    public final /* synthetic */ Object get() {
        return (zzbmg) zzdto.zza(new zzbmg(this.zzfgk.get().zzmi(), this.zzfgl.get(), this.zzfgh.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
