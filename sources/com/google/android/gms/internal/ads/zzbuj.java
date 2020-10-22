package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;

public final class zzbuj implements zzdti<Set<zzbuz<AppEventListener>>> {
    private final zzbtv zzfky;

    private zzbuj(zzbtv zzbtv) {
        this.zzfky = zzbtv;
    }

    public static zzbuj zzq(zzbtv zzbtv) {
        return new zzbuj(zzbtv);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzdto.zza(this.zzfky.zzagq(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
