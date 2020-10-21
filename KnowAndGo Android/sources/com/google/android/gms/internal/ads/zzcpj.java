package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcpj implements zzdti<zzcpf> {
    private final zzdtu<zzclc> zzeog;
    private final zzdtu<Context> zzeoj;
    private final zzdtu<Executor> zzfgh;

    public zzcpj(zzdtu<zzclc> zzdtu, zzdtu<Executor> zzdtu2, zzdtu<Context> zzdtu3) {
        this.zzeog = zzdtu;
        this.zzfgh = zzdtu2;
        this.zzeoj = zzdtu3;
    }

    public final /* synthetic */ Object get() {
        return new zzcpf(this.zzeog.get(), this.zzfgh.get(), this.zzeoj.get());
    }
}
