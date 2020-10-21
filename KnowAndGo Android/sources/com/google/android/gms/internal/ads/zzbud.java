package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbud implements zzdti<Set<zzbuz<zzbro>>> {
    private final zzbtv zzfky;

    private zzbud(zzbtv zzbtv) {
        this.zzfky = zzbtv;
    }

    public static zzbud zzk(zzbtv zzbtv) {
        return new zzbud(zzbtv);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzdto.zza(this.zzfky.zzagn(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
