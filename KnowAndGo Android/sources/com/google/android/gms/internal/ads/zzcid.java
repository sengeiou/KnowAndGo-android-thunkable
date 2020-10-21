package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcid implements zzdti<zzcic> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<zzavg> zzfly;

    private zzcid(zzdtu<Context> zzdtu, zzdtu<zzavg> zzdtu2) {
        this.zzeoj = zzdtu;
        this.zzfly = zzdtu2;
    }

    public static zzcid zzad(zzdtu<Context> zzdtu, zzdtu<zzavg> zzdtu2) {
        return new zzcid(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return new zzcic(this.zzeoj.get(), this.zzfly.get());
    }
}
