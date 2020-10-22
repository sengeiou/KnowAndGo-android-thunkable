package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;

public final class zzbsu implements zzdti<zzbss> {
    private final zzdtu<Set<zzbuz<AdMetadataListener>>> zzfhq;

    private zzbsu(zzdtu<Set<zzbuz<AdMetadataListener>>> zzdtu) {
        this.zzfhq = zzdtu;
    }

    public static zzbsu zzr(zzdtu<Set<zzbuz<AdMetadataListener>>> zzdtu) {
        return new zzbsu(zzdtu);
    }

    public final /* synthetic */ Object get() {
        return new zzbss(this.zzfhq.get());
    }
}
