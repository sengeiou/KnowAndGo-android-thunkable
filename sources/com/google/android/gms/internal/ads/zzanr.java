package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@zzard
public final class zzanr extends zzane {
    private final NativeContentAdMapper zzdgr;

    public zzanr(NativeContentAdMapper nativeContentAdMapper) {
        this.zzdgr = nativeContentAdMapper;
    }

    public final zzaea zzrj() {
        return null;
    }

    public final IObjectWrapper zzrk() {
        return null;
    }

    public final String getHeadline() {
        return this.zzdgr.getHeadline();
    }

    public final List getImages() {
        List<NativeAd.Image> images = this.zzdgr.getImages();
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
        return this.zzdgr.getBody();
    }

    public final zzaei zzrl() {
        NativeAd.Image logo = this.zzdgr.getLogo();
        if (logo != null) {
            return new zzadw(logo.getDrawable(), logo.getUri(), logo.getScale(), logo.getWidth(), logo.getHeight());
        }
        return null;
    }

    public final String getCallToAction() {
        return this.zzdgr.getCallToAction();
    }

    public final String getAdvertiser() {
        return this.zzdgr.getAdvertiser();
    }

    public final void recordImpression() {
        this.zzdgr.recordImpression();
    }

    public final void zzt(IObjectWrapper iObjectWrapper) {
        this.zzdgr.handleClick((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzu(IObjectWrapper iObjectWrapper) {
        this.zzdgr.trackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.zzdgr.trackViews((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    public final void zzv(IObjectWrapper iObjectWrapper) {
        this.zzdgr.untrackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final boolean getOverrideImpressionRecording() {
        return this.zzdgr.getOverrideImpressionRecording();
    }

    public final boolean getOverrideClickHandling() {
        return this.zzdgr.getOverrideClickHandling();
    }

    public final Bundle getExtras() {
        return this.zzdgr.getExtras();
    }

    public final IObjectWrapper zzso() {
        View adChoicesContent = this.zzdgr.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.wrap(adChoicesContent);
    }

    public final zzaar getVideoController() {
        if (this.zzdgr.getVideoController() != null) {
            return this.zzdgr.getVideoController().zzdh();
        }
        return null;
    }

    public final IObjectWrapper zzsp() {
        View zzacd = this.zzdgr.zzacd();
        if (zzacd == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzacd);
    }
}
