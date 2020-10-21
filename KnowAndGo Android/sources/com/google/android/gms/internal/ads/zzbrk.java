package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbrk implements zzdti<zzbri> {
    private final zzdtu<Set<zzbuz<zzxr>>> zzfhq;

    private zzbrk(zzdtu<Set<zzbuz<zzxr>>> zzdtu) {
        this.zzfhq = zzdtu;
    }

    public static zzbrk zzm(zzdtu<Set<zzbuz<zzxr>>> zzdtu) {
        return new zzbrk(zzdtu);
    }

    public final /* synthetic */ Object get() {
        return new zzbri(this.zzfhq.get());
    }
}
