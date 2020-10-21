package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

public final class zzbxr implements zzdti<Set<String>> {
    private final zzdtu<zzbzc> zzfhh;

    public zzbxr(zzdtu<zzbzc> zzdtu) {
        this.zzfhh = zzdtu;
    }

    public final /* synthetic */ Object get() {
        Set set;
        if (this.zzfhh.get().zzail() != null) {
            set = Collections.singleton("banner");
        } else {
            set = Collections.emptySet();
        }
        return (Set) zzdto.zza(set, "Cannot return null from a non-@Nullable @Provides method");
    }
}
