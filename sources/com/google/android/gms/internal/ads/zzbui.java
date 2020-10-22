package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;

public final class zzbui implements zzdti<Set<zzbuz<AdMetadataListener>>> {
    private final zzbtv zzfky;

    private zzbui(zzbtv zzbtv) {
        this.zzfky = zzbtv;
    }

    public static zzbui zzp(zzbtv zzbtv) {
        return new zzbui(zzbtv);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzdto.zza(this.zzfky.zzagp(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
