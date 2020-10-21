package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

public final class zzbwm implements zzdti<Set<zzbuz<zzbuu>>> {
    private final zzdtu<zzbxe> zzfhs;

    private zzbwm(zzdtu<zzbxe> zzdtu) {
        this.zzfhs = zzdtu;
    }

    public static zzbwm zzz(zzdtu<zzbxe> zzdtu) {
        return new zzbwm(zzdtu);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzdto.zza(Collections.singleton(zzbuz.zzb(this.zzfhs.get(), zzbbm.zzeaf)), "Cannot return null from a non-@Nullable @Provides method");
    }
}
