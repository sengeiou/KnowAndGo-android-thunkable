package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzblr implements zzdti<zzblq> {
    private final zzdtu<Map<String, zzbls>> zzfew;

    private zzblr(zzdtu<Map<String, zzbls>> zzdtu) {
        this.zzfew = zzdtu;
    }

    public static zzblr zzb(zzdtu<Map<String, zzbls>> zzdtu) {
        return new zzblr(zzdtu);
    }

    public final /* synthetic */ Object get() {
        return new zzblq(this.zzfew.get());
    }
}
