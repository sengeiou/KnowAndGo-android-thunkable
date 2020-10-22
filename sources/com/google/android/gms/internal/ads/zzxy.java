package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;

@zzard
public final class zzxy extends zzzq {
    private final AdMetadataListener zzcgm;

    public zzxy(AdMetadataListener adMetadataListener) {
        this.zzcgm = adMetadataListener;
    }

    public final void onAdMetadataChanged() {
        if (this.zzcgm != null) {
            this.zzcgm.onAdMetadataChanged();
        }
    }
}
