package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbrv implements zzdti<zzbrt> {
    private final zzdtu<Set<zzbuz<zzbrw>>> zzfhq;

    private zzbrv(zzdtu<Set<zzbuz<zzbrw>>> zzdtu) {
        this.zzfhq = zzdtu;
    }

    public static zzbrv zzn(zzdtu<Set<zzbuz<zzbrw>>> zzdtu) {
        return new zzbrv(zzdtu);
    }

    public final /* synthetic */ Object get() {
        return new zzbrt(this.zzfhq.get());
    }
}
