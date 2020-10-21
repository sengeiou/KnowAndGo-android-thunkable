package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcuu implements zzdti<zzcus> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<zzbbl> zzfgh;
    private final zzdtu<zzavg> zzfly;

    private zzcuu(zzdtu<zzavg> zzdtu, zzdtu<zzbbl> zzdtu2, zzdtu<Context> zzdtu3) {
        this.zzfly = zzdtu;
        this.zzfgh = zzdtu2;
        this.zzeoj = zzdtu3;
    }

    public static zzcuu zzo(zzdtu<zzavg> zzdtu, zzdtu<zzbbl> zzdtu2, zzdtu<Context> zzdtu3) {
        return new zzcuu(zzdtu, zzdtu2, zzdtu3);
    }

    public final /* synthetic */ Object get() {
        return new zzcus(this.zzfly.get(), this.zzfgh.get(), this.zzeoj.get());
    }
}
