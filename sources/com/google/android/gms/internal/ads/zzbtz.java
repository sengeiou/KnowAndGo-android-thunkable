package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

public final class zzbtz implements zzdti<Set<zzbuz<zzbsr>>> {
    private final zzbtv zzfky;

    private zzbtz(zzbtv zzbtv) {
        this.zzfky = zzbtv;
    }

    public static zzbtz zzf(zzbtv zzbtv) {
        return new zzbtz(zzbtv);
    }

    public static Set<zzbuz<zzbsr>> zzg(zzbtv zzbtv) {
        return (Set) zzdto.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzg(this.zzfky);
    }
}
