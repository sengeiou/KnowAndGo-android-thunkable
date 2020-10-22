package com.google.android.gms.internal.ads;

public final class zzrr {
    public final zzrb zzbly;
    public final zzro zzblz;
    public final Object zzbma;
    public final zzlq[] zzbmb;

    public zzrr(zzrb zzrb, zzro zzro, Object obj, zzlq[] zzlqArr) {
        this.zzbly = zzrb;
        this.zzblz = zzro;
        this.zzbma = obj;
        this.zzbmb = zzlqArr;
    }

    public final boolean zza(zzrr zzrr, int i) {
        if (zzrr != null && zzsy.zza(this.zzblz.zzbi(i), zzrr.zzblz.zzbi(i)) && zzsy.zza(this.zzbmb[i], zzrr.zzbmb[i])) {
            return true;
        }
        return false;
    }
}
