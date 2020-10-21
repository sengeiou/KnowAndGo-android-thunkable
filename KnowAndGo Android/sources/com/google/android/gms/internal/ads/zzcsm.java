package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

public final class zzcsm implements zzdti<zzcsk<zzcsg>> {
    private final zzdtu<Clock> zzfgj;
    private final zzdtu<zzcsh> zzgha;

    public zzcsm(zzdtu<zzcsh> zzdtu, zzdtu<Clock> zzdtu2) {
        this.zzgha = zzdtu;
        this.zzfgj = zzdtu2;
    }

    public final /* synthetic */ Object get() {
        return (zzcsk) zzdto.zza(new zzcsk(this.zzgha.get(), 10000, this.zzfgj.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
