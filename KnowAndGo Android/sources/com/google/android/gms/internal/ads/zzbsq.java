package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbsq implements zzdti<zzbso> {
    private final zzdtu<Set<zzbuz<zzbsr>>> zzfhq;

    private zzbsq(zzdtu<Set<zzbuz<zzbsr>>> zzdtu) {
        this.zzfhq = zzdtu;
    }

    public static zzbsq zzq(zzdtu<Set<zzbuz<zzbsr>>> zzdtu) {
        return new zzbsq(zzdtu);
    }

    public final /* synthetic */ Object get() {
        return new zzbso(this.zzfhq.get());
    }
}
