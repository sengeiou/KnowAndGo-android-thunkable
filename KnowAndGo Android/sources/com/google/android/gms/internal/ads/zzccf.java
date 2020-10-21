package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzccf implements zzdti<zzccd> {
    private final zzdtu<zzbzl> zzeym;
    private final zzdtu<Context> zzfjq;
    private final zzdtu<zzbyt> zzfnh;
    private final zzdtu<zzbyn> zzfsd;

    private zzccf(zzdtu<Context> zzdtu, zzdtu<zzbyt> zzdtu2, zzdtu<zzbzl> zzdtu3, zzdtu<zzbyn> zzdtu4) {
        this.zzfjq = zzdtu;
        this.zzfnh = zzdtu2;
        this.zzeym = zzdtu3;
        this.zzfsd = zzdtu4;
    }

    public static zzccf zzb(zzdtu<Context> zzdtu, zzdtu<zzbyt> zzdtu2, zzdtu<zzbzl> zzdtu3, zzdtu<zzbyn> zzdtu4) {
        return new zzccf(zzdtu, zzdtu2, zzdtu3, zzdtu4);
    }

    public final /* synthetic */ Object get() {
        return new zzccd(this.zzfjq.get(), this.zzfnh.get(), this.zzeym.get(), this.zzfsd.get());
    }
}
