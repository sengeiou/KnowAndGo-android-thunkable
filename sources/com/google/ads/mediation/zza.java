package com.google.ads.mediation;

import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

final class zza implements RewardedVideoAdListener {
    private final /* synthetic */ AbstractAdViewAdapter zzmk;

    zza(AbstractAdViewAdapter abstractAdViewAdapter) {
        this.zzmk = abstractAdViewAdapter;
    }

    public final void onRewardedVideoAdLoaded() {
        this.zzmk.zzmi.onAdLoaded(this.zzmk);
    }

    public final void onRewardedVideoAdOpened() {
        this.zzmk.zzmi.onAdOpened(this.zzmk);
    }

    public final void onRewardedVideoStarted() {
        this.zzmk.zzmi.onVideoStarted(this.zzmk);
    }

    public final void onRewardedVideoAdClosed() {
        this.zzmk.zzmi.onAdClosed(this.zzmk);
        InterstitialAd unused = this.zzmk.zzmh = null;
    }

    public final void onRewarded(RewardItem rewardItem) {
        this.zzmk.zzmi.onRewarded(this.zzmk, rewardItem);
    }

    public final void onRewardedVideoAdLeftApplication() {
        this.zzmk.zzmi.onAdLeftApplication(this.zzmk);
    }

    public final void onRewardedVideoAdFailedToLoad(int i) {
        this.zzmk.zzmi.onAdFailedToLoad(this.zzmk, i);
    }

    public final void onRewardedVideoCompleted() {
        this.zzmk.zzmi.onVideoCompleted(this.zzmk);
    }
}
