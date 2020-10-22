package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeContentAd;

@zzard
public final class zzagn extends zzafm {
    private final NativeContentAd.OnContentAdLoadedListener zzczf;

    public zzagn(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
        this.zzczf = onContentAdLoadedListener;
    }

    public final void zza(zzafa zzafa) {
        this.zzczf.onContentAdLoaded(new zzafd(zzafa));
    }
}
