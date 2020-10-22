package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcyv implements zzdti<Executor> {
    private static final zzcyv zzglx = new zzcyv();

    public static zzcyv zzamu() {
        return zzglx;
    }

    public final /* synthetic */ Object get() {
        return (Executor) zzdto.zza(zzbbm.zzeae, "Cannot return null from a non-@Nullable @Provides method");
    }
}
