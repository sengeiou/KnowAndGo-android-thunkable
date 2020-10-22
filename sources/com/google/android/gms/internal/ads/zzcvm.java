package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcvm implements zzdti<zzcvk> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<zzbbl> zzfgh;

    private zzcvm(zzdtu<zzbbl> zzdtu, zzdtu<Context> zzdtu2) {
        this.zzfgh = zzdtu;
        this.zzeoj = zzdtu2;
    }

    public static zzcvm zzat(zzdtu<zzbbl> zzdtu, zzdtu<Context> zzdtu2) {
        return new zzcvm(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return new zzcvk(this.zzfgh.get(), this.zzeoj.get());
    }
}
