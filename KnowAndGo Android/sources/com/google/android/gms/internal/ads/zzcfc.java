package com.google.android.gms.internal.ads;

public final class zzcfc implements zzdti<zzcfb> {
    private final zzdtu<zzcfi> zzeqq;
    private final zzdtu<zzdae> zzerp;

    private zzcfc(zzdtu<zzcfi> zzdtu, zzdtu<zzdae> zzdtu2) {
        this.zzeqq = zzdtu;
        this.zzerp = zzdtu2;
    }

    public static zzcfc zzs(zzdtu<zzcfi> zzdtu, zzdtu<zzdae> zzdtu2) {
        return new zzcfc(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return new zzcfb(this.zzeqq.get(), this.zzerp.get());
    }
}
