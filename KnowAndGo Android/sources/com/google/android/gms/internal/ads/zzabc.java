package com.google.android.gms.internal.ads;

final class zzabc extends zzyv {
    private final /* synthetic */ zzabb zzcjl;

    zzabc(zzabb zzabb) {
        this.zzcjl = zzabb;
    }

    public final void onAdLoaded() {
        this.zzcjl.zzcje.zza(this.zzcjl.zzdh());
        super.onAdLoaded();
    }

    public final void onAdFailedToLoad(int i) {
        this.zzcjl.zzcje.zza(this.zzcjl.zzdh());
        super.onAdFailedToLoad(i);
    }
}
