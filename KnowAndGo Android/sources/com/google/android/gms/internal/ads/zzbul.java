package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

public final class zzbul implements zzdti<Set<zzbuz<zzue>>> {
    private final zzbtv zzfky;

    private zzbul(zzbtv zzbtv) {
        this.zzfky = zzbtv;
    }

    public static zzbul zzs(zzbtv zzbtv) {
        return new zzbul(zzbtv);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzdto.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
