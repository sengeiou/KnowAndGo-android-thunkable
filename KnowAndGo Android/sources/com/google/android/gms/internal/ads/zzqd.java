package com.google.android.gms.internal.ads;

import java.io.IOException;

final class zzqd implements Runnable {
    private final /* synthetic */ zzpz zzbis;
    private final /* synthetic */ IOException zzbiu;

    zzqd(zzpz zzpz, IOException iOException) {
        this.zzbis = zzpz;
        this.zzbiu = iOException;
    }

    public final void run() {
        this.zzbis.zzbia.zzb(this.zzbiu);
    }
}
