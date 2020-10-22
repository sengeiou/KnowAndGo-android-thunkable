package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzcuz;
import java.util.concurrent.atomic.AtomicReference;

public final class zzcsk<S extends zzcuz> implements zzcva<S> {
    private final Clock zzbsa;
    private final AtomicReference<zzcsl<S>> zzggv = new AtomicReference<>();
    private final zzcva<S> zzggw;
    private final long zzggx;

    public zzcsk(zzcva<S> zzcva, long j, Clock clock) {
        this.zzbsa = clock;
        this.zzggw = zzcva;
        this.zzggx = j;
    }

    public final zzbbh<S> zzalm() {
        zzcsl zzcsl = this.zzggv.get();
        if (zzcsl == null || zzcsl.hasExpired()) {
            zzcsl = new zzcsl(this.zzggw.zzalm(), this.zzggx, this.zzbsa);
            this.zzggv.set(zzcsl);
        }
        return zzcsl.zzggy;
    }
}
