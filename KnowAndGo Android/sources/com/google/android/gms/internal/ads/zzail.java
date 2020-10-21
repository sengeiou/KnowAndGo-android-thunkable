package com.google.android.gms.internal.ads;

final class zzail implements Runnable {
    private final /* synthetic */ zzaii zzdaz;

    zzail(zzaii zzaii) {
        this.zzdaz = zzaii;
    }

    public final void run() {
        this.zzdaz.disconnect();
    }
}
