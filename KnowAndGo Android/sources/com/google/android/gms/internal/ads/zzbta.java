package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
import java.util.Set;

public final class zzbta implements zzdti<zzbsv> {
    private final zzdtu<Set<zzbuz<zzo>>> zzfhq;

    private zzbta(zzdtu<Set<zzbuz<zzo>>> zzdtu) {
        this.zzfhq = zzdtu;
    }

    public static zzbta zzs(zzdtu<Set<zzbuz<zzo>>> zzdtu) {
        return new zzbta(zzdtu);
    }

    public final /* synthetic */ Object get() {
        return new zzbsv(this.zzfhq.get());
    }
}
