package com.google.android.gms.internal.ads;

public final class zzccc implements zzdti<zzccb> {
    private final zzdtu<String> zzfhk;
    private final zzdtu<zzbyt> zzfnh;
    private final zzdtu<zzbyn> zzfsd;

    private zzccc(zzdtu<String> zzdtu, zzdtu<zzbyn> zzdtu2, zzdtu<zzbyt> zzdtu3) {
        this.zzfhk = zzdtu;
        this.zzfsd = zzdtu2;
        this.zzfnh = zzdtu3;
    }

    public static zzccc zzj(zzdtu<String> zzdtu, zzdtu<zzbyn> zzdtu2, zzdtu<zzbyt> zzdtu3) {
        return new zzccc(zzdtu, zzdtu2, zzdtu3);
    }

    public final /* synthetic */ Object get() {
        return new zzccb(this.zzfhk.get(), this.zzfsd.get(), this.zzfnh.get());
    }
}
