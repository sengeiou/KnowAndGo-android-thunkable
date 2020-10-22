package com.google.android.gms.internal.ads;

final class zzk implements Runnable {
    private final zzr zzw;
    private final zzy zzx;
    private final Runnable zzy;

    public zzk(zzr zzr, zzy zzy2, Runnable runnable) {
        this.zzw = zzr;
        this.zzx = zzy2;
        this.zzy = runnable;
    }

    public final void run() {
        this.zzw.isCanceled();
        if (this.zzx.zzbi == null) {
            this.zzw.zza(this.zzx.result);
        } else {
            this.zzw.zzb(this.zzx.zzbi);
        }
        if (this.zzx.zzbj) {
            this.zzw.zzb("intermediate-response");
        } else {
            this.zzw.zzc("done");
        }
        if (this.zzy != null) {
            this.zzy.run();
        }
    }
}
