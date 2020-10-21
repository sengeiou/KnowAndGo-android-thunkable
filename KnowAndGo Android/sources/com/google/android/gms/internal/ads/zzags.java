package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd;

@zzard
public final class zzags extends zzafy {
    private final UnifiedNativeAd.OnUnifiedNativeAdLoadedListener zzczm;

    public zzags(UnifiedNativeAd.OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
        this.zzczm = onUnifiedNativeAdLoadedListener;
    }

    public final void zza(zzagg zzagg) {
        this.zzczm.onUnifiedNativeAdLoaded(new zzagj(zzagg));
    }
}
