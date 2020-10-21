package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzcha implements zzdti<zzbbh<Bundle>> {
    private final zzdtu<zzcvb<Bundle>> zzeth;
    private final zzdtu<zzczt> zzfhv;

    private zzcha(zzdtu<zzczt> zzdtu, zzdtu<zzcvb<Bundle>> zzdtu2) {
        this.zzfhv = zzdtu;
        this.zzeth = zzdtu2;
    }

    public static zzcha zzz(zzdtu<zzczt> zzdtu, zzdtu<zzcvb<Bundle>> zzdtu2) {
        return new zzcha(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return (zzbbh) zzdto.zza(this.zzfhv.get().zzv(zzczs.SIGNALS).zzb(this.zzeth.get().zzu(new Bundle())).zzane(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
