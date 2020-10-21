package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzabb;
import com.google.android.gms.internal.ads.zzbad;
import com.google.android.gms.internal.ads.zzzk;

public final class PublisherAdView extends ViewGroup {
    private final zzabb zzabf;

    public PublisherAdView(Context context) {
        super(context);
        this.zzabf = new zzabb(this);
    }

    public PublisherAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zzabf = new zzabb(this, attributeSet, true);
        Preconditions.checkNotNull(context, "Context cannot be null");
    }

    public PublisherAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzabf = new zzabb(this, attributeSet, true);
    }

    public final VideoController getVideoController() {
        return this.zzabf.getVideoController();
    }

    public final void setVideoOptions(VideoOptions videoOptions) {
        this.zzabf.setVideoOptions(videoOptions);
    }

    public final VideoOptions getVideoOptions() {
        return this.zzabf.getVideoOptions();
    }

    public final void destroy() {
        this.zzabf.destroy();
    }

    public final AdListener getAdListener() {
        return this.zzabf.getAdListener();
    }

    public final AdSize getAdSize() {
        return this.zzabf.getAdSize();
    }

    public final AdSize[] getAdSizes() {
        return this.zzabf.getAdSizes();
    }

    public final String getAdUnitId() {
        return this.zzabf.getAdUnitId();
    }

    public final AppEventListener getAppEventListener() {
        return this.zzabf.getAppEventListener();
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzabf.getOnCustomRenderedAdLoadedListener();
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(PublisherAdRequest publisherAdRequest) {
        this.zzabf.zza(publisherAdRequest.zzde());
    }

    public final void pause() {
        this.zzabf.pause();
    }

    public final void setManualImpressionsEnabled(boolean z) {
        this.zzabf.setManualImpressionsEnabled(z);
    }

    public final void recordManualImpression() {
        this.zzabf.recordManualImpression();
    }

    public final void resume() {
        this.zzabf.resume();
    }

    public final void setAdListener(AdListener adListener) {
        this.zzabf.setAdListener(adListener);
    }

    public final void setAdSizes(AdSize... adSizeArr) {
        if (adSizeArr == null || adSizeArr.length <= 0) {
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }
        this.zzabf.zza(adSizeArr);
    }

    public final void setAdUnitId(String str) {
        this.zzabf.setAdUnitId(str);
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        this.zzabf.setAppEventListener(appEventListener);
    }

    public final void setCorrelator(Correlator correlator) {
        this.zzabf.setCorrelator(correlator);
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzabf.setOnCustomRenderedAdLoadedListener(onCustomRenderedAdLoadedListener);
    }

    public final String getMediationAdapterClassName() {
        return this.zzabf.getMediationAdapterClassName();
    }

    public final boolean isLoading() {
        return this.zzabf.isLoading();
    }

    public final boolean zza(zzzk zzzk) {
        return this.zzabf.zza(zzzk);
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = ((i3 - i) - measuredWidth) / 2;
            int i6 = ((i4 - i2) - measuredHeight) / 2;
            childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
        }
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i, int i2) {
        int i3;
        int i4 = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            AdSize adSize = null;
            try {
                adSize = getAdSize();
            } catch (NullPointerException e) {
                zzbad.zzc("Unable to retrieve ad size.", e);
            }
            if (adSize != null) {
                Context context = getContext();
                int widthInPixels = adSize.getWidthInPixels(context);
                i3 = adSize.getHeightInPixels(context);
                i4 = widthInPixels;
            } else {
                i3 = 0;
            }
        } else {
            measureChild(childAt, i, i2);
            i4 = childAt.getMeasuredWidth();
            i3 = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(i4, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i3, getSuggestedMinimumHeight()), i2));
    }
}
