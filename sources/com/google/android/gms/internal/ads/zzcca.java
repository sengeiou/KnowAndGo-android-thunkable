package com.google.android.gms.internal.ads;

public final class zzcca implements zzdti<zzcbz> {
    private final zzdtu<String> zzfhk;
    private final zzdtu<zzbyt> zzfnh;
    private final zzdtu<zzbyn> zzfsd;

    private zzcca(zzdtu<String> zzdtu, zzdtu<zzbyn> zzdtu2, zzdtu<zzbyt> zzdtu3) {
        this.zzfhk = zzdtu;
        this.zzfsd = zzdtu2;
        this.zzfnh = zzdtu3;
    }

    public static zzcca zzi(zzdtu<String> zzdtu, zzdtu<zzbyn> zzdtu2, zzdtu<zzbyt> zzdtu3) {
        return new zzcca(zzdtu, zzdtu2, zzdtu3);
    }

    public final /* synthetic */ Object get() {
        return new zzcbz(this.zzfhk.get(), this.zzfsd.get(), this.zzfnh.get());
    }
}
