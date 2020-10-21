package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;

public final class zzble implements zzdti<zzdan> {
    private final zzdtu<Context> zzeoj;

    public zzble(zzdtu<Context> zzdtu) {
        this.zzeoj = zzdtu;
    }

    public final /* synthetic */ Object get() {
        return (zzdan) zzdto.zza(new zzdan(this.zzeoj.get(), zzk.zzlu().zzwr()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
