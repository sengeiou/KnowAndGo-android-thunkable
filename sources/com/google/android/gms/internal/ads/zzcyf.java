package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;

public final class zzcyf implements zzdti<Clock> {
    private final zzcye zzglo;

    public zzcyf(zzcye zzcye) {
        this.zzglo = zzcye;
    }

    public final /* synthetic */ Object get() {
        return (Clock) zzdto.zza(DefaultClock.getInstance(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
