package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbuy implements zzdti<zzbuv> {
    private final zzdtu<Set<zzbuz<zzbuu>>> zzfhq;

    private zzbuy(zzdtu<Set<zzbuz<zzbuu>>> zzdtu) {
        this.zzfhq = zzdtu;
    }

    public static zzbuy zzw(zzdtu<Set<zzbuz<zzbuu>>> zzdtu) {
        return new zzbuy(zzdtu);
    }

    public final /* synthetic */ Object get() {
        return new zzbuv(this.zzfhq.get());
    }
}
