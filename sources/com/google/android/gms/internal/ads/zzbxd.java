package com.google.android.gms.internal.ads;

public final class zzbxd implements zzdti<zzbxc> {
    private final zzdtu<zzbrt> zzfil;
    private final zzdtu<zzcxm> zzflv;

    private zzbxd(zzdtu<zzbrt> zzdtu, zzdtu<zzcxm> zzdtu2) {
        this.zzfil = zzdtu;
        this.zzflv = zzdtu2;
    }

    public static zzbxd zzj(zzdtu<zzbrt> zzdtu, zzdtu<zzcxm> zzdtu2) {
        return new zzbxd(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return new zzbxc(this.zzfil.get(), this.zzflv.get());
    }
}
