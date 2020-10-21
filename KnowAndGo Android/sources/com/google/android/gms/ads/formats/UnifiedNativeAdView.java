package com.google.android.gms.ads.formats;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaem;
import com.google.android.gms.internal.ads.zzbad;
import com.google.android.gms.internal.ads.zzyt;

public final class UnifiedNativeAdView extends FrameLayout {
    private final FrameLayout zzbqi;
    private final zzaem zzbqj = zzks();

    public UnifiedNativeAdView(Context context) {
        super(context);
        this.zzbqi = zzd(context);
    }

    public UnifiedNativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zzbqi = zzd(context);
    }

    public UnifiedNativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzbqi = zzd(context);
    }

    @TargetApi(21)
    public UnifiedNativeAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.zzbqi = zzd(context);
    }

    private final void zza(String str, View view) {
        try {
            this.zzbqj.zzc(str, ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzbad.zzc("Unable to call setAssetView on delegate", e);
        }
    }

    public final void setHeadlineView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_HEADLINE, view);
    }

    public final void setCallToActionView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_CALL_TO_ACTION, view);
    }

    public final void setIconView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_ICON, view);
    }

    public final void setBodyView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_BODY, view);
    }

    public final void setAdvertiserView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_ADVERTISER, view);
    }

    public final void setStoreView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_STORE, view);
    }

    public final void setClickConfirmingView(View view) {
        try {
            this.zzbqj.zzi(ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzbad.zzc("Unable to call setClickConfirmingView on delegate", e);
        }
    }

    public final void setPriceView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_PRICE, view);
    }

    public final void setImageView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_IMAGE, view);
    }

    public final void setStarRatingView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_STAR_RATING, view);
    }

    public final void setMediaView(MediaView mediaView) {
        zza(UnifiedNativeAdAssetNames.ASSET_MEDIA_VIDEO, mediaView);
    }

    public final void setAdChoicesView(AdChoicesView adChoicesView) {
        zza(UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW, adChoicesView);
    }

    public final void setNativeAd(UnifiedNativeAd unifiedNativeAd) {
        try {
            this.zzbqj.zze((IObjectWrapper) unifiedNativeAd.zzkq());
        } catch (RemoteException e) {
            zzbad.zzc("Unable to call setNativeAd on delegate", e);
        }
    }

    private final View zzbj(String str) {
        try {
            IObjectWrapper zzcf = this.zzbqj.zzcf(str);
            if (zzcf != null) {
                return (View) ObjectWrapper.unwrap(zzcf);
            }
            return null;
        } catch (RemoteException e) {
            zzbad.zzc("Unable to call getAssetView on delegate", e);
            return null;
        }
    }

    public final View getHeadlineView() {
        return zzbj(UnifiedNativeAdAssetNames.ASSET_HEADLINE);
    }

    public final View getCallToActionView() {
        return zzbj(UnifiedNativeAdAssetNames.ASSET_CALL_TO_ACTION);
    }

    public final View getIconView() {
        return zzbj(UnifiedNativeAdAssetNames.ASSET_ICON);
    }

    public final View getBodyView() {
        return zzbj(UnifiedNativeAdAssetNames.ASSET_BODY);
    }

    public final View getStoreView() {
        return zzbj(UnifiedNativeAdAssetNames.ASSET_STORE);
    }

    public final View getPriceView() {
        return zzbj(UnifiedNativeAdAssetNames.ASSET_PRICE);
    }

    public final View getAdvertiserView() {
        return zzbj(UnifiedNativeAdAssetNames.ASSET_ADVERTISER);
    }

    public final View getImageView() {
        return zzbj(UnifiedNativeAdAssetNames.ASSET_IMAGE);
    }

    public final View getStarRatingView() {
        return zzbj(UnifiedNativeAdAssetNames.ASSET_STAR_RATING);
    }

    public final MediaView getMediaView() {
        View zzbj = zzbj(UnifiedNativeAdAssetNames.ASSET_MEDIA_VIDEO);
        if (zzbj instanceof MediaView) {
            return (MediaView) zzbj;
        }
        if (zzbj == null) {
            return null;
        }
        zzbad.zzdp("View is not an instance of MediaView");
        return null;
    }

    public final AdChoicesView getAdChoicesView() {
        View zzbj = zzbj(UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW);
        if (zzbj instanceof AdChoicesView) {
            return (AdChoicesView) zzbj;
        }
        return null;
    }

    public final void destroy() {
        try {
            this.zzbqj.destroy();
        } catch (RemoteException e) {
            zzbad.zzc("Unable to destroy native ad view", e);
        }
    }

    private final FrameLayout zzd(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(frameLayout);
        return frameLayout;
    }

    private final zzaem zzks() {
        Preconditions.checkNotNull(this.zzbqi, "createDelegate must be called after overlayFrame has been created");
        if (isInEditMode()) {
            return null;
        }
        return zzyt.zzpb().zza(this.zzbqi.getContext(), (FrameLayout) this, this.zzbqi);
    }

    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.zzbqi);
    }

    public final void removeView(View view) {
        if (this.zzbqi != view) {
            super.removeView(view);
        }
    }

    public final void removeAllViews() {
        super.removeAllViews();
        super.addView(this.zzbqi);
    }

    public final void bringChildToFront(View view) {
        super.bringChildToFront(view);
        if (this.zzbqi != view) {
            super.bringChildToFront(this.zzbqi);
        }
    }

    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.zzbqj != null) {
            try {
                this.zzbqj.zzc(ObjectWrapper.wrap(view), i);
            } catch (RemoteException e) {
                zzbad.zzc("Unable to call onVisibilityChanged on delegate", e);
            }
        }
    }
}
