package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbuc implements zzdti<Set<zzbuz<zzxr>>> {
    private final zzbtv zzfky;

    private zzbuc(zzbtv zzbtv) {
        this.zzfky = zzbtv;
    }

    public static zzbuc zzj(zzbtv zzbtv) {
        return new zzbuc(zzbtv);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzdto.zza(this.zzfky.zzagr(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
