package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbny implements zzdti<zzbuz<zzue>> {
    private final zzdtu<Executor> zzfgh;
    private final zzbnk zzfhp;
    private final zzdtu<zzboz> zzfhs;

    public zzbny(zzbnk zzbnk, zzdtu<zzboz> zzdtu, zzdtu<Executor> zzdtu2) {
        this.zzfhp = zzbnk;
        this.zzfhs = zzdtu;
        this.zzfgh = zzdtu2;
    }

    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.zzfhs.get(), this.zzfgh.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
