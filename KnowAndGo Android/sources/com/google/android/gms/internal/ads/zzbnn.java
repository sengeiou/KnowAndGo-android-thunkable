package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbnn implements zzdti<zzbso> {
    private final zzbnk zzfhp;
    private final zzdtu<Set<zzbuz<zzbsr>>> zzfhq;

    public zzbnn(zzbnk zzbnk, zzdtu<Set<zzbuz<zzbsr>>> zzdtu) {
        this.zzfhp = zzbnk;
        this.zzfhq = zzdtu;
    }

    public static zzbso zza(zzbnk zzbnk, Set<zzbuz<zzbsr>> set) {
        return (zzbso) zzdto.zza(zzbnk.zza(set), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzfhp, this.zzfhq.get());
    }
}
