package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@zzard
public final class zzaoi extends zzanh {
    private final UnifiedNativeAdMapper zzdhb;

    public zzaoi(UnifiedNativeAdMapper unifiedNativeAdMapper) {
        this.zzdhb = unifiedNativeAdMapper;
    }

    public final zzaea zzrj() {
        return null;
    }

    public final float zzsq() {
        return 0.0f;
    }

    public final String getHeadline() {
        return this.zzdhb.getHeadline();
    }

    public final List getImages() {
        List<NativeAd.Image> images = this.zzdhb.getImages();
        ArrayList arrayList = new ArrayList();
        if (images != null) {
            for (NativeAd.Image next : images) {
                arrayList.add(new zzadw(next.getDrawable(), next.getUri(), next.getScale(), next.getWidth(), next.getHeight()));
            }
        }
        return arrayList;
    }

    public final String getBody() {
        return this.zzdhb.getBody();
    }

    public final zzaei zzri() {
        NativeAd.Image icon = this.zzdhb.getIcon();
        if (icon != null) {
            return new zzadw(icon.getDrawable(), icon.getUri(), icon.getScale(), icon.getWidth(), icon.getHeight());
        }
        return null;
    }

    public final String getCallToAction() {
        return this.zzdhb.getCallToAction();
    }

    public final String getAdvertiser() {
        return this.zzdhb.getAdvertiser();
    }

    public final double getStarRating() {
        if (this.zzdhb.getStarRating() != null) {
            return this.zzdhb.getStarRating().doubleValue();
        }
        return -1.0d;
    }

    public final String getStore() {
        return this.zzdhb.getStore();
    }

    public final String getPrice() {
        return this.zzdhb.getPrice();
    }

    public final zzaar getVideoController() {
        if (this.zzdhb.getVideoController() != null) {
            return this.zzdhb.getVideoController().zzdh();
        }
        return null;
    }

    public final IObjectWrapper zzso() {
        View adChoicesContent = this.zzdhb.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.wrap(adChoicesContent);
    }

    public final IObjectWrapper zzsp() {
        View zzacd = this.zzdhb.zzacd();
        if (zzacd == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzacd);
    }

    public final IObjectWrapper zzrk() {
        Object zzkv = this.zzdhb.zzkv();
        if (zzkv == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzkv);
    }

    public final Bundle getExtras() {
        return this.zzdhb.getExtras();
    }

    public final boolean getOverrideImpressionRecording() {
        return this.zzdhb.getOverrideImpressionRecording();
    }

    public final boolean getOverrideClickHandling() {
        return this.zzdhb.getOverrideClickHandling();
    }

    public final void recordImpression() {
        this.zzdhb.recordImpression();
    }

    public final void zzt(IObjectWrapper iObjectWrapper) {
        this.zzdhb.handleClick((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.zzdhb.trackViews((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    public final void zzv(IObjectWrapper iObjectWrapper) {
        this.zzdhb.untrackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }
}
