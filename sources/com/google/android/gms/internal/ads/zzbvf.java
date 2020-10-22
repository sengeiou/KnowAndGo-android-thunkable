package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbvf implements zzdti<zzbvd> {
    private final zzdtu<Set<zzbuz<zzbvg>>> zzfhq;

    private zzbvf(zzdtu<Set<zzbuz<zzbvg>>> zzdtu) {
        this.zzfhq = zzdtu;
    }

    public static zzbvf zzx(zzdtu<Set<zzbuz<zzbvg>>> zzdtu) {
        return new zzbvf(zzdtu);
    }

    public final /* synthetic */ Object get() {
        return new zzbvd(this.zzfhq.get());
    }
}
