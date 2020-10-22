package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

public final class zzbqf implements zzdti<zzbqe> {
    private final zzdtu<Clock> zzfgj;
    private final zzdtu<zzawj> zzfjl;

    private zzbqf(zzdtu<Clock> zzdtu, zzdtu<zzawj> zzdtu2) {
        this.zzfgj = zzdtu;
        this.zzfjl = zzdtu2;
    }

    public static zzbqf zzb(zzdtu<Clock> zzdtu, zzdtu<zzawj> zzdtu2) {
        return new zzbqf(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return new zzbqe(this.zzfgj.get(), this.zzfjl.get());
    }
}
