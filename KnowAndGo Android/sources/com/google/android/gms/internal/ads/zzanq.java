package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@zzard
public final class zzanq extends zzanb {
    private final NativeAppInstallAdMapper zzdgq;

    public zzanq(NativeAppInstallAdMapper nativeAppInstallAdMapper) {
        this.zzdgq = nativeAppInstallAdMapper;
    }

    public final zzaea zzrj() {
        return null;
    }

    public final IObjectWrapper zzrk() {
        return null;
    }

    public final String getHeadline() {
        return this.zzdgq.getHeadline();
    }

    public final List getImages() {
        List<NativeAd.Image> images = this.zzdgq.getImages();
        if (images == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NativeAd.Image next : images) {
            arrayList.add(new zzadw(next.getDrawable(), next.getUri(), next.getScale(), next.getWidth(), next.getHeight()));
        }
        return arrayList;
    }

    public final String getBody() {
        return this.zzdgq.getBody();
    }

    public final zzaei zzri() {
        NativeAd.Image icon = this.zzdgq.getIcon();
        if (icon != null) {
            return new zzadw(icon.getDrawable(), icon.getUri(), icon.getScale(), icon.getWidth(), icon.getHeight());
        }
        return null;
    }

    public final String getCallToAction() {
        return this.zzdgq.getCallToAction();
    }

    public final double getStarRating() {
        return this.zzdgq.getStarRating();
    }

    public final String getStore() {
        return this.zzdgq.getStore();
    }

    public final String getPrice() {
        return this.zzdgq.getPrice();
    }

    public final void recordImpression() {
        this.zzdgq.recordImpression();
    }

    public final void zzt(IObjectWrapper iObjectWrapper) {
        this.zzdgq.handleClick((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzu(IObjectWrapper iObjectWrapper) {
        this.zzdgq.trackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.zzdgq.trackViews((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    public final void zzv(IObjectWrapper iObjectWrapper) {
        this.zzdgq.untrackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final boolean getOverrideImpressionRecording() {
        return this.zzdgq.getOverrideImpressionRecording();
    }

    public final boolean getOverrideClickHandling() {
        return this.zzdgq.getOverrideClickHandling();
    }

    public final Bundle getExtras() {
        return this.zzdgq.getExtras();
    }

    public final zzaar getVideoController() {
        if (this.zzdgq.getVideoController() != null) {
            return this.zzdgq.getVideoController().zzdh();
        }
        return null;
    }

    public final IObjectWrapper zzso() {
        View adChoicesContent = this.zzdgq.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.wrap(adChoicesContent);
    }

    public final IObjectWrapper zzsp() {
        View zzacd = this.zzdgq.zzacd();
        if (zzacd == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzacd);
    }
}
