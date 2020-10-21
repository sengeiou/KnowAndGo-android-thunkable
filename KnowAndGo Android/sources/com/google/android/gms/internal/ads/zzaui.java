package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewarded.RewardedAdCallback;

@zzard
public final class zzaui extends zzatx {
    private final RewardedAdCallback zzdqx;

    public zzaui(RewardedAdCallback rewardedAdCallback) {
        this.zzdqx = rewardedAdCallback;
    }

    public final void onRewardedAdOpened() {
        if (this.zzdqx != null) {
            this.zzdqx.onRewardedAdOpened();
        }
    }

    public final void onRewardedAdClosed() {
        if (this.zzdqx != null) {
            this.zzdqx.onRewardedAdClosed();
        }
    }

    public final void zza(zzatq zzatq) {
        if (this.zzdqx != null) {
            this.zzdqx.onUserEarnedReward(new zzauh(zzatq));
        }
    }

    public final void onRewardedAdFailedToShow(int i) {
        if (this.zzdqx != null) {
            this.zzdqx.onRewardedAdFailedToShow(i);
        }
    }
}
