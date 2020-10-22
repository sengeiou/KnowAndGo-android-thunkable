package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.Collections;
import java.util.Set;

public final class zzbuo implements zzdti<Set<zzbuz<VideoController.VideoLifecycleCallbacks>>> {
    private final zzbtv zzfky;

    private zzbuo(zzbtv zzbtv) {
        this.zzfky = zzbtv;
    }

    public static zzbuo zzu(zzbtv zzbtv) {
        return new zzbuo(zzbtv);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzdto.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
