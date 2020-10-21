package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.Executor;

public final class zzcjw<DelegateT, AdapterT> implements zzcjv<AdapterT> {
    @VisibleForTesting
    private final zzcjv<DelegateT> zzfzl;
    private final zzbam<DelegateT, AdapterT> zzfzm;

    public zzcjw(zzcjv<DelegateT> zzcjv, zzbam<DelegateT, AdapterT> zzbam) {
        this.zzfzl = zzcjv;
        this.zzfzm = zzbam;
    }

    public final boolean zza(zzcxu zzcxu, zzcxm zzcxm) {
        return this.zzfzl.zza(zzcxu, zzcxm);
    }

    public final zzbbh<AdapterT> zzb(zzcxu zzcxu, zzcxm zzcxm) {
        return zzbar.zza(this.zzfzl.zzb(zzcxu, zzcxm), this.zzfzm, (Executor) zzaxg.zzdvp);
    }
}
