package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

public final class zzcuc implements zzdti<zzcub> {
    private final zzdtu<PackageInfo> zzfwk;
    private final zzdtu<ApplicationInfo> zzfws;

    private zzcuc(zzdtu<ApplicationInfo> zzdtu, zzdtu<PackageInfo> zzdtu2) {
        this.zzfws = zzdtu;
        this.zzfwk = zzdtu2;
    }

    public static zzcuc zzap(zzdtu<ApplicationInfo> zzdtu, zzdtu<PackageInfo> zzdtu2) {
        return new zzcuc(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return new zzcub(this.zzfws.get(), this.zzfwk.get());
    }
}
