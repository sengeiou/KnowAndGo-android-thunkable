package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

public final class zzbzs implements zzdti<zzbzq> {
    private final zzdtu<zzccj> zzeve;
    private final zzdtu<Clock> zzfgj;

    public zzbzs(zzdtu<zzccj> zzdtu, zzdtu<Clock> zzdtu2) {
        this.zzeve = zzdtu;
        this.zzfgj = zzdtu2;
    }

    public final /* synthetic */ Object get() {
        return new zzbzq(this.zzeve.get(), this.zzfgj.get());
    }
}
