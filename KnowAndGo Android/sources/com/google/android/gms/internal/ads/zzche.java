package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;

public final class zzche implements zzdti<ApplicationInfo> {
    private final zzdtu<Context> zzeoj;

    private zzche(zzdtu<Context> zzdtu) {
        this.zzeoj = zzdtu;
    }

    public static zzche zzac(zzdtu<Context> zzdtu) {
        return new zzche(zzdtu);
    }

    public final /* synthetic */ Object get() {
        return (ApplicationInfo) zzdto.zza(this.zzeoj.get().getApplicationInfo(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
