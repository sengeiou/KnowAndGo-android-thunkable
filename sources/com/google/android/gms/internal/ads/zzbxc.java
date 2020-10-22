package com.google.android.gms.internal.ads;

public final class zzbxc implements zzbrl {
    private final zzbrt zzfij;
    private final zzcxm zzflu;

    public zzbxc(zzbrt zzbrt, zzcxm zzcxm) {
        this.zzfij = zzbrt;
        this.zzflu = zzcxm;
    }

    public final void onAdClosed() {
    }

    public final void onAdLeftApplication() {
    }

    public final void onRewardedVideoCompleted() {
    }

    public final void onRewardedVideoStarted() {
    }

    public final void zzb(zzasr zzasr, String str, String str2) {
    }

    public final void onAdOpened() {
        if (this.zzflu.zzgkp == 0 || this.zzflu.zzgkp == 1) {
            this.zzfij.onAdImpression();
        }
    }
}
