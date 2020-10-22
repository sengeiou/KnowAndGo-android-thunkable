package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;

public final class zzczb implements zzdti<ThreadFactory> {
    private static final zzczb zzgmd = new zzczb();

    public static zzczb zzana() {
        return zzgmd;
    }

    public final /* synthetic */ Object get() {
        return (ThreadFactory) zzdto.zza(new zzcyu(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
