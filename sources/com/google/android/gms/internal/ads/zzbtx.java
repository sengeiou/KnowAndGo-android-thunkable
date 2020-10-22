package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbtx implements zzdti<zzbrm> {
    private final zzbtv zzfky;
    private final zzdtu<Set<zzbuz<zzbro>>> zzfkz;

    private zzbtx(zzbtv zzbtv, zzdtu<Set<zzbuz<zzbro>>> zzdtu) {
        this.zzfky = zzbtv;
        this.zzfkz = zzdtu;
    }

    public static zzbtx zza(zzbtv zzbtv, zzdtu<Set<zzbuz<zzbro>>> zzdtu) {
        return new zzbtx(zzbtv, zzdtu);
    }

    public final /* synthetic */ Object get() {
        return (zzbrm) zzdto.zza(this.zzfky.zzc(this.zzfkz.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
