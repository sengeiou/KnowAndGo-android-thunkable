package com.google.android.gms.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzabd;
import com.google.android.gms.internal.ads.zzxr;

public final class InterstitialAd {
    private final zzabd zzaas;

    public InterstitialAd(Context context) {
        this.zzaas = new zzabd(context);
        Preconditions.checkNotNull(context, "Context cannot be null");
    }

    public final AdListener getAdListener() {
        return this.zzaas.getAdListener();
    }

    public final String getAdUnitId() {
        return this.zzaas.getAdUnitId();
    }

    public final boolean isLoaded() {
        return this.zzaas.isLoaded();
    }

    public final boolean isLoading() {
        return this.zzaas.isLoading();
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(AdRequest adRequest) {
        this.zzaas.zza(adRequest.zzde());
    }

    public final void setAdListener(AdListener adListener) {
        this.zzaas.setAdListener(adListener);
        if (adListener != null && (adListener instanceof zzxr)) {
            this.zzaas.zza((zzxr) adListener);
        } else if (adListener == null) {
            this.zzaas.zza((zzxr) null);
        }
    }

    public final void setAdUnitId(String str) {
        this.zzaas.setAdUnitId(str);
    }

    public final String getMediationAdapterClassName() {
        return this.zzaas.getMediationAdapterClassName();
    }

    public final void show() {
        this.zzaas.show();
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        this.zzaas.setRewardedVideoAdListener(rewardedVideoAdListener);
    }

    public final void setAdMetadataListener(AdMetadataListener adMetadataListener) {
        this.zzaas.setAdMetadataListener(adMetadataListener);
    }

    public final Bundle getAdMetadata() {
        return this.zzaas.getAdMetadata();
    }

    public final void zzc(boolean z) {
        this.zzaas.zzc(true);
    }

    public final void setImmersiveMode(boolean z) {
        this.zzaas.setImmersiveMode(z);
    }
}
