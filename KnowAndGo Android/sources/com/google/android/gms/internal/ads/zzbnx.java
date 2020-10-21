package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbnx implements zzdti<zzavf> {
    private final zzdtu<Context> zzeoj;
    private final zzbnk zzfhp;
    private final zzdtu<zzcxv> zzfhr;

    public zzbnx(zzbnk zzbnk, zzdtu<Context> zzdtu, zzdtu<zzcxv> zzdtu2) {
        this.zzfhp = zzbnk;
        this.zzeoj = zzdtu;
        this.zzfhr = zzdtu2;
    }

    public final /* synthetic */ Object get() {
        return (zzavf) zzdto.zza(new zzavf(this.zzeoj.get(), this.zzfhr.get().zzglb), "Cannot return null from a non-@Nullable @Provides method");
    }
}
