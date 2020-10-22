package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

public final class zzbub implements zzdti<Set<zzbuz<zzbto>>> {
    private final zzbtv zzfky;

    private zzbub(zzbtv zzbtv) {
        this.zzfky = zzbtv;
    }

    public static zzbub zzi(zzbtv zzbtv) {
        return new zzbub(zzbtv);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzdto.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
