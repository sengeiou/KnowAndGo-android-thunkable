package com.google.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdView;
import com.google.android.gms.ads.formats.NativeAdViewHolder;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzaar;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzazt;
import com.google.android.gms.internal.ads.zzbad;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzxr;
import com.google.android.gms.internal.ads.zzyt;
import java.util.Date;
import java.util.Map;
import java.util.Set;

@zzard
public abstract class AbstractAdViewAdapter implements MediationBannerAdapter, MediationNativeAdapter, OnImmersiveModeUpdatedListener, com.google.android.gms.ads.mediation.zza, MediationRewardedVideoAdAdapter, zzbjl {
    public static final String AD_UNIT_ID_PARAMETER = "pubid";
    private AdView zzmd;
    private InterstitialAd zzme;
    private AdLoader zzmf;
    private Context zzmg;
    /* access modifiers changed from: private */
    public InterstitialAd zzmh;
    /* access modifiers changed from: private */
    public MediationRewardedVideoAdListener zzmi;
    @VisibleForTesting
    private final RewardedVideoAdListener zzmj = new zza(this);

    /* access modifiers changed from: protected */
    public abstract Bundle zza(Bundle bundle, Bundle bundle2);

    private final AdRequest zza(Context context, MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        AdRequest.Builder builder = new AdRequest.Builder();
        Date birthday = mediationAdRequest.getBirthday();
        if (birthday != null) {
            builder.setBirthday(birthday);
        }
        int gender = mediationAdRequest.getGender();
        if (gender != 0) {
            builder.setGender(gender);
        }
        Set<String> keywords = mediationAdRequest.getKeywords();
        if (keywords != null) {
            for (String addKeyword : keywords) {
                builder.addKeyword(addKeyword);
            }
        }
        Location location = mediationAdRequest.getLocation();
        if (location != null) {
            builder.setLocation(location);
        }
        if (mediationAdRequest.isTesting()) {
            zzyt.zzpa();
            builder.addTestDevice(zzazt.zzbe(context));
        }
        if (mediationAdRequest.taggedForChildDirectedTreatment() != -1) {
            boolean z = true;
            if (mediationAdRequest.taggedForChildDirectedTreatment() != 1) {
                z = false;
            }
            builder.tagForChildDirectedTreatment(z);
        }
        builder.setIsDesignedForFamilies(mediationAdRequest.isDesignedForFamilies());
        builder.addNetworkExtrasBundle(AdMobAdapter.class, zza(bundle, bundle2));
        return builder.build();
    }

    @VisibleForTesting
    static final class zzd extends AdListener implements AppEventListener, zzxr {
        @VisibleForTesting
        private final AbstractAdViewAdapter zzmo;
        @VisibleForTesting
        private final MediationBannerListener zzmp;

        public zzd(AbstractAdViewAdapter abstractAdViewAdapter, MediationBannerListener mediationBannerListener) {
            this.zzmo = abstractAdViewAdapter;
            this.zzmp = mediationBannerListener;
        }

        public final void onAdLoaded() {
            this.zzmp.onAdLoaded(this.zzmo);
        }

        public final void onAdFailedToLoad(int i) {
            this.zzmp.onAdFailedToLoad(this.zzmo, i);
        }

        public final void onAdOpened() {
            this.zzmp.onAdOpened(this.zzmo);
        }

        public final void onAdClosed() {
            this.zzmp.onAdClosed(this.zzmo);
        }

        public final void onAdLeftApplication() {
            this.zzmp.onAdLeftApplication(this.zzmo);
        }

        public final void onAdClicked() {
            this.zzmp.onAdClicked(this.zzmo);
        }

        public final void onAppEvent(String str, String str2) {
            this.zzmp.zza(this.zzmo, str, str2);
        }
    }

    @VisibleForTesting
    static final class zze extends AdListener implements zzxr {
        @VisibleForTesting
        private final AbstractAdViewAdapter zzmo;
        @VisibleForTesting
        private final MediationInterstitialListener zzmq;

        public zze(AbstractAdViewAdapter abstractAdViewAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.zzmo = abstractAdViewAdapter;
            this.zzmq = mediationInterstitialListener;
        }

        public final void onAdLoaded() {
            this.zzmq.onAdLoaded(this.zzmo);
        }

        public final void onAdFailedToLoad(int i) {
            this.zzmq.onAdFailedToLoad(this.zzmo, i);
        }

        public final void onAdOpened() {
            this.zzmq.onAdOpened(this.zzmo);
        }

        public final void onAdClosed() {
            this.zzmq.onAdClosed(this.zzmo);
        }

        public final void onAdLeftApplication() {
            this.zzmq.onAdLeftApplication(this.zzmo);
        }

        public final void onAdClicked() {
            this.zzmq.onAdClicked(this.zzmo);
        }
    }

    @VisibleForTesting
    static final class zzf extends AdListener implements NativeAppInstallAd.OnAppInstallAdLoadedListener, NativeContentAd.OnContentAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener, NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener, UnifiedNativeAd.OnUnifiedNativeAdLoadedListener {
        @VisibleForTesting
        private final AbstractAdViewAdapter zzmo;
        @VisibleForTesting
        private final MediationNativeListener zzmr;

        public zzf(AbstractAdViewAdapter abstractAdViewAdapter, MediationNativeListener mediationNativeListener) {
            this.zzmo = abstractAdViewAdapter;
            this.zzmr = mediationNativeListener;
        }

        public final void onAdLoaded() {
        }

        public final void onAdFailedToLoad(int i) {
            this.zzmr.onAdFailedToLoad(this.zzmo, i);
        }

        public final void onAdOpened() {
            this.zzmr.onAdOpened(this.zzmo);
        }

        public final void onAdClosed() {
            this.zzmr.onAdClosed(this.zzmo);
        }

        public final void onAdLeftApplication() {
            this.zzmr.onAdLeftApplication(this.zzmo);
        }

        public final void onAdClicked() {
            this.zzmr.onAdClicked(this.zzmo);
        }

        public final void onAdImpression() {
            this.zzmr.onAdImpression(this.zzmo);
        }

        public final void onAppInstallAdLoaded(NativeAppInstallAd nativeAppInstallAd) {
            this.zzmr.onAdLoaded((MediationNativeAdapter) this.zzmo, (NativeAdMapper) new zza(nativeAppInstallAd));
        }

        public final void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
            this.zzmr.onAdLoaded((MediationNativeAdapter) this.zzmo, (UnifiedNativeAdMapper) new zzc(unifiedNativeAd));
        }

        public final void onContentAdLoaded(NativeContentAd nativeContentAd) {
            this.zzmr.onAdLoaded((MediationNativeAdapter) this.zzmo, (NativeAdMapper) new zzb(nativeContentAd));
        }

        public final void onCustomTemplateAdLoaded(NativeCustomTemplateAd nativeCustomTemplateAd) {
            this.zzmr.zza(this.zzmo, nativeCustomTemplateAd);
        }

        public final void onCustomClick(NativeCustomTemplateAd nativeCustomTemplateAd, String str) {
            this.zzmr.zza(this.zzmo, nativeCustomTemplateAd, str);
        }
    }

    static class zzb extends NativeContentAdMapper {
        private final NativeContentAd zzmm;

        public zzb(NativeContentAd nativeContentAd) {
            this.zzmm = nativeContentAd;
            setHeadline(nativeContentAd.getHeadline().toString());
            setImages(nativeContentAd.getImages());
            setBody(nativeContentAd.getBody().toString());
            if (nativeContentAd.getLogo() != null) {
                setLogo(nativeContentAd.getLogo());
            }
            setCallToAction(nativeContentAd.getCallToAction().toString());
            setAdvertiser(nativeContentAd.getAdvertiser().toString());
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            zza(nativeContentAd.getVideoController());
        }

        public final void trackView(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.zzmm);
            }
            NativeAdViewHolder nativeAdViewHolder = NativeAdViewHolder.zzbql.get(view);
            if (nativeAdViewHolder != null) {
                nativeAdViewHolder.setNativeAd((NativeAd) this.zzmm);
            }
        }
    }

    static class zzc extends UnifiedNativeAdMapper {
        private final UnifiedNativeAd zzmn;

        public zzc(UnifiedNativeAd unifiedNativeAd) {
            this.zzmn = unifiedNativeAd;
            setHeadline(unifiedNativeAd.getHeadline());
            setImages(unifiedNativeAd.getImages());
            setBody(unifiedNativeAd.getBody());
            setIcon(unifiedNativeAd.getIcon());
            setCallToAction(unifiedNativeAd.getCallToAction());
            setAdvertiser(unifiedNativeAd.getAdvertiser());
            setStarRating(unifiedNativeAd.getStarRating());
            setStore(unifiedNativeAd.getStore());
            setPrice(unifiedNativeAd.getPrice());
            zzp(unifiedNativeAd.zzkv());
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            zza(unifiedNativeAd.getVideoController());
        }

        public final void trackViews(View view, Map<String, View> map, Map<String, View> map2) {
            if (view instanceof UnifiedNativeAdView) {
                ((UnifiedNativeAdView) view).setNativeAd(this.zzmn);
                return;
            }
            NativeAdViewHolder nativeAdViewHolder = NativeAdViewHolder.zzbql.get(view);
            if (nativeAdViewHolder != null) {
                nativeAdViewHolder.setNativeAd(this.zzmn);
            }
        }
    }

    static class zza extends NativeAppInstallAdMapper {
        private final NativeAppInstallAd zzml;

        public zza(NativeAppInstallAd nativeAppInstallAd) {
            this.zzml = nativeAppInstallAd;
            setHeadline(nativeAppInstallAd.getHeadline().toString());
            setImages(nativeAppInstallAd.getImages());
            setBody(nativeAppInstallAd.getBody().toString());
            setIcon(nativeAppInstallAd.getIcon());
            setCallToAction(nativeAppInstallAd.getCallToAction().toString());
            if (nativeAppInstallAd.getStarRating() != null) {
                setStarRating(nativeAppInstallAd.getStarRating().doubleValue());
            }
            if (nativeAppInstallAd.getStore() != null) {
                setStore(nativeAppInstallAd.getStore().toString());
            }
            if (nativeAppInstallAd.getPrice() != null) {
                setPrice(nativeAppInstallAd.getPrice().toString());
            }
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            zza(nativeAppInstallAd.getVideoController());
        }

        public final void trackView(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.zzml);
            }
            NativeAdViewHolder nativeAdViewHolder = NativeAdViewHolder.zzbql.get(view);
            if (nativeAdViewHolder != null) {
                nativeAdViewHolder.setNativeAd((NativeAd) this.zzml);
            }
        }
    }

    public void onDestroy() {
        if (this.zzmd != null) {
            this.zzmd.destroy();
            this.zzmd = null;
        }
        if (this.zzme != null) {
            this.zzme = null;
        }
        if (this.zzmf != null) {
            this.zzmf = null;
        }
        if (this.zzmh != null) {
            this.zzmh = null;
        }
    }

    public void onPause() {
        if (this.zzmd != null) {
            this.zzmd.pause();
        }
    }

    public void onResume() {
        if (this.zzmd != null) {
            this.zzmd.resume();
        }
    }

    public String getAdUnitId(Bundle bundle) {
        return bundle.getString(AD_UNIT_ID_PARAMETER);
    }

    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzmd = new AdView(context);
        this.zzmd.setAdSize(new AdSize(adSize.getWidth(), adSize.getHeight()));
        this.zzmd.setAdUnitId(getAdUnitId(bundle));
        this.zzmd.setAdListener(new zzd(this, mediationBannerListener));
        this.zzmd.loadAd(zza(context, mediationAdRequest, bundle2, bundle));
    }

    public View getBannerView() {
        return this.zzmd;
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzme = new InterstitialAd(context);
        this.zzme.setAdUnitId(getAdUnitId(bundle));
        this.zzme.setAdListener(new zze(this, mediationInterstitialListener));
        this.zzme.loadAd(zza(context, mediationAdRequest, bundle2, bundle));
    }

    public void onImmersiveModeUpdated(boolean z) {
        if (this.zzme != null) {
            this.zzme.setImmersiveMode(z);
        }
        if (this.zzmh != null) {
            this.zzmh.setImmersiveMode(z);
        }
    }

    public zzaar getVideoController() {
        VideoController videoController;
        if (this.zzmd == null || (videoController = this.zzmd.getVideoController()) == null) {
            return null;
        }
        return videoController.zzdh();
    }

    public void showInterstitial() {
        this.zzme.show();
    }

    public Bundle getInterstitialAdapterInfo() {
        return new MediationAdapter.zza().zzdj(1).zzacc();
    }

    public void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        zzf zzf2 = new zzf(this, mediationNativeListener);
        AdLoader.Builder withAdListener = new AdLoader.Builder(context, bundle.getString(AD_UNIT_ID_PARAMETER)).withAdListener(zzf2);
        NativeAdOptions nativeAdOptions = nativeMediationAdRequest.getNativeAdOptions();
        if (nativeAdOptions != null) {
            withAdListener.withNativeAdOptions(nativeAdOptions);
        }
        if (nativeMediationAdRequest.isUnifiedNativeAdRequested()) {
            withAdListener.forUnifiedNativeAd(zzf2);
        }
        if (nativeMediationAdRequest.isAppInstallAdRequested()) {
            withAdListener.forAppInstallAd(zzf2);
        }
        if (nativeMediationAdRequest.isContentAdRequested()) {
            withAdListener.forContentAd(zzf2);
        }
        if (nativeMediationAdRequest.zzsu()) {
            for (String next : nativeMediationAdRequest.zzsv().keySet()) {
                withAdListener.forCustomTemplateAd(next, zzf2, nativeMediationAdRequest.zzsv().get(next).booleanValue() ? zzf2 : null);
            }
        }
        this.zzmf = withAdListener.build();
        this.zzmf.loadAd(zza(context, nativeMediationAdRequest, bundle2, bundle));
    }

    public void initialize(Context context, MediationAdRequest mediationAdRequest, String str, MediationRewardedVideoAdListener mediationRewardedVideoAdListener, Bundle bundle, Bundle bundle2) {
        this.zzmg = context.getApplicationContext();
        this.zzmi = mediationRewardedVideoAdListener;
        this.zzmi.onInitializationSucceeded(this);
    }

    public void loadAd(MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        if (this.zzmg == null || this.zzmi == null) {
            zzbad.zzen("AdMobAdapter.loadAd called before initialize.");
            return;
        }
        this.zzmh = new InterstitialAd(this.zzmg);
        this.zzmh.zzc(true);
        this.zzmh.setAdUnitId(getAdUnitId(bundle));
        this.zzmh.setRewardedVideoAdListener(this.zzmj);
        this.zzmh.setAdMetadataListener(new zzb(this));
        this.zzmh.loadAd(zza(this.zzmg, mediationAdRequest, bundle2, bundle));
    }

    public void showVideo() {
        this.zzmh.show();
    }

    public boolean isInitialized() {
        return this.zzmi != null;
    }
}
