package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.PublisherAdView;

final class zzagr implements Runnable {
    private final /* synthetic */ PublisherAdView zzczj;
    private final /* synthetic */ zzzk zzczk;
    private final /* synthetic */ zzagq zzczl;

    zzagr(zzagq zzagq, PublisherAdView publisherAdView, zzzk zzzk) {
        this.zzczl = zzagq;
        this.zzczj = publisherAdView;
        this.zzczk = zzzk;
    }

    public final void run() {
        if (this.zzczj.zza(this.zzczk)) {
            this.zzczl.zzczi.onPublisherAdViewLoaded(this.zzczj);
        } else {
            zzbad.zzep("Could not bind.");
        }
    }
}
