package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzagq extends zzafv {
    /* access modifiers changed from: private */
    public final OnPublisherAdViewLoadedListener zzczi;

    public zzagq(OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener) {
        this.zzczi = onPublisherAdViewLoadedListener;
    }

    public final void zza(zzzk zzzk, IObjectWrapper iObjectWrapper) {
        if (zzzk != null && iObjectWrapper != null) {
            PublisherAdView publisherAdView = new PublisherAdView((Context) ObjectWrapper.unwrap(iObjectWrapper));
            AppEventListener appEventListener = null;
            try {
                if (zzzk.zzpp() instanceof zzxv) {
                    zzxv zzxv = (zzxv) zzzk.zzpp();
                    publisherAdView.setAdListener(zzxv != null ? zzxv.getAdListener() : null);
                }
            } catch (RemoteException e) {
                zzbad.zzc("", e);
            }
            try {
                if (zzzk.zzpo() instanceof zzyf) {
                    zzyf zzyf = (zzyf) zzzk.zzpo();
                    if (zzyf != null) {
                        appEventListener = zzyf.getAppEventListener();
                    }
                    publisherAdView.setAppEventListener(appEventListener);
                }
            } catch (RemoteException e2) {
                zzbad.zzc("", e2);
            }
            zzazt.zzyr.post(new zzagr(this, publisherAdView, zzzk));
        }
    }
}
