package com.google.android.gms.internal.ads;

final class zzbcm implements Runnable {
    private final /* synthetic */ zzbcd zzebm;

    zzbcm(zzbcd zzbcd) {
        this.zzebm = zzbcd;
    }

    public final void run() {
        if (this.zzebm.zzebk != null) {
            this.zzebm.zzebk.onPaused();
        }
    }
}
