package com.google.android.gms.internal.ads;

final /* synthetic */ class zzbgj implements Runnable {
    private final boolean zzecm;
    private final long zzega;
    private final zzbdf zzein;

    zzbgj(zzbdf zzbdf, boolean z, long j) {
        this.zzein = zzbdf;
        this.zzecm = z;
        this.zzega = j;
    }

    public final void run() {
        this.zzein.zza(this.zzecm, this.zzega);
    }
}
