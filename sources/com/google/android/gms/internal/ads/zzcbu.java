package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcbu implements zzdti<zzcbp> {
    private final zzdtu<Executor> zzfhi;
    private final zzdtu<zzbmy> zzfql;
    private final zzdtu<zzbva> zzfsa;

    public zzcbu(zzdtu<Executor> zzdtu, zzdtu<zzbmy> zzdtu2, zzdtu<zzbva> zzdtu3) {
        this.zzfhi = zzdtu;
        this.zzfql = zzdtu2;
        this.zzfsa = zzdtu3;
    }

    public final /* synthetic */ Object get() {
        return new zzcbp(this.zzfhi.get(), this.zzfql.get(), this.zzfsa.get());
    }
}
