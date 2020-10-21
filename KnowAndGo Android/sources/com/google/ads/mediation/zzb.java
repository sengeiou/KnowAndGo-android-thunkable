package com.google.ads.mediation;

import com.google.android.gms.ads.reward.AdMetadataListener;

final class zzb extends AdMetadataListener {
    private final /* synthetic */ AbstractAdViewAdapter zzmk;

    zzb(AbstractAdViewAdapter abstractAdViewAdapter) {
        this.zzmk = abstractAdViewAdapter;
    }

    public final void onAdMetadataChanged() {
        if (this.zzmk.zzmh != null && this.zzmk.zzmi != null) {
            this.zzmk.zzmi.zzb(this.zzmk.zzmh.getAdMetadata());
        }
    }
}
