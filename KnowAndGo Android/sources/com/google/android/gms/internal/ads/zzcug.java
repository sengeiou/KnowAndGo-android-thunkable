package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzcug implements zzdti<zzcue> {
    private final zzdtu<zzbbl> zzfgh;
    private final zzdtu<Bundle> zzghq;

    private zzcug(zzdtu<zzbbl> zzdtu, zzdtu<Bundle> zzdtu2) {
        this.zzfgh = zzdtu;
        this.zzghq = zzdtu2;
    }

    public static zzcug zzaq(zzdtu<zzbbl> zzdtu, zzdtu<Bundle> zzdtu2) {
        return new zzcug(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return new zzcue(this.zzfgh.get(), this.zzghq.get());
    }
}
