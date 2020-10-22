package com.google.android.gms.internal.ads;

public final class zzakw extends zzbbw<zzalf> {
    private final Object lock = new Object();
    /* access modifiers changed from: private */
    public final zzala zzdct;
    private boolean zzdcu;

    public zzakw(zzala zzala) {
        this.zzdct = zzala;
    }

    public final void release() {
        synchronized (this.lock) {
            if (!this.zzdcu) {
                this.zzdcu = true;
                zza(new zzakx(this), new zzbbu());
                zza(new zzaky(this), new zzakz(this));
            }
        }
    }
}
