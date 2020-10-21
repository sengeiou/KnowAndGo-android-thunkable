package com.google.android.gms.internal.ads;

public final class zzcby implements zzdti<zzcbw> {
    private final zzdtu<zzbyt> zzfnh;
    private final zzdtu<zzbyn> zzfsd;

    private zzcby(zzdtu<zzbyn> zzdtu, zzdtu<zzbyt> zzdtu2) {
        this.zzfsd = zzdtu;
        this.zzfnh = zzdtu2;
    }

    public static zzcby zzk(zzdtu<zzbyn> zzdtu, zzdtu<zzbyt> zzdtu2) {
        return new zzcby(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return new zzcbw(this.zzfsd.get(), this.zzfnh.get());
    }
}
