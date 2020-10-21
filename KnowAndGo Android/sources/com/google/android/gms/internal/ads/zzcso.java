package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

public final class zzcso implements zzdti<zzcxk> {
    private final zzdtu<Clock> zzfgj;

    public zzcso(zzdtu<Clock> zzdtu) {
        this.zzfgj = zzdtu;
    }

    public final /* synthetic */ Object get() {
        return (zzcxk) zzdto.zza(new zzcxk(this.zzfgj.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
