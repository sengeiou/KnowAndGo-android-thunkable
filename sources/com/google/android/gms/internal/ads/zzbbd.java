package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicInteger;

final /* synthetic */ class zzbbd implements Runnable {
    private final AtomicInteger zzdzp;
    private final zzbbc zzdzw;

    zzbbd(zzbbc zzbbc, AtomicInteger atomicInteger) {
        this.zzdzw = zzbbc;
        this.zzdzp = atomicInteger;
    }

    public final void run() {
        this.zzdzw.zza(this.zzdzp);
    }
}
