package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

public final class zzbov implements zzbsr, zzue {
    private final zzcxm zzffc;
    private final zzbrt zzfij;
    private final AtomicBoolean zzfik = new AtomicBoolean();

    public zzbov(zzcxm zzcxm, zzbrt zzbrt) {
        this.zzffc = zzcxm;
        this.zzfij = zzbrt;
    }

    public final synchronized void onAdLoaded() {
        if (this.zzffc.zzgjz != 1) {
            zzafw();
        }
    }

    public final void zza(zzud zzud) {
        if (this.zzffc.zzgjz == 1 && zzud.zzbtk) {
            zzafw();
        }
    }

    private final void zzafw() {
        if (this.zzfik.compareAndSet(false, true)) {
            this.zzfij.onAdImpression();
        }
    }
}
