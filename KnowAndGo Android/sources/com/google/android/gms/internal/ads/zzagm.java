package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeAppInstallAd;

@zzard
public final class zzagm extends zzafj {
    private final NativeAppInstallAd.OnAppInstallAdLoadedListener zzcze;

    public zzagm(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
        this.zzcze = onAppInstallAdLoadedListener;
    }

    public final void zza(zzaew zzaew) {
        this.zzcze.onAppInstallAdLoaded(new zzaez(zzaew));
    }
}
