package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

@zzard
public final class zzatg extends zzatc {
    @Nullable
    private RewardedVideoAdListener zzcjm;

    public zzatg(@Nullable RewardedVideoAdListener rewardedVideoAdListener) {
        this.zzcjm = rewardedVideoAdListener;
    }

    public final void onRewardedVideoAdLoaded() {
        if (this.zzcjm != null) {
            this.zzcjm.onRewardedVideoAdLoaded();
        }
    }

    public final void onRewardedVideoAdOpened() {
        if (this.zzcjm != null) {
            this.zzcjm.onRewardedVideoAdOpened();
        }
    }

    public final void onRewardedVideoStarted() {
        if (this.zzcjm != null) {
            this.zzcjm.onRewardedVideoStarted();
        }
    }

    public final void onRewardedVideoAdClosed() {
        if (this.zzcjm != null) {
            this.zzcjm.onRewardedVideoAdClosed();
        }
    }

    public final void zza(zzasr zzasr) {
        if (this.zzcjm != null) {
            this.zzcjm.onRewarded(new zzate(zzasr));
        }
    }

    public final void onRewardedVideoAdLeftApplication() {
        if (this.zzcjm != null) {
            this.zzcjm.onRewardedVideoAdLeftApplication();
        }
    }

    public final void onRewardedVideoAdFailedToLoad(int i) {
        if (this.zzcjm != null) {
            this.zzcjm.onRewardedVideoAdFailedToLoad(i);
        }
    }

    public final void onRewardedVideoCompleted() {
        if (this.zzcjm != null) {
            this.zzcjm.onRewardedVideoCompleted();
        }
    }

    @Nullable
    public final RewardedVideoAdListener getRewardedVideoAdListener() {
        return this.zzcjm;
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        this.zzcjm = rewardedVideoAdListener;
    }
}
