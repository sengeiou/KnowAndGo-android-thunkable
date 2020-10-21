package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzabd;

public final class PublisherInterstitialAd {
    private final zzabd zzaas;

    public PublisherInterstitialAd(Context context) {
        this.zzaas = new zzabd(context, this);
        Preconditions.checkNotNull(context, "Context cannot be null");
    }

    public final AdListener getAdListener() {
        return this.zzaas.getAdListener();
    }

    public final String getAdUnitId() {
        return this.zzaas.getAdUnitId();
    }

    public final AppEventListener getAppEventListener() {
        return this.zzaas.getAppEventListener();
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzaas.getOnCustomRenderedAdLoadedListener();
    }

    public final boolean isLoaded() {
        return this.zzaas.isLoaded();
    }

    public final boolean isLoading() {
        return this.zzaas.isLoading();
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(PublisherAdRequest publisherAdRequest) {
        this.zzaas.zza(publisherAdRequest.zzde());
    }

    public final void setAdListener(AdListener adListener) {
        this.zzaas.setAdListener(adListener);
    }

    public final void setAdUnitId(String str) {
        this.zzaas.setAdUnitId(str);
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        this.zzaas.setAppEventListener(appEventListener);
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzaas.setOnCustomRenderedAdLoadedListener(onCustomRenderedAdLoadedListener);
    }

    public final void setCorrelator(Correlator correlator) {
        this.zzaas.setCorrelator(correlator);
    }

    public final String getMediationAdapterClassName() {
        return this.zzaas.getMediationAdapterClassName();
    }

    public final void show() {
        this.zzaas.show();
    }

    public final void setImmersiveMode(boolean z) {
        this.zzaas.setImmersiveMode(z);
    }
}
