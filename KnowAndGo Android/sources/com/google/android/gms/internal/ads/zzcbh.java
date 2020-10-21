package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcbh implements zzdti<zzcbd> {
    private final zzdtu<Executor> zzfgh;
    private final zzdtu<zzcau> zzfrj;

    public zzcbh(zzdtu<Executor> zzdtu, zzdtu<zzcau> zzdtu2) {
        this.zzfgh = zzdtu;
        this.zzfrj = zzdtu2;
    }

    public final /* synthetic */ Object get() {
        return new zzcbd(this.zzfgh.get(), this.zzfrj.get());
    }
}
