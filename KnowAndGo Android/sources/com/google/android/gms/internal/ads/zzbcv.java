package com.google.android.gms.internal.ads;

final class zzbcv implements Runnable {
    private final /* synthetic */ zzbcq zzecn;
    private final /* synthetic */ boolean zzeco;

    zzbcv(zzbcq zzbcq, boolean z) {
        this.zzecn = zzbcq;
        this.zzeco = z;
    }

    public final void run() {
        this.zzecn.zzd("windowVisibilityChanged", "isVisible", String.valueOf(this.zzeco));
    }
}
