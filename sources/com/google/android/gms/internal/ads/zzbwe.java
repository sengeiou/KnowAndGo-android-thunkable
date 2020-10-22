package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbwe implements zzdti<Set<zzbuz<zzbrl>>> {
    private final zzdtu<zzbxc> zzfhs;
    private final zzbvz zzflo;

    private zzbwe(zzbvz zzbvz, zzdtu<zzbxc> zzdtu) {
        this.zzflo = zzbvz;
        this.zzfhs = zzdtu;
    }

    public static zzbwe zza(zzbvz zzbvz, zzdtu<zzbxc> zzdtu) {
        return new zzbwe(zzbvz, zzdtu);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzdto.zza(this.zzflo.zza(this.zzfhs.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
