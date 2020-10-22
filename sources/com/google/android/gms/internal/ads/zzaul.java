package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

@zzard
public final class zzaul extends zzauc {
    private final RewardedAdLoadCallback zzdqy;

    public zzaul(RewardedAdLoadCallback rewardedAdLoadCallback) {
        this.zzdqy = rewardedAdLoadCallback;
    }

    public final void onRewardedAdLoaded() {
        if (this.zzdqy != null) {
            this.zzdqy.onRewardedAdLoaded();
        }
    }

    public final void onRewardedAdFailedToLoad(int i) {
        if (this.zzdqy != null) {
            this.zzdqy.onRewardedAdFailedToLoad(i);
        }
    }
}
