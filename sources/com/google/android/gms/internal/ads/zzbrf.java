package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbqy;

public final class zzbrf implements zzdti<zzbqy.zza> {
    private final zzbqy zzfjw;

    private zzbrf(zzbqy zzbqy) {
        this.zzfjw = zzbqy;
    }

    public static zzbrf zzj(zzbqy zzbqy) {
        return new zzbrf(zzbqy);
    }

    public final /* synthetic */ Object get() {
        return (zzbqy.zza) zzdto.zza(this.zzfjw.zzagd(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
