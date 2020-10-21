package com.google.android.gms.internal.ads;

public final class zzcga implements zzdti<zzcfz> {
    private final zzdtu<zzbjm> zzeoh;
    private final zzdtu<zzcfn> zzfuc;

    private zzcga(zzdtu<zzcfn> zzdtu, zzdtu<zzbjm> zzdtu2) {
        this.zzfuc = zzdtu;
        this.zzeoh = zzdtu2;
    }

    public static zzcga zzy(zzdtu<zzcfn> zzdtu, zzdtu<zzbjm> zzdtu2) {
        return new zzcga(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return new zzcfz(this.zzfuc.get(), this.zzeoh.get());
    }
}
