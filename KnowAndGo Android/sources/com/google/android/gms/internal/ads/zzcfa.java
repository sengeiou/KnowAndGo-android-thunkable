package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzcfa implements zzdti<zzcex> {
    private final zzdtu<zzwj> zzfuc;
    private final zzdtu<Map<zzczs, zzcez>> zzfun;

    private zzcfa(zzdtu<zzwj> zzdtu, zzdtu<Map<zzczs, zzcez>> zzdtu2) {
        this.zzfuc = zzdtu;
        this.zzfun = zzdtu2;
    }

    public static zzcfa zzr(zzdtu<zzwj> zzdtu, zzdtu<Map<zzczs, zzcez>> zzdtu2) {
        return new zzcfa(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return new zzcex(this.zzfuc.get(), this.zzfun.get());
    }
}
