package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;

@zzard
public final class zzxv extends zzza {
    private final AdListener zzcgl;

    public zzxv(AdListener adListener) {
        this.zzcgl = adListener;
    }

    public final void onAdClosed() {
        this.zzcgl.onAdClosed();
    }

    public final void onAdFailedToLoad(int i) {
        this.zzcgl.onAdFailedToLoad(i);
    }

    public final void onAdLeftApplication() {
        this.zzcgl.onAdLeftApplication();
    }

    public final void onAdLoaded() {
        this.zzcgl.onAdLoaded();
    }

    public final void onAdOpened() {
        this.zzcgl.onAdOpened();
    }

    public final void onAdClicked() {
        this.zzcgl.onAdClicked();
    }

    public final void onAdImpression() {
        this.zzcgl.onAdImpression();
    }

    public final AdListener getAdListener() {
        return this.zzcgl;
    }
}
