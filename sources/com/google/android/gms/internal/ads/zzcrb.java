package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcrb implements zzdti<zzcqz> {
    private final zzdtu<Executor> zzfgh;
    private final zzdtu<zzchz> zzfvx;

    public zzcrb(zzdtu<Executor> zzdtu, zzdtu<zzchz> zzdtu2) {
        this.zzfgh = zzdtu;
        this.zzfvx = zzdtu2;
    }

    public final /* synthetic */ Object get() {
        return new zzcqz(this.zzfgh.get(), this.zzfvx.get());
    }
}
