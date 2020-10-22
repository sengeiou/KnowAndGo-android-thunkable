package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import javax.annotation.Nullable;

public final class zzchg implements zzdti<PackageInfo> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<ApplicationInfo> zzfws;

    private zzchg(zzdtu<Context> zzdtu, zzdtu<ApplicationInfo> zzdtu2) {
        this.zzeoj = zzdtu;
        this.zzfws = zzdtu2;
    }

    public static zzchg zzac(zzdtu<Context> zzdtu, zzdtu<ApplicationInfo> zzdtu2) {
        return new zzchg(zzdtu, zzdtu2);
    }

    @Nullable
    public final /* synthetic */ Object get() {
        return zzcgt.zza(this.zzeoj.get(), this.zzfws.get());
    }
}
