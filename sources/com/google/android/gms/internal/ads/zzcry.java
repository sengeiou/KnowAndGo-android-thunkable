package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcry implements zzdti<zzcrv> {
    private final zzdtu<Executor> zzfgh;
    private final zzdtu<zzawm> zzggj;

    private zzcry(zzdtu<Executor> zzdtu, zzdtu<zzawm> zzdtu2) {
        this.zzfgh = zzdtu;
        this.zzggj = zzdtu2;
    }

    public static zzcry zzaj(zzdtu<Executor> zzdtu, zzdtu<zzawm> zzdtu2) {
        return new zzcry(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return new zzcrv(this.zzfgh.get(), this.zzggj.get());
    }
}
