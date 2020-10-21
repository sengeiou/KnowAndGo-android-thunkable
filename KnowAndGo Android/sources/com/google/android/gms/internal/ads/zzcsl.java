package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzcuz;

final class zzcsl<S extends zzcuz> {
    private final Clock zzbsa;
    public final zzbbh<S> zzggy;
    private final long zzggz;

    public zzcsl(zzbbh<S> zzbbh, long j, Clock clock) {
        this.zzggy = zzbbh;
        this.zzbsa = clock;
        this.zzggz = clock.elapsedRealtime() + j;
    }

    public final boolean hasExpired() {
        return this.zzggz < this.zzbsa.elapsedRealtime();
    }
}
