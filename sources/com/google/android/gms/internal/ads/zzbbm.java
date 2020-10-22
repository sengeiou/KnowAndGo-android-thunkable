package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

@zzard
public final class zzbbm {
    public static final Executor zzeae = new zzbbn();
    public static final Executor zzeaf = new zzbbo();
    public static final zzbbl zzeag = zza(zzeae);
    private static final zzbbl zzeah = zza(zzeaf);

    public static zzbbl zza(Executor executor) {
        return new zzbbp(executor, (zzbbn) null);
    }
}
