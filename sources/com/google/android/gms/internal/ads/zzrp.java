package com.google.android.gms.internal.ads;

public abstract class zzrp {
    private zzrq zzblx;

    public abstract zzrr zza(zzlp[] zzlpArr, zzrb zzrb) throws zzku;

    public abstract void zzd(Object obj);

    public final void zza(zzrq zzrq) {
        this.zzblx = zzrq;
    }

    /* access modifiers changed from: protected */
    public final void invalidate() {
        if (this.zzblx != null) {
            this.zzblx.zzgv();
        }
    }
}
