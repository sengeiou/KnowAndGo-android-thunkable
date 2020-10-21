package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbma implements zzdti<zzblz> {
    private final zzdtu<Context> zzeoj;

    private zzbma(zzdtu<Context> zzdtu) {
        this.zzeoj = zzdtu;
    }

    public static zzbma zzf(zzdtu<Context> zzdtu) {
        return new zzbma(zzdtu);
    }

    public final /* synthetic */ Object get() {
        return new zzblz(this.zzeoj.get());
    }
}
