package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

public final class zzbqd implements zzdti<zzawj> {
    private final zzdtu<zzawu> zzerc;
    private final zzdtu<Clock> zzfgj;
    private final zzdtu<zzcxv> zzfhr;

    private zzbqd(zzdtu<Clock> zzdtu, zzdtu<zzawu> zzdtu2, zzdtu<zzcxv> zzdtu3) {
        this.zzfgj = zzdtu;
        this.zzerc = zzdtu2;
        this.zzfhr = zzdtu3;
    }

    public static zzbqd zzg(zzdtu<Clock> zzdtu, zzdtu<zzawu> zzdtu2, zzdtu<zzcxv> zzdtu3) {
        return new zzbqd(zzdtu, zzdtu2, zzdtu3);
    }

    public final /* synthetic */ Object get() {
        return (zzawj) zzdto.zza(this.zzerc.get().zza(this.zzfgj.get(), this.zzfhr.get().zzglb), "Cannot return null from a non-@Nullable @Provides method");
    }
}
