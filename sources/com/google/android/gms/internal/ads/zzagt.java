package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd;

public final class zzagt extends zzage {
    private final UnifiedNativeAd.UnconfirmedClickListener zzczn;

    public zzagt(UnifiedNativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        this.zzczn = unconfirmedClickListener;
    }

    public final void onUnconfirmedClickReceived(String str) {
        this.zzczn.onUnconfirmedClickReceived(str);
    }

    public final void onUnconfirmedClickCancelled() {
        this.zzczn.onUnconfirmedClickCancelled();
    }
}
