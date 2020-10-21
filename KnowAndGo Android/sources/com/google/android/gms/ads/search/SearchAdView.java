package com.google.android.gms.ads.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.internal.ads.zzabb;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzbad;

@zzard
public final class SearchAdView extends ViewGroup {
    private final zzabb zzabf;

    public SearchAdView(Context context) {
        super(context);
        this.zzabf = new zzabb(this);
    }

    public SearchAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zzabf = new zzabb(this, attributeSet, false);
    }

    public SearchAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzabf = new zzabb(this, attributeSet, false);
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

    public final String getAdUnitId() {
        return this.zzabf.getAdUnitId();
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(SearchAdRequest searchAdRequest) {
        this.zzabf.zza(searchAdRequest.zzde());
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(DynamicHeightSearchAdRequest dynamicHeightSearchAdRequest) {
        if (AdSize.SEARCH.equals(getAdSize())) {
            this.zzabf.zza(dynamicHeightSearchAdRequest.zzde());
            return;
        }
        throw new IllegalStateException("You must use AdSize.SEARCH for a DynamicHeightSearchAdRequest");
    }

    public final void pause() {
        this.zzabf.pause();
    }

    public final void resume() {
        this.zzabf.resume();
    }

    public final void setAdListener(AdListener adListener) {
        this.zzabf.setAdListener(adListener);
    }

    public final void setAdSize(AdSize adSize) {
        this.zzabf.setAdSizes(adSize);
    }

    public final void setAdUnitId(String str) {
        this.zzabf.setAdUnitId(str);
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
