package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;

@zzard
public final class zzadr extends zzadp {
    private final OnCustomRenderedAdLoadedListener zzcji;

    public zzadr(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzcji = onCustomRenderedAdLoadedListener;
    }

    public final void zza(zzadl zzadl) {
        this.zzcji.onCustomRenderedAdLoaded(new zzadk(zzadl));
    }
}
