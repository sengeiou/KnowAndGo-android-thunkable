package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

@zzard
public final class zzagp extends zzafs {
    private final NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener zzczh;

    public zzagp(NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener) {
        this.zzczh = onCustomTemplateAdLoadedListener;
    }

    public final void zzb(zzafe zzafe) {
        this.zzczh.onCustomTemplateAdLoaded(zzafh.zza(zzafe));
    }
}
