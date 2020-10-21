package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

public final class zzbqe implements zzbrl, zzbrw, zzbsr, zzbtk, zzxr {
    private final Clock zzbsa;
    private final zzawj zzfjk;

    public zzbqe(Clock clock, zzawj zzawj) {
        this.zzbsa = clock;
        this.zzfjk = zzawj;
    }

    public final void onAdLeftApplication() {
    }

    public final void onAdOpened() {
    }

    public final void onRewardedVideoCompleted() {
    }

    public final void onRewardedVideoStarted() {
    }

    public final void zzb(zzarx zzarx) {
    }

    public final void zzb(zzasr zzasr, String str, String str2) {
    }

    public final void onAdClicked() {
        this.zzfjk.zzuk();
    }

    public final void onAdLoaded() {
        this.zzfjk.zzah(true);
    }

    public final void onAdImpression() {
        this.zzfjk.zzuj();
    }

    public final void zzf(zzxz zzxz) {
        this.zzfjk.zze(zzxz);
    }

    public final void zza(zzcxu zzcxu) {
        this.zzfjk.zzfb(this.zzbsa.elapsedRealtime());
    }

    public final void onAdClosed() {
        this.zzfjk.zzul();
    }

    public final String zzum() {
        return this.zzfjk.zzum();
    }
}
