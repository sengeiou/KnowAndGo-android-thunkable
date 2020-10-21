package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp;

final class zzeb implements Runnable {
    private final /* synthetic */ zzdy zzxx;
    private final /* synthetic */ int zzxy;
    private final /* synthetic */ boolean zzxz;

    zzeb(zzdy zzdy, int i, boolean z) {
        this.zzxx = zzdy;
        this.zzxy = i;
        this.zzxz = z;
    }

    public final void run() {
        zzbp.zza zzb = this.zzxx.zzb(this.zzxy, this.zzxz);
        zzbp.zza unused = this.zzxx.zzxm = zzb;
        if (zzdy.zza(this.zzxy, zzb)) {
            this.zzxx.zza(this.zzxy + 1, this.zzxz);
        }
    }
}
