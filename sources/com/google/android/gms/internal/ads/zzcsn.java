package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

public final class zzcsn implements zzdti<zzcsk<zzcvf>> {
    private final zzdtu<zzcvg> zzeph;
    private final zzdtu<Clock> zzfgj;

    public zzcsn(zzdtu<zzcvg> zzdtu, zzdtu<Clock> zzdtu2) {
        this.zzeph = zzdtu;
        this.zzfgj = zzdtu2;
    }

    public final /* synthetic */ Object get() {
        return (zzcsk) zzdto.zza(new zzcsk(this.zzeph.get(), ((Long) zzyt.zzpe().zzd(zzacu.zzcqm)).longValue(), this.zzfgj.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
