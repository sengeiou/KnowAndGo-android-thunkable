package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.Set;

public final class zzbvw implements zzdti<zzbvq> {
    private final zzdtu<Set<zzbuz<VideoController.VideoLifecycleCallbacks>>> zzfhq;

    private zzbvw(zzdtu<Set<zzbuz<VideoController.VideoLifecycleCallbacks>>> zzdtu) {
        this.zzfhq = zzdtu;
    }

    public static zzbvw zzy(zzdtu<Set<zzbuz<VideoController.VideoLifecycleCallbacks>>> zzdtu) {
        return new zzbvw(zzdtu);
    }

    public final /* synthetic */ Object get() {
        return new zzbvq(this.zzfhq.get());
    }
}
