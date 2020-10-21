package com.google.android.gms.internal.ads;

import android.view.View;

public final class zzbno implements zzdti<View> {
    private final zzbnk zzfhp;

    public zzbno(zzbnk zzbnk) {
        this.zzfhp = zzbnk;
    }

    public static View zza(zzbnk zzbnk) {
        return (View) zzdto.zza(zzbnk.zzafi(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzfhp);
    }
}
