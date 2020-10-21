package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

public final class zzbmq implements zzdti<zzbmn> {
    private final zzdtu<zzaly> zzfgf;
    private final zzdtu<zzbml> zzfgg;
    private final zzdtu<Executor> zzfgh;
    private final zzdtu<zzbmg> zzfgi;
    private final zzdtu<Clock> zzfgj;

    private zzbmq(zzdtu<zzaly> zzdtu, zzdtu<zzbml> zzdtu2, zzdtu<Executor> zzdtu3, zzdtu<zzbmg> zzdtu4, zzdtu<Clock> zzdtu5) {
        this.zzfgf = zzdtu;
        this.zzfgg = zzdtu2;
        this.zzfgh = zzdtu3;
        this.zzfgi = zzdtu4;
        this.zzfgj = zzdtu5;
    }

    public static zzbmq zza(zzdtu<zzaly> zzdtu, zzdtu<zzbml> zzdtu2, zzdtu<Executor> zzdtu3, zzdtu<zzbmg> zzdtu4, zzdtu<Clock> zzdtu5) {
        return new zzbmq(zzdtu, zzdtu2, zzdtu3, zzdtu4, zzdtu5);
    }

    public final /* synthetic */ Object get() {
        return new zzbmn(this.zzfgf.get(), this.zzfgg.get(), this.zzfgh.get(), this.zzfgi.get(), this.zzfgj.get());
    }
}
