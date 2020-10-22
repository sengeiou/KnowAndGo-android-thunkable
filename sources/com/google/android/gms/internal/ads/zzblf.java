package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzblf implements zzdti<zzayu> {
    private final zzdtu<Context> zzeoj;

    public zzblf(zzdtu<Context> zzdtu) {
        this.zzeoj = zzdtu;
    }

    public final /* synthetic */ Object get() {
        return (zzayu) zzdto.zza(new zzayu(this.zzeoj.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
