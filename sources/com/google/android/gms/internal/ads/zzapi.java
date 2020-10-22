package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardItem;

final class zzapi implements MediationBannerAdCallback, MediationInterstitialAdCallback, MediationNativeAdCallback, MediationRewardedAdCallback {
    private zzamv zzdhl;

    zzapi(zzamv zzamv) {
        this.zzdhl = zzamv;
    }

    public final void onVideoMute() {
    }

    public final void onVideoPause() {
    }

    public final void onVideoUnmute() {
    }

    public final void reportAdImpression() {
    }

    public final void reportAdClicked() {
        try {
            this.zzdhl.onAdClicked();
        } catch (RemoteException unused) {
        }
    }

    public final void onAdOpened() {
        try {
            this.zzdhl.onAdOpened();
        } catch (RemoteException unused) {
        }
    }

    public final void onAdClosed() {
        try {
            this.zzdhl.onAdClosed();
        } catch (RemoteException unused) {
        }
    }

    public final void onAdLeftApplication() {
        try {
            this.zzdhl.onAdLeftApplication();
        } catch (RemoteException unused) {
        }
    }

    public final void onVideoPlay() {
        try {
            this.zzdhl.onVideoPlay();
        } catch (RemoteException unused) {
        }
    }

    public final void onUserEarnedReward(RewardItem rewardItem) {
        try {
            this.zzdhl.zza((zzatq) new zzaup(rewardItem));
        } catch (RemoteException unused) {
        }
    }

    public final void onVideoStart() {
        try {
            this.zzdhl.zzsm();
        } catch (RemoteException unused) {
        }
    }

    public final void onVideoComplete() {
        try {
            this.zzdhl.onVideoEnd();
        } catch (RemoteException unused) {
        }
    }

    public final void onAdFailedToShow(String str) {
        try {
            String valueOf = String.valueOf(str);
            zzbad.zzep(valueOf.length() != 0 ? "Mediated ad failed to show: ".concat(valueOf) : new String("Mediated ad failed to show: "));
            this.zzdhl.zzcs(0);
        } catch (RemoteException unused) {
        }
    }
}
