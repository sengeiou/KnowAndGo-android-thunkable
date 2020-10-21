package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;

public final class zzcwz implements zzdti<ApplicationInfo> {
    private final zzcwx zzgjo;

    public zzcwz(zzcwx zzcwx) {
        this.zzgjo = zzcwx;
    }

    public static ApplicationInfo zzc(zzcwx zzcwx) {
        return (ApplicationInfo) zzdto.zza(zzcwx.zzamh(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzc(this.zzgjo);
    }
}
