package com.google.android.gms.internal.ads;

final class zzbck implements Runnable {
    private final /* synthetic */ zzbcd zzebm;

    zzbck(zzbcd zzbcd) {
        this.zzebm = zzbcd;
    }

    public final void run() {
        if (this.zzebm.zzebk != null) {
            this.zzebm.zzebk.onPaused();
            this.zzebm.zzebk.zzxo();
        }
    }
}
