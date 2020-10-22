package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzdab implements zzdti<zzczu> {
    private final zzdtu<Set<zzbuz<zzczz>>> zzfhq;

    private zzdab(zzdtu<Set<zzbuz<zzczz>>> zzdtu) {
        this.zzfhq = zzdtu;
    }

    public static zzdab zzan(zzdtu<Set<zzbuz<zzczz>>> zzdtu) {
        return new zzdab(zzdtu);
    }

    public final /* synthetic */ Object get() {
        return new zzczu(this.zzfhq.get());
    }
}
