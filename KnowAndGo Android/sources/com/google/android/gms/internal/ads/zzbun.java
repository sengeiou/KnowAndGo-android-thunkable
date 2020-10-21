package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

public final class zzbun implements zzdti<zzcmu> {
    private final zzdtu<Clock> zzfgj;
    private final zzbtv zzfky;

    private zzbun(zzbtv zzbtv, zzdtu<Clock> zzdtu) {
        this.zzfky = zzbtv;
        this.zzfgj = zzdtu;
    }

    public static zzbun zzb(zzbtv zzbtv, zzdtu<Clock> zzdtu) {
        return new zzbun(zzbtv, zzdtu);
    }

    public final /* synthetic */ Object get() {
        return (zzcmu) zzdto.zza(this.zzfky.zza(this.zzfgj.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
