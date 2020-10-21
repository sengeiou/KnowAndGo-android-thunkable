package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbtj implements zzdti<zzbtg> {
    private final zzdtu<Set<zzbuz<zzbtk>>> zzfhq;

    private zzbtj(zzdtu<Set<zzbuz<zzbtk>>> zzdtu) {
        this.zzfhq = zzdtu;
    }

    public static zzbtj zzt(zzdtu<Set<zzbuz<zzbtk>>> zzdtu) {
        return new zzbtj(zzdtu);
    }

    public final /* synthetic */ Object get() {
        return new zzbtg(this.zzfhq.get());
    }
}
