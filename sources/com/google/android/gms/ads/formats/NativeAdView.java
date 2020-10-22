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

@Deprecated
public class NativeAdView extends FrameLayout {
    private final FrameLayout zzbqi;
    private final zzaem zzbqj = zzks();

    public NativeAdView(Context context) {
        super(context);
        this.zzbqi = zzd(context);
    }

    public NativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zzbqi = zzd(context);
    }

    public NativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzbqi = zzd(context);
    }

    @TargetApi(21)
    public NativeAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.zzbqi = zzd(context);
    }

    public void setAdChoicesView(AdChoicesView adChoicesView) {
        zza(NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW, adChoicesView);
    }

    public AdChoicesView getAdChoicesView() {
        View zzbj = zzbj(NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW);
        if (zzbj instanceof AdChoicesView) {
            return (AdChoicesView) zzbj;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final void zza(String str, View view) {
        try {
            this.zzbqj.zzc(str, ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzbad.zzc("Unable to call setAssetView on delegate", e);
        }
    }

    /* access modifiers changed from: protected */
    public final View zzbj(String str) {
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

    public void setNativeAd(NativeAd nativeAd) {
        try {
            this.zzbqj.zze((IObjectWrapper) nativeAd.zzkq());
        } catch (RemoteException e) {
            zzbad.zzc("Unable to call setNativeAd on delegate", e);
        }
    }

    public void destroy() {
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
        Preconditions.checkNotNull(this.zzbqi, "createDelegate must be called after mOverlayFrame has been created");
        if (isInEditMode()) {
            return null;
        }
        return zzyt.zzpb().zza(this.zzbqi.getContext(), (FrameLayout) this, this.zzbqi);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.zzbqi);
    }

    public void removeView(View view) {
        if (this.zzbqi != view) {
            super.removeView(view);
        }
    }

    public void removeAllViews() {
        super.removeAllViews();
        super.addView(this.zzbqi);
    }

    public void bringChildToFront(View view) {
        super.bringChildToFront(view);
        if (this.zzbqi != view) {
            super.bringChildToFront(this.zzbqi);
        }
    }

    public void onVisibilityChanged(View view, int i) {
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
