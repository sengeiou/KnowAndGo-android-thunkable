package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashSet;

public final class zzbyi implements zzdti<zzbva> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<zzcxm> zzfhj;

    public zzbyi(zzdtu<Context> zzdtu, zzdtu<zzcxm> zzdtu2) {
        this.zzeoj = zzdtu;
        this.zzfhj = zzdtu2;
    }

    public final /* synthetic */ Object get() {
        return (zzbva) zzdto.zza(new zzbva(this.zzeoj.get(), new HashSet(), this.zzfhj.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
