package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

public final class zzbty implements zzdti<Set<zzbuz<zzbrx>>> {
    private final zzbtv zzfky;

    private zzbty(zzbtv zzbtv) {
        this.zzfky = zzbtv;
    }

    public static zzbty zze(zzbtv zzbtv) {
        return new zzbty(zzbtv);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzdto.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
