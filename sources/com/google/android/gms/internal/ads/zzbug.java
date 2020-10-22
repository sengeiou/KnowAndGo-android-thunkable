package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbug implements zzdti<Set<zzbuz<zzbrl>>> {
    private final zzbtv zzfky;

    private zzbug(zzbtv zzbtv) {
        this.zzfky = zzbtv;
    }

    public static zzbug zzm(zzbtv zzbtv) {
        return new zzbug(zzbtv);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzdto.zza(this.zzfky.zzagl(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
