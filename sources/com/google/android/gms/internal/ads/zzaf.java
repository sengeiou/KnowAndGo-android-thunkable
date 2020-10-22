package com.google.android.gms.internal.ads;

public class zzaf extends Exception {
    private long zzad;
    private final zzp zzbk;

    public zzaf() {
        this.zzbk = null;
    }

    public zzaf(zzp zzp) {
        this.zzbk = zzp;
    }

    public zzaf(String str) {
        super(str);
        this.zzbk = null;
    }

    public zzaf(Throwable th) {
        super(th);
        this.zzbk = null;
    }

    /* access modifiers changed from: package-private */
    public final void zza(long j) {
        this.zzad = j;
    }
}
