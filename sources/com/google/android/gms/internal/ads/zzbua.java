package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
import java.util.Collections;
import java.util.Set;

public final class zzbua implements zzdti<Set<zzbuz<zzo>>> {
    private final zzbtv zzfky;

    private zzbua(zzbtv zzbtv) {
        this.zzfky = zzbtv;
    }

    public static zzbua zzh(zzbtv zzbtv) {
        return new zzbua(zzbtv);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzdto.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
