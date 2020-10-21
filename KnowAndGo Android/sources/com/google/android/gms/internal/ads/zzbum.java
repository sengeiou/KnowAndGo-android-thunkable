package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

public final class zzbum implements zzdti<Set<zzbuz<zzbvg>>> {
    private final zzbtv zzfky;

    private zzbum(zzbtv zzbtv) {
        this.zzfky = zzbtv;
    }

    public static zzbum zzt(zzbtv zzbtv) {
        return new zzbum(zzbtv);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzdto.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
