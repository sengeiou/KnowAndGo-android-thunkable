package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;

public final class zzctu implements zzdti<zzctp> {
    private final zzdtu<zzaxb> zzerj;
    private final zzdtu<zzbbl> zzfgh;
    private final zzdtu<zzcxv> zzfhr;
    private final zzdtu<PackageInfo> zzfwk;

    public zzctu(zzdtu<zzbbl> zzdtu, zzdtu<zzcxv> zzdtu2, zzdtu<PackageInfo> zzdtu3, zzdtu<zzaxb> zzdtu4) {
        this.zzfgh = zzdtu;
        this.zzfhr = zzdtu2;
        this.zzfwk = zzdtu3;
        this.zzerj = zzdtu4;
    }

    public final /* synthetic */ Object get() {
        return new zzctp(this.zzfgh.get(), this.zzfhr.get(), this.zzfwk.get(), this.zzerj.get());
    }
}
