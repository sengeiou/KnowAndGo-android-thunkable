package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbuh implements zzdti<Set<zzbuz<zzbsr>>> {
    private final zzbtv zzfky;

    private zzbuh(zzbtv zzbtv) {
        this.zzfky = zzbtv;
    }

    public static zzbuh zzn(zzbtv zzbtv) {
        return new zzbuh(zzbtv);
    }

    public static Set<zzbuz<zzbsr>> zzo(zzbtv zzbtv) {
        return (Set) zzdto.zza(zzbtv.zzagm(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzo(this.zzfky);
    }
}
