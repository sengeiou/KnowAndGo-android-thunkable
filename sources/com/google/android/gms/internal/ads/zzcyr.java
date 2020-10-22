package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcyr implements zzdti<Context> {
    private final zzcyo zzglu;
    private final zzdtu<zzcym> zzglv;

    private zzcyr(zzcyo zzcyo, zzdtu<zzcym> zzdtu) {
        this.zzglu = zzcyo;
        this.zzglv = zzdtu;
    }

    public static zzcyr zzb(zzcyo zzcyo, zzdtu<zzcym> zzdtu) {
        return new zzcyr(zzcyo, zzdtu);
    }

    public final /* synthetic */ Object get() {
        return (Context) zzdto.zza(this.zzglv.get().zzys, "Cannot return null from a non-@Nullable @Provides method");
    }
}
