package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

public final class zzbyl implements zzdti<zzbmy> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<Executor> zzfgh;
    private final zzdtu<Clock> zzfgj;
    private final zzdtu<zzty> zzfnn;

    public zzbyl(zzdtu<zzty> zzdtu, zzdtu<Executor> zzdtu2, zzdtu<Context> zzdtu3, zzdtu<Clock> zzdtu4) {
        this.zzfnn = zzdtu;
        this.zzfgh = zzdtu2;
        this.zzeoj = zzdtu3;
        this.zzfgj = zzdtu4;
    }

    public final /* synthetic */ Object get() {
        return (zzbmy) zzdto.zza(new zzbmy(this.zzfgh.get(), new zzbml(this.zzeoj.get(), this.zzfnn.get()), this.zzfgj.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
