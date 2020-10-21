package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzchi implements zzdti<zzchv> {
    private final zzdtu<Context> zzeoj;

    private zzchi(zzdtu<Context> zzdtu) {
        this.zzeoj = zzdtu;
    }

    public static zzchi zzae(zzdtu<Context> zzdtu) {
        return new zzchi(zzdtu);
    }

    public final /* synthetic */ Object get() {
        return (zzchv) zzdto.zza(new zzchv(this.zzeoj.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
