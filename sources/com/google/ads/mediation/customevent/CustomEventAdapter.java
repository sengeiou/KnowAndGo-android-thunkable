package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbad;

@KeepName
public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {
    private View zzmx;
    @VisibleForTesting
    private CustomEventBanner zzmy;
    @VisibleForTesting
    private CustomEventInterstitial zzmz;

    private static <T> T zzaj(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            String message = th.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 46 + String.valueOf(message).length());
            sb.append("Could not instantiate custom event adapter: ");
            sb.append(str);
            sb.append(". ");
            sb.append(message);
            zzbad.zzep(sb.toString());
            return null;
        }
    }

    @VisibleForTesting
    static final class zza implements CustomEventBannerListener {
        private final CustomEventAdapter zzna;
        private final MediationBannerListener zznb;

        public zza(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.zzna = customEventAdapter;
            this.zznb = mediationBannerListener;
        }

        public final void onReceivedAd(View view) {
            zzbad.zzdp("Custom event adapter called onReceivedAd.");
            this.zzna.zza(view);
            this.zznb.onReceivedAd(this.zzna);
        }

        public final void onFailedToReceiveAd() {
            zzbad.zzdp("Custom event adapter called onFailedToReceiveAd.");
            this.zznb.onFailedToReceiveAd(this.zzna, AdRequest.ErrorCode.NO_FILL);
        }

        public final void onClick() {
            zzbad.zzdp("Custom event adapter called onFailedToReceiveAd.");
            this.zznb.onClick(this.zzna);
        }

        public final void onPresentScreen() {
            zzbad.zzdp("Custom event adapter called onFailedToReceiveAd.");
            this.zznb.onPresentScreen(this.zzna);
        }

        public final void onDismissScreen() {
            zzbad.zzdp("Custom event adapter called onFailedToReceiveAd.");
            this.zznb.onDismissScreen(this.zzna);
        }

        public final void onLeaveApplication() {
            zzbad.zzdp("Custom event adapter called onFailedToReceiveAd.");
            this.zznb.onLeaveApplication(this.zzna);
        }
    }

    @VisibleForTesting
    class zzb implements CustomEventInterstitialListener {
        private final CustomEventAdapter zzna;
        private final MediationInterstitialListener zznc;

        public zzb(CustomEventAdapter customEventAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.zzna = customEventAdapter;
            this.zznc = mediationInterstitialListener;
        }

        public final void onReceivedAd() {
            zzbad.zzdp("Custom event adapter called onReceivedAd.");
            this.zznc.onReceivedAd(CustomEventAdapter.this);
        }

        public final void onFailedToReceiveAd() {
            zzbad.zzdp("Custom event adapter called onFailedToReceiveAd.");
            this.zznc.onFailedToReceiveAd(this.zzna, AdRequest.ErrorCode.NO_FILL);
        }

        public final void onPresentScreen() {
            zzbad.zzdp("Custom event adapter called onPresentScreen.");
            this.zznc.onPresentScreen(this.zzna);
        }

        public final void onDismissScreen() {
            zzbad.zzdp("Custom event adapter called onDismissScreen.");
            this.zznc.onDismissScreen(this.zzna);
        }

        public final void onLeaveApplication() {
            zzbad.zzdp("Custom event adapter called onLeaveApplication.");
            this.zznc.onLeaveApplication(this.zzna);
        }
    }

    public final void destroy() {
        if (this.zzmy != null) {
            this.zzmy.destroy();
        }
        if (this.zzmz != null) {
            this.zzmz.destroy();
        }
    }

    public final Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    public final View getBannerView() {
        return this.zzmx;
    }

    public final Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    public final void requestBannerAd(MediationBannerListener mediationBannerListener, Activity activity, CustomEventServerParameters customEventServerParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        Object extra;
        this.zzmy = (CustomEventBanner) zzaj(customEventServerParameters.className);
        if (this.zzmy == null) {
            mediationBannerListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
            return;
        }
        if (customEventExtras == null) {
            extra = null;
        } else {
            extra = customEventExtras.getExtra(customEventServerParameters.label);
        }
        this.zzmy.requestBannerAd(new zza(this, mediationBannerListener), activity, customEventServerParameters.label, customEventServerParameters.parameter, adSize, mediationAdRequest, extra);
    }

    public final void requestInterstitialAd(MediationInterstitialListener mediationInterstitialListener, Activity activity, CustomEventServerParameters customEventServerParameters, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        Object extra;
        this.zzmz = (CustomEventInterstitial) zzaj(customEventServerParameters.className);
        if (this.zzmz == null) {
            mediationInterstitialListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
            return;
        }
        if (customEventExtras == null) {
            extra = null;
        } else {
            extra = customEventExtras.getExtra(customEventServerParameters.label);
        }
        this.zzmz.requestInterstitialAd(new zzb(this, mediationInterstitialListener), activity, customEventServerParameters.label, customEventServerParameters.parameter, mediationAdRequest, extra);
    }

    public final void showInterstitial() {
        this.zzmz.showInterstitial();
    }

    /* access modifiers changed from: private */
    public final void zza(View view) {
        this.zzmx = view;
    }
}
