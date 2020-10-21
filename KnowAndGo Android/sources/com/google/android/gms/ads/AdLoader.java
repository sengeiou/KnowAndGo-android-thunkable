package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzaaz;
import com.google.android.gms.internal.ads.zzady;
import com.google.android.gms.internal.ads.zzafi;
import com.google.android.gms.internal.ads.zzafl;
import com.google.android.gms.internal.ads.zzafx;
import com.google.android.gms.internal.ads.zzagm;
import com.google.android.gms.internal.ads.zzagn;
import com.google.android.gms.internal.ads.zzago;
import com.google.android.gms.internal.ads.zzagp;
import com.google.android.gms.internal.ads.zzagq;
import com.google.android.gms.internal.ads.zzags;
import com.google.android.gms.internal.ads.zzamo;
import com.google.android.gms.internal.ads.zzbad;
import com.google.android.gms.internal.ads.zzxv;
import com.google.android.gms.internal.ads.zzyc;
import com.google.android.gms.internal.ads.zzyd;
import com.google.android.gms.internal.ads.zzyt;
import com.google.android.gms.internal.ads.zzyz;
import com.google.android.gms.internal.ads.zzzc;
import com.google.android.gms.internal.ads.zzzf;
import com.google.android.gms.internal.ads.zzzy;

public class AdLoader {
    private final zzyc zzaaj;
    private final zzzc zzaak;
    private final Context zzlj;

    public static class Builder {
        private final zzzf zzaal;
        private final Context zzlj;

        public Builder(Context context, String str) {
            this((Context) Preconditions.checkNotNull(context, "context cannot be null"), zzyt.zzpb().zzb(context, str, new zzamo()));
        }

        private Builder(Context context, zzzf zzzf) {
            this.zzlj = context;
            this.zzaal = zzzf;
        }

        @Deprecated
        public Builder forContentAd(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
            try {
                this.zzaal.zza((zzafl) new zzagn(onContentAdLoadedListener));
            } catch (RemoteException e) {
                zzbad.zzd("Failed to add content ad listener", e);
            }
            return this;
        }

        @Deprecated
        public Builder forAppInstallAd(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
            try {
                this.zzaal.zza((zzafi) new zzagm(onAppInstallAdLoadedListener));
            } catch (RemoteException e) {
                zzbad.zzd("Failed to add app install ad listener", e);
            }
            return this;
        }

        public Builder forUnifiedNativeAd(UnifiedNativeAd.OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
            try {
                this.zzaal.zza((zzafx) new zzags(onUnifiedNativeAdLoadedListener));
            } catch (RemoteException e) {
                zzbad.zzd("Failed to add google native ad listener", e);
            }
            return this;
        }

        public Builder forCustomTemplateAd(String str, NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
            zzago zzago;
            try {
                zzzf zzzf = this.zzaal;
                zzagp zzagp = new zzagp(onCustomTemplateAdLoadedListener);
                if (onCustomClickListener == null) {
                    zzago = null;
                } else {
                    zzago = new zzago(onCustomClickListener);
                }
                zzzf.zza(str, zzagp, zzago);
            } catch (RemoteException e) {
                zzbad.zzd("Failed to add custom template ad listener", e);
            }
            return this;
        }

        public Builder forPublisherAdView(OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener, AdSize... adSizeArr) {
            if (adSizeArr == null || adSizeArr.length <= 0) {
                throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
            }
            try {
                this.zzaal.zza(new zzagq(onPublisherAdViewLoadedListener), new zzyd(this.zzlj, adSizeArr));
            } catch (RemoteException e) {
                zzbad.zzd("Failed to add publisher banner ad listener", e);
            }
            return this;
        }

        public Builder withAdListener(AdListener adListener) {
            try {
                this.zzaal.zza((zzyz) new zzxv(adListener));
            } catch (RemoteException e) {
                zzbad.zzd("Failed to set AdListener.", e);
            }
            return this;
        }

        public Builder withNativeAdOptions(NativeAdOptions nativeAdOptions) {
            try {
                this.zzaal.zza(new zzady(nativeAdOptions));
            } catch (RemoteException e) {
                zzbad.zzd("Failed to specify native ad options", e);
            }
            return this;
        }

        public Builder withPublisherAdViewOptions(PublisherAdViewOptions publisherAdViewOptions) {
            try {
                this.zzaal.zza(publisherAdViewOptions);
            } catch (RemoteException e) {
                zzbad.zzd("Failed to specify DFP banner ad options", e);
            }
            return this;
        }

        public Builder withCorrelator(@NonNull Correlator correlator) {
            Preconditions.checkNotNull(correlator);
            try {
                this.zzaal.zza((zzzy) correlator.zzaar);
            } catch (RemoteException e) {
                zzbad.zzd("Failed to set correlator.", e);
            }
            return this;
        }

        public AdLoader build() {
            try {
                return new AdLoader(this.zzlj, this.zzaal.zzpk());
            } catch (RemoteException e) {
                zzbad.zzc("Failed to build AdLoader.", e);
                return null;
            }
        }
    }

    AdLoader(Context context, zzzc zzzc) {
        this(context, zzzc, zzyc.zzche);
    }

    private AdLoader(Context context, zzzc zzzc, zzyc zzyc) {
        this.zzlj = context;
        this.zzaak = zzzc;
        this.zzaaj = zzyc;
    }

    private final void zza(zzaaz zzaaz) {
        try {
            this.zzaak.zza(zzyc.zza(this.zzlj, zzaaz));
        } catch (RemoteException e) {
            zzbad.zzc("Failed to load ad.", e);
        }
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(AdRequest adRequest) {
        zza(adRequest.zzde());
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAds(AdRequest adRequest, int i) {
        try {
            this.zzaak.zza(zzyc.zza(this.zzlj, adRequest.zzde()), i);
        } catch (RemoteException e) {
            zzbad.zzc("Failed to load ads.", e);
        }
    }

    public void loadAd(PublisherAdRequest publisherAdRequest) {
        zza(publisherAdRequest.zzde());
    }

    @Deprecated
    public String getMediationAdapterClassName() {
        try {
            return this.zzaak.zzpj();
        } catch (RemoteException e) {
            zzbad.zzd("Failed to get the mediation adapter class name.", e);
            return null;
        }
    }

    public boolean isLoading() {
        try {
            return this.zzaak.isLoading();
        } catch (RemoteException e) {
            zzbad.zzd("Failed to check if ad is loading.", e);
            return false;
        }
    }
}
