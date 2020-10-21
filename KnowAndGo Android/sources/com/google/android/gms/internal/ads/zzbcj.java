package com.google.android.gms.internal.ads;

final class zzbcj implements Runnable {
    private final /* synthetic */ zzbcd zzebm;
    private final /* synthetic */ int zzebp;
    private final /* synthetic */ int zzebq;

    zzbcj(zzbcd zzbcd, int i, int i2) {
        this.zzebm = zzbcd;
        this.zzebp = i;
        this.zzebq = i2;
    }

    public final void run() {
        if (this.zzebm.zzebk != null) {
            this.zzebm.zzebk.zzk(this.zzebp, this.zzebq);
        }
    }
}
