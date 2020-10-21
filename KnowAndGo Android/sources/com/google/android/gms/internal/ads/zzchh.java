package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzchh implements zzdti<String> {
    private final zzdtu<Context> zzeoj;

    private zzchh(zzdtu<Context> zzdtu) {
        this.zzeoj = zzdtu;
    }

    public static zzchh zzad(zzdtu<Context> zzdtu) {
        return new zzchh(zzdtu);
    }

    public final /* synthetic */ Object get() {
        return (String) zzdto.zza(this.zzeoj.get().getPackageName(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
