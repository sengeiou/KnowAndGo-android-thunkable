package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

public final class zzcap implements zzdti<zzcan> {
    private final zzdtu<zzayu> zzepv;
    private final zzdtu<Executor> zzfgh;
    private final zzdtu<Clock> zzfgj;

    public zzcap(zzdtu<zzayu> zzdtu, zzdtu<Clock> zzdtu2, zzdtu<Executor> zzdtu3) {
        this.zzepv = zzdtu;
        this.zzfgj = zzdtu2;
        this.zzfgh = zzdtu3;
    }

    public final /* synthetic */ Object get() {
        return new zzcan(this.zzepv.get(), this.zzfgj.get(), this.zzfgh.get());
    }
}
