package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbsd implements zzdti<zzbry> {
    private final zzdtu<Set<zzbuz<zzbrx>>> zzfhq;

    private zzbsd(zzdtu<Set<zzbuz<zzbrx>>> zzdtu) {
        this.zzfhq = zzdtu;
    }

    public static zzbsd zzo(zzdtu<Set<zzbuz<zzbrx>>> zzdtu) {
        return new zzbsd(zzdtu);
    }

    public final /* synthetic */ Object get() {
        return new zzbry(this.zzfhq.get());
    }
}
