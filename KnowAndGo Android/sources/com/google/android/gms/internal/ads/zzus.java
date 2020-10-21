package com.google.android.gms.internal.ads;

final class zzus implements Runnable {
    private final /* synthetic */ zzur zzbuy;

    zzus(zzur zzur) {
        this.zzbuy = zzur;
    }

    public final void run() {
        synchronized (this.zzbuy.lock) {
            if (!this.zzbuy.foreground || !this.zzbuy.zzbut) {
                zzawz.zzdp("App is still foreground");
            } else {
                boolean unused = this.zzbuy.foreground = false;
                zzawz.zzdp("App went background");
                for (zzut zzp : this.zzbuy.zzbuu) {
                    try {
                        zzp.zzp(false);
                    } catch (Exception e) {
                        zzbad.zzc("", e);
                    }
                }
            }
        }
    }
}
