package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbsl implements zzdti<zzbse> {
    private final zzdtu<Set<zzbuz<zzbrl>>> zzfhq;

    private zzbsl(zzdtu<Set<zzbuz<zzbrl>>> zzdtu) {
        this.zzfhq = zzdtu;
    }

    public static zzbsl zzp(zzdtu<Set<zzbuz<zzbrl>>> zzdtu) {
        return new zzbsl(zzdtu);
    }

    public final /* synthetic */ Object get() {
        return new zzbse(this.zzfhq.get());
    }
}
