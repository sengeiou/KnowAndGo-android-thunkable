package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbtn implements zzdti<zzbtl> {
    private final zzdtu<Set<zzbuz<zzbto>>> zzfhq;

    private zzbtn(zzdtu<Set<zzbuz<zzbto>>> zzdtu) {
        this.zzfhq = zzdtu;
    }

    public static zzbtn zzu(zzdtu<Set<zzbuz<zzbto>>> zzdtu) {
        return new zzbtn(zzdtu);
    }

    public final /* synthetic */ Object get() {
        return new zzbtl(this.zzfhq.get());
    }
}
