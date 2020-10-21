package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbuf implements zzdti<Set<zzbuz<zzbrw>>> {
    private final zzbtv zzfky;

    private zzbuf(zzbtv zzbtv) {
        this.zzfky = zzbtv;
    }

    public static zzbuf zzl(zzbtv zzbtv) {
        return new zzbuf(zzbtv);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzdto.zza(this.zzfky.zzags(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
