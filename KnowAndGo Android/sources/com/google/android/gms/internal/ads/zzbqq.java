package com.google.android.gms.internal.ads;

import java.util.concurrent.TimeUnit;

public final class zzbqq {
    public static <T> zzbbh<T> zza(zzczt zzczt, zzbbh<zzcxu> zzbbh, zzblq zzblq, zzcmx<T> zzcmx) {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcvm)).booleanValue()) {
            return zzczt.zza(zzczs.RENDERER, zzbbh).zza(zzblq).zza(zzcmx).zzane();
        }
        return zzczt.zza(zzczs.RENDERER, zzbbh).zza(zzblq).zza(zzcmx).zza((long) ((Integer) zzyt.zzpe().zzd(zzacu.zzcvn)).intValue(), TimeUnit.SECONDS).zzane();
    }
}
