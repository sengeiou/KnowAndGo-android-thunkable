package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

public final class zzbnt implements zzdti<Set<zzbuz<zzbsr>>> {
    private final zzbnk zzfhp;
    private final zzdtu<zzbov> zzfhs;

    public zzbnt(zzbnk zzbnk, zzdtu<zzbov> zzdtu) {
        this.zzfhp = zzbnk;
        this.zzfhs = zzdtu;
    }

    public static Set<zzbuz<zzbsr>> zza(zzbnk zzbnk, zzbov zzbov) {
        return (Set) zzdto.zza(Collections.singleton(new zzbuz(zzbov, zzbbm.zzeaf)), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzfhp, this.zzfhs.get());
    }
}
