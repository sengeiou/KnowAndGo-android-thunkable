package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcst implements zzdti<zzcsp> {
    private final zzdtu<zzbbl> zzfgh;
    private final zzdtu<Context> zzfjq;

    private zzcst(zzdtu<Context> zzdtu, zzdtu<zzbbl> zzdtu2) {
        this.zzfjq = zzdtu;
        this.zzfgh = zzdtu2;
    }

    public static zzcst zzal(zzdtu<Context> zzdtu, zzdtu<zzbbl> zzdtu2) {
        return new zzcst(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return new zzcsp(this.zzfjq.get(), this.zzfgh.get());
    }
}
